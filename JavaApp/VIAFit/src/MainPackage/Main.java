package MainPackage;

public class Main
{
	public static void main(String[] args)
	{
		FileAdapter fileAdapter = new FileAdapter();
		EventsList eventsList = new EventsList();
		mainGUI test = new mainGUI();
		
//		for(int i = 0;i<eventsList.getEventsList().size();i++)
//		{
//		   System.out.println(eventsList.getEventsList().get(i).getEventID());
//		}

		// This will run every 5 min.
		try
		{
			while (true)
			{
				fileAdapter.updateOnGoingEventsList();
				fileAdapter.updateUpComingEventsList();
				fileAdapter.updateEventsList();
				Thread.sleep(10000);

			}
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
