package MainPackage;

public class Main
{
	public static void main(String[] args)
	{
		mainGUI test = new mainGUI();
		FileAdapter fileAdapter = new FileAdapter();

		// This will run the updateOnGoingEventsList(); and updateUpComingEventsList();
		// every 5 min.
		try
		{
			while (true)
			{
				fileAdapter.updateOnGoingEventsList();
				fileAdapter.updateUpComingEventsList();
				Thread.sleep(5 * 60 * 10000);
			}
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
