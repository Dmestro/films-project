package dao;

import dao.generic.DAOConstants;
import dao.generic.IGenericDAO;
import entity.Country;
import entity.Entity;
import entity.Genre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lytki on 26.03.2017.
 */
public class GenreDAO implements IGenericDAO {
    @Override
    public Entity create(Entity entity) {
        Connection connection = null;
        PreparedStatement preparedStatement =null;
        try {
            Genre genre = (Genre) entity;
            connection = this.getConnection();
            StringBuilder StatementBuilder = new StringBuilder();
            StatementBuilder.append("INSERT INTO ")
                    .append(DAOConstants.TABLE_GENRE)
                    .append(" (")
                    .append(DAOConstants.GENRE_NAME)
                    .append(") ")
                    .append("VALUES")
                    .append("(?)");
            preparedStatement = connection.prepareStatement(StatementBuilder.toString());
            preparedStatement.setString(1,genre.getName());
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
        return null;
    }

    @Override
    public Entity read(int entityId) {
        Connection connection = null;
        PreparedStatement preparedStatement =null;
        Genre genre = null;
        try {
            connection = this.getConnection();
            StringBuilder StatementBuilder = new StringBuilder();
            StatementBuilder.append("SELECT * FROM ")
                    .append(DAOConstants.TABLE_GENRE)
                    .append(" WHERE ")
                    .append(DAOConstants.ID)
                    .append("=")
                    .append("?");
            preparedStatement = connection.prepareStatement(StatementBuilder.toString());
            preparedStatement.setInt(1,entityId);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                genre = new Genre();
                genre.setId(resultSet.getInt(1));
                genre.setName(resultSet.getString(2));
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
        return genre;
    }

    @Override
    public void update(Entity entity) {
        Connection connection = null;
        PreparedStatement preparedStatement =null;
        Genre genre = (Genre) entity;
        try {
            connection = this.getConnection();
            StringBuilder StatementBuilder = new StringBuilder();
            StatementBuilder.append("UPDATE ")
                    .append(DAOConstants.TABLE_GENRE)
                    .append(" SET ")
                    .append(DAOConstants.GENRE_NAME)
                    .append("=?")
                    .append(" WHERE ")
                    .append(DAOConstants.ID)
                    .append("=?");
            preparedStatement = connection.prepareStatement(StatementBuilder.toString());
            preparedStatement.setString(1,genre.getName());
            preparedStatement.setInt(2, genre.getId());
            preparedStatement.executeUpdate();
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

    @Override
    public void delete(int entityId) {
        Connection connection = null;
        PreparedStatement preparedStatement =null;
        try {
            connection = this.getConnection();
            StringBuilder StatementBuilder = new StringBuilder();
            StatementBuilder.append("DELETE FROM ")
                    .append(DAOConstants.TABLE_GENRE)
                    .append(" WHERE ")
                    .append(DAOConstants.ID)
                    .append("=?");
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

    public List<Genre> getAllGenres(){
        Connection connection = null;
        PreparedStatement preparedStatement =null;
        Genre genre = null;
        List<Genre> genres = new ArrayList<>();
        try {
            connection = this.getConnection();
            StringBuilder StatementBuilder = new StringBuilder();
            StatementBuilder.append("SELECT * FROM ")
                    .append(DAOConstants.TABLE_GENRE);
            preparedStatement = connection.prepareStatement(StatementBuilder.toString());
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                genre = new Genre();
                genre.setId(resultSet.getInt(1));
                genre.setName(resultSet.getString(2));
                genres.add(genre);
            }
            return genres;
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
