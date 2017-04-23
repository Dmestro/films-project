import com.google.gson.Gson;
import dao.CountryDAO;
import dao.FilmDAO;
import dao.GenreDAO;
import dao.PeopleDAO;
import entity.Country;
import entity.Film;
import entity.Genre;
import entity.People;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Lytki on 26.03.2017.
 */
public class Test {
    public static void main(String[] args) {
//        People people = new People();
//        CountryDAO countryDAO = new CountryDAO();
//        countryDAO.create(new Country("Россия"));
//        countryDAO.create(new Country("Англия"));
//        countryDAO.create(new Country("Франция"));
//        List<Country> countries = countryDAO.getAll();
//        Map<String,List<Country>> c = new HashMap<>();
//        c.put("countries", countries);
//        Gson gson = new Gson();
//        String json = gson.toJson(c);
//        System.out.println(json);
//        PeopleDAO peopleDAO = new PeopleDAO();
//        people.setFirstName("Михаил");
//        people.setLastName("Богомолов");
//        peopleDAO.create(people);
//            GenreDAO genreDAO = new GenreDAO();
//        Genre genre = new Genre();
//        genre.setName("Боевик");
//        genreDAO.create(genre);

        Film film = new Film();
        film.setRaiting(5);
        film.setReleaseDate(2017);
        film.setTitle("Test Title");
        film.setTrailerUrl("test url");
        film.setDescription("Test description");
        FilmDAO filmDAO = new FilmDAO();
//        Film film1 = (Film) filmDAO.create(film);
//        System.out.println(film1);
//        filmDAO.insertCountriesById(film1.getId(),new int[]{52,53,54});
//        filmDAO.insertPeoplesById(film1.getId(),new int[]{66,67,68}, FilmDAO.ACTOR_ALIAS);
//        filmDAO.insertPeoplesById(film1.getId(),new int[]{71,72}, FilmDAO.PRODUCER_ALIAS);
//        filmDAO.insertGenresById(film1.getId(),new int[]{46,47,48});
//        filmDAO.deleteCountriesById(81);
//        filmDAO.deleteGenresById(81);
//        filmDAO.deletePeoplesById(81);
//        filmDAO.delete(82);
        Film f= (Film) filmDAO.read(87);
        Gson gson = new Gson();
        System.out.println(gson.toJson(f));
//        System.out.println(f);
    }

}
