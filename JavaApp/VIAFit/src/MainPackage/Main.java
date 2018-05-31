package MainPackage;

import java.util.ArrayList;

public class Main
{

   private ArrayList<Event> onGoingEventsList, upComingEventsList,
         allEventsList;
   private ArrayList<ClassType> allClassesList;
   private ArrayList<Member> memberList;
   private ArrayList<Instructor> instructorList;

   public ArrayList<Event> getOnGoingEventList()
   {
      return onGoingEventsList;
   }

   public ArrayList<Event> getUpComingEventsList()
   {
      return upComingEventsList;
   }

   public boolean getInstructorIsAvailable(Instructor instructor, Event event)
   {
      for (int i = 0; i < allEventsList.size(); i++)
         if (allEventsList.get(i).getInstructorsList().contains(instructor))
            for (int j = 0; j < allEventsList.size(); j++)
               if (allEventsList.get(i).getStarTime()
                     .isBefore(event.getStarTime())
                     && (event.getStarTime().isBefore(
                           allEventsList.get(i).getEndTime()) == false))
                  return true;

      return false;
   }

   public ArrayList<ClassType> getAllClassesList()
   {
      return allClassesList;
   }

   public ArrayList<Member> getMemberList()
   {
      return memberList;
   }

   public ArrayList<Instructor> getInstructorList()
   {
      return instructorList;
   }

}