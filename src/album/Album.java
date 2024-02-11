package album;

public class Album {
    private String title;
    private Artist artist;
    private Genre genre;
    private Date released;
    private Rating ratings; //head for a linked list of ratings

    public Album(){

    }

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

    //add a rating to the linked list
    public void rate(int star) {
        // Create a new Rating instance
        Rating newRating = new Rating(star);
        // Set the next rating to the current head of ratings
        newRating.setNext(this.ratings);
        // Update the head of ratings to the newly added rating
        ratings = newRating;
    }

    public double avgRatings() {

        if(ratings == null){
            return 0.0;
        }

        int totalStars = 0;
        int numRatings = 0;
        Rating currRating = this.ratings;

        while(currRating != null){
            numRatings++;
            totalStars += currRating.getStar();
            currRating = currRating.getNext();
        }
        return (double) totalStars/numRatings;


    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Album) {
            Album album = (Album) obj;
            return artist.getName().equals(this.title); // Remember that it needs to be all lowercase
            // we can do this through Scanner method.
        }
        return false;
    }
    public String toString() {
        return "[" + this.getTitle() + "]" + " Released " + released.getMonth() + "/" + released.getDay() + "/" + released.getYear()
                + "[" + artist.toString(artist) + "]" + " " + "[" + this.genre + "]" + " ";


        }

    }

