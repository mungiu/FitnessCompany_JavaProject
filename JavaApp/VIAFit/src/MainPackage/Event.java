package MainPackage;

public class Event
{
	private String className;
	private boolean requiresQualification;
	private int maxMembers;

	public Event(String className, MyDate startDate, MyDate endDate, MyClock startTIme, MyClock endTime)
	{
		this.className=className;
	}
	
	public String getClassName()
	{
		return className;
	}
	
}
