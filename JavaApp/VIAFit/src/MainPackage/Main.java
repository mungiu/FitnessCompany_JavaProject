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

   public boolean IsAvailable(Instructor instructor, Event event)
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

   public static void main(String[] args)
   {

   }

}