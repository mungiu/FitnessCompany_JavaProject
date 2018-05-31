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
	private FileAdapter fileAdapter;
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
<<<<<<< HEAD
		// TODO return (last instructorID +1)
		// AND set latest instructor id as new instructor ID
		
		//bla bla from ron
		return 0;
=======
		int biggestID = 0;
		ArrayList<Instructor> tempInstList = fileAdapter.getInstructorsList();

		for (int i = 0; i < tempInstList.size(); i++)
			if (biggestID < tempInstList.get(i).getInstructorID())
				biggestID = tempInstList.get(i).getInstructorID();

		return biggestID + 1;
>>>>>>> master
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

	@Override
	public boolean equals(Object obj)
	{
		if (!(obj instanceof Instructor))
			return false;
		else
		{
			Instructor temp = (Instructor) obj;

			return instructorID == temp.instructorID;
		}
	}

	@Override
	public String toString()
	{
		return "Instructor [instructorID=" + instructorID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", isQualified=" + isQualified + ", fileAdapter=" + fileAdapter + "]";
	}

}
