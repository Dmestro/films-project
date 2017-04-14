package dao;

import dao.generic.DAOConstants;
import dao.generic.IGenericDAO;
import entity.Country;
import entity.Entity;
import entity.People;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lytki on 26.03.2017.
 */
public class PeopleDAO implements IGenericDAO {
    @Override
    public Entity create(Entity entity) {
        Connection connection = null;
        PreparedStatement preparedStatement =null;
        try {
            People people = (People) entity;
            connection = this.getConnection();
            StringBuilder StatementBuilder = new StringBuilder();
            StatementBuilder.append("INSERT INTO ")
                    .append(DAOConstants.TABLE_PEOPLE)
                    .append(" (")
                    .append(DAOConstants.PEOPLE_FIRSTNAME)
                    .append(",")
                    .append(DAOConstants.PEOPLE_LASTNAME)
                    .append(") ")
                    .append("VALUES")
                    .append("(?,?)");
            preparedStatement = connection.prepareStatement(StatementBuilder.toString());
            preparedStatement.setString(1,people.getFirstName());
            preparedStatement.setString(2,people.getLastName());
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
        People people = null;
        try {
            connection = this.getConnection();
            StringBuilder StatementBuilder = new StringBuilder();
            StatementBuilder.append("SELECT * FROM ")
                    .append(DAOConstants.TABLE_PEOPLE)
                    .append(" WHERE ")
                    .append(DAOConstants.ID)
                    .append("=")
                    .append("?");
            preparedStatement = connection.prepareStatement(StatementBuilder.toString());
            preparedStatement.setInt(1,entityId);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                people = new People();
                people.setId(resultSet.getInt(1));
                people.setFirstName(resultSet.getString(2));
                people.setLastName(resultSet.getString(3));
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
        return people;
    }

    @Override
    public void update(Entity entity) {
        Connection connection = null;
        PreparedStatement preparedStatement =null;
        People people = (People) entity;
        try {
            connection = this.getConnection();
            StringBuilder StatementBuilder = new StringBuilder();
            StatementBuilder.append("UPDATE ")
                    .append(DAOConstants.TABLE_PEOPLE)
                    .append(" SET ")
                    .append(DAOConstants.PEOPLE_FIRSTNAME)
                    .append("=?, ")
                    .append(DAOConstants.PEOPLE_LASTNAME)
                    .append("=? ")
                    .append(" WHERE ")
                    .append(DAOConstants.ID)
                    .append("=?");
            preparedStatement = connection.prepareStatement(StatementBuilder.toString());
            preparedStatement.setString(1,people.getFirstName());
            preparedStatement.setString(2,people.getLastName());
            preparedStatement.setInt(3, people.getId());
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
                    .append(DAOConstants.TABLE_PEOPLE)
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

    public List<People> getAllPeoples(){
        Connection connection = null;
        PreparedStatement preparedStatement =null;
        People people = null;
        List<People> peoples=new ArrayList<>();
        try {
            connection = this.getConnection();
            StringBuilder StatementBuilder = new StringBuilder();
            StatementBuilder.append("SELECT * FROM ")
                    .append(DAOConstants.TABLE_PEOPLE);
            preparedStatement = connection.prepareStatement(StatementBuilder.toString());
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                people = new People();
                people.setId(resultSet.getInt(1));
                people.setFirstName(resultSet.getString(2));
                people.setLastName(resultSet.getString(3));
                peoples.add(people);
            }
            return peoples;
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
