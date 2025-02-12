package kz.aitu.oop.restservice.DBconnect;

import java.sql.*;
import java.util.ArrayList;

public class dbConnect {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "q1p0w2o9@";

    public void getConnectionToDB() throws Exception {
        // Class.forName("org.postgresql.Driver"); // Driver name
        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
        System.out.println("Connection Established successfully");

        String query = "SELECT * FROM assik.assik"; // query to be run
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query); // Execute query
        rs.next();

        String name = rs.getString("name"); // Retrieve name from db
        System.out.println(name); // Print result on console

        st.close(); // close statement
        con.close(); // close connection
        System.out.println("Connection Closed....");}
}
