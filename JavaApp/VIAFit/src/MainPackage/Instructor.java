package MainPackage;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class containing the Instructor with first name, last name and instructor
 * ID.
 * 
 * @author Group 1
 */
public class Instructor implements Serializable
{
   /**
    * Generated serial version UID
    */
   private static final long serialVersionUID = 2596626544601247578L;
   private int instructorID;
   private String name;
   private ArrayList<ClassType> qualifiedForList;

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
      this.qualifiedForList = qualifiedForList;
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
    * Gets the instructors first name.
    * 
    * @return the instructors first name.
    */
   public String getName()
   {
      return name;
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
      if (qualifiedForList.size() != 0)
      {
         for (int i = 0; i < qualifiedForList.size(); i++)
         {
            list += qualifiedForList.get(i).getClassName() + ", ";
         }
      }
      String str = "<html><pre style='font-size:11px'>" + name + "\t\t"
            + instructorID + "\t\t" + list + "</pre></html>";
      return str;
   }

   public String toSmallString()
   {
      return name + "  ID: " + instructorID;
   }
}
