package dao;

import dao.generic.DAOConstants;
import dao.generic.IGenericDAO;
import entity.Country;
import entity.Entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lytki on 26.03.2017.
 */
public class CountryDAO implements IGenericDAO {
    @Override
    public Entity create(Entity entity) {
        Connection connection = null;
        PreparedStatement preparedStatement =null;
        try {
            Country country= (Country)entity;
            connection = this.getConnection();
            StringBuilder StatementBuilder = new StringBuilder();
            StatementBuilder.append("INSERT INTO ")
                    .append(DAOConstants.TABLE_COUNTRY)
                    .append(" (")
                    .append(DAOConstants.COUNTRY_NAME)
                    .append(") ")
                    .append("VALUES")
                    .append("(?)");
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

    @Override
    public Entity read(int entityId) {
        Connection connection = null;
        PreparedStatement preparedStatement =null;
        Country country = null;
        try {
            connection = this.getConnection();
            StringBuilder StatementBuilder = new StringBuilder();
            StatementBuilder.append("SELECT * FROM ")
                    .append(DAOConstants.TABLE_COUNTRY)
                    .append(" WHERE ")
                    .append(DAOConstants.ID)
                    .append("=")
                    .append("?");
            preparedStatement = connection.prepareStatement(StatementBuilder.toString());
            preparedStatement.setInt(1,entityId);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                country = new Country();
                country.setId(resultSet.getInt(1));
                country.setCountryName(resultSet.getString(2));
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
        return country;
    }

    @Override
    public void update(Entity entity) {
        Connection connection = null;
        PreparedStatement preparedStatement =null;
        Country country = (Country) entity;
        try {
            connection = this.getConnection();
            StringBuilder StatementBuilder = new StringBuilder();
            StatementBuilder.append("UPDATE ")
                    .append(DAOConstants.TABLE_COUNTRY)
                    .append(" SET ")
                    .append(DAOConstants.COUNTRY_NAME)
                    .append("=?")
                    .append(" WHERE ")
                    .append(DAOConstants.ID)
                    .append("=?");
            preparedStatement = connection.prepareStatement(StatementBuilder.toString());
            preparedStatement.setString(1,country.getCountryName());
            preparedStatement.setInt(2, country.getId());
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
                    .append(DAOConstants.TABLE_COUNTRY)
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

    public List<Country> getAllCountries() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Country> countries = new ArrayList<>();
        Country country = null;
        try {
            connection = this.getConnection();
            StringBuilder StatementBuilder = new StringBuilder();
            StatementBuilder.append("SELECT * FROM ")
                    .append(DAOConstants.TABLE_COUNTRY);
            preparedStatement = connection.prepareStatement(StatementBuilder.toString());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                country = new Country();
                country.setId(resultSet.getInt(1));
                country.setCountryName(resultSet.getString(2));
                countries.add(country);
            }
            return countries;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
