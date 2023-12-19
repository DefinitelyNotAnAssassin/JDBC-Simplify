package main.java.database;
// This will be a class for a Database interaction using various available drivers for sqlite and mysql 

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {

    private Connection conn;
    private Statement stmt;
    private ResultSet rs;

    public Database() {
        conn = null;
        stmt = null;
        rs = null;
    }

    public void connect(String db) {
        try {
            Class.forName("org.sqlite.JDBC");
            System.out.println("Loaded driver");
            String current_dir = System.getProperty("user.dir");
            conn = DriverManager.getConnection("jdbc:sqlite:" + current_dir + "\\" + db);
            stmt = conn.createStatement(); // test statement
            System.out.println("Connected to database");
        } catch (Exception e) {
            System.out.println("Error connecting to database");
            System.out.println(e);
        }
    }

    public void disconnect() {
        try {
            if (conn != null) {
                conn.close();
                System.out.println("Disconnected from database");
            }
        } catch (Exception e) {
            System.out.println("Error disconnecting from database");
            System.out.println(e.getMessage());
        }
    }

    // method that will execute a query

    public void executeQuery(String query) {
        try {
            stmt.executeUpdate(query);
            System.out.println("Query executed");
        } catch (Exception e) {
            System.out.println("Error executing query");
            System.out.println(e.getMessage());
        }
    }

    /**
     * This method will create a table in the database
     * 
     * @param table The name of the table to be created
     * @return void
     * 
     *         Example: createTable("people"); This will create a table called
     *         people with the following columns: id, name, age
     * 
     */

    public void createTable(String table) {
        try {
            // create a table based on a string that will be supplied by the user, the
            // fields shall also be handled in a oop way
            executeQuery(table);
            System.out.println(table);
            System.out.println("Table created");

        } catch (Exception e) {
            System.out.println("Error creating table " + table);
            System.out.println(e.getMessage());
        }
    }

    public void insert(String table, String name, int age) {
        try {
            stmt.executeUpdate("INSERT INTO " + table + " (name, age) VALUES ('" + name + "', " + age + ")");
            System.out.println("Inserted " + name + " into " + table);
        } catch (Exception e) {
            System.out.println("Error inserting " + name + " into " + table);
            System.out.println(e.getMessage());
        }
    }

    public void update(String table, String name, int age) {
        try {
            stmt.executeUpdate("UPDATE " + table + " SET age = " + age + " WHERE name = '" + name + "'");
            System.out.println("Updated " + name + " in " + table);
        } catch (Exception e) {
            System.out.println("Error updating " + name + " in " + table);
            System.out.println(e.getMessage());
        }
    }

    public void delete(String table, String name) {
        try {
            stmt.executeUpdate("DELETE FROM " + table + " WHERE name = '" + name + "'");
            System.out.println("Deleted " + name + " from " + table);
        } catch (Exception e) {
            System.out.println("Error deleting " + name + " from " + table);
            System.out.println(e.getMessage());
        }

    }

    public List<String> select(String table) {
        List<String> list = new ArrayList<String>();
        try {
            rs = stmt.executeQuery("SELECT * FROM " + table);
            while (rs.next()) {
                list.add(rs.getString("name") + " " + rs.getInt("age"));
            }
        } catch (Exception e) {
            System.out.println("Error selecting from " + table);
            System.out.println(e.getMessage());
        }
        return list;
    }

}
