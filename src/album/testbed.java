package album;
public class testbed {
    public static void main(String[] args) {
        // Test the Date class
        Date date1 = new Date(2023, 10, 15);
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
