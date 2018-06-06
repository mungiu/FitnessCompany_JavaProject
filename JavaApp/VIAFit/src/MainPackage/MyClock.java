 package MainPackage;

import java.io.Serializable;

/**
 * A class representing a MyClock with hour, minute and second.
 * 
 * @author Group 1
 * @version 1.0
 */
public class MyClock implements Serializable
{
   /**
    * Generated serial version UID.
    */
   private static final long serialVersionUID = -8060363652216244441L;
   private int hour;
   private int minute;
   private int second;

   /**
    * Three-argument constructor.
    * 
    * @param hour
    *           is MyClock hour.
    * @param min
    *           is MyClock minute.
    * @param sec
    *           is MyClock second.
    */
   public MyClock(int hour, int min, int sec)
   {
      // the class has a set method that does exactly
      // what I need, so no need to implement everything twice
      setTime(hour, min, sec);
   }

   /**
    * One-argument constructor
    * 
    * @param timeInSeconds
    *           is MyClock time in seconds.
    */
   public MyClock(int timeInSeconds)
   {
      // we got a set method for this too now
      setTime(timeInSeconds);
   }

   /**
    * One-argument constructor.
    * 
    * @param obj
    */
   public MyClock(MyClock obj)
   {
      hour = obj.hour;
      minute = obj.minute;
      second = obj.second;
   }

   /**
    * No-argument constructor.
    */
   public MyClock()
   {
      hour = 0;
      minute = 0;
      second = 0;
   }

   /**
    * Gets the MyClock hour.
    * 
    * @return the MyClock hour.
    */
   public int getHour()
   {
      return hour;
   }

   /**
    * Gets the MyClock minute.
    * 
    * @return the MyClock minute.
    */
   public int getMinute()
   {
      return minute;
   }

   /**
    * Gets the MyClock second.
    * 
    * @return the MyClock second.
    */
   public int getSecond()
   {
      return second;
   }

   /**
    * Sets the MyClock time.
    * 
    * @param hour
    *           is what the MyClock hour will be set to.
    * @param min
    *           is what the MyClock minute will be set to.
    * @param sec
    *           is what the MyClock second will be set to.
    */
   public void setTime(int hour, int min, int sec)
   {
      this.hour = hour;
      minute = min;
      second = sec;
   }

   /**
    * Sets the MyClock time in seconds.
    * 
    * @param timeInSeconds
    *           is what the MyClock time will be set to in seconds.
    */
   public void setTime(int timeInSeconds)
   {
      hour = timeInSeconds / 3600;
      timeInSeconds -= 3600 * hour;

      minute = timeInSeconds / 60;
      timeInSeconds -= 60 * minute;

      second = timeInSeconds;
   }

   /**
    * Converts the MyClock time to seconds.
    * 
    * @return the time converted to the total seconds
    */
   public int convertToSeconds()
   {
      return hour * 3600 + minute * 60 + second;
   }

   // static method that converts an hour, minute, and second to the total
   // seconds
   /**
    * Converts the MyClock time to seconds.
    * 
    * @param hour
    *           is what the MyClock hour will be converted into seconds.
    * @param min
    *           is what the MyClock minute will be converted into seconds.
    * @param sec
    *           is what the MyClock second will be counted up into seconds.
    * @return the MyClock time in seconds.
    */
   public static int convertToSec(int hour, int min, int sec)
   {
      return hour * 3600 + min * 60 + sec;
   }

   /**
    * Adds one second to the MyClock time.
    */
   public void tic()
   {
      second++;

      if (second > 59)
      {
         second = 0;
         minute++;

         if (minute > 59)
         {
            minute = 0;
            hour++;

            if (hour > 23)
               hour = 0;
         }
      }
   }

   // returns whether or not the time is before the time in the Clock object
   // given as argument
   /**
    * Compares the MyClock time if it is before the time in the Clock object
    * 
    * @return TODO
    */
   public boolean isBefore(MyClock time)
   {
      return convertToSeconds() < time.convertToSeconds();
   }

   // returns the number of seconds between the time and the time in the Clock
   // object given as argument
   public int timeInSecondsTo(MyClock time)
   {
      if (isBefore(time))
      {
         return time.convertToSeconds() - convertToSeconds();
      }
      else
      {
         return 24 * 3600 - (convertToSeconds() - time.convertToSeconds());
      }
   }

   // returns the time difference between the time and the time in the Clock
   // object given as argument as a Clock object
   public MyClock timeTo(MyClock time)
   {
      return new MyClock(timeInSecondsTo(time));
   }

   // returns the time as a String in the format hh:mm:ss
   /**
    * Returns a string representation of MyClock
    * 
    * @return a string representation of MyClock in the format:
    *         hour:minute:second.
    */
   public String toString()
   {
      String time = "";
      if (hour < 10)
      {
         time += "0";
      }
      time += hour + ":";

      if (minute < 10)
      {
         time += "0";
      }
      time += minute + ":";

      if (second < 10)
      {
         time += "0";
      }
      time += second;

      return time;
   }

   /**
    * Compares the hour, minute and second of two MyClock.
    * 
    * @param obj
    *           the object to compare with
    * @return true if the given object is equal to this MyClock.
    */
   public boolean equals(Object obj)
   {
      if(!(obj instanceof MyClock))
      {
         return false;
      }
      MyClock other = (MyClock)obj;
      
      return (other.hour==hour && other.minute==minute && other.second==second);
   }

   /**
    * Makes a copy of MyClock object
    * 
    * @return a new MyClock object identical to the current one.
    */
   public MyClock copy()
   {
      return new MyClock(hour, minute, second);
   }
}
