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
   private ArrayList<ClassType> qualifiedClassList;
   private ArrayList<FileAdapter> allTaughtEventsList;

   public Instructor(int instructorID, String firstName, String lastName,
         boolean isQualified)
   {
      this.firstName = firstName;
      this.lastName = lastName;
      this.instructorID = instructorID;
      this.isQualified = isQualified;
      allTaughtEventsList = new ArrayList<FileAdapter>();
      qualifiedClassList = new ArrayList<ClassType>();
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

   public ArrayList<FileAdapter> getAllTaughtEvents()
   {
      return allTaughtEventsList;
   }

}
