package models;

import java.sql.*;
public class PeopleModel {
    public Connection conn;
    public PeopleModel() throws SQLException {
        this.conn = DriverManager.
                getConnection("jdbc:h2:./app/DB/MangerDB", "sa", "");
        // add application code here
        conn.close();
    }
}