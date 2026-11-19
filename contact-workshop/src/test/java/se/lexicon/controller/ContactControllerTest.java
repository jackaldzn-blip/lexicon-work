package se.lexicon.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import se.lexicon.data.FileContactDAOImpl;
import se.lexicon.view.ContactView;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ContactControllerTest {
    @TempDir
    Path tempDir;

    private String runWithInput(String input) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        ContactView view = new ContactView(new Scanner(in, StandardCharsets.UTF_8),
                new PrintStream(output, true, StandardCharsets.UTF_8));
        new ContactController(new FileContactDAOImpl(tempDir.resolve("contacts.txt")), view).run();
        return output.toString(StandardCharsets.UTF_8);
    }

    @Test
    void createsListsAndFindsContactThroughMenu() {
        String output = runWithInput("2\nAnna\n0123456789\n1\n3\nANNA\n0\n");
        assertTrue(output.contains("Contact saved successfully."));
        assertEquals(2, output.split("Anna \\| 0123456789", -1).length - 1);
        assertTrue(output.contains("Goodbye!"));
    }

    @Test
    void duplicateAndValidationErrorsDoNotExitTheApplication() {
        String output = runWithInput("2\nAnna\n0123456789\n2\nanna\n0987654321\n2\nBob\ninvalid\n1\n0\n");
        assertTrue(output.contains("already exists"));
        assertTrue(output.contains("Invalid input"));
        assertTrue(output.contains("Anna | 0123456789"));
        assertTrue(output.contains("Goodbye!"));
    }

    @Test
    void handlesEndOfInputWithoutCrashing() {
        assertTrue(runWithInput("2\nAlice\n").contains("Goodbye!"));
    }

    @Test
    void handlesUnknownOptionAndAbsentContact() {
        String output = runWithInput("9\n3\nMissing\n0\n");
        assertTrue(output.contains("Unknown option"));
        assertTrue(output.contains("No contact found"));
    }
}
