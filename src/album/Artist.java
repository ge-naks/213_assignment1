package album;

/**
 * This class represents an artist and an artists name and DOB
 * It contains methods to compare artist names and create a well formatted string for artist names.
 *
 * @author George Nakhla, Mena Youssef
 */

public class Artist implements Comparable<Artist> {
    private String name;
    private Date born;

    public Artist() {

    }

    /**
     * Constructor for an artist object.
     *
     * @param name artist Name
     * @param born the D.O.B of an artist (mm/dd/yyyy)
     */
    public Artist(String name, Date born) {
        this.name = name;
        this.born = born;
    }

    public String getName() {
        return name;
    }

    public Date getBorn() {
        return born;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBorn(Date born) {
        this.born = born;
    }


    /**
     * Checks for equality between two artists
     *
     * @param obj an object (likely an Artist, will test for equality)
     * @return true if the names of artists are the same. False otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Artist artist = (Artist) obj;
        return (name == null ? artist.name == null : name.equalsIgnoreCase(artist.name)) &&
                (born == null ? artist.born == null : born.equals(artist.born));
    }


    /**
     * Converts all artist information to a well formatted string.
     *
     * @return A string containing artist name and DOB
     */
    public String toString() {
        return "[" + this.name + ":" + this.born.getMonth() + "/"
                + this.born.getDay() + "/" + this.born.getYear() + "]";
    }

    /**
     * Compares this artist with another artist for order.
     * The comparison is based on the artist's name and date of birth.
     *
     * @param artist the artist to be compared
     * @return a negative integer, zero, or a positive integer if this artist is less than,
     * equal to, or greater than the specified artist, respectively, based on the comparison rules.
     */
    public int compareTo(Artist artist) {
        int nameEquality = this.name.compareToIgnoreCase(artist.name);

        if (nameEquality != 0) {
            return nameEquality;
        } else {
            return this.born.compareTo(artist.born);
        }

    }

    public static void main(String[] args) {
        // Test for equality
        Date date1 = new Date(1960, 1, 10);
        Date date2 = new Date(1960, 1, 11);
        Artist artist1 = new Artist("Drake", date1);
        Artist artist2 = new Artist("drake", date1);
        System.out.println("Equality Test: " + artist1.equals(artist2)); // Should print true

        // Test for inequality
        Artist artist3 = new Artist("Adele", date1);
        System.out.println("Inequality Test: " + artist1.equals(artist3)); // Should print false

        // Test for string representation
        System.out.println("String Representation Test:");
        System.out.println(artist1); // Should print "[Drake:1/10/1960]"

        // Test for comparison
        System.out.println("\nComparison Test:");
        System.out.println("Comparison Result between " + artist1.getName() + " and " + artist2.getName() + ": " + artist1.compareTo(artist2));
        System.out.println("Comparison Result between " + artist1.getName() + " and " + artist3.getName() + ": " + artist1.compareTo(artist3));

        // Additional Tests

        // Test for same artist name but different birth dates
        Artist artist4 = new Artist("Drake", date2);
        System.out.println("Comparison Result between " + artist1.getName() + " and " + artist4.getName() + ": " + artist1.compareTo(artist4)); // Should print a negative number

        // Test for same artist name and same birth dates
        Artist artist5 = new Artist("Drake", date1);
        System.out.println("Comparison Result between " + artist1.getName() + " and " + artist5.getName() + ": " + artist1.compareTo(artist5)); // Should print 0

        // Test for setting name and birth date
        artist1.setName("Beyonce");
        artist1.setBorn(new Date(1981, 9, 4));
        System.out.println("Updated Artist Info: " + artist1); // Should print "[Beyonce:9/4/1981]"
    }


}
