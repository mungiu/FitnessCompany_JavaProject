package MainPackage;

public class Main
{
	public static void main(String[] args)
	{
		mainGUI test = new mainGUI();
		FileAdapter fileAdapter = new FileAdapter();
		// Member temp = new Member("test", "test", "test",true);
		// temp.setMemberID(20);
		// fileAdapter.getMembersList().add(temp);
		// fileAdapter.saveMembersListToBin(fileAdapter.getMembersList());
		// fileAdapter.updateMembersList();
		// This will run every 5 min.
		try
		{
			while (true)
			{
				System.out.println("Update");
				fileAdapter.updateOnGoingEventsList();
				fileAdapter.updateUpComingEventsList();
				test.updateUpcomingEventsArea();
				test.updateOnGoingEventsArea();
				Thread.sleep(5 * 60 * 10000);
			}
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
