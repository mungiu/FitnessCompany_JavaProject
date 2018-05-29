package MainPackage;

import java.util.ArrayList;

public class Event
{
	private String className;
	private boolean requiresQualification;
	private int maxMembers;
	private MyDate startDate;
	private MyDate endDate;
	private MyClock startTime;
	private MyClock endTime;
	private ClassType classType;
	private ArrayList<Instructor> attendingInstructorsList;
	private ArrayList<Member> attendingMembersList;

	public Event(String className, MyDate startDate, MyDate endDate, MyClock startTIme, MyClock endTime)
	{
		this.className = className;
		attendingInstructorsList = new ArrayList<Instructor>();
	}

	public String getClassName()
	{
		return className;
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

	public ArrayList<Member> getMemberList()
	{
		return attendingMembersList;
	}

	public ArrayList<Instructor> getInstructorList()
	{
		return attendingInstructorsList;
	}

	public void assignInstructor(Instructor instructor)
	{
		if(requiresQualification)
			if()
		attendingInstructorsList.add(instructor);
	}

	public void removeInstructor(Instructor instructor)
	{
		attendingInstructorsList.remove(instructor);
	}

	public void removeMember(Member member)
	{
		attendingMembersList.remove(member);
	}

	public void assignMember(Member member)
	{
		attendingMembersList.add(member);
	}

	public String toString()
	{
		return "asd";
	}

}
