package MainPackage;

import java.io.Serializable;

/**
 * A class representing a MyClock with hour, minute and second.
 * 
 * @author Group 1
 * @version 1.0
 */
public class MyClock implements Serializable, Comparable<MyClock>
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
	 *            is MyClock hour.
	 * @param min
	 *            is MyClock minute.
	 * @param sec
	 *            is MyClock second.
	 */
	public MyClock(int hour, int min, int sec)
	{
		// setTime() method used instead of setting each variable separately

		setTime(hour, min, sec);
	}

	/**
	 * One-argument constructor, using seconds only.
	 * 
	 * @param timeInSeconds
	 *            is MyClock time in seconds.
	 */
	public MyClock(int timeInSeconds)
	{
		// we got a set method for this too now
		setTime(timeInSeconds);
	}

	/**
	 * One-argument constructor, using an existing MyClock object.
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
	 * No-argument constructor, setting time to 00:00:00.
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
	 *            is what the MyClock hour will be set to.
	 * @param min
	 *            is what the MyClock minute will be set to.
	 * @param sec
	 *            is what the MyClock second will be set to.
	 */
	public void setTime(int hour, int min, int sec)
	{
		if ((hour >= 0 && hour <= 24) && (min >= 0 && min <= 60) && (sec >= 0 && sec <= 60))
		{
			this.hour = hour;
			minute = min;
			second = sec;
		}
	}

	/**
	 * Sets the MyClock time in seconds.
	 * 
	 * @param timeInSeconds
	 *            is what the MyClock time will be set to in seconds.
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
	 * Converts and return the current MyClock time in seconds.
	 * 
	 * @return the time converted to the total seconds
	 */
	public int convertToSeconds()
	{
		return hour * 3600 + minute * 60 + second;
	}

	/**
	 * Static method that converts the inputed hours, minutes and seconds to total
	 * seconds and returns the results.
	 * 
	 * @param hour
	 *            is what the MyClock hour will be converted into seconds.
	 * @param min
	 *            is what the MyClock minute will be converted into seconds.
	 * @param sec
	 *            is what the MyClock second will be counted up into seconds.
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

	/**
	 * Compares whether or not the time is before the time in the Clock object given
	 * as argument
	 * 
	 * @return true of false of the description.
	 */
	public boolean isBefore(MyClock time) throws NullPointerException
	{
		return convertToSeconds() < time.convertToSeconds();
	}

	/**
	 * Compares the number of seconds between current time and passed in time
	 * 
	 * @param time
	 *            a MyClock object to compare against
	 * @return the number of seconds between current time and passed in time
	 * @throws NullPointerException
	 */
	public int timeInSecondsTo(MyClock time) throws NullPointerException
	{
		if (isBefore(time))
			return time.convertToSeconds() - convertToSeconds();
		else
			return 24 * 3600 - (convertToSeconds() - time.convertToSeconds());
	}

	// returns the time difference between the time and the time in the Clock
	// object given as argument as a Clock object
	public MyClock timeTo(MyClock time) throws NullPointerException
	{
		return new MyClock(timeInSecondsTo(time));
	}

	// returns the time as a String in the format hh:mm:ss
	/**
	 * Returns a string representation of MyClock
	 * 
	 * @return a string representation of MyClock in the format: hour:minute:second.
	 */
	public String toString()
	{
		String time = "";
		if (hour < 10)
			time += "0";
		time += hour + ":";

		if (minute < 10)
			time += "0";
		time += minute + ":";

		if (second < 10)
			time += "0";
		time += second;

		return time;
	}

	/**
	 * Compares the hour, minute and second of two MyClock.
	 * 
	 * @param obj
	 *            the object to compare with
	 * @return true if the given object is equal to this MyClock.
	 */
	public boolean equals(Object obj) throws NullPointerException
	{
		if (!(obj instanceof MyClock))
			return false;
		else
		{
			MyClock temp = (MyClock) obj;

			return (temp.hour == hour && temp.minute == minute && temp.second == second);
		}
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

	@Override
	public int compareTo(MyClock clock)
	{
		boolean thisClockIsSameHour = this.getHour() == clock.getHour();
		boolean thisClockIsSameMinute = (thisClockIsSameHour && this.getMinute() == clock.getMinute());
		boolean thisClockIsSameSecond = (thisClockIsSameMinute && this.getSecond() == clock.getSecond());

		boolean thisClockIsEarlierHour = this.getHour() < clock.getHour();
		boolean thisClockIsEarlierMinute = thisClockIsSameHour && this.getMinute() < clock.getMinute();
		boolean thisClockIsEarlierSecond = thisClockIsSameHour && thisClockIsSameMinute
				&& this.getSecond() < clock.getSecond();

		if (thisClockIsEarlierHour | thisClockIsEarlierMinute | thisClockIsEarlierSecond)
			return -1;
		else if (thisClockIsSameSecond)
			return 0;
		else
			return 1;
	}
}
