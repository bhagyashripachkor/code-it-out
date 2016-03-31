import java.util.Scanner;
import java.util.ArrayList;

public class Add {
	
	public static void main(String[]args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter number1:");
		String number1=sc.nextLine();
		System.out.println("enter number2:");
		String number2=sc.nextLine();
		System.out.println("enter base:");
		String base=sc.nextLine();
		Numbers n=new Numbers(number1,number2,base);

	}
}
