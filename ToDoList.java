import java.text.*;
import java.util.*;

class ToDoList {
	private String name;
	private Date date2;
	private Task[] tasks;
	private final int size=11;
	private int taskCount;
	
	public ToDoList(String name) {
		tasks=new Task[size];
		this.name=name;
		taskCount=0;
	}
	public String getName(){
		return name;
	}

	public void addTask(Task task) {
		if(taskCount<size){
		tasks[taskCount++]=task;
		}
	}

	public void printAllTasks() {
		for(Task t : tasks)
		System.out.println(t);
	}

	public Task[] findTask(String name) {
		System.out.println(taskCount);
		Task[] t = new Task[taskCount];
		int c=0;
		for(int i=0;i<taskCount;i++)
		{
			if((tasks[i].getTaskName()).contains(name))
				t[c++]=tasks[i];
							
		}
		return t;
	}

	public Task[] getTask(String datetime)
	{
		Task[] t1 = new Task[taskCount];
		int k=0;
		Date date;
		Date date2=null;
		SimpleDateFormat date1 = new SimpleDateFormat ("dd/MM/yy HH:mm:ss");
		try
		 {
		 	date2 = date1.parse(datetime);
		 }
		 catch(Exception e)
		 {
		 	System.out.println(e);
		 }
		for(int i=0;i<taskCount;i++)
		{
			date=tasks[i].getDueDate();
			if((date).compareTo(date2)==0)
			{
				t1[k]=tasks[i];
				k++;
			}
							
		}
		return t1;
	}
		
	public Task[] getPendingTasks()
	{
		Task[] pending = new Task[taskCount];
		int p=0;
		boolean temp=false;
		for(int i=0;i<taskCount;i++)
		{
			temp=tasks[i].getMarkAsDone();
			if(!temp)
			{
				pending[p]=tasks[i];
				p++;
			}
		}
		return pending;
	}/*public Task[] getPendingTasks() 
    {
        Task[] overdue = new Task[taskCount];
        int j=0;
	    Date temp;
	    SimpleDateFormat date1= new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	    String s = GetCurrentDateTime();
        try {
          	date2 = date1.parse(s);

        } 
        catch(Exception e) {
            System.out.println(e);
            //System.out.println(date2);
        }

        for(int i=0;i<taskCount;i++) {
        	temp = tasks[i].getDueDate();
        	if(temp.after(date2)) {
            	overdue[j] = tasks[i];
            	j++;
        	}
        }
        return overdue;
    }*/

	public Task[] getOverdueTasks() 
    {
        Task[] overdue = new Task[taskCount];
        int j=0;
	    Date temp;
	    SimpleDateFormat date1= new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	    String s = GetCurrentDateTime();
        try {
          	date2 = date1.parse(s);

        } 
        catch(Exception e) {
            System.out.println(e);
            //System.out.println(date2);
        }

        for(int i=0;i<taskCount;i++) {
        	temp = tasks[i].getDueDate();
        	if(temp.before(date2)) {
            	overdue[j] = tasks[i];
            	j++;
        	}
        }
        return overdue;
    }

    public String GetCurrentDateTime()
    {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	    Date date = new Date();
	    return (dateFormat.format(date));
	    
    }
   /* public void removeTask(Task task)
    {
    	taskarray.remove(task);
    }*/
}
