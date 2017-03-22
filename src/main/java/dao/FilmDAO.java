package dao;

import entity.Film;

/**
 * Created by Lytki on 22.03.2017.
 */
public class FilmDAO {
    private Film film;

    public FilmDAO() {
        this.film = new Film("УПЯЧКА",34);
    }

    public Film getFilm() {
        return film;
    }
}
