import java.util.*;
import java.text.*;
class Task
{
	private String taskName;
	private Date dueDate;
	private boolean done;
	//Systen.out.println(boolean);
	
	public Task(String taskName)
	{
		this.taskName=taskName;
		  done=false;
	}

	public String getTaskName()
	{
		return taskName;
	}

	public void setDueDate(String date)
	{
		 SimpleDateFormat date1 = new SimpleDateFormat ("dd/MM/yy HH:mm:ss");
		 try
		 {
		 	dueDate = date1.parse(date);
		 	
		 }
		 catch(Exception e)
		 {
		 	System.out.println(e);
		 }
	}

	public Date getDueDate()
	{
		return dueDate;
	}

	public String toString()
	{
		String s = taskName+"  ";
		s=s+dueDate;
		return s;
	}

	public void markAsDone()
	{
		done=true;
	}

	public boolean getMarkAsDone()
	{
		return done;
	}

}
