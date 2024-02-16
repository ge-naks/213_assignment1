package album;

import java.util.StringTokenizer;
import java.util.Scanner;

/**
 * This class handles user interaction by reading and processing command lines from the terminal.
 * It should contain methods to process each command, manage the collection of albums, and display
 * results.
 *
 * @author George Nakhla
 */
public class CollectionManager {
    Scanner scanner;
    Collection collection;


    /**
     * Constructor for the CollectionManager class.
     * Initializes the scanner and the collection.
     */
    public CollectionManager() {
        this.scanner = new Scanner(System.in);
        this.collection = new Collection();
        System.out.println("Collection Manager is up running.");
    }

    /**
     * Method to start running the collection manager.
     * Reads user input and processes commands until termination.
     */
    public void run() {
        while (true) {
            String line = scanner.nextLine().trim(); // Trim to remove leading/trailing whitespace
            if (line.equals("Q")) {
                System.out.println("Collection Manager terminated.");
                scanner.close();
                return; // Exit the method and terminate the program
            } else if (!line.isEmpty()) {
                StringTokenizer tokens = new StringTokenizer(line, ",");
                processCommand(tokens);
            }
        }
    }


    /**
     * Checks if an album with a specific name, artist name, and date of birth already exists in the collection.
     *
     * @param albumName The name of the album to check.
     * @param name      The name of the artist to check.
     * @param DOB       The date of birth of the artist to check.
     * @return true if the album exists, false otherwise.
     */
    private boolean check(String albumName, String name, String DOB){
        for(int i = 0; i < collection.getSize(); i++){
            Album album = collection.getAlbums()[i];
            if(album != null) {
                Artist artist = album.getArtist();
                if (artist != null) {
                    Date tempDate = artist.getBorn();
                    String tempDateStr = tempDate.toString(tempDate);
                    if (album.getTitle().equalsIgnoreCase(albumName) &&
                            artist.getName().equalsIgnoreCase(name) &&
                            tempDateStr.equals(DOB)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }



    /**
     * Processes the 'A' command which adds a new album to the collection.
     * Parses the input tokens to create an Album object and adds it to the collection if it's not a duplicate.
     * Prints appropriate messages for invalid input or duplicate albums.
     *
     * @param tokens A StringTokenizer containing the command parameters: albumName, name, DOB, genre, release.
     */
    private void commandA(StringTokenizer tokens) {
        String albumName = tokens.nextToken();
        String name = tokens.nextToken();
        String DOB = tokens.nextToken();
        Genre genre = Genre.mapToKnownGenre(tokens.nextToken());
        String release = tokens.nextToken();

        StringTokenizer bornTokens = new StringTokenizer(DOB, "/");
        int month = Integer.parseInt(bornTokens.nextToken());
        int day = Integer.parseInt(bornTokens.nextToken());
        int year = Integer.parseInt(bornTokens.nextToken());

        Date born = new Date(year, month, day);

        StringTokenizer releaseTokens = new StringTokenizer(release, "/");
        int releaseMonth = Integer.parseInt(releaseTokens.nextToken());
        int releaseDay = Integer.parseInt(releaseTokens.nextToken());
        int releaseYear = Integer.parseInt(releaseTokens.nextToken());

        Date releaseDate = new Date(releaseYear, releaseMonth, releaseDay);

        Artist artist = new Artist(name, born);
        Album album = new Album(albumName, artist, genre, releaseDate);


        if (!born.isValid(born)) {
            System.out.println("Artist DOB: " + born.toString(born) + " is invalid.");
        } else if (!releaseDate.isValid(releaseDate)) {
            System.out.println("Date Released: " + releaseDate.toString(releaseDate) + " is invalid.");
        } else if (check(albumName, name, DOB)) {
            System.out.println(albumName + "(" + name + ":" + born.toString(born) + ") is already in the collection.");
        } else {
            collection.add(album);
            System.out.println(albumName + "(" + name + ":" + born.toString(born) + ") added to the collection.");
        }
    }

    /**
     * Processes the 'D' command which deletes an new album from the collection.
     * Parses the input tokens to create an Album object and adds it to the collection if it's not a duplicate.
     * Prints appropriate messages for invalid input or duplicate albums.
     *
     * @param tokens A StringTokenizer containing the command parameters: albumName, name, DOB, genre, release.
     */
    private void commandD(StringTokenizer tokens) {
        String albumName = tokens.nextToken();
        String name = tokens.nextToken();
        String DOB = tokens.nextToken();


        StringTokenizer bornTokens = new StringTokenizer(DOB, "/");
        int month = Integer.parseInt(bornTokens.nextToken());
        int day = Integer.parseInt(bornTokens.nextToken());
        int year = Integer.parseInt(bornTokens.nextToken());

        Date born = new Date(year, month, day);


        Artist artist = new Artist(name, born);
        Album album = new Album(albumName, artist, Genre.Unknown, born); // genre and release date are irrelevant

        if (!check(albumName, name, DOB)) {
            System.out.println(albumName + "(" + name + ":" + born.toString(born) + ") is not in the collection");
        } else {
            collection.checkRemove(album);
            System.out.println(albumName + "(" + name + ":" + born.toString(born) + ") removed from the collection.");
        }
    }




    /**
     * Processes the 'R' command which adds a new rating to an album in the collection.
     *
     * Prints appropriate messages for invalid inputs.
     *
     * @param tokens A StringTokenizer containing the command parameters: albumName, name, DOB, genre, release.
     */
    private void commandR(StringTokenizer tokens) {
        String albumName = tokens.nextToken();
        String name = tokens.nextToken();
        String DOB = tokens.nextToken();
        int rating = Integer.parseInt(tokens.nextToken());


        StringTokenizer bornTokens = new StringTokenizer(DOB, "/");
        int month = Integer.parseInt(bornTokens.nextToken());
        int day = Integer.parseInt(bornTokens.nextToken());
        int year = Integer.parseInt(bornTokens.nextToken());

        Date born = new Date(year, month, day);

        Artist artist = new Artist(name, born);
        Album album = new Album(albumName, artist, Genre.Unknown, born); // genre and release date are irrelevant

        if (rating < 1 || rating > 5) {
            System.out.println("Invalid rating, rating scale is 1 to 5.");
        } else if (!check(albumName, name, DOB)) {
            System.out.println(albumName + "(" + name + born.toString(born) + ") is not in the collection");
        } else {
            collection.rate(album, rating);
            int index = checkIndex(albumName, name, DOB);

            System.out.println("You rate " + rating + " for " + albumName + ":"  +
                    collection.getAlbums()[index].getReleased().toString(collection.getAlbums()[index].getReleased()) +
                    "("+ name + ")" );
        }
    }


    /**
     * Checks index for passed album info
     *
     * @param albumName name of target album
     * @param DOB birth of artist
     * @param name artist name
     */
    private int checkIndex(String albumName, String name, String DOB){
        int NOT_FOUND = -1;
        for(int i = 0; i < collection.getSize(); i++){
            Date tempDate = collection.getAlbums()[i].getArtist().getBorn();
            String tempDateStr = tempDate.toString(tempDate);
            if(collection.getAlbums()[i].getTitle().equalsIgnoreCase(albumName) &&
                    collection.getAlbums()[i].getArtist().getName().equalsIgnoreCase(name) &&
                    tempDateStr.equals(DOB)){
                return i;
            }
        }
        return NOT_FOUND;
    }



    /**
     * Searches for album in collection
     * @param album song album
     * @param albums array of albums
     */
    private boolean search(Album[] albums, Album album){
        for(int i = 0; i < albums.length; i++){
            if(albums[i] == null) continue;
            if(albums[i].equals(album)){
                return true;
            }
        }
        return false;
    }


    private void processCommand(StringTokenizer tokens) {
        String command = tokens.nextToken();

        switch (command) {
            case "A": // add
                commandA(tokens);
                break;
            case "D": // remove
                commandD(tokens);
                break;
            case "R":
                commandR(tokens);
                break;
            case "PD": //sort by release date
                if (collection.getSize() == 0) {
                    System.out.println("Collection is empty!");
                } else {
                    System.out.println("* Collection sorted by Released Date/Title *");
                    collection.printByDate();
                    System.out.println("* end of list *");
                }
                break;
            case "PG": //sort by genre
                if (collection.getSize() == 0) {
                    System.out.println("Collection is empty!");
                } else {
                    System.out.println("* Collection sorted by Genre/Artist *");
                    collection.printByGenre();
                    System.out.println("* end of list *");
                }
                break;
            case "PR": // sort by avg ratings
                if (collection.getSize() == 0) {
                    System.out.println("Collection is empty!");
                } else {
                    if (collection.getSize() == 0) {
                        System.out.println("Collection is empty!");
                    } else {
                        System.out.println("* Collection sorted by Rating/Title *");
                        collection.printByRating();
                        System.out.println("* end of list *");
                    }
                }
                break;
            case "test":
                for(int i =0; i < collection.getAlbums().length; i++){
                    System.out.println(collection.getAlbums()[i]);
                }
                break;
            case "eq":
                System.out.println(collection.getAlbums()[0].equals(collection.getAlbums()[1]));
                System.out.println(collection.getAlbums()[0].getTitle().equalsIgnoreCase(collection.getAlbums()[1].getTitle()));
                System.out.println(collection.getAlbums()[0].getArtist().getName().equalsIgnoreCase(collection.getAlbums()[1].getArtist().getName()));
                System.out.println(collection.getSize());
                break;
            default:
                System.out.println("Invalid command!");

        }
    }
}
