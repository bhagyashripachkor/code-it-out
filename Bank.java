
/**
 * Write a description of class Ban here.k
 * 
 * @author (bhagyashri) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
public class Bank
{
    private int accNumber;
    private String name;
    private String address;
    private int phoneNumber;
    public double balance;
    public double totalAmount=0.0;
    DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
    Calendar calobj = Calendar.getInstance();

    
    
    //Date date = new Date();
    public Bank()
    {
       
        accNumber=0;
        name="";
        address="";
        phoneNumber=0;
        balance=0.0;
        totalAmount=0.0;
    }
    
    public double credit(double balance)
    {
        this.balance=this.balance + balance;
        this.totalAmount=balance;
        //System.out.println(dateFormat.format(date));
        System.out.println(df.format(calobj.getTime()));
        
        return this.totalAmount;
    }
    
    public double debit(double amount)
    {
        balance=balance-amount;
        this.totalAmount=balance;
        //System.out.println(dateFormat.format(date));
        System.out.println(df.format(calobj.getTime()));
        return this.totalAmount;
    }
    
    
    public static void main(String[] args)
    {
        Bank b=new Bank();
        Scanner in = new Scanner(System.in);
        double camount=0,damount=0,ctotal=0,dtotal=0;
        System.out.println("Enter the bank details");
        System.out.println("Enter name");
        b.name=in.nextLine();
        System.out.println("Enter account number");
        b.accNumber=in.nextInt();
        System.out.println("Enter address");
        b.address=in.nextLine(); 
        System.out.println("Enter phone number");
        b.phoneNumber=in.nextInt();
        
        System.out.println("Credit amount in account");
        camount=in.nextInt();
        b.totalAmount=b.credit(camount);
      
        
        System.out.println("Debit amount in account");
        damount=in.nextInt();
        b.totalAmount=b.debit(damount);
        System.out.println("---------------------");
        System.out.println("Total amount in account");
        System.out.println(b.totalAmount);
        
        System.out.println("Credit amount in account");
        camount=in.nextInt();
        b.totalAmount=b.credit(camount);
      
        
        System.out.println("Debit amount in account");
        damount=in.nextInt();
        b.totalAmount=b.debit(damount);
        System.out.println("---------------------");
        System.out.println("Total amount in account");
        System.out.println(b.totalAmount);
        
    }
}
