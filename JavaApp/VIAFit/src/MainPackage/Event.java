package MainPackage;

import java.io.Serializable;
import java.util.ArrayList;

public class Event implements Serializable
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

	public Event(ClassType classType, String className, int maxMembers, MyDate startDate, MyDate endDate,
			MyClock startTime, MyClock endTime)
	{
		this.classType = classType;
		this.className = className;
		this.maxMembers = maxMembers;
		this.startDate = startDate;
		this.endDate = endDate;
		this.startTime = startTime;
		this.endTime = endTime;

		attendingInstructorsList = new ArrayList<Instructor>();
		attendingMembersList = new ArrayList<Member>();
		eventsList = new EventsList();
		eventID = getNewEventID();
	}

	// move this to instructor and remove parameter
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

	public int getNewEventID()
	{
		int biggestID = 0;
		try
		{
			// with new UML pull this from EventsList class
			ArrayList<Event> tempEventList = eventsList.getEventsList();

			for (int i = 0; i < tempEventList.size(); i++)
				if (biggestID < tempEventList.get(i).getEventID())
					biggestID = tempEventList.get(i).getEventID();
		} catch (NullPointerException e)
		{
			e.printStackTrace();
			System.out.println(
					"tempEventList.get(i).getEventID() or fileAdapter.getEventsList() is NULL >>>>> biggestID set to 1");
		}

		return biggestID + 1;
	}

	public int getEventID()
	{
		return eventID;
	}

	public int getMaxMembers()
	{
		return maxMembers;
	}

	public String getClassName()
	{
		return className;
	}

	public String getClassType()
	{
		return classType.getClassName();
	}

	public MyDate getStartDate()
	{
		return startDate;
	}

	public MyDate getEndDate()
	{
		return endDate;
	}

	public MyClock getStarTime()
	{
		return startTime;
	}

	public MyClock getEndTime()
	{
		return endTime;
	}

	public ArrayList<Member> getMembersList()
	{
		return attendingMembersList;
	}

	public ArrayList<Instructor> getInstructorsList()
	{
		return attendingInstructorsList;
	}

	public void setEventID(int id)
	{
		eventID = id;
	}

	public void setMaxMembers(int maxMembers)
	{
		this.maxMembers = maxMembers;
	}

	public void setClassType(String classType)
	{
		this.classType.setClassName(classType);
	}

	public void setClassName(String className)
	{
		this.className = className;
	}

	public void setStartDate(MyDate startDate)
	{
		this.startDate = startDate;
	}

	public void setEndDate(MyDate endDate)
	{
		this.endDate = endDate;
	}

	public void setStartTime(MyClock startTime)
	{
		this.startTime = startTime;
	}

	public void setEndTime(MyClock endTime)
	{
		this.endTime = endTime;
	}

	public void setMembersList(ArrayList<Member> attendingMembersList)
	{
		this.attendingMembersList = new ArrayList<Member>(attendingMembersList.size());

		for (int i = 0; i < attendingMembersList.size(); i++)
			this.attendingMembersList.add(attendingMembersList.get(i));
	}

	public void setInstructorsList(ArrayList<Instructor> attendingInstructorsList)
	{
		this.attendingInstructorsList = new ArrayList<Instructor>(attendingInstructorsList.size());

		for (int i = 0; i < attendingInstructorsList.size(); i++)
			this.attendingInstructorsList.add(attendingInstructorsList.get(i));
	}

	public void assignInstructorToEvent(Instructor instructor)
	{
		for (int i = 0; i < instructor.getQualifiedClassesList().size(); i++)
		{
			if (instructor.getQualifiedClassesList().get(i).getClassName().equals(getClassType())
					&& getInstructorIsAvailable(instructor))
				attendingInstructorsList.add(instructor);
		}
	}

	public void assignMemberToEvent(Member member)
	{
		if (member.getIsPremium())
			attendingMembersList.add(member);
	}

	public void removeInstructorFromEvent(Instructor instructor)
	{
		attendingInstructorsList.remove(instructor);
	}

	public boolean equals(Object obj)
	{
		if (!(obj instanceof Event))
			return false;

		Event other = (Event) obj;
		return other.className.equals(className) && other.maxMembers == maxMembers && other.startDate.equals(startDate)
				&& other.endDate.equals(endDate) && other.startTime.equals(startTime) && other.endTime.equals(endTime)
				&& other.classType.equals(classType) && other.eventID == eventID;
	}

	public String toString()
	{
		String str = "<html><pre style='font-size:11px'>" + className + "\t\t" + classType + "\t" + maxMembers + "\t"
				+ startDate + " - " + endDate + "\t" + startTime + " - " + endTime + "</pre></html>";
		return str;
	}
}
