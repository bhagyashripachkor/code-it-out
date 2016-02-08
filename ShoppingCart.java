import java.util.ArrayList;
import java.util.Collection;
import java.util.ListIterator;


public class ShoppingCart {
  ArrayList<Item> item;
  double result ;
  double totalAmount = 0.0;
  double tax = 0.0;
  double discount = 0.0;
  double finalAmount = 0.0;
  public ShoppingCart() {
    item = new ArrayList<Item>();
  }
  public void addToCart(Item i1) {
    item.add(i1);
 }
  public void showCart() {
    ListIterator<Item> iterator = item.listIterator();
    while (iterator.hasNext()) {
      Item i = iterator.next();
    
      System.out.println(i.getProductName() + ":" + i.getQuantity());
  }
}
 public void removeFromCart(Item i3) {
    ListIterator<Item> iterator = item.listIterator();
    while (iterator.hasNext()) {
      Item i1 = iterator.next();
      if(i3.equals(i1)) {
       iterator.remove();
      }
    }
  }
  public double getTotalAmount() {
    ListIterator<Item> iterator = item.listIterator();
    while (iterator.hasNext()) {
      Item i1 = iterator.next();
      totalAmount = totalAmount + (i1.getUnitPrice() * i1.getQuantity());
      finalAmount = totalAmount;
    }
    return totalAmount;
  }
  public double getPayableAmount() {
    ListIterator<Item> iterator = item.listIterator();
    while (iterator.hasNext()) {
      Item i1 = iterator.next();
      tax = totalAmount * 0.14;
      finalAmount = totalAmount + tax;
    }
    return tax;
  }
  public void applyCoupon(String string) {
    if (string.equals("IND10")) {
    ListIterator<Item> iterator = item.listIterator();
    while (iterator.hasNext()) {
      Item i1 = iterator.next();
      discount = totalAmount * 0.10;
      finalAmount =totalAmount - discount;
      finalAmount = finalAmount + (0.14 * finalAmount);
      }
    }
 }
  public void printInvoice() {
    ListIterator<Item> iterator = item.listIterator();
    while (iterator.hasNext()) {
      Item i = iterator.next();
      System.out.println(i.getProductName() + " " + i.getQuantity() + " " + i.getUnitPrice() + " " + (i.getUnitPrice() * i.getQuantity()));
    }
    System.out.println("Total:" + totalAmount);
    System.out.println("Discount:" + discount);
    System.out.println("Tax: " + tax);
    System.out.println("Total:" + finalAmount);
  }
}
