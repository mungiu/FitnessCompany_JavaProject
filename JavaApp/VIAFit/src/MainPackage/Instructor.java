package MainPackage;
import java.util.ArrayList;

import org.w3c.dom.events.Event;

public class Instructor
{
   private int instructorID;
   private String firstName;
   private String lastName;
   private ArrayList<ClassType> qualification;
   private ArrayList<Event> event;
   
   public Instructor(int instructorID, String firstName, String lastName)
   {
      int newID = instructorID++;
      this.instructorID = instructorID;
      Main.setInstructorID(newID);
      this.firstName = firstName;
      this.lastName = lastName;
   }
   public String getFirstName()
   {
      return firstName;
   }
   public String getLastName()
   {
      return lastName;
   }
   public boolean isAvailable()
   {
      if(event.get(assignInstructor))
   }
   

}
