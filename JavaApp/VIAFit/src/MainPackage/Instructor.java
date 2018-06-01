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
	private FileAdapter fileAdapter;
	private ArrayList<ClassType> qualifiedClassesList;
	private ArrayList<ClassType> allTaughtEventsList;

	public Instructor(String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.instructorID = getNewInstructorID();
		allTaughtEventsList = new ArrayList<ClassType>();
		qualifiedClassesList = new ArrayList<ClassType>();
	}

	public int getNewInstructorID()
	{
	   int biggestID = 0;
      ArrayList<Instructor> tempInstList = fileAdapter.getInstructorsList();

      for (int i = 0; i < tempInstList.size(); i++)
         if (biggestID < tempInstList.get(i).getInstructorID())
            biggestID = tempInstList.get(i).getInstructorID();

      return biggestID + 1;
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


	public ArrayList<ClassType> getQualifiedClassesList()
	{
		return qualifiedClassesList;
	}

	public ArrayList<ClassType> getAllTaughtEvents()
	{
		return allTaughtEventsList;
	}
	
	public void addQualifedClassToList(ClassType classType){
		qualifiedClassesList.add(classType);
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
		String str = instructorID +"\t"+firstName +"\t" + lastName + "\t";
		return str;
	}
}
