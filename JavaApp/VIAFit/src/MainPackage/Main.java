package MainPackage;

public class Main
{
	public static void main(String[] args)
	{
		mainGUI test = new mainGUI();
		FileAdapter fileAdapter = new FileAdapter();

		//This will run every 5 min.
		try {
	        while (true) 
	        {
	           fileAdapter.updateOnGoingEventsList();
	           fileAdapter.updateUpComingEventsList();
	           test.updateUpcomingEventsArea();
	           test.updateOnGoingEventsArea();
	            Thread.sleep(5 * 60 * 1000);
	        }
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	}
}
