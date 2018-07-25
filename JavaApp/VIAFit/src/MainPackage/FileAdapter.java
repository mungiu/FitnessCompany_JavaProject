package MainPackage;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;

/**
 * A class representing FileAdapter with events list, members list, instructors
 * list, class types list.
 * 
 * @author Group 1
 */
public class FileAdapter
{

	String membersListBinFileName, instructorsListBinFileName, eventsListBinFileName, classTypeListBinFileName;

	private ArrayList<Event> onGoingEventsList, upComingEventsList;

	MyFileIO myFileIO;
	private EventsList eventsList;
	private MembersList membersList;
	private InstructorsList instructorsList;
	private ClassTypesList classTypesList;

	public FileAdapter() throws FileNotFoundException, ClassNotFoundException, IOException
	{
		eventsListBinFileName = "allEvents.bin";
		instructorsListBinFileName = "allInstructors.bin";
		membersListBinFileName = "allMembers.bin";
		classTypeListBinFileName = "allClassTypes.bin";

		myFileIO = new MyFileIO();
		try
		{
			/// CHECK if lists already exists and copy OR create new lists
			if (myFileIO.readObjectFromFile(eventsListBinFileName).equals(null))
				eventsList = new EventsList();
			else
				updateEventsList();

			if (myFileIO.readObjectFromFile(membersListBinFileName).equals(null))
				membersList = new MembersList();
			else
				updateMembersList();

			if (myFileIO.readObjectFromFile(instructorsListBinFileName).equals(null))
				instructorsList = new InstructorsList();
			else
				updateInstructorsList();

			if (myFileIO.readObjectFromFile(classTypeListBinFileName).equals(null))
				classTypesList = new ClassTypesList();
			else
				updateInstructorsList();
		} catch (EOFException e)
		{
			System.out.println("One of the binary files reached end of line when File adapter was instantiated");
		}

		onGoingEventsList = new ArrayList<Event>();
		upComingEventsList = new ArrayList<Event>();
	}

	/**
	 * Gets the list of on going events list.
	 * 
	 * @return the list of onGoingEventsList.
	 */
	public ArrayList<Event> getOnGoingEventsList()
	{
		return onGoingEventsList;
	}

	/**
	 * Gets the list of up coming events list.
	 * 
	 * @return the list of upComingEventsList.
	 */
	public ArrayList<Event> getUpComingEventsList()
	{
		return upComingEventsList;
	}

	/**
	 * Gets the EventsList from FileAdapter.
	 * 
	 * @return the eventsList.
	 */
	public EventsList getEventsList()
	{
		return eventsList;
	}

	/**
	 * Gets the InstructorList from FileAdapter.
	 * 
	 * @return the instructorList.
	 */
	public InstructorsList getInstructorsList()
	{
		return instructorsList;
	}

	/**
	 * Gets the MembersList from FileAdapter.
	 * 
	 * @return the membersList.
	 */
	public MembersList getMembersList()
	{
		return membersList;
	}

	/**
	 * Gets the ClassTypesList from FileAdapter.
	 * 
	 * @return the classTypesList.
	 */
	public ClassTypesList getClassTypesList()
	{
		return classTypesList;
	}

	/**
	 * Updates the OnGoingEventsList table.
	 */
	public void updateOnGoingEventsList()
	{
		updateEventsList();
		onGoingEventsList.clear();
		GregorianCalendar calendar = new GregorianCalendar();
		MyClock currentTime = new MyClock(calendar.get(GregorianCalendar.HOUR_OF_DAY), 0, 0);
		MyDate today = MyDate.today();

		ArrayList<Event> temp = new ArrayList<Event>();
		try
		{
			for (int i = 0; i < eventsList.getEventsList().size(); i++)
				temp.add(eventsList.getEventsList().get(i));
		} catch (NullPointerException e)
		{
			System.out.println("Events list binary file is still empty, nothing to update");
		}
		Event currentEvent;

		MyClock thisEventStartTime;
		MyClock thisEventEndTime;
		MyDate thisEventStartDate;
		MyDate thisEventEndDate;

		for (int i = 0; i < temp.size(); i++)
		{
			currentEvent = temp.get(i);

			thisEventStartTime = currentEvent.getStartTime();
			thisEventEndTime = currentEvent.getEndTime();
			thisEventStartDate = currentEvent.getStartDate();
			thisEventEndDate = currentEvent.getEndDate();

			boolean eventIsToday = thisEventStartDate.compareTo(today) == 0;

			boolean eventStartedPastDate = thisEventStartDate.compareTo(today) < 0;
			boolean eventStarted = (eventStartedPastDate
					| (eventIsToday && thisEventStartTime.compareTo(currentTime) <= 0));

			boolean eventFinishedFutureDate = thisEventEndDate.compareTo(today) > 0;
			boolean eventDidNotFinish = (eventFinishedFutureDate
					| (eventIsToday && thisEventEndTime.compareTo(currentTime) > 0));

			boolean eventFinishedPastDate = thisEventEndDate.compareTo(today) < 0;
			boolean eventFinished = (eventFinishedPastDate
					| (eventIsToday && thisEventEndTime.compareTo(currentTime) <= 0));

			boolean containsEvent = onGoingEventsList.contains(currentEvent);

			if (eventStarted && eventDidNotFinish && !containsEvent)
				onGoingEventsList.add(currentEvent);
			else if (containsEvent && eventFinished)
				onGoingEventsList.remove(i);
		}
	}

	/**
	 * Updates the upComingEventsList and sorts it.
	 */
	public void updateUpComingEventsList()
	{
		updateEventsList();
		upComingEventsList.clear();
		int maxUpcomingEvents = 30;
		GregorianCalendar calendar = new GregorianCalendar();
		MyClock currentTime = new MyClock(calendar.get(GregorianCalendar.HOUR_OF_DAY), 0, 0);
		MyDate today = MyDate.today();

		ArrayList<Event> temp = new ArrayList<Event>();
		try
		{
			for (int i = 0; i < eventsList.getEventsList().size(); i++)
				temp.add(eventsList.getEventsList().get(i));
		} catch (NullPointerException e)
		{
			System.out.println("Events List binary file is still empty, nothing to update");
		}

		Event currentEvent;

		MyDate thisEventStartDate;
		MyDate thisEventEndDate;
		MyClock thisEventStartTime;

		for (int i = 0; i < temp.size(); i++)
		{
			currentEvent = temp.get(i);
			thisEventStartDate = currentEvent.getStartDate();
			thisEventEndDate = currentEvent.getEndDate();
			thisEventStartTime = currentEvent.getStartTime();

			boolean eventIsUpcomingDate = thisEventStartDate.compareTo(today) > 0;
			boolean eventIsToday = thisEventStartDate.compareTo(today) == 0;
			boolean eventIsUpcomingTime = thisEventStartTime.compareTo(currentTime) > 0;
			boolean eventStartedPastDate = thisEventEndDate.compareTo(today) < 0;
			boolean eventStarted = (eventStartedPastDate
					| (eventIsToday && thisEventStartTime.compareTo(currentTime) <= 0));
			boolean containsEvent = upComingEventsList.contains(currentEvent);
			// adding future events (30 max)
			if (upComingEventsList.size() < maxUpcomingEvents && !containsEvent)
			{
				if (eventIsUpcomingDate)
					upComingEventsList.add(currentEvent);
				else if (eventIsToday && eventIsUpcomingTime)
					upComingEventsList.add(currentEvent);
			} else if (containsEvent && eventStarted)
				upComingEventsList.remove(currentEvent);
		}

		// sorting events
		Collections.sort(upComingEventsList, new Comparator<Event>()
		{
			@Override
			public int compare(Event eventLowerIndex, Event eventUpperIndex)
			{
				return eventLowerIndex.compareTo(eventUpperIndex);
			}
		});

	}

	/**
	 * Updates the instructorsList.
	 */
	public void updateInstructorsList()
	{
		try
		{
			instructorsList.setInstructorsList(readInstructorsListFromBin());
		} catch (NullPointerException e)
		{
			System.out.println("Instructors List binary file is empty, nothing to update");
		}
	}

	/**
	 * Updates the membersList.
	 */
	public void updateMembersList()
	{
		try
		{
			membersList.setMembersList(readMembersListFromBin());
		} catch (NullPointerException e)
		{
			System.out.println("Members List binary file is empty, nothing to update");
		}
	}

	/**
	 * Updates the eventsList.
	 */
	public void updateEventsList()
	{
		try
		{
			eventsList.setEventsList(readEventsListFromBin());
		} catch (NullPointerException e)
		{
			System.out.println("Events List binary file is empty, nothing to update");
		}
	}

	/**
	 * Updates the classTypesList.
	 */
	public void updateClassTypesList()
	{
		try
		{
			classTypesList.setClassTypesList(readClassTypesListFromBin());
		} catch (NullPointerException e)
		{
			System.out.println("Class Types List binary file is empty, nothing to update");
		}
	}

	/**
	 * Saves the members list to binary file
	 * 
	 * @param membersList
	 *            is what will be stored into binary file.
	 */
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

	/**
	 * Saves member to a available binary list.
	 * 
	 * @param member
	 *            is what will be stored into binary file.
	 */
	public void saveMemberToAvailableBinList(Member member)
	{
		ArrayList<Member> tempList = readMembersListFromBin();
		tempList.add(member);
		saveMembersListToBin(tempList);
	}

	/**
	 * Saves the instructors list to binary file.
	 * 
	 * @param instructorsList
	 *            is what will be stored into binary file.
	 */
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

	/**
	 * Saves the instructor to an available binary list.
	 * 
	 * @param instructor
	 *            is what will be stored into binary file.
	 */
	public void saveInstructorToAvailableBinList(Instructor instructor)
	{
		ArrayList<Instructor> tempList = readInstructorsListFromBin();
		tempList.add(instructor);
		saveInstructorsListToBin(tempList);
	}

	/**
	 * Saves the events list to binary file.
	 * 
	 * @param eventsList
	 *            is what will be stored into binary file.
	 */
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

	/**
	 * Saves event to an available binary list.
	 * 
	 * @param event
	 *            is what will be stored into binary file.
	 */
	public void saveEventToAvailableBinList(Event event)
	{
		ArrayList<Event> tempList = readEventsListFromBin();
		tempList.add(event);
		saveEventsListToBin(tempList);
	}

	/**
	 * Saves the class types list into binary.
	 * 
	 * @param classTypesList
	 *            will be stored into binary file.
	 */
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

	/**
	 * Saves class type to an available binary list.
	 * 
	 * @param classType
	 */
	public void saveClassTypeToAvailableBinList(ClassType classType)
	{
		ArrayList<ClassType> tempList = readClassTypesListFromBin();
		tempList.add(classType);
		saveClassTypesListToBin(tempList);
	}

	/**
	 * Reads the members list from the binary file.
	 * 
	 * @return the list of members from the binary file.
	 */
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
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tempList;
	}

	/**
	 * Reads the instructor list from the binary file.
	 * 
	 * @return the list of instructors from binary file.
	 */
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

	/**
	 * Reads the Events list from the binary file.
	 * 
	 * @return the list of events from the binary file.
	 */
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
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tempList;
	}

	/**
	 * Reads the class type list from binary file.
	 * 
	 * @return the list of class types from the binary file.
	 */
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
			System.out.println("Class Type List Binary File reached end of line");
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tempList;
	}
}