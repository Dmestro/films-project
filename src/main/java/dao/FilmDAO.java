package dao;

import dao.generic.DAOConstants;
import dao.generic.IGenericDAO;
import entity.Country;
import entity.Entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Lytki on 22.03.2017.
 */
public class FilmDAO implements IGenericDAO {
    public Entity create(Entity entity) {
        Connection connection = null;
        PreparedStatement preparedStatement =null;
        try {
            Country country= (Country)entity;
            connection = this.getConnection();
            StringBuilder StatementBuilder = new StringBuilder();
            StatementBuilder.append("INSERT INTO ")
                    .append(DAOConstants.TABLE_FILM)
                    .append(" (")
                    .append(DAOConstants.FILM_TITLE+",")
                    .append(DAOConstants.FILM_RELEASE_DATE+",")
                    .append(DAOConstants.FILM_RAITING+",")
                    .append(DAOConstants.FILM_POSTER+",")
                    .append(DAOConstants.FILM_DESCRIPTION+",")
                    .append(DAOConstants.FILM_TRAILER_URL)
                    .append(") ")
                    .append("VALUES")
                    .append("(?,?,?,?,?,?)");
            preparedStatement = connection.prepareStatement(StatementBuilder.toString());
            preparedStatement.setString(1,country.getCountryName());
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                country.setId(resultSet.getInt(1));
            }
            return country;
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
        return null;
    }

    public void update(Entity entity) {

    }

    public void delete(int entityId) {

    }
}
