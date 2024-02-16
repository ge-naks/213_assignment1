package album;
import java.util.Calendar;

/**
 * Represents a date with year, month, and day components.
 */
public class Date implements Comparable<Date> {
    private int year;
    private int month;
    private int day;

    /**
     * Constructs a default Date object with year, month, and day initialized to 0.
     */
    public Date() {

    }

    /**
     * Constructs a Date object with the specified year, month, and day.
     *
     * @param year  The year.
     * @param month The month (1-based index).
     * @param day   The day of the month.
     */
    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    /**
     * Gets the year component of the date.
     *
     * @return The year.
     */
    public int getYear() {
        return year;
    }
    /**
     * Gets the month component of the date.
     *
     * @return The month.
     */
    public int getMonth() {
        return month;
    }
    /**
     * Gets the day component of the date.
     *
     * @return The day.
     */
    public int getDay() {
        return day;
    }

    /**
     * Checks if the specified date is valid.
     *
     * @param date The date to be checked.
     * @return {@code true} if the date is valid, {@code false} otherwise.
     */
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

    /**
     * Compares this Date object with the specified Date object for order.
     *
     * @param date The Date object to be compared.
     * @return A negative integer, zero, or a positive integer as this Date object is less than, equal to, or greater than the specified Date object.
     */
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

    /**
     * Returns a string representation of the date in the format "month/day/year".
     *
     * @param date The Date object to be converted to a string.
     * @return The string representation of the date.
     */
    public String toString(Date date){
        return date.getMonth() + "/" + date.getDay() + "/" + date.getYear();
    }


    /**
     * Test method for the Date class.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args){
        // Test the Date class
        Date date1 = new Date(2023, 1, 15);
        Date date2 = new Date(2022, 12, 31);
        Date date3 = new Date(2024, 2, 10);
        Date date4 = new Date(1899, 5, 20);
        Date date5 = new Date(1960, 2, 30); // Invalid day of month
        Date date6 = new Date(1960, 1, 32); // Invalid day of month
        Date date7 = new Date(1960, 13, 32); // Invalid month
        Date date8 = new Date(2016, 2, 29); // VALID leap year
        Date date9 = new Date(2022, 2, 29); // "fake" leap year

        // Test isValid method
        System.out.println("date1 is valid: " + date1.isValid(date1)); // true
        System.out.println("date2 is valid: " + date2.isValid(date2)); // true
        System.out.println("date3 is valid: " + date3.isValid(date3)); // false
        System.out.println("date4 is valid: " + date4.isValid(date4)); // false
        System.out.println("date5 is valid: " + date5.isValid(date5)); // false
        System.out.println("date6 is valid: " + date6.isValid(date6)); // false
        System.out.println("date7 is valid: " + date7.isValid(date7)); // false
        System.out.println("date8 is valid: " + date8.isValid(date8)); // true
        System.out.println("date9 is valid: " + date9.isValid(date9)); // false

        // Test compareTo method
        System.out.println("Comparing date1 and date2: " + date1.compareTo(date2)); // > 0
        System.out.println("Comparing date1 and date3: " + date1.compareTo(date3)); // < 0
        System.out.println("Comparing date3 and date3: " + date1.compareTo(date4)); // 0
    }

}

