package album;

public class Album {
    private String title;
    private Artist artist;
    private Genre genre;
    private Date released;
    private Rating ratings; //a linked list of ratings

    public void rate(int star) { } //add a rating to the linked list
    if (ratings == null) {
        ratings = new Rating(star);
    } else {
        ratings.addRating(star);
    }
    public double avgRatings() { } //compute the average ratings
}
