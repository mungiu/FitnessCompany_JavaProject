package MainPackage;

import java.io.Serializable;
import java.util.ArrayList;

public class Member implements Serializable
{

	/**
	 * Generated serial version UID
	 */
	private static final long serialVersionUID = 4437337227753008510L;

	private String firstName, lastName, email;
	private int memberID;
	private int phoneNumber;
	private boolean isPremium;
	private FileAdapter fileAdapter;
	private MyDate memberSince;
	private ArrayList<Event> allAttendedEventsList;

	public Member(String firstName, String lastName, String email, int phoneNumber, boolean isPremium)
	{
		// TODO: pull new memberID from binary file by checking biggest member ID
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.memberID = getNewMemberID();
		this.phoneNumber = phoneNumber;
		this.isPremium = isPremium;
		this.memberSince = MyDate.today();

		allAttendedEventsList = new ArrayList<Event>();

	}

	public int getNewMemberID()
	{
		int biggestID = 0;
		ArrayList<Member> tempMembList = fileAdapter.getMembersList();

		for (int i = 0; i < tempMembList.size(); i++)
			if (biggestID < tempMembList.get(i).getMemberID())
				biggestID = tempMembList.get(i).getMemberID();

		return biggestID + 1;
	}

	public int getMemberID()
	{
		return memberID;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public int getPhoneNumber()
	{
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

	public String getEMail()
	{
		return email;
	}

	public void setEMail(String email)
	{
		this.email = email;
	}

	public boolean getIsPremium()
	{
		return isPremium;
	}

	public void setIsPremium(boolean isPremium)
	{
		this.isPremium = isPremium;
	}

	public MyDate getMemberSince()
	{
		return memberSince;
	}

	public ArrayList<Event> getMemberEvents()
	{
		return allAttendedEventsList;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (!(obj instanceof Member))
			return false;
		else
		{
			Member temp = (Member) obj;

			return memberID == temp.memberID;
		}
	}

	@Override
	public String toString()
	{
		String str = memberID + "\t" + firstName + "\t" + lastName; 
		return str;
	}

}
