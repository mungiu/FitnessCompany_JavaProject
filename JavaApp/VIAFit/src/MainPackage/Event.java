package MainPackage;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class representing an Event with class name, max members, start date, end
 * date, start time, end time, class type, event list and event ID.
 * 
 * @author Group 1
 */
public class Event implements Serializable, Comparable<Event>
{
	private static final long serialVersionUID = 8108565391263087432L;
	private String className;
	private int maxMembers;
	private MyDate startDate, endDate;
	private MyClock startTime, endTime;
	private ClassType classType;
	private ArrayList<Instructor> attendingInstructorsList;
	private ArrayList<Member> attendingMembersList;
	private EventsList eventsList;
	private int eventID;

	/**
	 * Eight-argument constructor.
	 * 
	 * @param classType
	 *            the Events class type.
	 * @param className
	 *            the Events class name.
	 * @param maxMembers
	 *            the Events max members allowed.
	 * @param startDate
	 *            the Events start date.
	 * @param endDate
	 *            the Events end date.
	 * @param startTime
	 *            the Events starting time.
	 * @param endTime
	 *            the Events ending time.
	 * @param id
	 *            the Events ID number.
	 */
	public Event(ClassType classType, String className, int maxMembers, MyDate startDate, MyDate endDate,
			MyClock startTime, MyClock endTime, int id)
	{
		this.classType = classType;
		this.className = className;
		this.maxMembers = maxMembers;
		this.startDate = startDate;
		this.endDate = endDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.eventID = id;

		this.attendingInstructorsList = new ArrayList<Instructor>();
		this.attendingMembersList = new ArrayList<Member>();
		attendingInstructorsList = new ArrayList<Instructor>();
		attendingMembersList = new ArrayList<Member>();
		eventsList = new EventsList();
	}

	// move this to instructor and remove parameter
	/**
	 * Gets if the Instructor is available.
	 * 
	 * @param instructor
	 *            is what the Instructor availability will be set to.
	 * @return if the Instructor is available.
	 */
	public boolean getInstructorIsAvailable(Instructor instructor)
	{
		ArrayList<Event> temp = eventsList.getEventsList();

		for (int i = 0; i < temp.size(); i++)
			if (temp.get(i).getInstructorsList().contains(instructor))
				for (int j = 0; j < temp.size(); j++)
					if (temp.get(i).getStarTime().isBefore(getStarTime())
							&& (!getStarTime().isBefore(temp.get(i).getEndTime())))
						return true;

		return false;
	}

	/**
	 * Gets the Events ID number.
	 * 
	 * @return the Events ID number.
	 */
	public int getEventID()
	{
		return eventID;
	}

	/**
	 * Gets the Events max allowed members number.
	 * 
	 * @return the Events max members number.
	 */
	public int getMaxMembers()
	{
		return maxMembers;
	}

	/**
	 * Gets the Events class name.
	 * 
	 * @return the Events class name.
	 */
	public String getClassName()
	{
		return className;
	}

	/**
	 * Gets the Events class type.
	 * 
	 * @return the Events class type.
	 */
	public ClassType getClassType()
	{
		return classType;
	}

	/**
	 * Gets the Events class type name.
	 * 
	 * @return the Events class type name.
	 */
	public String getClassTypeString()
	{
		return classType.getClassName();
	}

	/**
	 * Gets the Events start date, date is taken from MyDate class.
	 * 
	 * @return the Events start date.
	 */
	public MyDate getStartDate()
	{
		return startDate;
	}

	/**
	 * Gets the Events end date, date is taken from MyDate class.
	 * 
	 * @return the Events end date.
	 */
	public MyDate getEndDate()
	{
		return endDate;
	}

	/**
	 * Gets the Events starting time, time is taken from MyClock class.
	 * 
	 * @return the Events starting time.
	 */
	public MyClock getStarTime()
	{
		return startTime;
	}

	/**
	 * Gets the Events ending time, time is taken from MyClock class.
	 * 
	 * @return the Events ending time.
	 */
	public MyClock getEndTime()
	{
		return endTime;
	}

	/**
	 * Gets the list of Members in the Event.
	 * 
	 * @return the attending members list.
	 */
	public ArrayList<Member> getMembersList()
	{
		return attendingMembersList;
	}

	/**
	 * Gets the list of Instructors in the Event.
	 * 
	 * @return the attending instructors list.
	 */
	public ArrayList<Instructor> getInstructorsList()
	{
		return attendingInstructorsList;
	}

	/**
	 * Gets the number of members currently signed up.
	 * 
	 * @return a number of members signed up for the event.
	 */
	public int getCurrentSignedUp()
	{
		return attendingMembersList.size();
	}

	/**
	 * Sets the Events ID number.
	 * 
	 * @param id
	 *            is what the EventsID number will be set to.
	 */
	public void setEventID(int id)
	{
		eventID = id;
	}

	/**
	 * Sets the Events max number of members.
	 * 
	 * @param maxMembers
	 *            is what the Events max members amount will be set to.
	 */
	public void setMaxMembers(int maxMembers)
	{
		this.maxMembers = maxMembers;
	}

	/**
	 * Sets the Events class type.
	 * 
	 * @param classType
	 *            is what the Events class type will be set to.
	 */
	public void setClassType(String classType)
	{
		this.classType.setClassName(classType);
	}

	/**
	 * Sets the Events class name.
	 * 
	 * @param className
	 *            is what the Events class name will be set to.
	 */
	public void setClassName(String className)
	{
		this.className = className;
	}

	/**
	 * Sets the Events start date.
	 * 
	 * @param startDate
	 *            is what the Events start date will be set to.
	 */
	public void setStartDate(MyDate startDate)
	{
		this.startDate = startDate;
	}

	/**
	 * Sets the Events end date.
	 * 
	 * @param endDate
	 *            is what the Events end date will be set to.
	 */
	public void setEndDate(MyDate endDate)
	{
		this.endDate = endDate;
	}

	/**
	 * Sets the Events starting time.
	 * 
	 * @param startTime
	 *            is what the Events starting time will be set to.
	 */
	public void setStartTime(MyClock startTime)
	{
		this.startTime = startTime;
	}

	/**
	 * Sets the Events ending time.
	 * 
	 * @param endTime
	 *            is what the Events ending time will be set to.
	 */
	public void setEndTime(MyClock endTime)
	{
		this.endTime = endTime;
	}

	/**
	 * Sets the member into attending member list.
	 * 
	 * @param attendingMembersList
	 *            is where the members will be placed into the attending members
	 *            list by counting up one time.
	 */
	public void setMembersList(ArrayList<Member> attendingMembersList)
	{
		this.attendingMembersList = new ArrayList<Member>(attendingMembersList.size());

		for (int i = 0; i < attendingMembersList.size(); i++)
			this.attendingMembersList.add(attendingMembersList.get(i));
	}

	/**
	 * Sets the instructor into attending instructor list.
	 * 
	 * @param attendingInstructorsList
	 *            is where the instructors will be placed into the attending
	 *            instructors list to by counting up one time.
	 */
	public void setInstructorsList(ArrayList<Instructor> attendingInstructorsList)
	{
		this.attendingInstructorsList = new ArrayList<Instructor>(attendingInstructorsList.size());

		for (int i = 0; i < attendingInstructorsList.size(); i++)
			this.attendingInstructorsList.add(attendingInstructorsList.get(i));
	}

	/**
	 * Assigning an Instructor to the Event.
	 * 
	 * @param instructor
	 *            is assigned to the Event if he/she is qualified for that given
	 *            Event.
	 */
	public void assignInstructorToEvent(Instructor instructor)
	{
		for (int i = 0; i < instructor.getQualifiedClassesList().size(); i++)
		{
			if (instructor.getQualifiedClassesList().get(i).getClassName().equals(getClassTypeString())
					&& getInstructorIsAvailable(instructor))
				attendingInstructorsList.add(instructor);
		}
	}

	/**
	 * Assigning a Member to the Event.
	 * 
	 * @param member
	 *            is assigned to the Event if he/she is a premium member.
	 */
	public void assignMemberToEvent(Member member)
	{
		if (member.getIsPremium())
			attendingMembersList.add(member);
	}

	/**
	 * Removing an Instructor from the Event.
	 * 
	 * @param instructor
	 *            is being removed from the attending instructor list.
	 */
	public void removeInstructorFromEvent(Instructor instructor)
	{
		attendingInstructorsList.remove(instructor);
	}

	/**
	 * Compares class name, max members, start date, end date, start time, end time,
	 * class type and event id of two events.
	 * 
	 * @param obj
	 *            the object to compare with.
	 * @return true if the given object is equal to event.
	 */
	public boolean equals(Object obj)
	{
		if (!(obj instanceof Event))
			return false;

		Event other = (Event) obj;
		return (other.className.equals(className) && other.maxMembers == maxMembers && other.startDate.equals(startDate)
				&& other.endDate.equals(endDate) && other.startTime.equals(startTime) && other.endTime.equals(endTime)
				&& other.classType.equals(classType) && other.eventID == eventID);
	}

	public String toString()
	{

		String nameTab = "";
		String classTypeTab = "";
		String dateTab = "\t\t";
		if (className.length() >= 8 && className.length() < 16)
		{
			nameTab = "\t\t";
		} else if (className.length() >= 16)
		{
			nameTab = "\t";
		} else
			nameTab = "\t\t\t";

		if (classType.getClassName().length() >= 8 && classType.getClassName().length() < 16)
		{
			classTypeTab = "\t";
		} else if (classType.getClassName().length() >= 16)
		{
			classTypeTab = "\t\t";
		} else
			classTypeTab = "\t\t";

		if (startDate.toString().length() < 8)
		{
			dateTab = "\t\t";
		}

		String str = "<html><pre style='font-size:11px'>" + className + nameTab + classType + classTypeTab + "     "
				+ maxMembers + "\t\t     " + startDate + dateTab + startTime + " - " + endTime + "</pre></html>";
		return str;
	}

	/**
	 * Returns a string representation of Event.
	 * 
	 * @return a string representation of Event in the format:
	 */
	public String toSmallString()
	{
		String nameTab = "";
		String dateTab = "";
		if (className.length() >= 8 && className.length() < 16)
		{
			nameTab = "\t\t";
		} else if (className.length() >= 16)
		{
			nameTab = "\t";
		} else
			nameTab = "\t\t\t";
		if (startDate.toString().length() == 5)
		{
			dateTab = "    ";
		} else if (startDate.toString().length() == 6)
		{
			dateTab = "   ";
		} else if (startDate.toString().length() == 7)
		{
			dateTab = "  ";
		} else if (startDate.toString().length() == 8)
		{
			dateTab = " ";
		}
		String str = "<html><pre style='font-size:10px'>" + className + nameTab + getCurrentSignedUp() + "/"
				+ getMaxMembers() + "\t\t\t\t\t\t\t\t\t\t" + eventID + "\n" + startDate + dateTab + "  from  "
				+ startTime + " - " + endTime + "</pre></html>";
		return str;
	}

	@Override
	public int compareTo(Event event)
	{
		boolean thisEventIsEarlierDate = (this.getStartDate().compareTo(event.getStartDate()) == -1);
		boolean thisEventIsSameDate = (this.getStartDate().compareTo(event.getStartDate()) == 0);

		boolean thisEventIsEarlierHour = (this.getStarTime().compareTo(event.getStarTime()) == -1);
		boolean thisEventIsSameHour = (this.getStarTime().compareTo(event.getStarTime()) == 0);

		if (thisEventIsEarlierDate)
			return -1;
		else if (thisEventIsSameDate && thisEventIsEarlierHour)
			return -1;
		else if (thisEventIsSameDate && thisEventIsSameHour)
			return 0;
		else
			return 1;
	}
}
