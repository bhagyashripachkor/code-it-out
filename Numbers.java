import java.util.ArrayList;
import java.util.StringTokenizer;

public class Numbers {
	ArrayList<Integer> number1;
	ArrayList<Integer> number2;
	ArrayList<Integer> result;
	int base;
	
	public Numbers(String num1, String num2, String base) {
		number1=new ArrayList<>();
		number2=new ArrayList<>();
		result=new ArrayList<>();
		StringTokenizer st=new StringTokenizer(num1,",");
		StringTokenizer st2=new StringTokenizer(num2,",");
		while(st.hasMoreTokens()) {
			number1.add(new Integer(Integer.parseInt(st.nextToken())));
		}
		while(st2.hasMoreTokens()) {
			number2.add(new Integer(Integer.parseInt(st2.nextToken())));
		}
		this.base=Integer.parseInt(base);
		print();
		setToSize();
		Add();
	}
	
	private void setToSize() {
		if(number1.size()>number2.size()) {
			while(number1.size()!=number2.size()) {
				number2.add(0,new Integer(0));
			}
		}
		else if(number1.size()<number2.size()) {
			while(number1.size()!=number2.size()) {
				number1.add(0,new Integer(0));
			}
		}
		print();
	}
	private void print() {
		for(int i=0;i<number1.size();i++){
			System.out.println(number1.get(i)+" ");
		}	
		System.out.println();
		for(int i=0;i<number2.size();i++){
			System.out.println(number2.get(i)+" ");
		}
		System.out.println();
	}
	
	public ArrayList<Integer> Add() {
		int size=number1.size();
		int num1=0;
		int num2=0;
		int mod=0;
		int quot=0;
		for(int i=size-1;i>=0;i--) {
			num1=number1.get(i);
			num2=number2.get(i);
			
			mod=(num1+num2+quot)%base;
			quot=(num1+num2+quot)/base;
			result.add(0,new Integer(mod));
		}
		result.add(0,new Integer(quot));
		if(result.get(0)==0) result.remove(0);
		String res="";
		for(int i=0;i<result.size();i++) {
			res=res+result.get(i)+",";
		}
		
		System.out.println(res);
		return result;
	}
}