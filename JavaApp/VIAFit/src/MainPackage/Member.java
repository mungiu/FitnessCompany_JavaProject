package MainPackage;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class containing a list of Member objects.
 * 
 * @author Group 1
 * @version 1.1
 */
public class Member implements Serializable
{

	/**
	 * Generated serial version UID
	 */
	private static final long serialVersionUID = 4437337227753008510L;

	private String name, email;
	private int memberID;
	private String phoneNumber;
	private boolean isPremium;
	private MyDate memberSince;
	private ArrayList<Event> allAttendedEventsList;

	/**
	 * Six-argument constructor.
	 * 
	 * @param firstName
	 *            the members first name.
	 * @param lastName
	 *            the members last name.
	 * @param email
	 *            the members email.
	 * @param memberID
	 *            the members ID number.
	 * @param phoneNumber
	 *            the members phone number.
	 * @param isPremium
	 *            is the member premium.
	 */
	public Member(String name, String email, String phoneNumber, int memberID, boolean isPremium)
	{
		// TODO: pull new memberID from binary file by checking biggest member ID
		this.name = name;

		this.email = email;
		this.memberID = memberID;
		this.phoneNumber = phoneNumber;
		this.isPremium = isPremium;
		this.memberSince = MyDate.today();

		allAttendedEventsList = new ArrayList<Event>();

	}

	/**
	 * Gets the members ID number.
	 * 
	 * @return the members ID number.
	 */
	public int getMemberID()
	{
		return memberID;
	}

	/**
	 * Gets the members first name.
	 * 
	 * @return the members first name.
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Gets the members phone number.
	 * 
	 * @return the ,members phone number.
	 */
	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	/**
	 * Gets the members email.
	 * 
	 * @return the members email.
	 */
	public String getEMail()
	{
		return email;
	}

	/**
	 * Gets if the member is premium
	 * 
	 * @return if member is premium return true.
	 */
	public boolean getIsPremium()
	{
		return isPremium;
	}

	/**
	 * Gets the member since date.
	 * 
	 * @return the members since date.
	 */

	public MyDate getMemberSince()
	{
		return memberSince;
	}

	/**
	 * Gets the members event list.
	 * 
	 * @return the members event list.
	 */
	public ArrayList<Event> getMemberEvents()
	{
		return allAttendedEventsList;
	}

	public void setMemberID(int id)
	{
		memberID = id;
	}

	/**
	 * Sets the members first name.
	 * 
	 * @param firstName
	 *            is what the members first name will be set to.
	 */
	public void setName(String firstName)
	{
		this.name = firstName;
	}

	/**
	 * Sets the members phone number.
	 * 
	 * @param phoneNumber
	 *            is what the members phone number will be set to.
	 */
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Sets the members email.
	 * 
	 * @param email
	 *            is what the members email will be set to.
	 */
	public void setEMail(String email)
	{
		this.email = email;
	}

	/**
	 * Sets the member premium
	 * 
	 * @param isPremium
	 *            is what the members premium status will be set to.
	 */
	public void setIsPremium(boolean isPremium)
	{
		this.isPremium = isPremium;
	}

	public void setMemberSince(MyDate memberSince) throws NullPointerException
	{
		this.memberSince = memberSince;
	}

	/**
	 * Compares the memberID of two members.
	 * 
	 * @param obj
	 *            the object to compare with.
	 * @return true if the given object is equal to this member.
	 */
	public boolean equals(Object obj) throws NullPointerException
	{
		if (!(obj instanceof Member))
			return false;
		else
		{
			Member temp = (Member) obj;

			return memberID == temp.memberID;
		}
	}

	/**
	 * Returns a shorter string representation of the member.
	 * 
	 * @return a string representation of the member in the format: "name phone
	 *         number member id"
	 */
	public String toSmallString()
	{
		String str = "<html><pre style='font-size:9px'>" + name + "\t\t" + "ID: " + memberID + "\nPhone number: "
				+ phoneNumber + "</pre></html>";
		return str;
	}

	/**
	 * Returns a string representation of the member.
	 * 
	 * @return a string representation of the member in the format: "name email
	 *         phone number member since member id"
	 */
	public String toString()
	{
		String nameTab = "";
		String emailTab = "\t";
		String phoneTab = "\t\t";
		if (name.length() >= 16)
			nameTab = "\t";
		else if (name.length() >= 8 && name.length() < 16)
			nameTab = "\t\t";
		else
			nameTab = "\t\t\t";

		if (email.length() >= 16 && email.length() <= 22)
			emailTab = "\t\t";
		else if (email.length() >= 8 && email.length() < 16)
			emailTab = "\t\t\t";
		else if (email.length() < 8)
			emailTab = "\t\t\t\t";

		if (phoneNumber.length() < 8)
			phoneTab = "\t\t\t";

		String str = "<html><pre style='font-size:11px'>" + name + nameTab + email + emailTab + phoneNumber + phoneTab
				+ memberSince + "\t\t" + memberID + "</pre></html>";
		return str;
	}
}
