package MainPackage;

import java.io.Serializable;
import java.util.ArrayList;

public class InstructorsList implements Serializable
{
	private static final long serialVersionUID = -5279083015052108795L;
	private ArrayList<Instructor> instructorsList = new ArrayList<Instructor>();

	public ArrayList<Instructor> getInstructorsList()
	{
		return instructorsList;
	}

	public void setInstructorsList(ArrayList<Instructor> instructorsList)
	{
		this.instructorsList = instructorsList;
	}
}
