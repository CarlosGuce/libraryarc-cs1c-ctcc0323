import java.io.*;
import java.util.Scanner;
import java.util.HashMap;
import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*; 

public class LibraryArc {

    //Main class
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //TODO input values into a file
        String[] name = {"Carlos", "Andrei", "Mateo", "Guce"};
        String[] idNumber = {"23-04323", "23-01234", "23-0042", "23-04321"};
        //String[] books = {"Book 1", "Book 2", "Book 3", "Book 4"};
        int[] bookStatus = loadBookStatus(); //load book status from file
        int loggedIn = 0;
        int clientNum = -1;
        int m = -1;
        int a = 0;
        
        File books = new File("bookData.txt");
	
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("bookList.txt"))) {
            String<String> books = new ArrayList<String>();
            books.add("Book 1");
            books.add("Book 2");
            books.add("Book 3");
            books.add("Book 4");
            books.add("Book 5");
            books.add("Book 6");
            books.add("Book 7");
            books.add("Book 8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //welcome user
        //System.out.println("Welcome to the LibraryArc System, Please input your Login Credentials.");
        

        //ask user to input name
        while (loggedIn == 0) {
            System.out.print("Enter Name: ");
            String userName = scanner.nextLine();

            //loop to check if name is in the database
            for (int i = 0; i < 4; i++) {
                if (userName.equals(name[i])) {
                    System.out.println("Success, Welcome " + name[i]);
                    //client's spot in the array
                    clientNum = i;
                    //exit after valid user
                    loggedIn++;
                    //stops invalid statement from printing
                    a++;
                    break;
                }
            }
            //invalid input
            if (a == 0) {
                    System.out.println("Invalid, please try again.");
            }
        }

        //section divider
        System.out.println("------------------------------------------------------------------------");
        
        //reset loggedIn
        loggedIn--;

        //ask user to input identification
        System.out.println("Please verify your identity by inputting your ID. (Format: 23-00000)");
        System.out.print("Enter ID: ");
        String userId = scanner.nextLine();

        //use a different variable for the loop condition
        int idVerificationAttempts = 0;

        while (loggedIn == 0 && idVerificationAttempts < 3) {
            //confirm identity with ID number
            if (userId.equals(idNumber[clientNum])) {
                System.out.println("ID Confirmed.");
                //exit after valid user
                loggedIn++;
            } else {
                System.out.println("Invalid, please try again.");
                //increment the attempt counter
                idVerificationAttempts++;
                //ask the user to input ID again
                System.out.print("Enter ID: ");
                userId = scanner.nextLine();
            }
        }

        //section divider
        System.out.println("------------------------------------------------------------------------");
        
        //check if the user has exceeded the maximum number of ID verification attempts
        if (idVerificationAttempts == 3) {
            System.out.println("Maximum attempts reached. Exiting the system.");
        } else {
            //ask user which service they need
            System.out.println("""
                    Are you borrowing or returning a book?
                    [0] Borrowing
                    [1] Returning
                    [2] Exit System""");
            System.out.print("Enter Number: ");
            int choice = scanner.nextInt();

            //section divider
            System.out.println("------------------------------------------------------------------------");
            
            //ejection message if request invalid
            if (choice != 0 && choice != 1 && choice != 2) {
                System.out.print("Request Invalid, Exiting LibraryArc System.");
            }
            
            switch (choice) {
                case 0:
                    //book borrow function
                    System.out.println("Select a book to borrow.");
                    for (int k = 0; k < 4; k++) {
                        System.out.print("[" + k + "] " + books[k]);
                        m++;
                        if (bookStatus[m] == 0) {
                            System.out.print(" [Not Available]");
                        }
                        System.out.println();
                    }

                    System.out.print("Enter Number: ");
                    int bookChoice = scanner.nextInt();
                    
                    //ejection message if request invalid
                    if (bookChoice != 0 && bookChoice != 1 && bookChoice != 2 && bookChoice != 3) {
                        System.out.print("Request Invalid, Exiting LibraryArc System.");
                        break;
                    }
                    
                    System.out.println("Borrowing " + books[bookChoice] + ".");
                    if (bookStatus[bookChoice] == 1) {
                        System.out.println("Book issued successfully.");
                        //take book out of the system database
                        bookStatus[bookChoice] = 0;
                        //save updated book status to file
                        saveBookStatus(bookStatus);
                    } else {
                        //invalid request
                        System.out.println("Request invalid, Exiting LibraryArc System.");
                    }
                    break;

                case 1:
                    //book return function
                    System.out.println("Select a book to return.");
                    for (int k = 0; k < 4; k++) {
                        System.out.print("[" + k + "] " + books[k]);
                        m++;
                        if (bookStatus[m] == 0) {
                            System.out.print(" [Borrowed]");
                        }
                        System.out.println();
                    }

                    System.out.print("Enter Number: ");
                    int bookReturn = scanner.nextInt();
                    
                    //ejection message if request invalid
                    if (bookReturn != 0 && bookReturn != 1 && bookReturn != 2 && bookReturn != 3) {
                        System.out.print("Request Invalid, Exiting LibraryArc System.");
                        break;
                    }
                    System.out.println("Returning " + books[bookReturn] + ".");
                    if (bookStatus[bookReturn] == 0) {
                        System.out.println("Book returned successfully.");
                        //integrate book back into the system database
                        bookStatus[bookReturn] = 1;
                        //save updated book status to file
                        saveBookStatus(bookStatus);
                    } else {
                        //invalid request
                        System.out.println("Request Invalid, Exiting LibraryArc System.");
                    }
                    break;

                case 2:
                    //exit program
                    System.out.println("Exiting LibraryArc System.");
                    break;
            }
        }

        scanner.close();
    }
    
    

    private static int[] loadBookStatus() {
        try {
            File file = new File("book_status.txt");
            Scanner scanner = new Scanner(file);
            int[] bookStatus = new int[4];
            int i = 0;

            while (scanner.hasNextInt()) {
                bookStatus[i] = scanner.nextInt();
                i++;
            }

            scanner.close();
            return bookStatus;

        } catch (FileNotFoundException e) {
            // If the file doesn't exist, initialize with all books available
            return new int[]{1, 1, 1, 1};
        }
    }

    private static void saveBookStatus(int[] bookStatus) {
        try {
            FileWriter writer = new FileWriter("book_status.txt");
            for (int status : bookStatus) {
                writer.write(status + " ");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
