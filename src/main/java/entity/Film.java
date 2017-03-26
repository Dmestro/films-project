package entity;

import java.util.Date;
import java.util.List;

/**
 * Created by Lytki on 22.03.2017.
 */
public class Film extends Entity{
    private String title;
    private Date releaseDate;
    private int raiting;
    private String poster;
    private String description;
    private String trailer_url;
    private List<Genre> genres;
    private List<People> actors;
    private List<People> producers;
    private List<People> scenarists;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getRaiting() {
        return raiting;
    }

    public void setRaiting(int raiting) {
        this.raiting = raiting;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTrailer_url() {
        return trailer_url;
    }

    public void setTrailer_url(String trailer_url) {
        this.trailer_url = trailer_url;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<People> getActors() {
        return actors;
    }

    public void setActors(List<People> actors) {
        this.actors = actors;
    }

    public List<People> getProducers() {
        return producers;
    }

    public void setProducers(List<People> producers) {
        this.producers = producers;
    }

    public List<People> getScenarists() {
        return scenarists;
    }

    public void setScenarists(List<People> scenarists) {
        this.scenarists = scenarists;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id='" + getId() + '\'' +
                "title='" + title + '\'' +
                ", releaseDate=" + releaseDate +
                ", raiting=" + raiting +
                ", poster='" + poster + '\'' +
                ", description='" + description + '\'' +
                ", trailer_url='" + trailer_url + '\'' +
                '}';
    }
}
