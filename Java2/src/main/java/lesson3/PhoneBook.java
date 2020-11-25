package lesson3;

import java.util.HashMap;
import java.util.HashSet;

public class PhoneBook {

    private HashMap<String, HashSet<String>> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public void addPerson(String name, String number) {
        phoneBook.putIfAbsent(name, new HashSet<>());
        phoneBook.get(name).add(number);
    }

    public HashSet<String> getNumberPerson(String name) {

        return phoneBook.get(name);
    }

}
