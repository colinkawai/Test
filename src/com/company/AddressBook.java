package com.company;
import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;
/**
 * The address of an AddressBook
 * @author colinkawai
 */
public class AddressBook {
    /**
     * An ArrayList of the AddressEntry class to store Address Entries
     */
    List<AddressEntry> addressEntryList = new ArrayList<AddressEntry>();

    /**
     * sorts array list with collections.sort by last name
     * prints all the address entries
     */
    void list(){
        Collections.sort(addressEntryList,
                Comparator.comparing(AddressEntry::getLastName));
        for(AddressEntry temp: addressEntryList){
            System.out.println(temp.toString());
        }
    }

    /**
     * Reads a file name to add to the address book
     * If the file is bad or not found an exception is thrown
     * @param filename
     * @throws FileNotFoundException
     */
    void readFromFile(String filename) throws FileNotFoundException {
        File file = new File("/Users/colinkawai/Documents/Test/src/com" +
                "/company/"+filename);
        Scanner sc = new Scanner(file);

        while(sc.hasNextLine()){
            String first, last, street, city, state, email, phone;
            first = last = street = city = state = email = phone = "";
            Integer zip = 0;
            int i = 0;
            while(i < 8){
                if(i == 0){
                    first = sc.nextLine();
                }
                else if(i==1){
                    last = sc.nextLine();
                }
                else if(i==2){
                     street = sc.nextLine();
                }
                else if(i==3){
                     city = sc.nextLine();
                }
                else if(i==4){
                    state = sc.nextLine();
                }
                else if(i==5){
                    zip = Integer.parseInt(sc.nextLine());
                }
                else if(i==6){
                     email = sc.nextLine();
                }
                else if(i==7){
                    phone = sc.nextLine();
                }
                i++;
            }
            AddressEntry temp = new AddressEntry(first, last, street, city,
                    state, zip, phone, email);

            this.add(temp);
        }
    }

    /**
     * adds an entry to the array list addressEntryList
      * @param addressEntry of AddressEntry type
     */
    void add(AddressEntry addressEntry){
        addressEntryList.add(addressEntry);
    }

    /**
     * Given the start of a last name
     * It will put all occurrences of that last name into a hashmap
     * The occurrences are put in a data structure like a hashmap to get the
     * size to print the amount of entries or none at all
     * Then loop through all the occurrences in the hash map and print
     * @param startOfLastName
     */
    void find(String startOfLastName){
        HashMap<Integer, AddressEntry> map = new HashMap<Integer, AddressEntry>();
        for(int i = 0; i<addressEntryList.size(); i++){
            if(addressEntryList.get(i).getLastName().startsWith(startOfLastName)){
                map.put(i, addressEntryList.get(i));
            }
        }
        if(map.isEmpty()){
            System.out.println("There isn't an entry with that LastName");
            return;
        }
        else{
            System.out.println("The following entires were found in the " +
                    "address book for a last name starting with " + startOfLastName);
        }
        int i = 1;
        for(Map.Entry<Integer, AddressEntry> entry : map.entrySet()){
            System.out.println(i + "." + entry.getValue().toString());
            i++;
        }

    }

    /**
     * loop through list and find all entries with the paramter lastName
     * store all indicies with the lastName in a hashmap
     * if there no entries with that last name print an error message and return
     * otherwise print how many entries there are with that last name
     * Then print all the entries that are stored in the map
     * Ask the client which entry they want to remove
     * After that, ask client if they want to remove the entry or go back to
     * main menu
     * If yes, then remove the entry, otherwise return
     * @param lastName
     */
    void remove(String lastName){
        HashMap<Integer, AddressEntry> map = new HashMap<Integer, AddressEntry>();

        int j = 1;
        for(int i = 0; i<addressEntryList.size(); i++){
            if(addressEntryList.get(i).getLastName().equals(lastName)){
                map.put(j, addressEntryList.get(i));
                j++;
            }
        }
        if(map.isEmpty()){
            System.out.println("There isn't an entry with that LastName");
            return;
        }
        else{
            System.out.println("The following "+map.size()+ " entries were " +
                    "found in " +
                    "the " +
                    "address book, select number of entry to remove:");
        }
        //print the map with the last name
        int k = 1;
        for(Map.Entry<Integer, AddressEntry> entry : map.entrySet()){
            System.out.println(k + "." + entry.getValue().toString());
            k++;
        }
        Scanner selection = new Scanner(System.in);
        String temp = selection.nextLine();
        int input = Integer.parseInt(temp);

        System.out.println("Hit y to remove the following entry or n to " +
                "return to main menu:");
        System.out.println(map.get(input));

        Scanner remove = new Scanner(System.in);
        String removeConfirm = remove.next();
        if(removeConfirm.equals("n")){
            return;
        }
        else if(removeConfirm.equals("y")){
            addressEntryList.remove(map.get(input));
            System.out.println("Successfully removed");
        }
    }

}
