package album;
/**
 * Class contains a genre enum that lists different genres
 *
 * @author George Nakhla
 */
enum Genre {
        pop, country, classical, jazz, unknown;

        // Method to map unknown genres to the unknown category
        public static Genre mapToKnownGenre(String genre) {
                try {
                        return Genre.valueOf(genre.toLowerCase());
                } catch (IllegalArgumentException e) {
                        return unknown;
                }
        }
}


