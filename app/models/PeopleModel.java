package models;

import org.springframework.ui.Model;

import java.sql.*;

@javax.persistence.Entity
public class PeopleModel{

    public Connection conn;
    public PeopleModel() throws SQLException {
        this.conn = DriverManager.
                getConnection("jdbc:h2:./app/DB/MangerDB", "sa", "sa");
        Statement stmt = conn.createStatement();
        String sql = "CREATE TABLE PEOPLE " +
                "(id VARCHAR not NULL, " +
                " first VARCHAR(255), " +
                " last VARCHAR(255), " +
                " age INTEGER, " +
                " PRIMARY KEY ( id ))";

        stmt.executeUpdate(sql);

    }
    // close the connection
    public void closeCon() throws SQLException {
        conn.close();
    }
}
