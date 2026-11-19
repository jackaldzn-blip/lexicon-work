package se.lexicon;

import se.lexicon.controller.ContactController;
import se.lexicon.data.ContactDAO;
import se.lexicon.data.FileContactDAOImpl;
import se.lexicon.view.ContactView;

import java.nio.file.Path;
import java.util.Scanner;

/** Composition root: create the MVC components and run the controller. */
public class App {
    public static void main(String[] args) {
        Path storage = args.length > 0 ? Path.of(args[0]) : Path.of("data", "contacts.txt");
        ContactDAO dao = new FileContactDAOImpl(storage);
        // Do not close this Scanner: it owns System.in, which belongs to the JVM.
        ContactView view = new ContactView(new Scanner(System.in), System.out);
        new ContactController(dao, view).run();
    }
}
