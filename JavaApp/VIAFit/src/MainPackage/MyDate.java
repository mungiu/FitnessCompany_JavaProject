package MainPackage;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class MyDate implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3253011395351701364L;
	private int day;
	private int month;
	private int year;

	public MyDate(int day, int month, int year)
	{
		this.day = day;
		this.month = month;
		this.year = year;

		if (day > daysInMonth())
		{
			for (int i = 0; i <= (Math.abs(day - daysInMonth())); i++)
			{
				nextDay();
			}
		}
	}

	public MyDate()
	{
		this.day = 1;
		this.month = 1;
		this.year = 1700;
	}

	public void setDay(int day)
	{
		this.day = day;
	}

	public void setMonth(int month)
	{
		this.month = month;
	}

	public void setYear(int year)
	{
		this.year = year;
	}

	public int getDay()
	{
		return day;
	}

	public int getMonth()
	{
		return month;
	}

	public int getYear()
	{
		return year;
	}

	public String getMonthName()
	{
		switch (month)
		{
		case 1:
			return "January";
		case 2:
			return "February";
		case 3:
			return "March";
		case 4:
			return "April";
		case 5:
			return "May";
		case 6:
			return "June";
		case 7:
			return "July";
		case 8:
			return "August";
		case 9:
			return "September";
		case 10:
			return "October";
		case 11:
			return "November";
		case 12:
			return "December";
		default:
			return "Error";
		}
	}

	public String displayDate()
	{
		String disP = "";

		disP += day + "/" + month + "/" + year;
		return disP;
	}

	public boolean isLeapYear()
	{
		if (year % 4 == 0)
		{
			if (year % 100 == 0)
			{
				if (year % 400 == 0)
				{
					return true;
				}
				return false;
			}
			return true;
		}
		return false;
	}

	public int daysInMonth()
	{
		switch (month)
		{
		case 1:
			return 31;
		case 2:
			if (isLeapYear())
			{
				return 29;
			} else
				return 28;
		case 3:
			return 31;
		case 4:
			return 30;
		case 5:
			return 31;
		case 6:
			return 30;
		case 7:
			return 31;
		case 8:
			return 31;
		case 9:
			return 30;
		case 10:
			return 31;
		case 11:
			return 30;
		case 12:
			return 31;
		default:
			return 0;
		}
	}

	public String getAstroSign()
	{
		if ((month == 3 && day >= 21) || (month == 4 && day <= 19))
		{
			return "Aries";
		} else if ((month == 4 && day >= 20) || (month == 5 && day <= 20))
		{
			return "Taurus";
		} else if ((month == 5 && day >= 21) || (month == 6 && day <= 20))
		{
			return "Gemini";
		} else if ((month == 6 && day >= 21) || (month == 7 && day <= 22))
		{
			return "Cancer";
		} else if ((month == 7 && day >= 23) || (month == 8 && day <= 22))
		{
			return "Leo";
		} else if ((month == 8 && day >= 23) || (month == 9 && day <= 22))
		{
			return "Virgo";
		} else if ((month == 9 && day >= 23) || (month == 10 && day <= 22))
		{
			return "Libra";
		} else if ((month == 10 && day >= 23) || (month == 11 && day <= 21))
		{
			return "Scorpio";
		} else if ((month == 11 && day >= 22) || (month == 12 && day <= 21))
		{
			return "Saggittarius";
		} else if ((month == 12 && day >= 22) || (month == 1 && day <= 19))
		{
			return "Capricorn";
		} else if ((month == 1 && day >= 20) || (month == 2 && day <= 18))
		{
			return "Aquarius";
		} else if ((month == 2 && day >= 19) || (month == 3 && day <= 20))
		{
			return "Pisces";
		} else
			return "Error in input";
	}

	public String dayOfWeek()
	{
		int day1;
		int yearTemp = year;
		int monthTemp = month;

		if (month == 1)
		{
			monthTemp = 13;
			yearTemp = year - 1;
		} else if (month == 2)
		{
			monthTemp = 14;
			yearTemp = year - 1;
		}
		day1 = (((day + ((13 * (monthTemp + 1))) / 5)) + yearTemp % 100 + ((yearTemp % 100) / 4)
				+ ((yearTemp / 100) / 4) + (5 * (yearTemp / 100))) % 7;

		switch (day1)
		{
		case 0:
			return "Saturday";
		case 1:
			return "Sunday";
		case 2:
			return "Monday";
		case 3:
			return "Tuesday";
		case 4:
			return "Wednesday";
		case 5:
			return "Thursday";
		case 6:
			return "Friday";
		default:
			return "Error in value";
		}
	}

	public void nextDay()
	{
		if (day + 1 > daysInMonth())
		{
			if (month + 1 > 12)
			{
				day = 1;
				month = 1;
				year++;
			} else
			{
				day = 1;
				month++;
			}
		} else
			day++;
	}

	public boolean equals(Object obj)
	{
		if (!(obj instanceof MyDate))
		{
			return false;
		}
		MyDate other = (MyDate) obj;
		return (other.day == day && other.month == day && other.year == year);
	}

	public MyDate copy()
	{
		return new MyDate(day, month, year);
	}

	public MyDate(MyDate obj)
	{
		day = obj.day;
		month = obj.month;
		year = obj.year;
	}

	public void nextDays(int days)

	{
		for (int i = 1; i <= days; i++)
		{
			nextDay();
		}
	}

	public static MyDate today()
	{
		GregorianCalendar cal = new GregorianCalendar();
		return new MyDate(cal.get(GregorianCalendar.DATE), cal.get(GregorianCalendar.MONTH) + 1,
				cal.get(GregorianCalendar.YEAR));
	}

	public boolean isBefore(MyDate obj)
	{
		if ((obj.year > year) || (obj.year >= year && obj.month > month)
				|| (obj.year >= year && obj.month >= month && obj.day >= day))
		{
			return true;
		} else
			return false;
	}

	public String toString()
	{
		return day + "/" + month + "/" + year;
	}
}
