package album;

import java.util.Date;
import java.util.StringTokenizer;

public class Album {
    private String title;
    private Artist artist;
    private Genre genre;
    private Date released;
    private Rating ratings; //a linked list of ratings

    public Album(){

    }
    public Album(String title, Artist artist, Genre genre, Date released) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.released = released;
        this.ratings = new Rating();
    }
    public void rate(int star) {  //add a rating to the linked list
        ratings.addRating(star);
    }

    public double avgRatings(int[] ratings) {
       // compute the average ratings
        return ratings.ratingAverage(); // implemented in Rating class
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Album album) {
            return artist.name.equals(album.title); // Remember that it needs to be all lowercase
            // we can do this through Scanner method.
        }
        return false;
    }
    public String toString() {

    }
}
