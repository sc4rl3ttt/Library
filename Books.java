import java.util.HashMap;
import java.util.Scanner;
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
     * Set BookId
     */
    public void setBookId()
    {
        this.currBookId += 1;
    }
    
    /**
     * find book based on name
     * set the current book instance if found
     * @return boolean true or false
     */
    public boolean findBook(String name)
    {
        for (int bookId : library.keySet())
        {
            if (library.get(bookId).getName().toLowerCase().equals(name.toLowerCase()))
            {
                currBook = library.get(bookId);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Add a book tot the hashmap
     */
    public void addBook(String name, String author, int qty)
    {
        this.setBookId();
        library.put(currBookId, new Book(currBookId, name, author, qty));
    }

    /**
     * Print all books
     */
    public void printAll()
    {
        for (int bookId: library.keySet())
        {
            System.out.println(bookId + " Details: ");
            System.out.println(library.get(bookId).getName() + " " + library.get(bookId).getAuthor() + library.get(bookId).getQuantity());
        }
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
            System.out.println("1. (A)dd a book");
            System.out.println("2. (F)ind a book");
            System.out.println("3. (P)rint all books");
            System.out.println("4. (Q)uit");
            
            choice = 
    }
}
