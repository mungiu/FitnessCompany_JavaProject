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

	private ArrayList<Event> onGoingEventsList, upComingEventsList;

	MyFileIO myFileIO;
	private EventsList eventsList;
	private MembersList membersList;
	private InstructorsList instructorsList;
	private ClassTypesList classTypesList;

	public FileAdapter()
	{
		eventsListBinFileName = "allEvents.bin";
		instructorsListBinFileName = "allInstructors.bin";
		membersListBinFileName = "allMembers.bin";
		classTypeListBinFileName = "allClassTypes.bin";

		/// CHECK OR COPY
		onGoingEventsList = new ArrayList<Event>();
		upComingEventsList = new ArrayList<Event>();
		eventsList = new EventsList();
		membersList = new MembersList();
		instructorsList = new InstructorsList();
		classTypesList = new ClassTypesList();
		myFileIO = new MyFileIO();

	}

	public ArrayList<Event> getOnGoingEventsList()
	{
		return onGoingEventsList;
	}

	public ArrayList<Event> getUpComingEventsList()
	{
		return upComingEventsList;
	}

	public EventsList getEventsList()
	{
		return eventsList;
	}

	public InstructorsList getInstructorsList()
	{
		return instructorsList;
	}

	public MembersList getMembersList()
	{
		return membersList;
	}

	public ClassTypesList getClassTypesList()
	{
		return classTypesList;
	}

	public void updateOnGoingEventsList()
	{
		updateEventsList();
		onGoingEventsList.clear();
		GregorianCalendar calendar = new GregorianCalendar();
		MyClock currentTime = new MyClock(calendar.get(GregorianCalendar.HOUR_OF_DAY), 0, 0);
		ArrayList<Event> temp = eventsList.getEventsList();
		MyDate today = MyDate.today();
		MyClock thisEventStartTime;
		MyClock thisEventEndTime;
		MyDate thisEventStartDate;

		for (int i = 0; i < temp.size(); i++)

		{
			thisEventStartTime = temp.get(i).getStarTime();
			thisEventEndTime = temp.get(i).getEndTime();
			thisEventStartDate = temp.get(i).getStartDate();

			boolean eventIsToday = thisEventStartDate.getDay() == today.getDay()
					&& thisEventStartDate.getMonth() == today.getMonth()
					&& thisEventStartDate.getYear() == today.getYear();
			boolean eventStarted = thisEventStartTime.getHour() <= currentTime.getHour();
			boolean eventDidNotFinish = thisEventEndTime.getHour() > currentTime.getHour();
			boolean eventFinished = thisEventEndTime.getHour() < currentTime.getHour();
			boolean containsEvent = onGoingEventsList.contains(temp.get(i));

			if (eventIsToday && eventStarted && eventDidNotFinish && !containsEvent)
			{
				onGoingEventsList.add(temp.get(i));
			} else if (containsEvent && eventFinished)
				onGoingEventsList.remove(i);
		}
	}

	public void updateUpComingEventsList()
	{
		updateEventsList();
		upComingEventsList.clear();
		int maxUpcomingEvents = 30;
		GregorianCalendar calendar = new GregorianCalendar();
		MyClock currentTime = new MyClock(calendar.get(GregorianCalendar.HOUR_OF_DAY), 0, 0);
		ArrayList<Event> temp = eventsList.getEventsList();
		MyDate today = MyDate.today();
		Event currentEvent;

		MyClock thisEventStartTime;
		MyClock thisEventEndTime;

		MyDate thisEventStartDate;
		MyDate thisEventEndDate;

		for (int i = 0; i < temp.size(); i++)
		{
			currentEvent = temp.get(i);
			thisEventStartTime = currentEvent.getStarTime();
			thisEventEndTime = currentEvent.getEndTime();
			thisEventStartDate = currentEvent.getStartDate();
			thisEventEndDate = currentEvent.getEndDate();

			boolean eventIsUpcomingYears = thisEventStartDate.getYear() > today.getYear();
			boolean eventIsUpcomingMonths = thisEventStartDate.getMonth() > today.getMonth();
			boolean eventIsUpcomingDays = thisEventStartDate.getDay() > today.getDay();
			boolean eventIsUpcomingHours = thisEventStartTime.getHour() > currentTime.getHour();
			boolean containsEvent = upComingEventsList.contains(currentEvent);
			// adding future events (30 max)
			if (upComingEventsList.size() < maxUpcomingEvents && !containsEvent)
			{
				if (eventIsUpcomingYears)
				{
					upComingEventsList.add(currentEvent);
				} else if (eventIsUpcomingMonths)
				{
					upComingEventsList.add(currentEvent);
				} else if (eventIsUpcomingDays)
				{
					upComingEventsList.add(currentEvent);
				} else if (eventIsUpcomingHours)
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
		instructorsList.setInstructorsList(readInstructorsListFromBin());
	}

	public void updateMembersList()
	{
		membersList.setMembersList(readMembersListFromBin());
	}

	public void updateEventsList()
	{
		eventsList.setEventsList(readEventsListFromBin());
	}

	public void updateClassTypesList()
	{
		classTypesList.setClassTypesList(readClassTypesListFromBin());
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

	public void saveClassTypeToAvailableBinList(ClassType classType)
	{
		ArrayList<ClassType> tempList = readClassTypesListFromBin();
		tempList.add(classType);
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
				{
					tempList.add((Event) all.get(i));
				}
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
}