package MainPackage;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class representing ClassTypeList with an Array of class type list.
 * 
 * @author Group 1
 */
public class ClassTypesList implements Serializable
{

   /**
    * Generated serial version UID
    */
   private static final long serialVersionUID = 4292784401879126523L;
   private ArrayList<ClassType> classTypesList = new ArrayList<ClassType>();

   /**
    * Method that converts the ArrayList<String> into a String array for use in
    * ComboBox
    * 
    * @return temp an array of strings
    */
   public String[] getClassTypesArr()
   {
      String[] temp = new String[1];
      temp[0] = "Choose Event Type";
      if (classTypesList != null)
      {
         temp = new String[classTypesList.size() + 1];
         temp[0] = "Choose Event Type";
         for (int i = 0; i < classTypesList.size(); i++)
         {
            temp[i + 1] = classTypesList.get(i).getClassName();
         }
      }
      return temp;

   }

   /**
    * Gets the ClassTypesList.
    * 
    * @return the ClassTypesList.
    */
   public ArrayList<ClassType> getClassTypesList()
   {
      return classTypesList;
   }

   /**
    * Sets the ClassTypesLists class type list
    * 
    * @param classTypesList
    */
   public void setClassTypesList(ArrayList<ClassType> classTypesList)
   {
      this.classTypesList.clear();
      for (int i = 0; i < classTypesList.size(); i++)
      {
         this.classTypesList.add(classTypesList.get(i));
      }
   }

}
