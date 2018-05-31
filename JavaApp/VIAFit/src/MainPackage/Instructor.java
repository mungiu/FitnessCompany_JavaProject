package MainPackage;

import java.io.Serializable;
import java.util.ArrayList;

public class Instructor implements Serializable
{
	/**
	 * Generated serial version UID
	 */
	private static final long serialVersionUID = 2596626544601247578L;
	private int instructorID;
	private String firstName, lastName;
	private boolean isQualified;
	private ArrayList<ClassType> qualifiedClassesList;
	private ArrayList<FileAdapter> allTaughtEventsList;

	public Instructor(String firstName, String lastName, boolean isQualified)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.instructorID = getNewInstructorID();
		this.isQualified = isQualified;
		allTaughtEventsList = new ArrayList<FileAdapter>();
		qualifiedClassesList = new ArrayList<ClassType>();
	}

	public int getNewInstructorID()
	{
		// TODO return (last instructorID +1)
		// AND set latest instructor id as new instructor ID
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
		return qualifiedClassesList;
	}

	public ArrayList<FileAdapter> getAllTaughtEvents()
	{
		return allTaughtEventsList;
	}

}
