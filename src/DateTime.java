
public class DateTime {

    private int day;
    private int month;
    private int year;
    private int hour;
    private int minute;

    public DateTime(){//default constructor

    }
    public DateTime(int day, int month, int year, int hour, int minute) {//Create constructor with parameters

        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.minute = minute;

    }
    //provide getter and setter method for make the class read-only or write-only .
    //Encapsulation in java is a process of wrapping code and data together into a single unit.
    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getMinute() {
        return minute;
    }

    public int getHour() {
        return hour;
    }

    public void setDay(int day) {
        this.day = day;

    }

    public void setMonth(int month) {
        this.month = month;

    }

    public void setYear(int year) {

        this.year = year;

    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

}
