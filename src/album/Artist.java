package album;

public class Artist {
    private String name;
    private Date born;

    public Artist(){

    }

    public Artist(String name, Date born) {
        this.name = name;
        this.born = born;
    }

    public String getName() {
        return name;
    }

    public Date getBorn() {
        return born;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBorn(Date born) {
        this.born = born;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Artist){
            Artist artist = (Artist) obj;
            return artist.name.equals(this.name);
        }
        return false;
    }

}
