package album;
/**
 * Class contains a Rating, which is represented via a Node for a singly linked list
 *
 * @author Mena Youssef
 */

public class Rating {
    private int star;
    private Rating next;

    public Rating() {

    }
    /**
     * @param star a 1-5 star rating for an album
     */
    public Rating(int star) {
        this.star = star;
    }
    /**
     * @param star a 1-5 star rating for an album
     * @param next a representation of the next node in the singly linked list
     */
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

