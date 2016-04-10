import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ClosetK {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String input1 = sc.nextLine();
		String[] str = input1.split(" ");
		int N = Integer.parseInt(str[0]);
		int K = Integer.parseInt(str[1]);
		String input2 = sc.nextLine();

		ArrayList<Integer> array = new ArrayList<Integer>();

		StringTokenizer stok = new StringTokenizer(input2," ");
		while(stok.hasMoreTokens()){
			array.add(Integer.parseInt(stok.nextToken()));
		}
		int closet = 0;
		Collections.sort(array);

		ArrayList<Integer> l = new ArrayList<Integer>();
		ArrayList<Integer> l1 = new ArrayList<Integer>();
		int flag = 0;
		if(N == 1){
			closet = array.get(0);
		}else if(array.contains(K)){
			closet = K;
		}else{
		for(Integer item:array) {
			if(item < K) {
					flag = 2;
					l.add(item);
			

			}else{

				l1.add(item);
			}
			
		}
		if(l1.equals(array))
			flag = 3;
		if(flag== 2){
	
        int m = l.get(l.size()-1);
        int a = array.indexOf(m);
    
        l.add(array.get(a+1));
       

        int last = l.get(l.size()-1);

        int secondLast = l.get(l.size()-2);
     
        if((last- K) == (K - secondLast)){
        	closet = last ;
        }else if((last- K) > (K - secondLast)){
        	closet = secondLast;
        }else if((last- K) < (K - secondLast)){
        	closet = last;
        }
		}
		if(flag == 3){
			closet = l1.get(0);
		}

		}
		System.out.println(closet);
		
	}

}
