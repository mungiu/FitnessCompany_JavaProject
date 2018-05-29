package MainPackage;

import java.util.ArrayList;

public class Member
{
   private int memberID, phoneNumber;
   private String firstName, lastName, email;
   private boolean isPremium;
   private MyDate memberSince;
   private ArrayList<Event> attendedEvents;

   public Member(String firstName, String lastName, String email, int memberID,
         int phoneNumber, boolean isPremium, MyDate memberSince)
   {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.memberID = memberID;
      this.phoneNumber = phoneNumber;
      this.isPremium = isPremium;
      this.memberSince = memberSince;
      attendedEvents = new ArrayList<Event>();
   }

   public int getMemberID()
   {
      return memberID;
   }

   public String getFirstName()
   {
      return firstName;
   }

   public void setFirstName()
   {
      this.firstName = firstName;
   }

   public String getLastName()
   {
      return lastName;
   }

   public void setLastName()
   {
      this.lastName = lastName;
   }

   public int getPhoneNumber()
   {
      return phoneNumber;
   }

   public void setPhoneNumber()
   {
      this.phoneNumber = phoneNumber;
   }

   public boolean getIsPremium()
   {
      return isPremium;
   }
   public MyDate getMemberSince()
   {
      return memberSince;
   }

   public void setIsPremium(boolean isPremium)
   {
      this.isPremium = isPremium;
   }

   public ArrayList<Event> getMemberEvents()
   {
      return attendedEvents;
   }
}
