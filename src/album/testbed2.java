package album;

public class testbed2 {
    private static Collection collection;

    public static void main(String[] args){
        Date date1 = new Date(2000,10,12);
        Date release1 = new Date(2010,10,12);
        Date release2 = new Date(2011,10,12);
        Date date2 = new Date(2005,10,12);
        Artist artist1 = new Artist("Kanye West", date1);
        Artist artist2 = new Artist("Kanye West", date2);


        Album album1 = new Album("Graduation", artist1, Genre.Unknown, release1);
        Album album2 = new Album("Failure", artist2, Genre.Jazz, release2);
        Album album3 = new Album("guac", artist1, Genre.Jazz, release2);
        Album album4 = new Album("queso", artist1, Genre.Jazz, release2);
        Album album5 = new Album("potato", artist2, Genre.Pop, release2);

        album1.rate(5);
        album1.rate(1);
        album1.rate(2);
        album1.rate(2);

        Album[] albums = new Album[4];

        Collection collection = new Collection(albums, 0);
        collection.add(album1);
        collection.add(album2);
        collection.add(album3);
        collection.add(album4);
        collection.add(album5);

        System.out.println(collection.getAlbums().length);



    }
}
