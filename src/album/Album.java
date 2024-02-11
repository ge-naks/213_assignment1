package album;
/**
 * This class represents an album and its associated information.
 * It contains methods to add ratings, compute average ratings, and describe all album information quickly.
 *
 *  @author George Nakhla, Mena Youssef
 *
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
     * @param title name of album title
     * @param artist name of album artist
     * @param genre the music genre of the album
     * @param released the release date of the album
     *
     */
    public Album(String title, Artist artist, Genre genre, Date released) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.released = released;
        this.ratings = new Rating();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Date getReleased() {
        return released;
    }

    public void setReleased(Date released) {
        this.released = released;
    }

    public Rating getRatings() {
        return ratings;
    }

    public void setRatings(Rating ratings) {
        this.ratings = ratings;
    }

    /**
     * Adds a new rating to the FRONT of the ratings singly linked list
     * @param star A 1-5 star (*) rating for the album
     */
    public void rate(int star) {
        Rating newRating = new Rating(star);
        newRating.setNext(this.ratings);
        ratings = newRating;
    }

    /**
     * Calculates the average star ratings for an album
     * @return  A double (1-5) that represents the average rating. 0.0 otherwise
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
     * @param obj an object (likely an Album, will test for equality)
     * @return true if the names and artists for the two albums are equal. False otherwise
     */

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Album) {
            Album album = (Album) obj;
            return album.getTitle().equals(this.title) && album.getArtist().equals(this.artist);
        }
        return false;
    }

    /**
     * Converts all album information to a well formatted string.
     * @return A string containing Album name, release date, artist genre, average rating, and individual ratings
     */

    public String toString() {
        if (this.avgRatings() >= 1) {
            String stringRatings = "";
            Rating ptr = this.ratings;

            String formattedRating = String.format("%.2f", this.avgRatings());

            while (ptr != null) {
                stringRatings = "(" + Integer.toString(ptr.getStar()) + ")" + "*".repeat(ptr.getStar());
                ptr = ptr.getNext();
            }


            return "[" + this.getTitle() + "] " + "Released " + released.getMonth() + "/" + released.getDay()
                    + "/" + released.getYear() + " " + "[" + this.getArtist().toString()
                    + " " + "[" + this.genre + "] " + "Rating: *" + stringRatings + "(" + "average rating: "
                    + formattedRating + ")";
        }
        return "[" + this.getTitle() + "] " + "Released " + released.getMonth() + "/" + released.getDay()
                + "/" + released.getYear() + " " + "[" + this.getArtist().toString()
                + " " + "[" + this.genre + "] " + "Rating: none";

    }

}

