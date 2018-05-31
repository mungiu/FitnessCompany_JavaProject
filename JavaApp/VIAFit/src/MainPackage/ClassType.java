package MainPackage;

public class ClassType
{
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
}
