package com.company;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The definition of a Menu
 * @author colinkawai
 */
class Menu {
    /**
     * prompts the client to enter the first name
     * @return returns the first name that the client enters as a String
     */
    public static String prompt_FirstName() {
        String firstName;
        do{
            try{
                System.out.println("First Name:");
                Scanner scan = new Scanner(System.in);
                firstName = scan.next();
                break;
            }
            catch(Exception e ){
               System.out.println("Couldn't parse the input, try again");
            }

        }
        while(true);
        return firstName;
    }

    /**
     * prompts the client to enter the last name
     * @return returns the last name that the client enters as a String
     */
     public static String prompt_LastName() {
         String lastName;
         do{
             try{
                 System.out.println("Last Name:");
                 Scanner scan = new Scanner(System.in);
                 lastName = scan.next();
                 break;
             }
             catch(Exception e){
                System.out.println("Couldn't parse the input, try again") ;
             }
         }
         while(true);
         return lastName;
     }

    /**
     * prompts the client to enter the street name
     * @return returns the street name that the client enters as a String
     */
     public static String prompt_Street() {
         String street;
         do{
             try{
                 System.out.println("Street:");
                 Scanner scan = new Scanner(System.in);
                 street = scan.next();
                 break;
             }
             catch(Exception e){
                 System.out.println("Couldn't parse the input, try again");
             }
         }
         while(true);
         return street;
     }

    /**
     * prompts the client to enter the city name
     * @return returns the city name that the client enters as a String
     */
     public static String prompt_City() {
         String city;
         do{
             try{
                 System.out.println("City:");
                 Scanner scan = new Scanner(System.in);
                 city = scan.next();
                 break;
             }
             catch(Exception e){
                 System.out.println("Couldn't parse the input, try again");
             }
         }
         while(true);
         return city;
     }

    /**
     * prompts the client to enter the state name
     * @return returns the state name that the client enters as a String
     */
     public static String prompt_State() {
         String state;
         do{
             try{
                 System.out.println("State:");
                 Scanner scan = new Scanner(System.in);
                 state = scan.next();
                break;
             }
             catch(Exception e){
                 System.out.println("Couldn't parse the input, try again");
             }
         }
         while(true);
         return state;
     }

    /**
     * prompts the client to enter the Zip Code
     * @return returns the Zip code that the client enters as an Integer
     */
     public static int prompt_Zip() {
         Integer zip;
         do{
             try{
                 System.out.println("Zip:");
                 Scanner scan = new Scanner(System.in);
                 zip = scan.nextInt();
                 break;
             }
             catch(Exception e){
                 System.out.println("Couldn't parse the input, try again");
             }
         }
         while(true);
         return zip;
     }

    /**
     * prompts the client to enter the telephone number
     * @return returns the telephone number that the client enters as a String
     */
     public static String prompt_Telephone() {
         String telephone;
         do{
             try{
                 System.out.println("Telephone:");
                 Scanner scan = new Scanner(System.in);
                 telephone= scan.next();
                break;
             }
             catch(Exception e){
                 System.out.println("Couldn't parse the input, try again ");
             }
         }
         while(true);
         return telephone;
     }

    /**
     * prompts the client to enter the email
     * @return returns the email as a String that the client enters as a String
     */
    public static String prompt_Email() {
        String email;
        do{
            try{
                System.out.println("Email:");
                Scanner scan = new Scanner(System.in);
                email = scan.next();
               break;
            }
            catch(Exception e){
                System.out.println(("Couldn't parse the input, try again"));
            }
        }
        while(true);
         return email;
     }

    /**
     * Asks the client for the name of the file
     * reads that file and add all the entries on that file
     * @param book
     */
     static void load(AddressBook book){
        System.out.println("Enter the name of the file to load");
        Scanner scan = new Scanner(System.in);
        String fileName = scan.next();
        try{
            book.readFromFile(fileName);
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        System.out.println("Successfully added file");
     }

     /**
      * Calls the prompts at the top
      * Adds to the book in the given paramter
      * @param book
      */
     static void add(AddressBook book){
        String first = prompt_FirstName();
        String last =  prompt_LastName();
        String street = prompt_Street();
        String city = prompt_City();
        String state = prompt_State();
        Integer zip = prompt_Zip();
        String telephone = prompt_Telephone();
        String email = prompt_Email();
        String newline = System.getProperty("line.separator");

        //create new AddressEntry object
        //add that to the AddressBook in the parameter
        AddressEntry newEntry = new AddressEntry(first, last, street, city,
                state, zip, telephone, email );
        book.add(newEntry);

        String output = ("Thank you the following contact has been added to " +
                "your address book" + newline + first + newline + last + street
                + newline + city + newline + state +  zip +newline + telephone
                + email);
        System.out.println(output);

     }

     /**
      * removes the first occurrence of the last name of contact to remove
      * @param book
      */
     static void remove(AddressBook book){
        System.out.println("Enter in the Last name of contact to remove ");
        Scanner scan = new Scanner(System.in);
        String last = scan.next();
        book.remove(last);
     }

     /**
      * finds the first occurrence of the last name to find
      * @param book
      */
     static void find(AddressBook book){
        System.out.println("Enter in all or the beginning of the Last Name of" +
                " the contact that you wish to find:");
        Scanner scan = new Scanner(System.in);
        String name = scan.next();
        book.find(name);
     }

     /**
      * list every entry in the address book
      * @param book
      */
     static void list(AddressBook book){
        book.list();
     }

    /**
     * prints goodbye when the client wants to exit
     */
    static void quit(){
         System.out.println("goodbye");
     }

 }
