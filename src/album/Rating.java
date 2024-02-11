package album;
// implement the rate method ->
// add a rating to the linked list
// implement the avgRating method ->
// computes the average ratings.

public class Rating {
    private int star;
    private Rating next;

    public Rating() {

    }

    public Rating(int star) {
        this.star = star;
    }

    public Rating(int star, Rating next) {
        this.star = star;
        this.next = next;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public Rating getNext() {
        return next;
    }

    public void setNext(Rating next) {
        this.next = next;
    }
}

