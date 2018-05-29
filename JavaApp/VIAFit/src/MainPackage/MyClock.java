package MainPackage;

public class MyClock
{
   private int hour;
   private int minute;
   private int second;

   // 3-argument constructor
   public MyClock(int hour, int min, int sec)
   {
      // the class has a set method that does exactly
      // what I need, so no need to implement everything twice
      setTime(hour, min, sec);   
   }

   // 1-argument constructor
   public MyClock(int timeInSeconds)
   {
      // we got a set method for this too now
      setTime(timeInSeconds);
   }

   // 1-argument copy constructor
   public MyClock(MyClock obj)
   {
      hour = obj.hour;
      minute = obj.minute;
      second = obj.second;
   }

   // no-arg constructor
   public MyClock()
   {
      hour = 0;
      minute = 0;
      second = 0;
   }

   // get method for hour
   public int getHour()
   {
      return hour;
   }

   // get method for minute
   public int getMinute()
   {
      return minute;
   }

   // get method for second
   public int getSecond()
   {
      return second;
   }

   // set method for all three fields
   public void setTime(int hour, int min, int sec)
   {
      this.hour = hour;
      minute = min;
      second = sec;
   }

   // sets the fields based on the time given as seconds
   public void setTime(int timeInSeconds)
   {
      hour = timeInSeconds / 3600;
      timeInSeconds -= 3600 * hour;

      minute = timeInSeconds / 60;
      timeInSeconds -= 60 * minute;

      second = timeInSeconds;
   }

   // returns the time converted to the total seconds
   public int convertToSeconds()
   {
      return hour * 3600 + minute * 60 + second;
   }

   // static method that converts an hour, minute, and second to the total seconds
   public static int convertToSec(int hour, int min, int sec)
   {
      return hour * 3600 + min * 60 + sec;
   }

   // adds 1 second to the time
   public void tic()
   {
      second++;
      
      if(second>59)
      {
         second=0;
         minute++;
         
         if(minute>59)
         {
            minute=0;
            hour++;
            
            if(hour>23)
            {
               hour=0;
            }
         }
      }
   }

   // returns whether or not the time is before the time in the Clock object
   // given as argument
   public boolean isBefore(MyClock time)
   {
      return convertToSeconds() < time.convertToSeconds();
   }

   // returns the number of seconds between the time and the time in the Clock
   // object given as argument
   public int timeInSecondsTo(MyClock time)
   {
      if(isBefore(time))
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
   public String toString()
   {
      String time = "";
      if(hour < 10)
      {
         time += "0";
      }
      time += hour + ":";

      if(minute < 10)
      {
         time += "0";
      }
      time += minute + ":";

      if(second < 10)
      {
         time += "0";
      }
      time += second;

      return time;
   }

   // returns whether or not the Clock object given as argument is identical to
   // the current one
   public boolean equals(MyClock obj)
   {
      return (hour == obj.hour && minute == obj.minute && second == obj.second);
   }

   // returns a new Clock object identical to the current one
   public MyClock copy()
   {
      return new MyClock(hour, minute, second);
   }
}
