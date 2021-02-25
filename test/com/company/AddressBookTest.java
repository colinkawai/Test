package com.company;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class AddressBookTest {

    @Test
    void list() {
        AddressBook book = new AddressBook();
        AddressEntry entryOne = new AddressEntry("c","z","c","d","e",6,"4",
                "af");
        AddressEntry entryTwo = new AddressEntry("a","a","c","d","e",6,"4",
                "af");
        book.add(entryOne);
        book.add(entryTwo);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        book.list();
//System.getProperty("line.separator")

        String output = ("Name: " + "a"+" " + "a"+ " " +
                "address: " + "c"+ " " + "d"+ " " +"e"+ "6"+ " " +
                "phone:" + "4"+ " email: " + "af" + System.getProperty("line" +
                ".separator") + "Name: " + "c"+" " + "z"+ " " +
                "address: " + "c"+ " " + "d"+ " " +"e"+ "6"+ " " +
                "phone:" + "4"+ " email: " + "af" + System.getProperty("line.separator"));
        assertEquals(output, outContent.toString());
    }

    @Test
    void readFromFile() throws FileNotFoundException {
        AddressBook book = new AddressBook();
        book.readFromFile("AddressInputDataFile");
        assertNotEquals(book.addressEntryList.size(), 0);
    }

    @Test
    void add() {
        AddressBook book = new AddressBook();
        AddressEntry entryOne = new AddressEntry("c","z","c","d","e",6,"4",
                "af");
        book.add(entryOne);
        assertNotEquals(book.addressEntryList.size(),0);
    }

    @Test
    void find() {
        AddressBook book = new AddressBook();
        AddressEntry entryOne = new AddressEntry("c","z","c","d","e",6,"4",
                "af");
        book.add(entryOne);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        book.find("z");
        String output = "The following entires were found in the " +
                "address book for a last name starting with z" + System.getProperty("line.separator") + "1.Name: " + "c"+" " + "z"+ " " +
                "address: " + "c"+ " " + "d"+ " " +"e"+ "6"+ " " +
                "phone:" + "4"+ " email: " + "af" + System.getProperty("line" +
                ".separator");

        assertEquals(output, outContent.toString());
    }

    @Test
    void remove() {
        AddressBook book = new AddressBook();
        AddressEntry entryOne = new AddressEntry("c","z","c","d","e",6,"4",
                "af");
        AddressEntry entryTwo = new AddressEntry("a","a","c","d","e",6,"4",
                "af");
        book.add(entryOne);
        book.add(entryTwo);

        String input = "1\n y \n";
        InputStream savedStandardInputStream = System.in;
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        int bookSizePrev = book.addressEntryList.size();
        book.remove("a");
        System.setIn(savedStandardInputStream);
        assertNotEquals(bookSizePrev, book.addressEntryList.size());
    }
}