package MainPackage;

import java.util.ArrayList;

import org.w3c.dom.events.Event;

public class Instructor
{
	private int instructorID = 1;
	private String firstName, lastName;
	private boolean isQualified;
	private ArrayList<ClassType> qualifiedClassesList;
	private ArrayList<Main> allTaughtEventsList;

	public Instructor(String firstName, String lastName, boolean isQualified)
	{
		// TODO: pull new instructorID from binary file by checking biggest instructor ID
		this.firstName = firstName;
		this.lastName = lastName;
		this.isQualified = isQualified;
		allTaughtEventsList = new ArrayList<Main>();
		qualifiedClassesList = new ArrayList<ClassType>();
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public int getInstructorID()
	{
		return instructorID;
	}

	public boolean getIsQualified()
	{
		return isQualified;
	}

	public void setIsQualified(boolean isQualified)
	{
		this.isQualified = isQualified;
	}

	public ArrayList<ClassType> getQualifiedClassesList()
	{
		return qualifiedClassList;
	}

	public ArrayList<Main> getAllTaughtEvents()
	{
		return allTaughtEventsList;
	}

	@Override
	public String toString()
	{
		return "Instructor [instructorID=" + instructorID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", isQualified=" + isQualified + "]";
	}

}
