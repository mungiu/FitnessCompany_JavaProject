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
	private ArrayList<ClassType> qualifiedClassesList;
	private ArrayList<ClassType> allTaughtEventsList;
	private InstructorsList instructorsList;

	/**
	 * Two-argument constructor.
	 * 
	 * @param firstName
	 *            the instructors first name.
	 * @param lastName
	 *            the instructors last name.
	 */
	public Instructor(String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.instructorID = getNewInstructorID();
		allTaughtEventsList = new ArrayList<ClassType>();
		qualifiedClassesList = new ArrayList<ClassType>();
		instructorsList = new InstructorsList();
	}

	/**
	 * Gets the instructors new ID number.
	 * 
	 * @return the instructors new ID number.
	 */
	public int getNewInstructorID()
	{
		int biggestID = 0;
		try
		{
			// with new UML pull this from InstructorsList class
			ArrayList<Instructor> tempInstList = instructorsList.getInstructorsList();

			for (int i = 0; i < tempInstList.size(); i++)
				if (biggestID < tempInstList.get(i).getInstructorID())
					biggestID = tempInstList.get(i).getInstructorID();
		} catch (NullPointerException e)
		{
			// e.printStackTrace();
			System.out.println("tempInstList.get(i).getInstructorID() is NULL >>>>> biggestID set to 1");
		}

		return biggestID + 1;
	}

	/**
	 * Gets the instructors first name.
	 * 
	 * @return the instructors first name.
	 */
	public String getFirstName()
	{
		return firstName;
	}

	/**
	 * Gets the instructors last name.
	 * 
	 * @return the instructors last name.
	 */
	public String getLastName()
	{
		return lastName;
	}

	/**
	 * Get the instructors ID number.
	 * 
	 * @return the instructors ID number.
	 */
	public int getInstructorID()
	{
		return instructorID;
	}

	/**
	 * Gets the instructors qualified classes list.
	 * 
	 * @return the instructors qualified classes list.
	 */
	public ArrayList<ClassType> getQualifiedClassesList()
	{
		return qualifiedClassesList;
	}

	/**
	 * Gets the instructors all taught events list.
	 * 
	 * @return the instructors all taught events list.
	 */

	public ArrayList<ClassType> getAllTaughtEvents()
	{
		return allTaughtEventsList;
	}

	/**
	 * Sets the instructors first name
	 * 
	 * @param firstName
	 *            is what the instructors first name will be set to.
	 */
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	/**
	 * Sets the instructors last name.
	 * 
	 * @param lastName
	 *            is what the instructors last name will be set to.
	 */
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	/**
	 * Adds the instructors qualified class to the list.
	 * 
	 * @param classType
	 *            adds the qualified class to the list.
	 */
	public void addQualifedClassToList(ClassType classType)
	{
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
		String str = instructorID + "\t" + firstName + "\t" + lastName + "\t";
		return str;
	}
}
