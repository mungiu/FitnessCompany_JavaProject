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
<<<<<<< HEAD
	
=======

	public void addInstructor(Instructor instructor)
	{
		attendingInstructorsList.add(instructor);
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

>>>>>>> master
}
