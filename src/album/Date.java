package album;
import java.util.Calendar;

public class Date implements Comparable<Date> {
    private int year;
    private int month;
    private int day;

    public Date() {

    }

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public boolean isValid(Date date) {
        // check if date argument is a valid calendar date
        Calendar checkDate = Calendar.getInstance();
        checkDate.setLenient(false); // Disable leniency (to strictly enforce date validity)

        checkDate.set(Calendar.YEAR, date.getYear());
        checkDate.set(Calendar.MONTH, date.getMonth() - 1); // Note: Month is zero-based, so subtract 1 from our 1 indexed date
        checkDate.set(Calendar.DAY_OF_MONTH, date.getDay());

        try {
            checkDate.getTime(); // This call will throw an exception if the date is invalid

        } catch (Exception e) {
            return false;
        }

        if (date.getYear() < 1900) return false;

        Calendar todayDate = Calendar.getInstance();
        int todayYear = todayDate.get(Calendar.YEAR);
        int todayMonth = todayDate.get(Calendar.MONTH) + 1; // Note: Month is zero-based, so add 1
        int todayDay = todayDate.get(Calendar.DAY_OF_MONTH);

        Date currentDate = new Date(todayYear, todayMonth, todayDay);

        return date.compareTo(currentDate) != 0 && date.compareTo(currentDate) <= 0;
    }


    @Override
    public int compareTo(Date date) {
            if (this.year != date.year) {
                return Integer.compare(this.year, date.year);
            }
            if (this.month != date.month) {
                return Integer.compare(this.month, date.month);
            }
            return Integer.compare(this.day, date.day);
        }
}