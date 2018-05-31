package MainPackage;

import java.util.ArrayList;

public class Member
{

	private String firstName, lastName, email;
	private int memberID = 1;
	private int phoneNumber;
	private boolean isPremium;
	private MyDate memberSince;
	private ArrayList<Event> allAttendedEventsList;

	public Member(String firstName, String lastName, String email, int memberID, int phoneNumber, boolean isPremium)
	{
		// TODO: pull new memberID from binary file by checking biggest member ID
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.memberID = memberID;
		this.phoneNumber = phoneNumber;
		this.isPremium = isPremium;
		this.memberSince = MyDate.today();

		allAttendedEventsList = new ArrayList<Event>();

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
	public String toString()
	{
		return "Member [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", memberID="
				+ memberID + ", phoneNumber=" + phoneNumber + ", isPremium=" + isPremium + ", memberSince="
				+ memberSince + "]";
	}

}
