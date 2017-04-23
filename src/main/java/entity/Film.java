package entity;

import java.util.List;

/**
 * Created by Lytki on 22.03.2017.
 */
public class Film extends Entity{
    private String title;
    private int releaseDate;
    private int raiting;
    private String description;
    private String trailerUrl;
    private List<Genre> genres;
    private List<People> actors;
    private List<People> producers;
    private List<Country> countries;

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getRaiting() {
        return raiting;
    }

    public void setRaiting(int raiting) {
        this.raiting = raiting;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTrailerUrl() {
        return trailerUrl;
    }

    public void setTrailerUrl(String trailerUrl) {
        this.trailerUrl = trailerUrl;
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

    @Override
    public String toString() {
        return "Film{" +
                "title='" + title + '\'' +
                ", releaseDate=" + releaseDate +
                ", raiting=" + raiting +
                ", description='" + description + '\'' +
                ", trailerUrl='" + trailerUrl + '\'' +
                ", genres=" + genres +
                ", actors=" + actors +
                ", producers=" + producers +
                ", countries=" + countries +
                '}';
    }
}
