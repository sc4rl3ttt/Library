import ecs100.*;
/**
 * GUI class for books manager 
 * Allows add, print, find books on GUI
 * 
 * ??? delete
 * ??? click the book cover to like the book
 * ??? show the total number of likes
 *
 * @yea definitely not me
 * @im sweating balls
 * @im gonna touch you
 */
public class GUI
{
    // field
    private Books books;     //declare books instance
    private Book book;      //declare book instance
    
    /**
     * Constructor for objects of class GUI
     */
    public GUI()
    {
        // initialise instance variables
        books = new Books();           //instantiate the books
        
        // Set up GUI
        UI.initialise();
        UI.addButton("Print All", books::printAllBooks);
        UI.addButton("Add", this::addBook);
        UI.addButton("Find", this::findBook);
        UI.addButton("Quit", UI::quit);

    }

    /**
     *Add a book to collection
     */
    public void addBook()
    {
        // force a range of quantity
        final int MAX_QUANTITY = 99; // max quantity it can add to the hashmap
        int quantity;

        //Ask the user for details
        String name = UI.askString("Title: ");
        String author = UI.askString("Author: ");

        //Check boundaries for the number of books added
        do {
            quantity = UI.askInt("Quantity: ");
            if ((quantity > 0) && (quantity <= MAX_QUANTITY)){
                UI.println("Added");
            }else if (quantity > MAX_QUANTITY) {
                UI.println("Must be less than 100");
            }else if (quantity < 1){
                UI.println("Must be greater than 0");
            }else{
                UI.println("Must be a number!");
            }
        }while (0 > quantity || quantity > MAX_QUANTITY);
        // add a book image for display
        String imgFileName = UIFileChooser.open("Choose Image File: ");
        
        // add books with images
        this.books.addBook(name, author, quantity, imgFileName);
    }

    /**
     * Finds book based on name
     * Prints out the author and qty if found
     */
    public void findBook(){
        String bookName = UI.askString("Name of Books: ");
        if(this.books.findBook(bookName.toLowerCase().trim())){ // Refer back to Books instance books method findBook to return true or false
            UI.println("Found Book!");
            
            this.book = books.getBook(); 
            this.book.displayBook();
            UI.println("Author: " + this.book.getAuthor());
            UI.println("Quantity: " + this.book.getQuantity());
            

        }
        else{
            UI.println("That book does not exist!");
        }
    }
    /**
     * main routine
     */
    public static void main(String[] args) {
        new GUI();
    }
    
}
