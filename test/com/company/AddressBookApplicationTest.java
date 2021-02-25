package com.company;

import static org.junit.jupiter.api.Assertions.*;

class AddressBookApplicationTest {

    @org.junit.jupiter.api.Test
    void init() {
        AddressBookApplication test = new AddressBookApplication();
        AddressBook book = new AddressBook();
        String filename = "AddressInputDataFile";
        test.init(book, filename);
    }

    @org.junit.jupiter.api.Test
    void main() {
    }
}