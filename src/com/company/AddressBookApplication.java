package com.company;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.sql.*;
import javax.swing.*;



/**
 * Represents an Address Book Application
 * @author colinkawai
 */
public class AddressBookApplication extends JFrame{
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
    JLabel label;
    AddDialog addDialog;
    JFrame frame;

   public AddressBookApplication() {
        JButton display = new JButton("Display");
        JButton New = new JButton("New");
        JButton remove = new JButton("Remove");
        /*
        JTextArea textArea = new JTextArea(100, 10);
        textArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(textArea);

         */

        New.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               addDialog = new AddDialog(frame, true,
                       AddressBookApplication.this);
               addDialog.setSize(200, 200);
               //addDialog.add(label);
               addDialog.setVisible(true);
            }
        });

        /*
        display.addActionListener(this);
        New.addActionListener(this);
        remove.addActionListener(this);
         */

        display.setBounds(0, 0, 100, 40);
        New.setBounds(0, 0, 20, 20);
        remove.setBounds(0, 100, 100, 40);
        //scroll.setBounds(0, 150, 300, 350);
        //scroll.setVerticalScrollBarPolicy(JScrollPane
       // .VERTICAL_SCROLLBAR_ALWAYS);

       FlowLayout f = new FlowLayout();
       this.setLayout(f);
       this.add(New);
       this.setSize(400, 500);
       this.setVisible(true);
        /*
        this.add(display);
        this.add(New);
        this.add(remove);
        this.add(scroll);
         */
    }

    public JLabel getJLabel(){
       return label;
    }

    /*
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == display){
           System.out.println("pressed display button ");
        }
        else if(e.getSource() == New){
            d1 = new JDialog(this);
            d1.setSize(200, 200);
            d1.setVisible(true);

            System.out.println("pressed new button ");
        }
        else if (e.getSource() == remove){
            System.out.println("pressed remove button");
        }

    }

     */

    public class AddDialog extends JDialog{
        private AddressBookApplication book;
        public AddDialog(final JFrame frame, boolean modal,
                         AddressBookApplication book){
            super(frame, modal);
            this.book = book;
            JButton button = new JButton("Button");
            this.add(button);
            button.addActionListener(new MyListener());
        }

        class MyListener implements ActionListener{
            public void actionPerformed(ActionEvent e){
                JLabel some = book.getJLabel();
                some.setText("Hello");

            }
        }
    }

    /**
     * The Main method
     * @param args
     */
    public static void main(String[] args) {
        AddressBookApplication book = new AddressBookApplication();
        book.setVisible(true);
        /*
          creates a new addressBook instance
          asks to import a file and calls to init
          prints the current address book
         */
        AddressBook addressBook = new AddressBook();

        /*
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin" +
                    ":@adcsdb01.csueastbay.edu:1521:mcspdb.ad.csueastbay.edu"
                    , "MCS1018", "y_WrlhyT");
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("select * from ADDRESSENTRYTABLE");

            while(rs.next()){
                AddressEntry entry = new AddressEntry(rs.getString(1),
                        rs.getString(2),rs.getString(3),rs.getString(4),
                        rs.getString(5), rs.getInt(6), rs.getString(7),
                        rs.getString(8));
                addressBook.add(entry);
            }
            conn.close();
        }
        catch(Exception e){System.out.println(e);}

         */
        addressBook.list();

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


