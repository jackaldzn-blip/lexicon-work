package se.lexicon.data;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import se.lexicon.exception.ContactStorageException;
import se.lexicon.exception.DuplicateContactException;
import se.lexicon.model.Contact;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class FileContactDAOImplTest {
    @TempDir
    Path tempDir;

    @Test
    void missingFileBehavesAsAnEmptyContactBook() throws Exception {
        FileContactDAOImpl dao = new FileContactDAOImpl(tempDir.resolve("contacts.txt"));
        assertTrue(dao.findAll().isEmpty());
        assertNull(dao.findByName("Nobody"));
    }

    @Test
    void savesAndReloadsDataFromNestedDirectory() throws Exception {
        Path path = tempDir.resolve("subfolder/contacts.txt");
        FileContactDAOImpl dao = new FileContactDAOImpl(path);
        dao.save(new Contact("Åsa, Björn", "0123456789"));
        dao.save(new Contact("Noah", "0987654321"));

        FileContactDAOImpl freshDao = new FileContactDAOImpl(path);
        assertEquals(2, freshDao.findAll().size());
        assertEquals("Åsa, Björn", freshDao.findByName("  åSA, BJÖRN  ").getName());
        assertEquals("0987654321", freshDao.findByName("Noah").getPhoneNumber());
    }

    @Test
    void preventsDuplicateNamesIgnoringCase() throws Exception {
        FileContactDAOImpl dao = new FileContactDAOImpl(tempDir.resolve("contacts.txt"));
        dao.save(new Contact("Alice", "0123456789"));
        assertThrows(DuplicateContactException.class,
                () -> dao.save(new Contact("ALICE", "0987654321")));
        assertEquals(1, dao.findAll().size());
    }

    @Test
    void malformedDataProducesCheckedStorageExceptionWithLineNumber() throws IOException {
        Path path = tempDir.resolve("contacts.txt");
        Files.writeString(path, "Alice\t0123456789\nBad data\n", StandardCharsets.UTF_8);
        ContactStorageException exception = assertThrows(ContactStorageException.class,
                () -> new FileContactDAOImpl(path).findAll());
        assertTrue(exception.getMessage().contains("line 2"));
    }

    @Test
    void invalidStoredPhoneIsWrappedAsStorageException() throws IOException {
        Path path = tempDir.resolve("contacts.txt");
        Files.writeString(path, "Alice\twrong\n", StandardCharsets.UTF_8);
        ContactStorageException exception = assertThrows(ContactStorageException.class,
                () -> new FileContactDAOImpl(path).findAll());
        assertNotNull(exception.getCause());
        assertInstanceOf(IllegalArgumentException.class, exception.getCause());
    }

    @Test
    void duplicatedStoredEntriesAreDetected() throws IOException {
        Path path = tempDir.resolve("contacts.txt");
        Files.writeString(path, "Alice\t0123456789\nalice\t0987654321\n", StandardCharsets.UTF_8);
        assertThrows(ContactStorageException.class, () -> new FileContactDAOImpl(path).findAll());
    }

    @Test
    void IOFailureBecomesCheckedStorageException() throws IOException {
        Path directory = tempDir.resolve("contacts.txt");
        Files.createDirectory(directory);
        FileContactDAOImpl dao = new FileContactDAOImpl(directory);
        assertThrows(ContactStorageException.class, dao::findAll);
        assertThrows(ContactStorageException.class,
                () -> dao.save(new Contact("Alice", "0123456789")));
    }
}
