package dao;

import dao.generic.DAOConstants;
import dao.generic.IGenericDAO;
import entity.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lytki on 22.03.2017.
 */
public class FilmDAO implements IGenericDAO {
    public static final String ACTOR_ALIAS = "ACTOR";
    public static final String PRODUCER_ALIAS = "PRODUCER";


    public Entity create(Entity entity) {
        Connection connection = null;
        PreparedStatement preparedStatement =null;
        try {
            Film film= (Film) entity;
            connection = this.getConnection();
            StringBuilder StatementBuilder = new StringBuilder();
            StatementBuilder.append("INSERT INTO ")
                    .append(DAOConstants.TABLE_FILM)
                    .append(" (")
                    .append(DAOConstants.FILM_TITLE+",")
                    .append(DAOConstants.FILM_RELEASE_DATE+",")
                    .append(DAOConstants.FILM_RAITING+",")
                    .append(DAOConstants.FILM_DESCRIPTION+",")
                    .append(DAOConstants.FILM_TRAILER_URL)
                    .append(") ")
                    .append("VALUES")
                    .append("(?,?,?,?,?)");
            preparedStatement = connection.prepareStatement(StatementBuilder.toString(), Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,film.getTitle());
            preparedStatement.setInt(2,film.getReleaseDate());
            preparedStatement.setInt(3,film.getRaiting());
            preparedStatement.setString(4,film.getDescription());
            preparedStatement.setString(5,film.getTrailerUrl());
            int rows=preparedStatement.executeUpdate();
            if(rows!=0){
                preparedStatement.getGeneratedKeys().next();
                film.setId(preparedStatement.getGeneratedKeys().getInt(1));
            }


            return film;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    public Entity read(int entityId) {
        Connection connection = null;
        PreparedStatement preparedStatement =null;
        GenreDAO genreDAO = new GenreDAO();
        CountryDAO countryDAO = new CountryDAO();
        PeopleDAO peopleDAO = new PeopleDAO();
        List<Genre> genres = new ArrayList<>();
        List<People> actors = new ArrayList<>();
        List<People> producers = new ArrayList<>();
        List<Country> countries = new ArrayList<>();

        Film film = new Film();
        try {
            connection = this.getConnection();
            StringBuilder StatementBuilder = new StringBuilder();
            StatementBuilder.append("SELECT * FROM ")
                    .append(DAOConstants.TABLE_FILM)
                    .append(" WHERE "+DAOConstants.ID)
                    .append("=(?)");
            preparedStatement = connection.prepareStatement(StatementBuilder.toString());
            preparedStatement.setInt(1, entityId);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                film.setId(resultSet.getInt(1));
                film.setTitle(resultSet.getString(2));
                film.setRaiting(resultSet.getInt(3));
                film.setDescription(resultSet.getString(4));
                film.setTrailerUrl(resultSet.getString(5));
                film.setReleaseDate(resultSet.getInt(6));
            }

            List<Integer> countriesIds = getChildIDs(film.getId(),DAOConstants.TABLE_FILM_COUNTRY,null);
            List<Integer> genresIds = getChildIDs(film.getId(),DAOConstants.TABLE_FILM_GENRE,null);
            List<Integer> actorsIds = getChildIDs(film.getId(),DAOConstants.TABLE_FILM_PEOLE, ACTOR_ALIAS);
            List<Integer> producersIds = getChildIDs(film.getId(),DAOConstants.TABLE_FILM_PEOLE, PRODUCER_ALIAS);

            for(int id:countriesIds){
                Country country = (Country) countryDAO.read(id);
                countries.add(country);
            }
            film.setCountries(countries);
            for(int id:genresIds){
                Genre genre = (Genre) genreDAO.read(id);
                genres.add(genre);
            }
            film.setGenres(genres);

            for(int id: actorsIds){
                People people = (People) peopleDAO.read(id);
                actors.add(people);
            }
            film.setActors(actors);

            for(int id: producersIds){
                People people = (People) peopleDAO.read(id);
                producers.add(people);
            }
            film.setProducers(producers);

        return film;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    public void update(Entity entity) {
        Connection connection = null;
        PreparedStatement preparedStatement =null;
        try {
            Film film= (Film) entity;
            connection = this.getConnection();
            StringBuilder StatementBuilder = new StringBuilder();
            StatementBuilder.append("UPDATE ")
                    .append(DAOConstants.TABLE_FILM)
                    .append(" SET ")
                    .append(DAOConstants.FILM_TITLE+"=?, ")
                    .append(DAOConstants.FILM_RELEASE_DATE+"=?, ")
                    .append(DAOConstants.FILM_RAITING+"=?, ")
                    .append(DAOConstants.FILM_DESCRIPTION+"=?, ")
                    .append(DAOConstants.FILM_TRAILER_URL)
                    .append("=? WHERE id=?");
            preparedStatement = connection.prepareStatement(StatementBuilder.toString());
            preparedStatement.setString(1,film.getTitle());
            preparedStatement.setInt(2,film.getReleaseDate());
            preparedStatement.setInt(3,film.getRaiting());
            preparedStatement.setString(4,film.getDescription());
            preparedStatement.setString(5,film.getTrailerUrl());
            preparedStatement.setInt(6,film.getId());
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    public void delete(int entityId) {
        Connection connection = null;
        PreparedStatement preparedStatement =null;
        try {
            deletePeoplesById(entityId, FilmDAO.ACTOR_ALIAS);
            deletePeoplesById(entityId, FilmDAO.PRODUCER_ALIAS);
            deleteGenresById(entityId);
            deleteCountriesById(entityId);
            connection = this.getConnection();
            StringBuilder StatementBuilder = new StringBuilder();
            StatementBuilder.append("DELETE FROM ")
                    .append(DAOConstants.TABLE_FILM)
                    .append(" WHERE "+DAOConstants.ID)
                    .append("=(?)");
            preparedStatement = connection.prepareStatement(StatementBuilder.toString());
            preparedStatement.setInt(1,entityId);
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    public void insertPeoplesById(int filmId,int[]ids, String status){
        Connection connection = null;
        PreparedStatement preparedStatement =null;
        try {
            connection = this.getConnection();
            StringBuilder StatementBuilder = new StringBuilder();
            StatementBuilder.append("INSERT INTO ")
                    .append(DAOConstants.TABLE_FILM_PEOLE)
                    .append(" (")
                    .append(DAOConstants.FILM_ID+","+DAOConstants.PEOPLE_ID+","+DAOConstants.PEOPLE_POSITION)
                    .append(") ")
                    .append("VALUES")
                    .append("(?,?,?)");
            preparedStatement = connection.prepareStatement(StatementBuilder.toString());
            for(int id:ids){
                preparedStatement.setInt(1,filmId);
                preparedStatement.setInt(2,id);
                preparedStatement.setString(3,status);
                preparedStatement.execute();
            }




        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    public void deletePeoplesById(int filmId,String position){
        Connection connection = null;
        PreparedStatement preparedStatement =null;
        try {
            connection = this.getConnection();
            StringBuilder StatementBuilder = new StringBuilder();
            StatementBuilder.append("DELETE FROM ")
                    .append(DAOConstants.TABLE_FILM_PEOLE)
                    .append(" WHERE ")
                    .append(DAOConstants.FILM_ID+"=(?) and"+DAOConstants.PEOPLE_POSITION+"=(?)");
            preparedStatement = connection.prepareStatement(StatementBuilder.toString());
           preparedStatement.setInt(1,filmId);
           preparedStatement.setString(2,position);
            preparedStatement.execute();



        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    private List<Integer> getChildIDs(int filmId, String tableName, String status){
        Connection connection = null;
        PreparedStatement preparedStatement =null;
        List<Integer> ids=new ArrayList<Integer>();
        try {
            connection = this.getConnection();
            StringBuilder statementBuilder = new StringBuilder();
            statementBuilder.append("SELECT * FROM ")
                    .append(tableName)
                    .append(" WHERE "+DAOConstants.FILM_ID)
                    .append("=(?)");
            if(tableName==DAOConstants.TABLE_FILM_PEOLE&&status!=null){
                statementBuilder.append("and "+DAOConstants.PEOPLE_POSITION+"=(?)");
            }
            preparedStatement = connection.prepareStatement(statementBuilder.toString());
            preparedStatement.setInt(1,filmId);
            if(tableName==DAOConstants.TABLE_FILM_PEOLE&&status!=null){
                preparedStatement.setString(2,status);
            }

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                ids.add(resultSet.getInt(2));
            }

        return ids;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    public void insertGenresById(int filmId,int[]ids){
        Connection connection = null;
        PreparedStatement preparedStatement =null;
        try {
            connection = this.getConnection();
            StringBuilder StatementBuilder = new StringBuilder();
            StatementBuilder.append("INSERT INTO ")
                    .append(DAOConstants.TABLE_FILM_GENRE)
                    .append(" (")
                    .append(DAOConstants.FILM_ID+","+DAOConstants.GENRE_ID)
                    .append(") ")
                    .append("VALUES")
                    .append("(?,?)");
            preparedStatement = connection.prepareStatement(StatementBuilder.toString());
            for(int id:ids){
                preparedStatement.setInt(1,filmId);
                preparedStatement.setInt(2,id);
                preparedStatement.execute();
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    public void deleteGenresById(int filmId){
        Connection connection = null;
        PreparedStatement preparedStatement =null;
        try {
            connection = this.getConnection();
            StringBuilder StatementBuilder = new StringBuilder();
            StatementBuilder.append("DELETE FROM ")
                    .append(DAOConstants.TABLE_FILM_GENRE)
                    .append(" WHERE ")
                    .append(DAOConstants.FILM_ID+"=(?)");
            preparedStatement = connection.prepareStatement(StatementBuilder.toString());
            preparedStatement.setInt(1,filmId);
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }



    public void insertCountriesById(int filmId,int[]ids){
        Connection connection = null;
        PreparedStatement preparedStatement =null;
        try {
            connection = this.getConnection();
            StringBuilder StatementBuilder = new StringBuilder();
            StatementBuilder.append("INSERT INTO ")
                    .append(DAOConstants.TABLE_FILM_COUNTRY)
                    .append(" (")
                    .append(DAOConstants.FILM_ID+","+DAOConstants.COUNTRY_ID)
                    .append(") ")
                    .append("VALUES")
                    .append("(?,?)");
            preparedStatement = connection.prepareStatement(StatementBuilder.toString());
            for(int id:ids){
                preparedStatement.setInt(1,filmId);
                preparedStatement.setInt(2,id);
                preparedStatement.execute();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    public void deleteCountriesById(int filmId){
        Connection connection = null;
        PreparedStatement preparedStatement =null;
        try {
            connection = this.getConnection();
            StringBuilder StatementBuilder = new StringBuilder();
            StatementBuilder.append("DELETE FROM ")
                    .append(DAOConstants.TABLE_FILM_COUNTRY)
                    .append(" WHERE ")
                    .append(DAOConstants.FILM_ID+"=(?)");
            preparedStatement = connection.prepareStatement(StatementBuilder.toString());
            preparedStatement.setInt(1,filmId);
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    public List<Film> getAllFilms(){
        Connection connection = null;
        PreparedStatement preparedStatement =null;
        List<Film> films = new ArrayList<>();
        try {
            connection = this.getConnection();
            StringBuilder StatementBuilder = new StringBuilder();
            StatementBuilder.append("Select id FROM ")
                    .append(DAOConstants.TABLE_FILM);
            preparedStatement = connection.prepareStatement(StatementBuilder.toString());
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt(1);
                Film film = (Film) this.read(id);
                films.add(film);
            }
            return films;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return null;

    }

}
