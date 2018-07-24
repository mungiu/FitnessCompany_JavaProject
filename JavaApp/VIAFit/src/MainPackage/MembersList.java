package MainPackage;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class containing a list of members.
 * 
 * @author Group 1
 */
public class MembersList implements Serializable
{
	/**
	 * Generated serial version UID.
	 */
	private static final long serialVersionUID = 546950501307470288L;
	ArrayList<Member> membersList = new ArrayList<Member>();
	private int lastMemberID = 1;

	/**
	 * Gets the members list.
	 * 
	 * @return the members list.
	 */
	public ArrayList<Member> getMembersList()
	{
		return membersList;
	}

	/**
	 * Gets the last members ID number.
	 * 
	 * @return the last members ID number.
	 */
	public int getLastMemberID()
	{
		return lastMemberID;
	}

	/**
	 * Sets the members list.
	 * 
	 * @param membersList
	 *            is what MemberList, members list will be set to.
	 */
	public void setMembersList(ArrayList<Member> membersList) throws NullPointerException
	{
		this.membersList.clear();

		for (int i = 0; i < membersList.size(); i++)
			this.membersList.add(membersList.get(i));
	}

	/**
	 * Sets the last members ID number.
	 * 
	 * @param biggest
	 *            is what the MembersList last member ID number will be set to.
	 */
	public void setLastMemberID(int biggest) throws NullPointerException
	{
		lastMemberID = biggest;
	}
}
