
public class Appointment {
  private String inputDateTime; 
  private int duration;
  private int booked;
  public Appointment(String string, int i) {
    this.inputDateTime = string;
    this.duration = i;
  }
  
  public String getDateTime() {
    return this.inputDateTime;
  }
  
  public int getDuration() {
    return this.duration;
  }
  
  public void setDateTime(String string) {
    this.inputDateTime = string;
  }
  
  public void setDuration(int i) {
    this.duration = i;
  }
}
