package se.lexicon.data;

import se.lexicon.exception.ContactStorageException;
import se.lexicon.exception.DuplicateContactException;
import se.lexicon.model.Contact;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/** UTF-8, tab-separated, one contact per line; uses try-with-resources for all file IO. */
public class FileContactDAOImpl implements ContactDAO {
    private final Path filePath;

    public FileContactDAOImpl(Path filePath) {
        this.filePath = Objects.requireNonNull(filePath, "filePath cannot be null");
    }

    @Override
    public List<Contact> findAll() throws ContactStorageException {
        List<Contact> contacts = new ArrayList<>();
        if (Files.notExists(filePath)) {
            return contacts;
        }

        Set<String> seenNames = new HashSet<>();
        try (BufferedReader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
            String line;
            int number = 0;
            while ((line = reader.readLine()) != null) {
                number++;
                String[] fields = line.split("\t", -1);
                if (fields.length != 2) {
                    throw new ContactStorageException("Invalid contact format on line " + number
                            + " of " + filePath + ".");
                }
                try {
                    Contact contact = new Contact(fields[0], fields[1]);
                    if (!seenNames.add(contact.getName().toLowerCase(java.util.Locale.ROOT))) {
                        throw new ContactStorageException("Duplicate stored contact on line " + number
                                + " of " + filePath + ".");
                    }
                    contacts.add(contact);
                } catch (IllegalArgumentException e) {
                    throw new ContactStorageException("Invalid contact on line " + number
                            + " of " + filePath + ": " + e.getMessage(), e);
                }
            }
        } catch (IOException e) {
            throw new ContactStorageException("Unable to read contacts from " + filePath + ".", e);
        }
        return contacts;
    }

    @Override
    public void save(Contact contact) throws ContactStorageException, DuplicateContactException {
        Objects.requireNonNull(contact, "contact cannot be null");
        // Reading first catches duplicates and corrupt existing data before any write.
        for (Contact existing : findAll()) {
            if (existing.getName().equalsIgnoreCase(contact.getName())) {
                throw new DuplicateContactException("A contact named '" + contact.getName()
                        + "' already exists.");
            }
        }

        try {
            Path parent = filePath.toAbsolutePath().getParent();
            if (parent != null) {
                Files.createDirectories(parent);
            }
            try (BufferedWriter writer = Files.newBufferedWriter(filePath, StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
                writer.write(contact.getName());
                writer.write('\t');
                writer.write(contact.getPhoneNumber());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new ContactStorageException("Unable to save contact to " + filePath + ".", e);
        }
    }

    @Override
    public Contact findByName(String name) throws ContactStorageException {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Search name cannot be empty.");
        }
        String query = name.trim();
        for (Contact contact : findAll()) {
            if (contact.getName().equalsIgnoreCase(query)) {
                return contact;
            }
        }
        return null;
    }
}
