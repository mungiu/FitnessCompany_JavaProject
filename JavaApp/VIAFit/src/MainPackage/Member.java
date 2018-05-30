package MainPackage;

import java.util.ArrayList;

public class Member
{
   private String firstName, lastName, email;
   private int memberID, phoneNumber;
   private boolean isPremium;
   private MyDate memberSince;
   private ArrayList<Event> allAttendedEventsList;

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

   public String getemail()
   {
      return email;
   }

   public void setemail(String email)
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
}
