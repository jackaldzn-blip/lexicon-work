package se.lexicon.model;

import java.util.Objects;

/** A contact with a nonblank name and an exactly 10-digit phone number. */
public class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        setName(name);
        setPhoneNumber(phoneNumber);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Contact name cannot be empty.");
        }
        String normalized = name.trim();
        // The file DAO stores one contact per tab-separated line.
        if (normalized.indexOf('\t') >= 0 || normalized.indexOf('\n') >= 0
                || normalized.indexOf('\r') >= 0) {
            throw new IllegalArgumentException("Contact name cannot contain tabs or line breaks.");
        }
        this.name = normalized;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || !phoneNumber.matches("[0-9]{10}")) {
            throw new IllegalArgumentException("Phone number must contain exactly 10 digits (0-9).");
        }
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return name + " | " + phoneNumber;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Contact)) return false;
        Contact contact = (Contact) other;
        return name.equals(contact.name) && phoneNumber.equals(contact.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phoneNumber);
    }
}
