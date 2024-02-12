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

    public CollectionManager() {
        this.scanner = new Scanner(System.in);
        this.collection = new Collection();
        System.out.println("Collection Manager is up running.");
    }

    public void run() {
        while (true) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            } else if (line.equals("Q")) {
                System.out.println("Collection Manager terminated.");
                scanner.close();
                return; // Exit the method and terminate the program
            } else {
                StringTokenizer tokens = new StringTokenizer(line, ",");
                processCommand(tokens);
            }
        }
    }


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


        if (this.collection.contains(album)) {
            System.out.println(albumName + "(" + name + ": " + born.toString(born) + ") is already in the collection");
        } else {
            this.collection.add(album);
            System.out.println(albumName + "(" + name + ": " + born.toString(born) + ") added to the collection.");
        }


    }


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
        Album album = new Album(albumName, artist, Genre.unknown, born); // genre and release date are irrelevant

        if (!this.collection.contains(album)) {
            System.out.println(albumName + "(" + name + born.toString(born) + ") is not in the collection");
        } else {
            this.collection.remove(album);
            System.out.println(albumName + "(" + name + born.toString(born) + ") removed from the collection.");
        }

        for(int i =0; i < this.collection.getAlbums().length; i++){
            System.out.println(collection.getAlbums()[i]);
        }
        System.out.println(collection.contains(album));
    }


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
        Album album = new Album(albumName, artist, Genre.unknown, born); // genre and release date are irrelevant

        if (rating < 1 || rating > 5) {
            System.out.println("Invalid rating, rating scale is 1 to 5.");
        } else if (!this.collection.contains(album)) {
            System.out.println(albumName + "(" + name + born.toString(born) + ") is not in the collection");
        } else {
            this.collection.rate(album, rating);
            System.out.println("You rate " + rating + " for " + albumName + "(" + name + born.toString(born) + ")");
        }



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
            case "PD": //sort by release date
                if (this.collection.getSize() == 0) {
                    System.out.println("Collection is empty!");
                } else {
                    System.out.println("* Collection sorted by Released Date/Title *");
                    this.collection.printByDate();
                    System.out.println("* end of list *");
                }
                break;
            case "PG": //sort by genre
                if (this.collection.getSize() == 0) {
                    System.out.println("Collection is empty!");
                } else {
                    System.out.println("* Collection sorted by Genre/Artist *");
                    this.collection.printByGenre();
                    System.out.println("* end of list *");
                }
                break;
            case "PR": // sort by avg ratings
                if (this.collection.getSize() == 0) {
                    System.out.println("Collection is empty!");
                } else {
                    if (this.collection.getSize() == 0) {
                        System.out.println("Collection is empty!");
                    } else {
                        System.out.println("* Collection sorted by Rating/Title *");
                        this.collection.printByDate();
                        System.out.println("* end of list *");
                    }
                }
                break;
            case "test":
                for(int i =0; i < this.collection.getAlbums().length; i++){
                    System.out.println(collection.getAlbums()[i]);
                }
                break;
            default:
                System.out.println("Invalid Command!");
        }
    }
}
