package main.java;

import main.java.models.*;
import main.java.fields.*;
import java.util.List;

import main.java.database.Database;

public class ORMTester {
    public static void main(String[] args) {
        // Create an instance of the Database class
        Database db = new Database();

        // Connect to the database
        db.connect("Database.db");

        CarsTable cars = new CarsTable();
        cars.createTable();
        db.disconnect();
    }
}