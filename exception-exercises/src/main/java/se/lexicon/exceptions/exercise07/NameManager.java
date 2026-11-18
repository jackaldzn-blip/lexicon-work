package se.lexicon.exceptions.exercise07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NameManager {
    private final List<String> names = new ArrayList<>();

    public void addName(String name) throws DuplicateNameException {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name must not be empty.");
        }
        String cleanedName = name.trim();
        for (String existing : names) {
            if (existing.equalsIgnoreCase(cleanedName)) {
                throw new DuplicateNameException("'" + cleanedName + "' already exists.");
            }
        }
        names.add(cleanedName);
    }

    public String findName(String name) throws NameNotFoundException {
        for (String existing : names) {
            if (existing.equalsIgnoreCase(name.trim())) {
                return existing;
            }
        }
        throw new NameNotFoundException("'" + name + "' was not found.");
    }

    public List<String> getNames() {
        return Collections.unmodifiableList(names);
    }
}
