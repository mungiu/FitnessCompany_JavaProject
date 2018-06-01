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
		GregorianCalendar calendar = new GregorianCalendar();
		MyClock currentTime = new MyClock(calendar.get(GregorianCalendar.HOUR_OF_DAY), 0, 0);
		MyClock thisEventStartTime;
		MyClock thisEventEndTime;
		MyDate today = MyDate.today();
		MyDate thisEventStartDate;

	if(allEventsList!=null)
	{
		for (int i = 0; i < allEventsList.size(); i++)
		{
			thisEventStartTime = allEventsList.get(i).getStarTime();
			thisEventEndTime = allEventsList.get(i).getEndTime();
			thisEventStartDate = allEventsList.get(i).getStartDate();

			boolean eventIsToday = thisEventStartDate.equals(today);
			boolean eventStarted = thisEventStartTime.getHour() < currentTime.getHour();
			boolean eventDidNotFinish = thisEventEndTime.getHour() > currentTime.getHour();
			boolean eventFinished = thisEventEndTime.getHour() < currentTime.getHour();
			boolean containsEvent = onGoingEventsList.contains(allEventsList.get(i));

			if (eventIsToday && eventStarted && eventDidNotFinish && !containsEvent)
				onGoingEventsList.add(allEventsList.get(i));

			else if (containsEvent && eventFinished)
				onGoingEventsList.remove(i);
		}
	}
	}

	public void updateUpComingEventsList()
	{
		int maxUpcomingEvents = 30;
		GregorianCalendar calendar = new GregorianCalendar();
		Event currentEvent;

		MyClock currentTime = new MyClock(calendar.get(GregorianCalendar.HOUR_OF_DAY), 0, 0);
		MyClock thisEventStartTime;
		MyClock thisEventEndTime;

		MyDate today = MyDate.today();
		MyDate thisEventStartDate;
		MyDate thisEventEndDate;
	if(allEventsList!=null)
	{
		for (int i = 0; i < allEventsList.size(); i++)
		{
			currentEvent = allEventsList.get(i);

			thisEventStartTime = currentEvent.getStarTime();
			thisEventEndTime = currentEvent.getEndTime();
			thisEventStartDate = currentEvent.getStartDate();
			thisEventEndDate = currentEvent.getEndDate();

			
			boolean eventIsUpcomingYears = thisEventStartDate.getYear() > today.getYear();
			boolean eventIsUpcomingMonths = thisEventStartDate.getMonth() > today.getMonth();
			boolean eventIsUpcomingDays = thisEventStartDate.getDay() > today.getDay();
			boolean eventIsUpcomingHours = thisEventStartTime.getHour() > currentTime.getHour();

			// adding future events (30 max)
			if (upComingEventsList.size() < maxUpcomingEvents && !upComingEventsList.contains(currentEvent))
			{
				if (eventIsUpcomingYears)
					upComingEventsList.add(currentEvent);
				else if (eventIsUpcomingMonths)
					upComingEventsList.add(currentEvent);
				else if (eventIsUpcomingDays)
					upComingEventsList.add(currentEvent);
				else if (eventIsUpcomingHours)
					upComingEventsList.add(currentEvent);
			}

			boolean eventWasBeforeThisYear = thisEventEndDate.getYear() < today.getYear();
			boolean eventWasBeforeThisMonth = thisEventEndDate.getMonth() < today.getMonth();
			boolean eventWasBeforeThisDay = thisEventEndDate.getDay() < today.getDay();
			boolean eventWasBeforeThisHour = thisEventEndTime.getHour() < currentTime.getHour();

			// removing old events
			if (upComingEventsList.contains(currentEvent))
			{
				if (eventWasBeforeThisYear)
					upComingEventsList.remove(currentEvent);
				else if (eventWasBeforeThisMonth)
					upComingEventsList.remove(currentEvent);
				else if (eventWasBeforeThisDay)
					upComingEventsList.remove(currentEvent);
				else if (eventWasBeforeThisHour)
					upComingEventsList.remove(currentEvent);
			}
		}
	}
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
	   String[] temp = new String[1]; 
	   temp[0] = "All events";
	   if(allClassTypeList!=null)
      {
	   temp = new String[allClassTypeList.size()+1];
	   temp[0] = "All events";
	   for(int i = 0;i<allClassTypeList.size();i++)
	   {
	      temp[i+1] = allClassTypeList.get(i).getClassName();
	   }
	   }
	   return temp;
	   
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
	
	/**
	 * Method that finds all events with a given classType of type String
	 * @param input A String to compare class type
	 * @return allEventOfType an ArrayList<Event> 
	 */
	public ArrayList<Event> getAllEventsOfType(String input)
	{
	   ArrayList<Event> allEventOfType = new ArrayList<Event>();
	   
	   for(int i = 0;i<upComingEventsList.size();i++)
	   {
	      if(upComingEventsList.get(i).getClassType().equals(input))
	      {
	         allEventOfType.add(upComingEventsList.get(i));
	      }
	   }
	   return allEventOfType;
	}
}