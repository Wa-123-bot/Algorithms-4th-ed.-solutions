package ch_1_2;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;

public class exer_11_12
{
    public static void main( String[] args)
    {
        int month = Integer.parseInt(args[0]);
        int day = Integer.parseInt(args[1]);
        int year = Integer.parseInt(args[2]);
        var date = new SmartDate( day, month, year);
        if (!date.is_valid())
        {
            throw new RuntimeException("Not a legal date.");
        }

        System.out.println("The day of the week of " + date.toString() + " is " + date.dayOfTheWeek());
    }


}

class SmartDate
{
    private final int day;
    private final int month;
    private final int year;

    public SmartDate( int day, int month, int year)
    {
        this.day = day;
        this.month = month;
        this.year = year;

    }

    public int get_day() { return day; }
    public int get_month() { return month; }
    public int get_year() { return year; }
    public String toString() { return year + "-" + month + "-" + day; }

    public boolean is_valid()
    {
        if ( month > 12 || month < 1 || day < 1 || day > 31)
        {
            return false;
        }

        if ( month % 2 == 0 && day > 30)
        {
            return false;
        }

        if (month == 2 && year % 4 == 0 && year % 100 == 0 && year % 400 == 0)
        {
            if (day > 29)
            {
                return false;
            }
        }

        if (month == 2 && year % 4 != 0)
        {
            if (day > 29)
            {
                return false;

            }
        }

        return true;

    }

    public String dayOfTheWeek()
    {
        String[] days = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

        Calendar date = Calendar.getInstance();
        var DATE = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        // handle parse exception may occurs when calling the parse()
        try
        {
            DATE = format.parse(this.toString());
        }

        catch (ParseException e)
        {
            e.printStackTrace();
        }

        date.setTime(DATE);
        int day_of_the_week = date.get(Calendar.DAY_OF_WEEK);
        return days[day_of_the_week-1];

    }
}
