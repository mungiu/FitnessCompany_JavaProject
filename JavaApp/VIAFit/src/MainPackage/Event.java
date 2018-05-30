package MainPackage;

import java.util.ArrayList;

public class Event
{
	private String className;
	private int maxMembers;
<<<<<<< HEAD
	private boolean requiresQualification, requiresPremium;
	private MyDate startDate;
	private MyDate endDate;
	private MyClock startTime;
	private MyClock endTime;
=======
	
	private MyDate startDate, endDate;
	private MyClock startTime, endTime;
>>>>>>> master
	private ClassType classType;
	private ArrayList<Instructor> attendingInstructorsList;
	private ArrayList<Member> attendingMembersList;

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

	public void setClassName(String className)
	{
		this.className = className;
	}

	public MyDate getStartDate()
	{
		return startDate;
	}

	public void getStartDate(MyDate startDate)
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
			if (instructor.getIsQualified() && instructor.getIsAvailable())
				attendingInstructorsList.add(instructor);
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

	public String toString()
	{
		return "asd";
	}

}
