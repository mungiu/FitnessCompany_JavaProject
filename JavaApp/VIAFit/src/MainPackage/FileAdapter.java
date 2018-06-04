package MainPackage;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class FileAdapter
{
	String membersListBinFileName, instructorsListBinFileName, eventsListBinFileName, classTypeListBinFileName;

	MyFileIO myFileIO;
	MyTextFileIO myTextFileIO;

	private ArrayList<Event> onGoingEventsList, upComingEventsList, eventsList;
	private ArrayList<ClassType> allClassTypeList;
	private ArrayList<Member> membersList;
	private ArrayList<Instructor> instructorsList;

	public FileAdapter()
	{
		eventsListBinFileName = "allEvents.bin";
		instructorsListBinFileName = "allInstructors.bin";
		membersListBinFileName = "allMembers.bin";
		classTypeListBinFileName = "allClassTypes.bin";

		/// CHECK OR COPY
		allClassTypeList = new ArrayList<ClassType>();
		onGoingEventsList = new ArrayList<Event>();
		upComingEventsList = new ArrayList<Event>();
		eventsList = new ArrayList<Event>();
		membersList = new ArrayList<Member>();

		myFileIO = new MyFileIO();
		myTextFileIO = new MyTextFileIO();

		// update and save of all lists ????? BROKE THE UPDATE PANEL - SIMON
//		updateOnGoingEventsList();
//		updateUpComingEventsList();
//		updateInstructorsList();
//		updateMembersList();
//		updateEventsList();
//		updateClassTypesList();
	}

	public ArrayList<Event> getOnGoingEventsList()
	{
		return onGoingEventsList;
	}

	public ArrayList<Event> getUpComingEventsList()
	{
		return upComingEventsList;
	}

	public ArrayList<ClassType> getAllClassTypesList()
	{
		return allClassTypeList;
	}

	/**
	 * Method that converts the ArrayList<String> into a String array for use in
	 * ComboBox
	 * 
	 * @return temp an array of strings
	 */
	public String[] getAllClassTypes()
	{
		updateClassTypesList();
		String[] temp = new String[1];
		temp[0] = "All events";
		if (allClassTypeList != null)
		{
			temp = new String[allClassTypeList.size() + 1];
			temp[0] = "All events";
			for (int i = 0; i < allClassTypeList.size(); i++)
			{
				temp[i + 1] = allClassTypeList.get(i).getClassName();
			}
		}
		return temp;

	}

	public ArrayList<Member> getMembersList()
	{
		return membersList;
	}

	public ArrayList<Instructor> getInstructorsList()
	{
		return instructorsList;
	}

	public ArrayList<Event> getEventsList()
	{
		return eventsList;
	}

	public boolean getInstructorIsAvailable(Instructor instructor, Event event)
	{
		for (int i = 0; i < eventsList.size(); i++)
			if (eventsList.get(i).getInstructorsList().contains(instructor))
				for (int j = 0; j < eventsList.size(); j++)
					if (eventsList.get(i).getStarTime().isBefore(event.getStarTime())
							&& (!event.getStarTime().isBefore(eventsList.get(i).getEndTime())))
						return true;

		return false;
	}

	public ArrayList<ClassType> getInstructorQualifiedFor(Instructor instructor)
	{

		return instructor.getQualifiedClassesList();
	}

	public ArrayList<ClassType> getToughtEventsList(Instructor instructor)
	{
		return instructor.getAllTaughtEvents();
	}

	/**
	 * Method for finding all upcoming or ongoing events a specific member is signed
	 * up for
	 * 
	 * @param member
	 *            The member object that is searched for in the ongoing and upcoming
	 *            ArrayLists
	 * @return temp An ArrayList<Event> containing all upcoming and ongoing events
	 *         the given member attended
	 */
	public ArrayList<Event> getAllAttendingEventsForMember(Member member)
	{
		ArrayList<Event> temp = new ArrayList<Event>();

		for (int i = 0; i < onGoingEventsList.size(); i++)
			if (onGoingEventsList.get(i).getMembersList().contains(member))
				temp.add(onGoingEventsList.get(i));

		for (int i = 0; i < upComingEventsList.size(); i++)
			if (upComingEventsList.get(i).getMembersList().contains(member))
				temp.add(upComingEventsList.get(i));

		return temp;
	}

	/**
	 * Method that finds all events with a given classType of type String
	 * 
	 * @param input
	 *            A String to compare class type
	 * @return allEventOfType an ArrayList<Event>
	 */
	public ArrayList<Event> getAllEventsOfType(String input)
	{
		ArrayList<Event> allEventOfType = new ArrayList<Event>();

		for (int i = 0; i < eventsList.size(); i++)
			if (eventsList.get(i).getClassType().equals(input))
				allEventOfType.add(eventsList.get(i));

		return allEventOfType;
	}

	public void updateOnGoingEventsList()
	{
		updateEventsList();

		GregorianCalendar calendar = new GregorianCalendar();
		MyClock currentTime = new MyClock(calendar.get(GregorianCalendar.HOUR_OF_DAY), 0, 0);
		MyClock thisEventStartTime;
		MyClock thisEventEndTime;
		MyDate today = MyDate.today();
		MyDate thisEventStartDate;

		
			for (int i = 0; i < eventsList.size(); i++)
			{
				thisEventStartTime = eventsList.get(i).getStarTime();
				thisEventEndTime = eventsList.get(i).getEndTime();
				thisEventStartDate = eventsList.get(i).getStartDate();

				boolean eventIsToday = thisEventStartDate.getDay()==today.getDay() && thisEventStartDate.getMonth()==today.getMonth() && thisEventStartDate.getYear()==today.getYear();
				boolean eventStarted = thisEventStartTime.getHour() < currentTime.getHour();
				boolean eventDidNotFinish = thisEventEndTime.getHour() > currentTime.getHour();
				boolean eventFinished = thisEventEndTime.getHour() < currentTime.getHour();
				boolean containsEvent = onGoingEventsList.contains(eventsList.get(i));


				if (eventIsToday && eventStarted && eventDidNotFinish && !containsEvent)
				{
				   onGoingEventsList.add(eventsList.get(i));
				}
				else if (containsEvent && eventFinished)
					onGoingEventsList.remove(i);
			}
	}

	public void updateUpComingEventsList()
	{
		updateEventsList();

		int maxUpcomingEvents = 30;
		GregorianCalendar calendar = new GregorianCalendar();
		Event currentEvent;

		MyClock currentTime = new MyClock(calendar.get(GregorianCalendar.HOUR_OF_DAY), 0, 0);
		MyClock thisEventStartTime;
		MyClock thisEventEndTime;

		MyDate today = MyDate.today();
		MyDate thisEventStartDate;
		MyDate thisEventEndDate;


			for (int i = 0; i < eventsList.size(); i++)
			{
				currentEvent = eventsList.get(i);
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
					{
					   upComingEventsList.add(currentEvent);
					}
					else if (eventIsUpcomingMonths)
					{
					   upComingEventsList.add(currentEvent);
					}
					else if (eventIsUpcomingDays)
					{
					   upComingEventsList.add(currentEvent);
					}
					else if (eventIsUpcomingHours)
					{
					   upComingEventsList.add(currentEvent);
					}	
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

	public void updateInstructorsList()
	{
		instructorsList = readInstructorsListFromBin();
	}

	public void updateMembersList()
	{
		membersList = readMembersListFromBin();
	}

	public void updateEventsList()
	{
		eventsList = readEventsListFromBin();
	}

	public void updateClassTypesList()
	{
		allClassTypeList = readClassTypesListFromBin();
	}

	public void saveMembersListToBin(ArrayList<Member> membersList)
	{
		try
		{
			myFileIO.writeToFile(membersListBinFileName, membersList);
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void saveMemberToAvailableBinList(Member member)
	{
		ArrayList<Member> tempList = readMembersListFromBin();
		tempList.add(member);
		saveMembersListToBin(tempList);
	}

	public void saveInstructorsListToBin(ArrayList<Instructor> instructorsList)
	{
		try
		{
			myFileIO.writeToFile(instructorsListBinFileName, instructorsList);
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void saveInstructorToAvailableBinList(Instructor instructor)
	{
		ArrayList<Instructor> tempList = readInstructorsListFromBin();
		tempList.add(instructor);
		saveInstructorsListToBin(tempList);
	}

	public void saveEventsListToBin(ArrayList<Event> eventsList)
	{
		try
		{
			myFileIO.writeToFile(eventsListBinFileName, eventsList);
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void saveEventToAvailableBinList(Event event)
	{
		ArrayList<Event> tempList = readEventsListFromBin();
		tempList.add(event);
		saveEventsListToBin(tempList);
	}

	public void saveClassTypesListToBin(ArrayList<ClassType> classTypesList)
	{
		try
		{
			myFileIO.writeToFile(classTypeListBinFileName, classTypesList);
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void saveClassTypeToAvailableBinList(ClassType ClassType)
	{
		ArrayList<ClassType> tempList = readClassTypesListFromBin();
		tempList.add(ClassType);
		saveClassTypesListToBin(tempList);
	}

	public ArrayList<Member> readMembersListFromBin()
	{
		ArrayList<Member> tempList = new ArrayList<Member>();

		try
		{
			Object obj = myFileIO.readObjectFromFile(membersListBinFileName);
			if (obj instanceof ArrayList<?>)
			{
				ArrayList<?> all = (ArrayList<?>) obj;
				for (int i = 0; i < all.size(); i++)
					tempList.add((Member) all.get(i));
			}

		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EOFException e)
		{
			// e.printStackTrace();
			System.out.println("Members List Binary File reached end of line");
		}

		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tempList;
	}

	public ArrayList<Instructor> readInstructorsListFromBin()
	{
		ArrayList<Instructor> tempList = new ArrayList<Instructor>();

		try
		{
			Object obj = myFileIO.readObjectFromFile(instructorsListBinFileName);
			if (obj instanceof ArrayList<?>)
			{
				ArrayList<?> all = (ArrayList<?>) obj;
				for (int i = 0; i < all.size(); i++)
					tempList.add((Instructor) all.get(i));
			}

		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EOFException e)
		{
			// e.printStackTrace();
			System.out.println("Instructor List Binary File reached end of line");
			// TODO
		} catch (IOException e)

		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tempList;
	}

	public ArrayList<Event> readEventsListFromBin()
	{
		ArrayList<Event> tempList = new ArrayList<Event>();

		try
		{
			Object obj = myFileIO.readObjectFromFile(eventsListBinFileName);
			if (obj instanceof ArrayList<?>)
			{
				ArrayList<?> all = (ArrayList<?>) obj;
				for (int i = 0; i < all.size(); i++)
					tempList.add((Event) all.get(i));
			}

		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EOFException e)
		{
			// e.printStackTrace();
			System.out.println("Events List Binary File reached end of line");
		}

		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tempList;
	}

	public ArrayList<ClassType> readClassTypesListFromBin()
	{
		ArrayList<ClassType> tempList = new ArrayList<ClassType>();

		try
		{
			Object obj = myFileIO.readObjectFromFile(classTypeListBinFileName);
			if (obj instanceof ArrayList<?>)
			{
				ArrayList<?> all = (ArrayList<?>) obj;
				for (int i = 0; i < all.size(); i++)
					tempList.add((ClassType) all.get(i));
			}

		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EOFException e)
		{
			// e.printStackTrace();
			System.out.println("EventsType List Binary File reached end of line");
		}

		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tempList;
	}
	
	public int getNewID(Object obj)
   {
	   if(obj instanceof Event)
	   {
      int biggestID = 0;
      
         for (int i = 0; i < eventsList.size(); i++)
            if (biggestID < eventsList.get(i).getEventID())
               biggestID = eventsList.get(i).getEventID();
     
      return biggestID + 1;
	   }
	   if(obj instanceof Member)
      {
      int biggestID = 0;

         for (int i = 0; i < membersList.size(); i++)
            if (biggestID < membersList.get(i).getMemberID())
               biggestID = membersList.get(i).getMemberID();
     
      return biggestID + 1;
      }
	   if(obj instanceof Instructor)
      {
      int biggestID = 0;


         for (int i = 0; i < instructorsList.size(); i++)
            if (biggestID < instructorsList.get(i).getInstructorID())
               biggestID = instructorsList.get(i).getInstructorID();
     
      return biggestID + 1;
      }
	   else return -1;
   }
}