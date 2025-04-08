import java.util.HashMap;
import ecs100.*;
/**
 * Holds a collection of books in a hashmap
 * Allows a user to add, find, print all books
 * i didnt get the rest of the description down oop
 *
 * @help
 * @still monday morning
 */
public class Books
{
    // fields
    private HashMap<Integer, Book> library; // declaring the hashmap
    private int currBookId; // store the current id number of the book being added
    private Book currBook;  // store the instance of the current book
    

    /**
     * Constructor for objects of class Books
     */
    public Books()
    {
        // initialise instance variables
        library = new HashMap<Integer, Book>(); // initialise hashmap
        
        // create books
        Book b1 = new Book(1, "The Wicked King", "Holly Black", 12);
        Book b2 = new Book(2, "The Holy Bible", "Lil Jeezy",36);
        Book b3 = new Book(3, "Harry Potter", "JK Rowling", 42);
        
        // add books to collection
        library.put(1, b1);
        library.put(2, b2);
        library.put(3, b3);
        
        this.currBookId = 3;    // Store the current book id number
    }
    
    
    /**
     * Menu to print all and call appropriate methods
     */
    public void menu()
    {
        // Print menu and force choice
        String choice;
        do
        {
            UI.println("1. (A)dd a book");
            UI.println("2. (F)ind a book");
            UI.println("3. (P)rint all books");
            UI.println("4. (Q)uit");
            
            choice = UI.askString("Enter a choice");
            
            if (choice.equalsIgnoreCase("A"))
            {
                // Add book
            }
            else if (choice.equalsIgnoreCase("F"))
            {
                // Find book
            }
            else if (choice.equalsIgnoreCase("P"))
            {
                // Print all books
            }
            else if (choice.equalsIgnoreCase("Q"))
            {
                // Quit
                UI.println("Goodbye");
                UI.quit();
            }
            else
            {
                UI.println("Not a valid choice.");
            }
        }
        while (!choice.equalsIgnoreCase("Q"));
    }
}
