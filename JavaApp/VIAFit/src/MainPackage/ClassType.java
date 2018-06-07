package MainPackage;

import java.io.Serializable;

/**
 * A class representing ClassType with the class name.
 * 
 * @author Group 1
 */
public class ClassType implements Serializable
{
   /**
    * Generated serial version UID
    */
   private static final long serialVersionUID = -7574607274053354338L;
   private String className;

   /**
    * One-argument constructor.
    * 
    * @param className
    *           is the ClassType classes name.
    */
   public ClassType(String className)
   {
      this.className = className;
   }

   /**
    * Gets the ClassTypes class name.
    * 
    * @return the ClassTypes class name.
    */
   public String getClassName()
   {
      return className;
   }

   /**
    * Sets the ClassTypes class name.
    * 
    * @param className
    *           is what the ClassTypes class name will be set to.
    */
   public void setClassName(String className)
   {
      this.className = className;
   }

   /**
    * Compares class name of two ClassTypes
    * 
    * @param obj
    *           the object to compare with
    * @return true if the given object is equal to this ClassType.
    */
   public boolean equals(Object obj)
   {
      if (!(obj instanceof ClassType))
      {
         return false;
      }
      ClassType temp = (ClassType) obj;

      return className.equals(temp.className);
   }

   /**
    * Returns a string representation of the ClassType.
    * 
    * @return a string representation of the ClassType in the format: className.
    */
   public String toString()
   {
      return className;
   }
}
