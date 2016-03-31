import java.util.Iterator;
import java.util.Scanner;


public class DynamicArrayList<E> {
  
  private E[] list1,list2;
  int current_size = 5;
  int count;
  
  


  @SuppressWarnings("unchecked")
  public DynamicArrayList(){

    list1 =(E[])new Object[current_size];
    list2 =(E[])new Object[current_size];
    count=0;
  }
  
 
  @SuppressWarnings("unchecked")
  public void addElements(E e)
  {

    if (current_size == count) {
      list2 = (E[]) new Object[current_size * 2];
      for (int i = 0; i < list1.length; i++ )
        list2[i] = list1[i];
      
      list1 = (E[])new Object[current_size * 2]; 
      for (int i = 0; i < list2.length; i++ )
        list1[i] = list2[i];
    }
     list1[count] = e;
    count++;

  }
  
  public void print()
  {
    if (list1 != null) {
    for(int i=0; list1[i] != null; i++) {
      System.out.print(list1[i] + ",");
    }
    } else {
      System.out.println("List is empty");
    }
  }
  
  public int countElement() {
     return count;
  }
  
  public void searchElement(int n) {
    int flag = 0;
    for (int i =0; i < count; i++) {
      if (list1[i].equals(n)) {
        flag = 1;
        System.out.println(n + " found at position " + (i+1));
      }
    }
    if (flag == 0) {
      System.out.println("Element is not found");
    }
  }
  
  public void read(int index) {
    int flag = 0;
    for (int i = 0; list1[i]!= null; i++) {
      if (index == i) {
        flag = 1;
        System.out.println(list1[i]);
      } 
    }
    if (flag == 0) {
      System.out.println("Index is not found");
    }
  }
  
  public void removeIndex(int index) {
    if (list1 != null) {
    for (int i = 0; list1[i]!= null; i++) {
      if (index == i) {
        list1[index] = list1[i+1];
        count--;
      }
    }
    }
    else {
      System.out.println("List is empty");
    }
  }
  
  public void remove(E n) {
    int flag = 0;
    for (int i =0; list1[i] != null; i++) {
      if (list1[i].equals(n)) {
        flag = 1;
        for(int j=i;list1[j] != null;j++){
          list1[j] = list1[j+1];
        }
        count--;
      }
    }
    if (flag == 0) {
      System.out.println("Element is not found");
    } 
  }
  
  public void modify(E oldElement, E newElement) {
    int flag = 0;
    for (int i = 0; list1[i]!= null; i++) {
      
      if (oldElement.equals(list1[i])) {
        
        list1[i] = newElement;
        flag = 1;
      } 
    }
    if (flag == 0) {
      System.out.println("Element is not found");
    }
  }
  
  public void modifyIndex(int index, E newElement) {
    int flag = 0;
    for (int i = 0; list1[i]!= null; i++) {
      if (index == i) {
        flag = 1;
        list1[i] = newElement;
      }
     }
    if (flag == 0) {
      System.out.println("Index is not found");
    }
  }
}
