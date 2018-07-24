package MainPackage;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Main
{
	public static void main(String[] args)
			throws FileNotFoundException, ClassNotFoundException, EOFException, IOException
	{
		FileAdapter fileAdapter = new FileAdapter();
		mainGUI test = new mainGUI();

		// This will run every x millisecond.
		Timer timer = new Timer();
		timer.schedule(new TimerTask()
		{
			public void run()
			{
				test.updateOnGoingEventsArea();
				test.updateUpcomingEventsArea();
			}
		}, 0, 60 * 1000);
	}
}
