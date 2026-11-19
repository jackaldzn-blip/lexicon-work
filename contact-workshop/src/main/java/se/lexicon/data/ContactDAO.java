package se.lexicon.data;

import se.lexicon.exception.ContactStorageException;
import se.lexicon.exception.DuplicateContactException;
import se.lexicon.model.Contact;

import java.util.List;

/** Persistence operations only; this layer never reads/writes the console. */
public interface ContactDAO {
    List<Contact> findAll() throws ContactStorageException;

    void save(Contact contact) throws ContactStorageException, DuplicateContactException;

    /** Returns null if the name does not exist. Names are matched case-insensitively. */
    Contact findByName(String name) throws ContactStorageException;
}
