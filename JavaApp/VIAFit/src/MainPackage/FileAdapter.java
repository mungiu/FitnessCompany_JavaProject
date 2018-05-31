package MainPackage;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class FileAdapter
{
	MyFileIO myFileIO;
	MyTextFileIO myTextFileIO;

	private ArrayList<Event> onGoingEventsList, upComingEventsList, allEventsList;
	private ArrayList<ClassType> allClassTypeList;
	private ArrayList<Member> memberList;
	private ArrayList<Instructor> instructorList;

	public FileAdapter()
	{
		myFileIO = new MyFileIO();
		myTextFileIO = new MyTextFileIO();

		updateOnGoingEventsList();
		updateUpComingEventsList();
		updateInstructorsList();
		updateMembersList();

	}

	public ArrayList<Event> getOnGoingEventsList()
	{
		return onGoingEventsList;
	}

	public ArrayList<Event> getUpComingEventsList()
	{
		return upComingEventsList;
	}

	public ArrayList<ClassType> getClassTypeList()
	{
		return allClassTypeList;
	}

	public ArrayList<Member> getMembersList()
	{
		return memberList;
	}

	public ArrayList<Instructor> getInstructorsList()
	{
		return instructorList;
	}

	public boolean getInstructorIsAvailable(Instructor instructor, Event event)
	{
		for (int i = 0; i < allEventsList.size(); i++)
			if (allEventsList.get(i).getInstructorsList().contains(instructor))
				for (int j = 0; j < allEventsList.size(); j++)
					if (allEventsList.get(i).getStarTime().isBefore(event.getStarTime())
							&& (!event.getStarTime().isBefore(allEventsList.get(i).getEndTime())))
						return true;

		return false;
	}

	public void updateOnGoingEventsList()
	{
		GregorianCalendar cal = new GregorianCalendar();

		// add new events
		
		// TODO: FINALIZE
		for (int i = 0; i < allEventsList.size(); i++)
			if (allEventsList.get(i).getStarTime().isBefore(time) < cal.get(GregorianCalendar.HOUR_OF_DAY))
				if (allEventsList.get(i).getEndTime() > cal.get(GregorianCalendar.HOUR_OF_DAY))
					onGoingEventsList.add(allEventsList.get(i));

		// remove old events
	}

	public void updateUpComingEventsList()
	{
		// TODO finalize
	}

	public void updateInstructorsList()
	{
		// TODO finalize
	}

	public void updateMembersList()
	{
		// TODO finalize
	}
}