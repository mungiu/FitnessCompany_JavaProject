package MainPackage;

import java.util.ArrayList;

public class Main
{
   private int lastInstructorID, lastMemberID;
   private ArrayList<Event> onGoingEventsList, upComingEventsList,
         allEventsList;
   private ArrayList<ClassType> allClassesList;
   private ArrayList<Member> memberList;
   private ArrayList<Instructor> instructorList;

   public int getLastInstructorID()
   {
      return lastInstructorID;
   }

   public void setLastInstructorID(int lastInstructorID)
   {
      this.lastInstructorID = lastInstructorID;
   }

   public int getLastMemberID()
   {
      return lastMemberID;
   }

   public void setLastMemberID(int lastMemberID)
   {
      this.lastMemberID = lastMemberID;
   }

   public ArrayList<Event> getOnGoingEventList()
   {
      return onGoingEventsList;
   }

   public ArrayList<Event> getUpComingEventsList()
   {
      return upComingEventsList;
   }

   public void updateIDsOnStart()
   {
      // TODO
   }

}
