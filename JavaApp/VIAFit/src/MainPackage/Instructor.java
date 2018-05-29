package MainPackage;

import java.util.ArrayList;

import org.w3c.dom.events.Event;

public class Instructor
{
   private int instructorID;
   private String firstName, lastName;
   private boolean qualified;
   private ArrayList<ClassType> qualifiedClassList;
   private ArrayList<Main> allTaughtEventsList;

   public Instructor(int instructorID, String firstName, String lastName,
         boolean qualified)
   {
      this.firstName = firstName;
      this.lastName = lastName;
      this.instructorID = instructorID;
      this.qualified = qualified;
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

   public boolean isAvailable()
   {
      
   }
   
   public boolean isQualified()
   {
      return qualified;
   }

   

}
