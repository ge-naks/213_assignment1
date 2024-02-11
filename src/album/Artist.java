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
        if (obj instanceof Artist) {
            Artist artist = (Artist) obj;
            return artist.name.equals(this.name);
        }
        return false;
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
        int nameEquality = this.name.compareTo(artist.name);

        if (nameEquality != 0) {
            return nameEquality;
        } else {
            return this.born.compareTo(artist.born);
        }

    }

}
