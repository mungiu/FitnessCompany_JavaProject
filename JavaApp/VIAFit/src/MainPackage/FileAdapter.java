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
//		for (int i = 0; i < allEventsList.size(); i++)
//			if (allEventsList.get(i).getStarTime().isBefore(time) < cal.get(GregorianCalendar.HOUR_OF_DAY))
//				if (allEventsList.get(i).getEndTime() > cal.get(GregorianCalendar.HOUR_OF_DAY))
//					onGoingEventsList.add(allEventsList.get(i));

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
	
	/**
	 * Method that converts the ArrayList<String> into a String array for use in ComboBox
	 * @return temp an array of strings
	 */
	public String[] getAllClassTypes()
	{
//	   String[] temp = new String[allClassTypeList.size()+1];
//	   temp[0] = "All events";
//	   for(int i = 0;i<allClassTypeList.size();i++)
//	   {
//	      temp[i+1] = allClassTypeList.get(i).getClassName();
//	   }
//	   return temp;
	   String[] temptemp = new String[3];
	   temptemp[0] = "All events";
	   temptemp[1] = "Change this";
	   temptemp[2] = "In FileAdapter";
	   return temptemp;
	}
	
	/**
	 * Method for finding all upcoming or ongoing events a specific member is signed up for
	 * @param member The member object that is searched for in the ongoing and upcoming ArrayLists
	 * @return temp An ArrayList<Event> containing all upcoming and ongoing events the given member attended
	 */
	public ArrayList<Event> getAllAttendingEventsForMember(Member member)
	{
	   ArrayList<Event> temp = new ArrayList<Event>();
	   
	   for(int i = 0;i<onGoingEventsList.size();i++)
      {
         if(onGoingEventsList.get(i).getMembersList().contains(member))
         {
            temp.add(onGoingEventsList.get(i));
         }
      }
	   
	   for(int i = 0;i<upComingEventsList.size();i++)
	   {
	      if(upComingEventsList.get(i).getMembersList().contains(member))
	      {
	         temp.add(upComingEventsList.get(i));
	      }
	   }
	   return temp;
	}
	
//	public ArrayList<Event> getAllEventsOfType(String input)
//	{
//	   ArrayList<Event> allEventOfType = new ArrayList<Event>();
//	   
//	   Work in progress
//	}
}