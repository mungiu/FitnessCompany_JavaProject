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
	private FileAdapter fileAdapter;

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
