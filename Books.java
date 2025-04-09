import java.util.HashMap;
import java.util.Scanner;
import ecs100.*;
/**
 * Holds a collection of books in a hashmap
 * Allows a user to add, find, print all books
 * i didnt get the rest of the description down oop
 *
 * * ??? delete
 * ??? prevent user from adding a duplicate
 * 
 * @help
 * @still monday morning
 */
public class Books
{
    // fields
    private HashMap<Integer, Book> library; // declaring the hashmap
    private int currBookId; // store the current id of book being added
    private Book currBook; // store the instance of the current book
    private Scanner scanner;
    /**
     * Constructor for objects of class Books
     */
    public Books()
    {
        // initialise instance variables
        library = new HashMap<Integer, Book>(); //initialise hashmap
        scanner = new Scanner(System.in); // initialise scanner
        
        //Create books
        Book b1 = new Book(1, "The Wicked King", "Holly Black", 2);
        Book b2 = new Book(2, "1984", "George Orwell", 42);
        Book b3 = new Book(3, "Song of Achilles", "Madelline Millar", 20);
        
        //add books to collection
        this.library.put(1, b1);
        this.library.put(2, b2);
        this.library.put(3, b3);
        
        this.currBookId = 3;        // Store the current book id
        
    }
    
    /**
     * Set bookId, increment by 1 
     */
    public void setBookId(){
        this.currBookId += 1;
        
    }
    
    /**
     * Add a book to the map
     * @param name, author, qty
     */
    public void addBook(String name, String author, int qty){
        this.setBookId(); // increment by 1 currentID
        this.library.put(this.currBookId, new Book(this.currBookId, name, author, qty));
    }
    
    /**
     * Add a book to the map and display the cover on canva
     * Override the method with different param
     * @ param name, author, qty, img
     */
    public void addBook(String name, String author, int qty, String img){
        this.setBookId();
        this.library.put(this.currBookId, new Book(this.currBookId, name, author, qty, img));
    }
    
    /**
     * Book Getter
     * @return an instance of Book class
     */
    public Book getBook(){
        return this.currBook;
    }
    
    /**
     * Finds a book based on name
     * Sets the current book instance if found
     * @return boolean false if not found
     */
    
    public boolean findBook(String name){
        //Search for book through hashmap library
        for (int bookId: this.library.keySet()){
            if(this.library.get(bookId).getName().toLowerCase().trim().equals(name.toLowerCase().trim())){
                this.currBook = this.library.get(bookId); //Set the current Book
                return true;
            }
        }
        return false;
    }
    
    /**
     * Print details of all books
     * Console based interaction
     */
    public void printAll(){
        //Traverse Map
        for (int bookId : this.library.keySet()){
            System.out.println(bookId + " Details: ");
            System.out.println(this.library.get(bookId).getName() + " "
                        +this.library.get(bookId).getAuthor() + " "
                        +this.library.get(bookId).getQuantity());
        }
    }
    
    /**
     * Print all books
     * GUI
     */
    public void printAllBooks(){
        //Traverse Map
        for (int bookId : this.library.keySet()){
            UI.println(bookId + " Details: ");
            UI.println(this.library.get(bookId).getName() + " "
                        +this.library.get(bookId).getAuthor() + " "
                        +this.library.get(bookId).getQuantity());
        }
    }
    
    /**
     * Menu to print and call appropriate methods
     * console-based menu
     */
    public void menu(){
        //Print menu and force choice
        String choice;
        do{
            System.out.println("(A)dd a book");
            System.out.println("(F)ind a book");
            System.out.println("(P)rint all");
            System.out.println("(Q)uit");
            
            choice = scanner.nextLine().trim().toUpperCase(); // avoid case-senstivity and whitespace before and after the string
            
            switch(choice){
                case "A": // only allows char "A"
                    System.out.print("\nEnter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    
                    // Check for existing book
                    if (this.findBook(title)) {  // check if findBook return true
                        System.out.println("Error: A book with that title already exists!");
                        break;
                    }
                    
                    System.out.print("Enter quantity: ");
                    int qty = Integer.parseInt(scanner.nextLine()); // ?? check how to force an int
                    
                    // call addBook method with 3 param: title, author, qty
                    this.addBook(title, author, qty);
                    System.out.println("Book added successfully! ID: " + this.currBookId);
                    break;
                    
                case "F":
                    System.out.print("\nEnter book title to find: ");
                    String searchTitle = scanner.nextLine();
                        
                    if (this.findBook(searchTitle)){
                        System.out.println("\nBook found: ");
                        System.out.println(this.currBook.getName()); // print current book instance's name    
                    }else{
                        System.out.println("Book not found!");
                    }
                    break;
                        
                case "P":
                    printAll();
                    break;
                        
                case "Q":
                    System.out.println("Goodbye");
                    break;
                        
                default:
                    System.out.println("Invalid choice!");
                    } 
        }while (!choice.equals("Q"));   //loop until choice is 'Q'
        scanner.close();
    }
    
    /**
     * main routine
     */
    public static void main(String[] args) {
        new Books().menu();
    }
}
