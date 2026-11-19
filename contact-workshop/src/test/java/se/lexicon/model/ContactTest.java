package se.lexicon.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactTest {
    @Test
    void acceptsValidContactAndTrimsName() {
        Contact contact = new Contact("  Anna Andersson  ", "0123456789");
        assertEquals("Anna Andersson", contact.getName());
        assertEquals("0123456789", contact.getPhoneNumber());
    }

    @Test
    void rejectsBlankAndUnsafeNames() {
        for (String name : new String[] {"", "   ", "A\tB", "A\nB", "A\rB"}) {
            assertThrows(IllegalArgumentException.class, () -> new Contact(name, "0123456789"));
        }
        assertThrows(IllegalArgumentException.class, () -> new Contact(null, "0123456789"));
    }

    @Test
    void rejectsInvalidPhoneNumbersInConstructorAndSetter() {
        for (String phone : new String[] {"123", "01234567890", "01234x6789", " 0123456789", "+4612345678"}) {
            assertThrows(IllegalArgumentException.class, () -> new Contact("Anna", phone));
        }
        assertThrows(IllegalArgumentException.class, () -> new Contact("Anna", null));
        Contact contact = new Contact("Anna", "0123456789");
        assertThrows(IllegalArgumentException.class, () -> contact.setPhoneNumber("invalid"));
        assertEquals("0123456789", contact.getPhoneNumber());
    }

    @Test
    void namesCanContainCommasAndUnicode() {
        Contact contact = new Contact("Åsa, Björn", "0987654321");
        assertEquals("Åsa, Björn", contact.getName());
    }
}
