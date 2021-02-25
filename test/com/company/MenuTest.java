package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.math.*;
import java.nio.ByteBuffer;

class MenuTest {

    @Test
    void prompt_FirstName() {
        String input="Colin";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals("Colin",  Menu.prompt_FirstName());
    }

    @Test
    void prompt_LastName() {
        String input = "Smith";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals("Smith", Menu.prompt_LastName());
    }

    @Test
    void prompt_Street() {
        String input = "someString";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals("someString", Menu.prompt_Street());
    }

    @Test
    void prompt_City() {
       String input = "someString";
       InputStream in = new ByteArrayInputStream(input.getBytes());
       System.setIn(in);
       assertEquals("someString", Menu.prompt_City());
    }

    @Test
    void prompt_State() {
        String input = "someString";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals("someString", Menu.prompt_State());
    }

    @Test
    void prompt_Zip() {
        String input = "123";
        //byte[] bytes = ByteBuffer.allocate(4).putInt(input).array();
        InputStream in =
                new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals(123, Menu.prompt_Zip());
    }

    @Test
    void prompt_Telephone() {
        String input = "someString";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals("someString", Menu.prompt_Telephone());
    }

    @Test
    void prompt_Email() {
        String input = "someString";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals("someString", Menu.prompt_Email());
    }

    @Test
    void load() {
        AddressBook book = new AddressBook();
        String input = "AddressInputDataFile";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Menu.load(book);
        assertNotEquals(book.addressEntryList.size(), 0);
    }

    @Test
    void add() {
        /*
        //AddressEntry entry = new AddressEntry("a","b","c","d","e",6,"4","af");
        AddressBook book = new AddressBook();
        String input =
                "a"+System.getProperty("line.separator")+"b"+System.getProperty("line.separator")+"c"+System.getProperty("line.separator")+"d"+System.getProperty("line.separator")+"e"+System.getProperty("line.separator")+"6"+System.getProperty("line.separator")+"adf"+System.getProperty("line.separator")+"adf"+System.getProperty("line.separator");

        InputStream inputStream = System.in;
        System.setIn(new ByteArrayInputStream(input.getBytes())) ;

        Menu.add(book);

        System.setIn(inputStream);
        assertNotEquals(book.addressEntryList.size(), 0);
         */
    }

    @Test
    void remove() {
    }

    @Test
    void find() {

    }

    @Test
    void list() {
    }

    @Test
    void quit() {
    }
}