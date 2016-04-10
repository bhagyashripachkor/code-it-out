import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Digits {
    public static void main(String args[] ) throws IOException{
    	try{
        Scanner sc = new Scanner(System.in);
	 int N = Integer.parseInt(sc.nextLine());
	 int tc = 0;
	 while(tc < N){
		 int num = Integer.parseInt(sc.nextLine());
		 digit(num);
		 System.out.println();
		 tc++;
	 }
	 }catch(Exception e){
         return;
     }
	 
 }

private static void digit(int num){
	// TODO Auto-generated method stub

	ArrayList<Integer> l = new ArrayList<Integer>();
	ArrayList<Integer> m = new ArrayList<Integer>();
	for(int i = 0; i < 10; i++)
            l.add(0);

	for(int i = 1; i <= num; i++ )
		m.add(i);

	for(Integer item : m){
		if(item < 10){
			int x = l.get(item);
			l.set(item, x+1);
		}else{
			int y = 0;
			while (item > 0){
			   y = item % 10;
			   int x = l.get(y);
				l.set(y, x+1);
			    item = item / 10;
			}
		}
	}
	int cnt = 0;
	for(Integer z:l){
		if(cnt == 0){
		System.out.print(z);
		cnt++;
		}
		else
			System.out.print(" "+z);
	}
	
	}
    
}
