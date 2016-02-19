
/**
 * Write a description of class Extract here.
 * 
 * @author (bhagyashri) 
 * @version (a version number or a date)
 */
public class Extract
{
   
   public static void main(String[] args)
   {
     String url=new String("<html><body><a href=\"http://www.google.com\">google link</a></body></html>");
     
     String tag=new String("<a href=\"");
     String ctag=new String("\">");
      
     System.out.println(url);
     int index=0,count=0,index2=0;
     index=url.indexOf(tag);
     
     index=index+9;
     count=index;
     index2=url.indexOf(ctag);
     System.out.println("Output");
     System.out.println(url.subSequence(index,index2));
     
   
   }
}
