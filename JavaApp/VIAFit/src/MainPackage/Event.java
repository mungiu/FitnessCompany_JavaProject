package MainPackage;

import java.io.Serializable;
import java.util.ArrayList;

public class Event implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8108565391263087432L;
	private String className;
	private int maxMembers;
	private FileAdapter fileAdapter;
	private MyDate startDate, endDate;
	private MyClock startTime, endTime;
	private ClassType classType;
	private ArrayList<Instructor> attendingInstructorsList;
	private ArrayList<Member> attendingMembersList;
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
		this.attendingInstructorsList = new ArrayList<Instructor>();
		this.attendingMembersList = new ArrayList<Member>();
//		eventID = getNewEventID();
	}

	public int getNewEventID()
   {
      int biggestID = 0;
      ArrayList<Event> tempEventList = fileAdapter.getEventsList();

      for (int i = 0; i < tempEventList.size(); i++)
         if (biggestID < tempEventList.get(i).getEventID())
            biggestID = tempEventList.get(i).getEventID();

      return biggestID + 1;
   }
	public void setEventID(int id)
	{
	   eventID = id;
	}
	public int getEventID()
	{
	   return eventID;
	}
	public int getMaxMembers()
	{
		return maxMembers;
	}

	public void setMaxMembers(int maxMembers)
	{
		this.maxMembers = maxMembers;
	}

	public String getClassName()
	{
		return className;
	}

	public String getClassType()
	{
		return classType.getClassName();
	}

	public void setClassType(String classType)
	{
		this.classType.setClassName(classType);
	}

	public void setClassName(String className)
	{
		this.className = className;
	}

	public MyDate getStartDate()
	{
		return startDate;
	}

	public void setStartDate(MyDate startDate)
	{
		this.startDate = startDate;
	}

	public MyDate getEndDate()
	{
		return endDate;
	}

	public void setEndDate(MyDate endDate)
	{
		this.endDate = endDate;
	}

	public MyClock getStarTime()
	{
		return startTime;
	}

	public void setStartTime(MyClock startTime)
	{
		this.startTime = startTime;
	}

	public MyClock getEndTime()
	{
		return endTime;
	}

	public void setEndTime(MyClock endTime)
	{
		this.endTime = endTime;
	}

	public ArrayList<Member> getMembersList()
	{
		return attendingMembersList;
	}

	public void setMembersList(ArrayList<Member> attendingMembersList)
	{
		this.attendingMembersList = new ArrayList<Member>(attendingMembersList.size());

		for (int i = 0; i < attendingMembersList.size(); i++)
			this.attendingMembersList.add(attendingMembersList.get(i));
	}

	public ArrayList<Instructor> getInstructorsList()
	{
		return attendingInstructorsList;
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
					&& fileAdapter.getInstructorIsAvailable(instructor, this))
			{
				attendingInstructorsList.add(instructor);
			}
		}
	}

	public void removeInstructorFromEvent(Instructor instructor)
	{
		attendingInstructorsList.remove(instructor);
	}

	public void assignMemberToEvent(Member member)
	{
		if (member.getIsPremium())
			attendingMembersList.add(member);
	}

	public void removeMemberFromEvent(Member member)
	{
		attendingMembersList.remove(member);
	}

	@Override
	public String toString()
	{
		String str = "<html><pre style='font-size:11px'>"+className + "\t" + classType + "\t" + maxMembers + "\t" + startDate + " - " + endDate + "\t"
				+ startTime + " - " + endTime+"</pre></html>";
		return str;
	}
}
