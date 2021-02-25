package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressEntryTest {

    @Test
    void testToString() {
        AddressEntry entry = new AddressEntry("Bill", "Withers","nut",
                "chicken","ca",123,"613","email");

        String correctString= ("Name: " + "Bill"+" " + "Withers"+ " " +
                "address: " + "nut"+ " " + "chicken"+ " " +"ca"+ "123"+ " " +
                "phone:" + "613"+ " email: " + "email");
        assertTrue(entry.toString().equals(correctString));
    }

    @Test
    void getFirstName() {
        AddressEntry entry = new AddressEntry();
        entry.setFirstName("bill");
        assertTrue(entry.getFirstName()==("bill"));
    }

    @Test
    void getLastName() {
        AddressEntry entry = new AddressEntry();
        entry.setLastName("smith");
        assertTrue(entry.getLastName()==("smith"));
    }

    @Test
    void getStreet() {
        AddressEntry entry = new AddressEntry();
        entry.setStreet("mission");
        assertTrue(entry.getStreet()==("mission"));
    }

    @Test
    void getCity() {
        AddressEntry entry = new AddressEntry();
        entry.setCity("Oakland");
        assertTrue(entry.getCity()=="Oakland");
    }

    @Test
    void getState() {
        AddressEntry entry = new AddressEntry();
        entry.setState("California");
        assertTrue(entry.getState() =="California");
    }

    @Test
    void getZip() {
        AddressEntry entry = new AddressEntry();
        entry.setZip(91007);
        assertTrue(entry.getZip()==91007);
    }

    @Test
    void getPhone() {
        AddressEntry entry = new AddressEntry();
        entry.setPhone("6263949191");
        assertTrue(entry.getPhone() == "6263949191");
    }

    @Test
    void getEmail() {
        AddressEntry entry = new AddressEntry();
        entry.setEmail("asdfl@mail.com");
        assertTrue(entry.getEmail()=="asdfl@mail.com");
    }

    @Test
    void setFirstName() {
        AddressEntry entry = new AddressEntry();
        entry.setFirstName("bill");
        assertTrue(entry.getFirstName()==("bill"));
    }

    @Test
    void setLastName() {
        AddressEntry entry = new AddressEntry();
        entry.setLastName("smith");
        assertTrue(entry.getLastName()==("smith"));
    }

    @Test
    void setStreet() {
        AddressEntry entry = new AddressEntry();
        entry.setStreet("mission");
        assertTrue(entry.getStreet()==("mission"));
    }

    @Test
    void setCity() {
        AddressEntry entry = new AddressEntry();
        entry.setCity("Oakland");
        assertTrue(entry.getCity()=="Oakland");
    }

    @Test
    void setState() {
        AddressEntry entry = new AddressEntry();
        entry.setState("California");
        assertTrue(entry.getState() =="California");
    }

    @Test
    void setZip() {
        AddressEntry entry = new AddressEntry();
        entry.setZip(91007);
        assertTrue(entry.getZip()==91007);
    }

    @Test
    void setPhone() {
        AddressEntry entry = new AddressEntry();
        entry.setPhone("6263949191");
        assertTrue(entry.getPhone() == "6263949191");
    }

    @Test
    void setEmail() {
        AddressEntry entry = new AddressEntry();
        entry.setEmail("asdfl@mail.com");
        assertTrue(entry.getEmail()=="asdfl@mail.com");
    }
}