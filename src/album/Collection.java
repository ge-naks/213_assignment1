package album;

/**
 * This is an array-based implementation of a linear data structure to hold the list of albums. A new album
 * is always added to the end of the array. An instance of this class is a growable list with an initial array
 * capacity of 4, and it automatically increases the capacity by 4 whenever it is full. The list does not decrease
 * in capacity.
 *
 * @author George Nakhla
 */
public class Collection {
    private Album[] albums; // list of albums
    private int size;       // numbers of albums in the list
    private final int NOT_FOUND = -1;
    private final int INITIAL_CAPACITY = 4;
    private final int CAPACITY_INCREMENT = 4;

    public Collection() {
        this.albums = new Album[INITIAL_CAPACITY];
        this.size = 0;
    }


    public Album[] getAlbums() {
        return albums;
    }

    public void setAlbums(Album[] albums) {
        this.albums = albums;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Locates album in collection and returns its index in the array.
     *
     * @param album the target album to search for
     * @return the index of the target album in the array
     */
    private int find(Album album) {
        Album[] temp = this.getAlbums();
        for(int i = 0; i < temp.length; i++){
            if(temp[i] == null) continue;
            if(album.equals(temp[i])){
                return i;
            }
        }
        return NOT_FOUND;
    }

    /**
     * Increases the size of the collection by 4 once the array reaches max capacity.
     */
    private void grow() {
        Album[] temp = new Album[this.size + CAPACITY_INCREMENT];

        for (int i = 0; i < this.size; i++) {
            temp[i] = this.albums[i];
        }

        this.albums = temp;

    }

    /**
     * Determines whether the album is in the Collection.
     *
     * @param album the target album to search for
     * @return true if the album is in the array, false otherwise
     */
    public boolean contains(Album album) {
        return NOT_FOUND != find(album);
    }

    /**
     * Adds an album to the Collection. Increases Collection size if it's at capacity
     *
     * @param album the album to add
     * @return true if the album is already in the array, false on successful removal
     */
    public boolean add(Album album) {
        if(find(album) == NOT_FOUND){
            if(this.size - 1 == this.albums.length ){
                this.grow();
            }
            this.albums[size] = album;
            size++;
            return true;
        }
        return false;
    }

    /**
     * Removes an album to the Collection.
     *
     * @param album the album to remove
     * @return false if the album is already in the array, true on successful removal
     */
    public boolean remove(Album album) {
        if (find(album) == NOT_FOUND) {
            return false;
        }
        int indexToRemove = this.find(album);
        this.albums[indexToRemove] = null;

        for (int i = indexToRemove; i < this.size - 1; i++) {
            this.albums[i] = this.albums[i + 1];
        }
        this.size--;
        return true;
    }

    /**
     * Adds a review to an album in the Collection.
     *
     * @param album  the target album to add a review to.
     * @param rating rating to be given to the target album
     */
    public void rate(Album album, int rating) {
        int targetAlbumIndex = find(album);
        this.albums[targetAlbumIndex].rate(rating);
    }

    /**
     * Prints the albums by date, then title
     */
    public void printByDate() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                // Compare release dates
                if (albums[j].getReleased().compareTo(albums[j + 1].getReleased()) > 0) {
                    // Swap albums
                    Album temp = albums[j];
                    albums[j] = albums[j + 1];
                    albums[j + 1] = temp;
                } else if (albums[j].getReleased().equals(albums[j + 1].getReleased())) {
                    // If release dates are equal, compare titles
                    if (albums[j].getTitle().compareTo(albums[j + 1].getTitle()) > 0) {
                        // Swap albums
                        Album temp = albums[j];
                        albums[j] = albums[j + 1];
                        albums[j + 1] = temp;
                    }
                }
            }
        }
        // Print the sorted albums
        for (int i = 0; i < size; i++) {
            System.out.println(albums[i]);
        }
    }

    /**
     * Prints the genre by date, then artist
     */
    public void printByGenre() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                // Compare genres using enum values
                if (albums[j].getGenre().compareTo(albums[j + 1].getGenre()) > 0) {
                    // Swap albums
                    Album temp = albums[j];
                    albums[j] = albums[j + 1];
                    albums[j + 1] = temp;
                } else if (albums[j].getGenre().equals(albums[j + 1].getGenre())) {
                    // If genres are equal, compare artists
                    if (albums[j].getArtist().compareTo(albums[j + 1].getArtist()) > 0) {
                        // Swap albums
                        Album temp = albums[j];
                        albums[j] = albums[j + 1];
                        albums[j + 1] = temp;
                    }
                }
            }
        }
        // Print the sorted albums
        for (int i = 0; i < size; i++) {
            System.out.println(albums[i]);
        }
    }

    /**
     * Prints the albums by average rating, then title
     */
    public void printByRating() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                // Calculate average ratings
                double rating1 = albums[j].avgRatings();
                double rating2 = albums[j + 1].avgRatings();
                // Compare ratings
                if (rating1 < rating2) {
                    // Swap albums
                    Album temp = albums[j];
                    albums[j] = albums[j + 1];
                    albums[j + 1] = temp;
                } else if (rating1 == rating2) {
                    // If ratings are equal, compare titles
                    if (albums[j].getTitle().compareTo(albums[j + 1].getTitle()) > 0) {
                        // Swap albums
                        Album temp = albums[j];
                        albums[j] = albums[j + 1];
                        albums[j + 1] = temp;
                    }
                }
            }
        }
        // Print the sorted albums
        for (int i = 0; i < size; i++) {
            System.out.println(albums[i]);
        }
    }

}
