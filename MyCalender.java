import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ListIterator;
import java.util.Timer;


public class MyCalendar {
  private String title;
  ArrayList<Appointment> appt = new ArrayList<Appointment>();
  private int apptcount = 0;
  int booked = 0;
  //private 
  public MyCalendar(String string) {
    this.title = string;
    
  }

  public boolean createAppointmentSlot(Appointment slot1) {
    ListIterator<Appointment> iterator = appt.listIterator();
 
    int flag = 0;
    Date aptDate;
    Date newaptDate;
    Timer t;
    String dateTime = slot1.getDateTime();
    int duration = slot1.getDuration();
    SimpleDateFormat date1 = new SimpleDateFormat ("dd/MM/yy HH:mm:ss");
    try
    {
      aptDate = date1.parse(dateTime);
      int minutes = aptDate.getMinutes();
      int totalminutes = minutes +duration;
      aptDate.setMinutes(totalminutes);

      dateTime = aptDate.toString();

      if ((appt.isEmpty())) {

       appt.add(slot1);
       flag = 1;
      } 
      else 
      {
        while (iterator.hasNext()) 
        {
          String s =iterator.next().getDateTime();

          newaptDate = date1.parse(s);

          if (aptDate.before(newaptDate)) {
            appt.add(slot1);

            flag = 1;
          } else 
          {
            flag = 0;
          }
        }
      }
     }
    catch(Exception e)
    {
     System.out.println(e);
    }
    if (flag == 0)
    return false;
    else 
      return true;
    
    //return false;
  }

  public boolean bookAppointment(String string, String string2, int i, String string3) {
    ListIterator<Appointment> iterator = appt.listIterator();
    Date uDate,oldDate;
    int flag = 0;
    SimpleDateFormat date1 = new SimpleDateFormat ("dd/MM/yy HH:mm:ss");
    try {
      uDate = date1.parse(string2);
      while (iterator.hasNext()) 
      {
        String s =iterator.next().getDateTime();
        oldDate = date1.parse(s);
        if (oldDate.equals(uDate)) {
          if (booked == 0) {
          flag = 1;
          booked = 1;
          }
        }
      }
    } catch(Exception e) {
      System.out.println(e);
     }
    if (flag == 0)
    return false;
    else
      return true;
  }

  public boolean cancelAppointment(String string) {
    ListIterator<Appointment> iterator = appt.listIterator();
    Date uDate,oldDate;
    int flag = 0;
    SimpleDateFormat date1 = new SimpleDateFormat ("dd/MM/yy HH:mm:ss");
    try {
      uDate = date1.parse(string);
      while (iterator.hasNext()) 
      {
        String s =iterator.next().getDateTime();
        oldDate = date1.parse(s);
        if (oldDate.equals(uDate)) {
        if (booked == 1) {
          booked = 0;
          flag = 1;
        }
      }
      } 
    }catch(Exception e) {
      System.out.println(e);
     }
      if (flag == 0)
        return false;
        else
          return true;
  }
 }

