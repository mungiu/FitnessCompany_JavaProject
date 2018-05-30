package MainPackage;

import java.util.ArrayList;

import org.w3c.dom.events.Event;

public class Instructor
{
   private int instructorID;
   private String firstName, lastName;
   private boolean isQualified;
   private ArrayList<ClassType> qualifiedClassList;
   private ArrayList<Main> allTaughtEventsList;

   public Instructor(int instructorID, String firstName, String lastName,
         boolean isQualified)
   {
      this.firstName = firstName;
      this.lastName = lastName;
      this.instructorID = instructorID;
      this.isQualified = isQualified;
      allTaughtEventsList = new ArrayList<Main>();
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

   public boolean getIsAvailable(Instructor event)
   {

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
   

}
