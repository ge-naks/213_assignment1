package album;


public class testbed2 {

    public static void main(String[] args) {
        Date date1 = new Date(2018, 5, 20);
        Date date2 = new Date(2019, 11, 10);
        Date date3 = new Date(2017, 3, 15);

        Date release1 = new Date(2010, 10, 12);
        Date release2 = new Date(2010, 10, 12);
        Date release3 = new Date(2010, 10, 12);


        Artist artist1 = new Artist("Kanye West", date1);
        Artist artist2 = new Artist("Beyoncé", date2);
        Artist artist3 = new Artist("Taylor Swift", date3);


        Album album1 = new Album("Graduation", artist1, Genre.Unknown, release1);
        Album album2 = new Album("Lemonade", artist2, Genre.Pop, release2);
        Album album3 = new Album("Fearless", artist3, Genre.Country, release3);
        Album album4 = new Album("Fearless", artist3, Genre.Country, release3);


        Collection collection = new Collection();
        collection.add(album1);
        collection.add(album2);
        collection.add(album3);

        if (collection.contains(album4)) {
            System.out.println("already here");
        } else {
            collection.add(album4);
            System.out.println("added");
        }

    }
}
