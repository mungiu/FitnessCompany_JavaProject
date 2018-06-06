package MainPackage;

import java.util.Timer;
import java.util.TimerTask;

public class Main
{
	public static void main(String[] args)
	{
		FileAdapter fileAdapter = new FileAdapter();
		EventsList eventsList = new EventsList();
		mainGUI test = new mainGUI();
		
		// This will run every x millisecond.
		Timer timer = new Timer();
      timer.schedule(new TimerTask() 
      {

           public void run() 
           {
            //test.updateOnGoingEventsArea();
            test.updateUpcomingEventsArea();
            System.out.println("No problem - Update");
           }
      }, 0, 10000);
	}
}
