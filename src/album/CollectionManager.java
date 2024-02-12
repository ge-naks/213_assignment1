package album;

import java.util.Scanner;

/*
 * This class handles user interaction by reading and processing command lines from the terminal.
 * It should contain methods to process each command, manage the collection of albums, and display
 * results.
 * @author George Nakhla
 * @ param collection the collection to be controlled by commands
 * This is the user interface class to process the command lines. An instance of this class can process a single
 * command line or multiple command lines at a time. You will lose 10 points if it cannot process multiple
 * command lines at a time.
 */
public class CollectionManager {
    public Collection albumcollection;
    public Scanner sc;

    }

    public void addAlbum(String[] albumTokens) { // starts at index 1
        String title = albumTokens[1];
        String artistName = albumTokens[2];
        String artistDOBstring = albumTokens[3];
        String genreString = albumTokens[4];
        String releaseDate = albumTokens[5];

        Genre genre = Genre.valueOf(genreString); // we convert the string into enum

        // formatting for artist's date of birth
        String[] tokenDOB = artistDOBstring.split("/");
        // date format mm/dd/yyyy
        int Dmonth = Integer.parseInt(tokenDOB[0]); // parsing string into int
        int Dday = Integer.parseInt(tokenDOB[1]);
        int Dyear = Integer.parseInt(tokenDOB[2]);
        Date artistDOB = new Date(Dmonth, Dday, Dyear);

        //formatting for release date
        String[] tokenReleaseDate = releaseDate.split("/");
        int Rmonth = Integer.parseInt(tokenReleaseDate[0]); // parsing string into int
        int Rday = Integer.parseInt(tokenReleaseDate[1]);
        int Ryear = Integer.parseInt(tokenReleaseDate[2]);
        Date artistReleaseDate = new Date(Rmonth, Rday, Ryear);

        // to create object for artist
        Artist artist = new Artist(artistName, artistDOB);
        // to create the album object to hold tokens
        Album album = new Album(title, artist, genre, artistReleaseDate);

        if (!artistDOB.isValid(artistDOB)) {
            System.out.println("Date of Birth is Invalid");
        }
        if (!artistReleaseDate.isValid(artistReleaseDate)) {
            System.out.println("Date of Release is Invalid");
        }
        if (albumcollection.contains(album)) {
            // contains method from Collection
            System.out.println("An album with the same title and artist is already in the collection");
        } else {
            albumcollection.add(album);
            // add method from Collection
            System.out.println("Album added");
            }
        }
    public void removeAlbum()

    public void processCommand(String command) {
        String[] albumTokens = command.split(",");
        // this is to separate all of our album tokens with commas
        String commands = albumTokens[0].toUpperCase();
        // index 0 -> command word is translated to uppercase
        // since commands are case-sensitive, they need to be uppercase to denote it being a command
        switch (commands) {
            case "A":
                addAlbum(albumTokens);
                break;
            case "D":
                removeAlbum(albumTokens);
                break;
            case "R":
                rateAlbum(albumTokens);
                break;
            case "PD":
                sortDates(albumTokens);
                break;
            case "PG":
                sortGenre(albumTokens);
                break;
            case "PR":
                sortRatings(albumTokens);
                break;
            case "Q":
                System.out.println("Collection Manager terminated.");
                break;
        }
    }

    public void run() {
        System.out.println("Collection Manager is up running.");

        while (true) {
            String command = sc.nextLine();
            if (command.equals("Q")) {
                break;
            }
            processCommand(command);
        }
    }
}
