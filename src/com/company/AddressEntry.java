package com.company;

/**
 * The definition of an addressEntry
 * @author colinkawai
 */
public class AddressEntry {
    /** The first name in the Entry */
    private String firstName;
    /** The second name in the Entry */
    private String lastName;
    /** The street name in the Entry */
    private String street;
    /** The city name in the Entry */
    private String city;
    /** The state name in the Entry */
    private String state;
    /** The zip code as an integer in the Entry */
    private Integer zip;
    /** The phone number as a String in the Entry */
    private String phone;
    /** The email of the entry */
    private String email;

    /**
     * The default constructor that defaults to nothing
     */
    public AddressEntry() {

    }

    /**
     * The constructor for the address entry that initializes the instance's
     * first name, last name, street, city, state, zip, phone, and email
     * @param firstName
     * @param lastName
     * @param street
     * @param city
     * @param state
     * @param zip
     * @param phone
     * @param email
     */
    public AddressEntry(String firstName, String lastName, String street,
                        String city, String state, Integer zip, String phone,
                        String email ){
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
    }


    /**
     * Ovverrides toString method
     * Calls to this method with an address entry will orient the return
     * string in an organized way
     * @return returns an organized string of the addressentry
     */
    public String toString(){
       String returnString = ("Name: " + firstName +" " + lastName + " " +
               "address: " + street + " " + city + " " +state + zip + " " +
               "phone:" + phone + " email: " + email);
       return returnString;
    }

    /**
     * @return the current first name as a String
     */
    String getFirstName(){
        return this.firstName;
    }

    /**
     * @return the current last name as a String
     */
    String getLastName(){
        return this.lastName;
    }

    /**
     * @return the current street as a String
     */
    String getStreet(){
        return this.street;
    }

    /**
     * @return the current city as a String
     */
    String getCity(){
        return this.city;
    }

    /**
     * @return the current state as a String
     */
    String getState(){
        return this.state;
    }

    /**
     * @return the current zip code as an Integer
     */
    Integer getZip(){
        return this.zip;
    }

    /**
     * @return the current phone number as a String
     */
    String getPhone(){
        return this.phone;
    }

    /**
     * @return the current email as a String
     */
    String getEmail(){
        return this.email;
    }

    /**
     * @param firstName first name to set as a String
     */
    void setFirstName(String firstName){
        this.firstName = firstName;
    }

    /**
     * @param lastName last name to set as a String
     */
    void setLastName(String lastName){
        this.lastName = lastName;
    }

    /**
     * @param street street name to set as a String
     */
    void setStreet(String street){
        this.street = street;
    }

    /**
     * @param city city name to set as a String
     */
    void setCity(String city){
        this.city = city;
    }

    /**
     * @param state state name to set as a String
     */
    void setState(String state){
        this.state = state;
    }

    /**
     * @param zip zip code to set as an Integer
     */
    void setZip(Integer zip){
        this.zip = zip;
    }

    /**
     * @param phone phone number to set as a String
     */
    void setPhone(String phone){
        this.phone = phone;
    }

    /**
     * @param email to set as a String
     */
    void setEmail(String email){
        this.email = email;
    }
}
