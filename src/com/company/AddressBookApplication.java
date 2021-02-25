package com.company;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Represents an Address Book Application
 * @author colinkawai
 */
public class AddressBookApplication{
    /**
     * Reads filename and calls to add from the file into the ad
     * @param ad
     * @param fileName
     */
    static void init(AddressBook ad, String fileName){
        try {
            ad.readFromFile(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * The Main method
     * @param args
     */
    public static void main(String[] args) {
        /*
          creates a new addressBook instance
          asks to import a file and calls to init
          prints the current address book
         */
        AddressBook addressBook = new AddressBook();

        System.out.println("Enter the file import");
        Scanner sc = new Scanner(System.in);
        String fileInput = sc.nextLine();
        init(addressBook, fileInput);
        addressBook.list();

        //Made a new line into a variable
        String newline = System.getProperty("line.separator");

        //What the initial menu will show
        String menu = ("Please enter in your menu selection:" +  newline +
                "a)Loading From File" + newline + "b)Addition" + newline +
                "c)Removal" +newline+ "d)Find" + newline +"e)Listing" + newline
                + "f)Quit" + newline);

        /*
         This can be a switch statement
         Calls an appropriate menu method given an input
         Uses Scanner class for user input
         */
        boolean quit = false;
        while(!quit){
            System.out.println(menu);
            Scanner scan = new Scanner(System.in);
            String input = scan.next();
            if(input.equals("a")){
                Menu.load(addressBook);
            }
            else if(input.equals("b")){
                System.out.println("here");
                Menu.add(addressBook);
            }
            else if(input.equals("c")){
                Menu.remove(addressBook);
            }
            else if(input.equals("d")){
                Menu.find(addressBook);
            }
            else if(input.equals("e")){
                Menu.list(addressBook);
            }
            else{
                Menu.quit();
                quit = true;
            }
        }
    }
}
