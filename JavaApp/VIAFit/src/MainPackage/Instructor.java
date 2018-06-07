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
   private String name;
   private ArrayList<ClassType> qualifiedForList;
   private ArrayList<ClassType> allTaughtEventsList;
   private InstructorsList instructorsList;

   /**
    * Two-argument constructor.
    * 
    * @param firstName
    *           the instructors first name.
    * @param lastName
    *           the instructors last name.
    */
   public Instructor(String name, int id, ArrayList<ClassType> qualifiedForList)
   {
      this.name = name;
      this.instructorID = id;
      allTaughtEventsList = new ArrayList<ClassType>();
      this.qualifiedForList = qualifiedForList;
      instructorsList = new InstructorsList();
   }

   /**
    * Gets the instructors first name.
    * 
    * @return the instructors first name.
    */
   public String getName()
   {
      return name;
   }

   /**
    * Get the instructors ID number.
    * 
    * @return the instructors ID number.
    */
   public int getInstructorID()
   {
      return instructorID;
   }

   /**
    * Gets the instructors qualified classes list.
    * 
    * @return the instructors qualified classes list.
    */
   public ArrayList<ClassType> getQualifiedClassesList()
   {
      return qualifiedForList;
   }

   /**
    * Gets the instructors all taught events list.
    * 
    * @return the instructors all taught events list.
    */

   public ArrayList<ClassType> getAllTaughtEvents()
   {
      return allTaughtEventsList;
   }

   /**
    * Sets the instructors name
    * 
    * @param name
    *           is what the instructors first name will be set to.
    */
   public void setName(String name)
   {
      this.name = name;
   }

   /**
    * Adds the instructors qualified class to the list.
    * 
    * @param classType
    *           adds the qualified class to the list.
    */
   public void setQualifiedList(ArrayList<ClassType> list)
   {
      qualifiedForList.clear();
      for (int i = 0; i < list.size(); i++)
      {
         qualifiedForList.add(list.get(i));
      }
   }

   /**
    * Compares instructorID number of two Instructors.
    * 
    * @param obj
    *           the object to compare with
    * @return true if the given object is equal to this Instructor.
    */
   public boolean equals(Object obj)
   {
      if (!(obj instanceof Instructor))
         return false;
      else
      {
         Instructor temp = (Instructor) obj;

         return instructorID == temp.instructorID;
      }
   }


	public String toString()
	{
	   String list = "";
	   String nameTab = "";
	   if(qualifiedForList.size()!=0)
	   {
	      for(int i = 0;i<qualifiedForList.size();i++)
	      {
	         list+=qualifiedForList.get(i).getClassName()+", ";
	      }
	   }
	   if(name.length()>=16 && name.length()<25)
      {
         nameTab = "\t";
      }
      else if (name.length() >= 8 && name.length() < 16)
      {
         nameTab = "\t\t";
      }

      else nameTab = "\t\t\t";
      
	   String str = "<html><pre style='font-size:11px'>" + name + nameTab+"ID: "+instructorID+"\t\t"+list+"</pre></html>";
      return str;
   }

   /**
    * Returns a string representation of the Instructor.
    * 
    * @return a string representation of the Instructor in the format: name
    *         ID:instructorID.
    */
   public String toSmallString()
   {
      return name + "  ID: " + instructorID;
   }
}
