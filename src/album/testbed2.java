package album;
import java.util.Arrays;
public class testbed2 {

    public static void main(String[] args){
        Date date1 = new Date(2018, 5, 20);
        Date date2 = new Date(2019, 11, 10);
        Date date3 = new Date(2017, 3, 15);
        Date date4 = new Date(2016, 8, 4);
        Date date5 = new Date(2015, 2, 28);

        Date release1 = new Date(2010,10,12);        Date release2 = new Date(2010, 10, 12);        Date release3 = new Date(2010, 10, 12);
        Date release4 = new Date(2014, 8, 20);
        Date release5 = new Date(2018, 1, 1);


        Artist artist1 = new Artist("Kanye West", date1);
        Artist artist2 = new Artist("Beyoncé", date2);
        Artist artist3 = new Artist("Taylor Swift", date3);
        Artist artist4 = new Artist("Ed Sheeran", date4);
        Artist artist5 = new Artist("Adele", date5);
        Artist artist6 = new Artist("Adele", date5);


        Album album1 = new Album("Graduation", artist1, Genre.unknown, release1);
        Album album2 = new Album("Lemonade", artist2, Genre.pop, release2);
        Album album3 = new Album("Fearless", artist3, Genre.country, release3);
        Album album4 = new Album("÷ (Divide)", artist4, Genre.pop, release4);
        Album album5 = new Album("25", artist5, Genre.pop, release5);

        Album test1 = new Album("Graduation", artist1, Genre.unknown, release1);
        Album test2 = new Album("Graduation", artist1, Genre.unknown, release1);


        album1.rate(5);
        album1.rate(4);
        album1.rate(5);

        album2.rate(4); 
        album2.rate(5);
        album2.rate(5);

        album3.rate(5);
        album3.rate(5);
        album3.rate(4);

        album4.rate(4);
        album4.rate(4);
        album4.rate(3);

        album5.rate(5);
        album5.rate(4);
        album5.rate(5);

        Album[] albums = new Album[4];

        Collection collection = new Collection();
        collection.add(album1);
        collection.add(album2);
        collection.add(album3);

        if(collection.contains(album3)){
            System.out.println("already here");

        }else{
            collection.add(album3);
            System.out.println("added");
        }


        collection.printByRating();

    }
}
