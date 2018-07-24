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
	private String classType;

	/**
	 * One-argument constructor.
	 * 
	 * @param className
	 *            is the ClassType classes name.
	 */
	public ClassType(String className) throws NullPointerException
	{
		this.classType = className;
	}

	/**
	 * Gets the ClassTypes class name.
	 * 
	 * @return the ClassTypes class name.
	 */
	public String getClassType()
	{
		return classType;
	}

	/**
	 * Sets the ClassTypes class name.
	 * 
	 * @param className
	 *            is what the ClassTypes class name will be set to.
	 */
	public void setClassType(String className) throws NullPointerException
	{
		this.classType = className;
	}

	/**
	 * Compares class name of two ClassTypes
	 * 
	 * @param obj
	 *            the object to compare with
	 * @return true if the given object is equal to this ClassType.
	 */
	public boolean equals(Object obj) throws NullPointerException
	{
		if (!(obj instanceof ClassType))
		{
			return false;
		}
		ClassType temp = (ClassType) obj;

		return classType.equals(temp.classType);
	}

	/**
	 * Returns a string representation of the ClassType.
	 * 
	 * @return a string representation of the ClassType in the format: className.
	 */
	public String toString()
	{
		return classType;
	}
}
