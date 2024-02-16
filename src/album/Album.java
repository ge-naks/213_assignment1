package album;

/**
 * This class represents an album and its associated information.
 * It contains methods to add ratings, compute average ratings, and describe all album information quickly.
 *
 * @author George Nakhla, Mena Youssef
 */
public class Album {
    private String title;
    private Artist artist;
    private Genre genre;
    private Date released;
    private Rating ratings; //head for a linked list of ratings

    public Album() {

    }

    /**
     * Creates an Album object with album title, release, genre, ratings and artist name.
     *
     * @param title    name of album title
     * @param artist   name of album artist
     * @param genre    the music genre of the album
     * @param released the release date of the album
     */
    public Album(String title, Artist artist, Genre genre, Date released) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.released = released;
    }

    /**
     * Returns title of album
     *
     * @return title
     */
    public String getTitle() {
        return title;
    }




    /**
     * Returns artist of album
     *
     * @return artist
     */
    public Artist getArtist() {
        return artist;
    }

    /**
     * Returns genre of album
     *
     * @return genre
     */
    public Genre getGenre() {
        return genre;
    }


    /**
     * Returns release of album
     *
     * @return release date
     */
    public Date getReleased() {
        return released;
    }


    /**
     * Adds a new rating to the FRONT of the ratings singly linked list
     *
     * @param star A 1-5 star (*) rating for the album
     */
    public void rate(int star) {
        Rating newRating = new Rating(star);
        newRating.setNext(this.ratings);
        ratings = newRating;
    }

    /**
     * Calculates the average star ratings for an album
     *
     * @return A double (1-5) that represents the average rating. 0.0 otherwise
     */
    public double avgRatings() {

        if (ratings == null) {
            return 0.0;
        }

        int totalStars = 0;
        int numRatings = 0;
        Rating currRating = this.ratings;

        while (currRating != null) {
            numRatings++;
            totalStars += currRating.getStar();
            currRating = currRating.getNext();
        }
        return (double) totalStars / numRatings;


    }

    /**
     * Checks for equality between two albums
     *
     * @param obj an object (likely an Album, will test for equality)
     * @return true if the names and artists for the two albums are equal. False otherwise
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Album album = (Album) obj;
        return (title == null ? album.title == null : title.equalsIgnoreCase(album.title)) &&
                (artist == null ? album.artist == null : artist.equals(album.artist));
    }


    /**
     * Converts all album information to a well formatted string.
     *
     * @return A string containing Album name, release date, artist genre, average rating, and individual ratings
     */
@Override
    public String toString() {
        if (this.avgRatings() >= 1) {
            Rating ptr = this.ratings;

            int[] ratingCounts = new int[5]; // index i = star rating, ratingCounts[i] = number of ratings

            while (ptr != null) {
                ratingCounts[ptr.getStar() - 1] += 1;
                ptr = ptr.getNext();
            }

            String stringRatings = "*" + "(" + Integer.toString(ratingCounts[0]) + ")"
                    + "*".repeat(2) + "(" + Integer.toString(ratingCounts[1]) + ")"
                    + "*".repeat(3) + "(" + Integer.toString(ratingCounts[2]) + ")"
                    + "*".repeat(4) + "(" + Integer.toString(ratingCounts[3]) + ")"
                    + "*".repeat(5) + "(" + Integer.toString(ratingCounts[4]) + ")";

            String formattedRating = String.format("%.2f", this.avgRatings());

            return "[" + this.getTitle() + "] " + "Released " + released.getMonth() + "/" + released.getDay()
                    + "/" + released.getYear() + " " + this.getArtist().toString()
                    + " " + "[" + this.genre + "] " + "Rating: " + stringRatings + "(" + "average rating: "
                    + formattedRating + ")";
        }
        return "[" + this.getTitle() + "] " + "Released " + released.getMonth() + "/" + released.getDay()
                + "/" + released.getYear() + " " + this.getArtist().toString()
                + " " + "[" + this.genre + "] " + "Rating: none";

    }

}

