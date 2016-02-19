
/**
 * Write a description of class BookShelf here.
 * 
 * @author (bhagyashri) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class BookShelf
{
    private String bookName;
    private int bookId;
    public int totalBooks=0;
    
    public BookShelf()
    {
        bookName="";
        bookId=0;
        totalBooks=0;
    }
    
    public void addBook(String bookName,int bookId)
    {
          
       
        this.bookName=bookName;
        this.bookId=bookId;
        totalBooks++;
    }
    
     public void removeBook(int bookId)
    {
        
        if(this.bookId==bookId)
        {
            System.out.println("book removed");
            this.bookId=0;
            this.bookName=" ";
            totalBooks--;
        
        }
        else
        System.out.println("book not found");
        
   }
    
    public void displayList(String bookName,int bookId)
    {
        if(this.bookId!=0)
        {
        System.out.println("------------");
        System.out.println(this.bookName);
        System.out.println(this.bookId);
        }
    }
    
    public void searchBook(int bookId)
    {
        if(this.bookId==bookId)
        
           //return 1;
           // displayList(this.bookName,this.bookId);
           System.out.println("book found");
       
        else
        //return 0;
        System.out.println("cannot find the book");
        
        
    }
    
    public static void main(String[] args)
    {
        BookShelf book=new BookShelf();
        int search;
        String name2="DS";
        int id2=1;
        book.totalBooks++;
        System.out.println(id2);
        System.out.println(name2);
        
         Scanner in = new Scanner(System.in);
         System.out.println("enter other book details");
         System.out.println("enter the book name");
         book.bookName=in.nextLine();
         System.out.println("enter the book id");
         book.bookId=in.nextInt();
         book.addBook(book.bookName,book.bookId);
         System.out.println("Total books");
         System.out.println(book.totalBooks);
         
         
         
         System.out.println("enter the book Id to be searched");
         book.bookId=in.nextInt();
         book.searchBook(book.bookId);
       
         System.out.println("enter the book Id to be removed");
         book.bookId=in.nextInt();
         book.removeBook(book.bookId);
         System.out.println("total books");
         System.out.println(book.totalBooks);
         
         book.displayList(book.bookName,book.bookId);
    }
}
