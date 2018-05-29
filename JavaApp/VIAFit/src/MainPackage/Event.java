package MainPackage;

public class Event
{
	private String className;
	private boolean requiresQualification;
	private int maxMembers;
	private MyDate startDate;
	private MyDate endDate;
	private MyClock startTime;
	private MyClock endTime;

	public Event(String className, MyDate startDate, MyDate endDate, MyClock startTIme, MyClock endTime)
	{
		this.className=className;
	}
	
	public String getClassName()
	{
		return className;
	}
	
}
