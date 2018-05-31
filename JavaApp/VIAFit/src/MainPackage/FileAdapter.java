package MainPackage;

import java.util.ArrayList;

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

	public ArrayList<Event> getOnGoingEventList()
	{
		return onGoingEventsList;
	}

	public ArrayList<Event> getUpComingEventsList()
	{
		return upComingEventsList;
	}

	public boolean getInstructorIsAvailable(Instructor instructor, Event event)
	{
		for (int i = 0; i < allEventsList.size(); i++)
			if (allEventsList.get(i).getInstructorsList().contains(instructor))
				for (int j = 0; j < allEventsList.size(); j++)
					if (allEventsList.get(i).getStarTime().isBefore(event.getStarTime())
							&& (event.getStarTime().isBefore(allEventsList.get(i).getEndTime()) == false))
						return true;

		return false;
	}

	public ArrayList<ClassType> getAllClassTypeList()
	{
		return allClassTypeList;
	}

	public ArrayList<Member> getMemberList()
	{
		return memberList;
	}

	public ArrayList<Instructor> getInstructorList()
	{
		return instructorList;
	}

	public void updateOnGoingEventsList()
	{
		// TODO finalize
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