package album;
/**
 * Class contains a genre enum that lists different genres
 *
 * @author George Nakhla
 */
enum Genre {
        Classical, Country, Jazz, Pop,  Unknown;

        public static Genre mapToKnownGenre(String genre) {
                if (genre == null || genre.isEmpty()) {
                        return Unknown;
                }

                // Capitalize the first letter of the genre string
                String capitalizedGenre = genre.substring(0, 1).toUpperCase() + genre.substring(1).toLowerCase();

                try {
                        return Genre.valueOf(capitalizedGenre);
                } catch (IllegalArgumentException e) {
                        return Unknown;
                }
        }
}


