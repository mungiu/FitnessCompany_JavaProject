package MainPackage;

import java.io.Serializable;
import java.util.ArrayList;

public class MembersList implements Serializable
{
	private static final long serialVersionUID = 546950501307470288L;
	ArrayList<Member> membersList = new ArrayList<Member>();
	private int lastMemberID = 1;

	public ArrayList<Member> getMembersList()
	{
		return membersList;
	}

	public void setMembersList(ArrayList<Member> membersList)
	{
		this.membersList = membersList;
	}
	public int getLastMemberID()
	{
	   return lastMemberID;
	}
	public void setLastMemberID(int biggest)
	{
	   lastMemberID = biggest;
	}
}
