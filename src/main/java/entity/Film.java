package entity;

/**
 * Created by Lytki on 22.03.2017.
 */
public class Film {
    private String title;
    private int rate;

    public Film(String title, int rate) {
        this.title = title;
        this.rate = rate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
