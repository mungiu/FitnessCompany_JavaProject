package MainPackage;

import java.io.Serializable;

public class ClassType implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7574607274053354338L;
	private String className;

	public ClassType(String className)
	{
		this.className = className;
	}

	public String getClassName()
	{
		return className;
	}

	public void setClassName(String className)
	{
		this.className = className;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (!(obj instanceof ClassType))
			return false;
		else
		{
			ClassType temp = (ClassType) obj;

			return className == temp.className;
		}
	}
	public String toString()
	{
	   return className;
	}
}
