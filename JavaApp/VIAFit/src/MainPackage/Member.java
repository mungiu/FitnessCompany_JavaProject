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
   private FileAdapter fileAdapter;
   private MyDate memberSince;
   private ArrayList<Event> allAttendedEventsList;

   /**
    * Six-argument constructor.
    * 
    * @param firstName
    *           the members first name.
    * @param lastName
    *           the members last name.
    * @param email
    *           the members email.
    * @param memberID
    *           the members ID number.
    * @param phoneNumber
    *           the members phone number.
    * @param isPremium
    *           is the member premium.
    */
   public Member(String name, String email,
         String phoneNumber, boolean isPremium)
   {
      // TODO: pull new memberID from binary file by checking biggest member ID
      this.name = name;

      this.email = email;
      this.memberID = getNewMemberID();
      this.phoneNumber = phoneNumber;
      this.isPremium = isPremium;
      this.memberSince = MyDate.today();

      allAttendedEventsList = new ArrayList<Event>();

   }

   /**
    * Gets the members new ID number.
    * 
    * @return the members new ID number and counts one up every time.
    */
   public int getNewMemberID()
   {
      int biggestID = 0;
      ArrayList<Member> tempMembList = fileAdapter.getMembersList();
   
      for (int i = 0; i < tempMembList.size(); i++)
         if (biggestID < tempMembList.get(i).getMemberID())
            biggestID = tempMembList.get(i).getMemberID();
      return biggestID + 1;
   }

   public void setMemberID(int id)
   {
      memberID = id;
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
    * Sets the members first name.
    * 
    * @param firstName
    *           is what the members first name will be set to.
    */
   public void setName(String firstName)
   {
      this.name = firstName;
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
    * Sets the members phone number.
    * 
    * @param phoneNumber
    *           is what the members phone number will be set to.
    */
   public void setPhoneNumber(String phoneNumber)
   {
      this.phoneNumber = phoneNumber;
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
    * Sets the members email.
    * 
    * @param email
    *           is what the members email will be set to.
    */
   public void setEMail(String email)
   {
      this.email = email;
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
    * Sets the member premium
    * 
    * @param isPremium
    *           is what the members premium status will be set to.
    */
   public void setIsPremium(boolean isPremium)
   {
      this.isPremium = isPremium;
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
   
   public void setMemberSince(MyDate memberSince)
   {
      this.memberSince = memberSince;
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
      String str = "<html><pre style='font-size:11px'>"+name+"\t\t"+email+"\t\t"+phoneNumber+"\t\t"+memberSince+"\t\t"+memberID+"</pre></html>";
      return str;
   }


}
