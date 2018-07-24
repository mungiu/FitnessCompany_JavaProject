package MainPackage;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class containing a list of InstructorList
 * 
 * @author Group 1
 *
 */
public class InstructorsList implements Serializable
{
	/**
	 * Generated serial version UID
	 */
	private static final long serialVersionUID = -5279083015052108795L;
	private ArrayList<Instructor> instructorsList = new ArrayList<Instructor>();

	/**
	 * Gets the instructors list.
	 * 
	 * @return the instructors list.
	 */
	public ArrayList<Instructor> getInstructorsList()
	{
		return instructorsList;
	}

	/**
	 * Sets the instructors list.
	 * 
	 * @param instructorsList
	 *            is what the InstructorList instructor list will be set to.
	 */
	public void setInstructorsList(ArrayList<Instructor> instructorsList) throws NullPointerException
	{
		this.instructorsList.clear();

		for (int i = 0; i < instructorsList.size(); i++)
			this.instructorsList.add(instructorsList.get(i));
	}
}
