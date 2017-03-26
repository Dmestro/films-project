package dao.generic;

/**
 * Created by Lytki on 26.03.2017.
 */
public class DAOConstants {
    //db connection
    public static final String DB_URL="jdbc:postgresql://localhost:5432/films";
    public static final String DB_USER="postgres";
    public static final String DB_PASS="";
    //db common
    public static final String ID="id";
    public static final String FILM_ID = "film_id";
    //film
    public static final String TABLE_FILM="film";
    public static final String FILM_TITLE="title";
    public static final String FILM_RELEASE_DATE="release_date";
    public static final String FILM_RAITING="raiting";
    public static final String FILM_POSTER="poster";
    public static final String FILM_DESCRIPTION="description";
    public static final String FILM_TRAILER_URL="trailer_url";
    //country
    public static final String TABLE_COUNTRY="country";
    public static final String COUNTRY_NAME="country_name";
    //genre
    public static final String TABLE_GENRE="genre";
    public static final String GENRE_NAME="name";
    //pepole
    public static final String TABLE_PEOPLE="people";
    public static final String PEOPLE_FIRSTNAME="first_name";
    public static final String PEOPLE_LASTNAME="last_name";
    //film_country
    public static final String TABLE_FILM_COUNTRY="film_country";
    public static final String COUNTRY_ID = "country_id";
    //film_genre
    public static final String TABLE_FILM_GENRE ="film_genre";
    public static final String GENRE_ID="genre_id";
    //film_people
    public static final String TABLE_FILM_PEOLE="film_people";
    public static final String  PEOPLE_ID="people_id";
    public static final String PEOPLE_POSITION="people_position";







}
