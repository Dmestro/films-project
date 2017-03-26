package dao.generic;

import dao.generic.DAOConstants;
import entity.Entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Lytki on 26.03.2017.
 */
public interface IGenericDAO {
    void create(Entity entity);
    Entity read(int entityId);
    void update(Entity entity);
    void delete(int entityId);
    default Connection getConnection() throws SQLException {
        Connection connection=null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(DAOConstants.DB_URL, DAOConstants.DB_USER, DAOConstants.DB_PASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
