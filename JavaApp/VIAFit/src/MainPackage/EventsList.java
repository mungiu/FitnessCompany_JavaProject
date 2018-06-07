package MainPackage;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class containing a list of events list
 * 
 * @author Group 1
 */
public class EventsList implements Serializable
{
   /**
    * Generated serial version UID.
    */
   private static final long serialVersionUID = -51289747856164745L;
   private ArrayList<Event> eventsList = new ArrayList<Event>();

   /**
    * Gets the events list from EventsList.
    * 
    * @return the event list from EventsList.
    */
   public ArrayList<Event> getEventsList()
   {
      return eventsList;
   }

   /**
    * Sets the event list from EventsList
    * 
    * @param eventsList
    *           is what the EventsList event list will be set to.
    */
   public void setEventsList(ArrayList<Event> eventsList)
   {
      this.eventsList.clear();
      for (int i = 0; i < eventsList.size(); i++)
      {
         this.eventsList.add(eventsList.get(i));
      }
   }

   /**
    * Method that finds all events with a given classType of type String
    * 
    * @param input
    *           A String to compare class type
    * @return allEventOfType an ArrayList<Event>
    */
   public ArrayList<Event> getAllEventsOfType(String input)
   {
      ArrayList<Event> allEventOfType = new ArrayList<Event>();

      for (int i = 0; i < eventsList.size(); i++)
         if (eventsList.get(i).getClassType().equals(input))
            allEventOfType.add(eventsList.get(i));

      return allEventOfType;
   }

   /**
    * Method for finding all upcoming or ongoing events a specific member is
    * signed up for
    * 
    * @param member
    *           The member object that is searched for in the ongoing and
    *           upcoming ArrayLists
    * @return temp An ArrayList<Event> containing all upcoming and ongoing
    *         events the given member attended
    */
   public ArrayList<Event> getAllAttendingEventsForMember(Member member)
   {
      ArrayList<Event> temp = new ArrayList<Event>();

      // adding ongoing events
      for (int i = 0; i < eventsList.size(); i++)
         if (eventsList.get(i).getMembersList().contains(member))
            temp.add(eventsList.get(i));

      return temp;
   }

}
