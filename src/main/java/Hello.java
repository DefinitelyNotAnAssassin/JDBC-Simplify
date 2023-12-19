package main.java;

import main.java.fields.*;

public class Hello {

    public class HelloTable {
        Object name = new CharField("name", 50);
        Object address = new CharField("address", 50);
        Object age = new IntegerField("age");

        // create a method that will take all of the fields and create a table in the
        // database

        public void createTable() {

            // insert logic and get all of the fields here in a generated way

            System.out.println("Created table");
        }

    }

    public static void main(String[] args) {
        System.out.println("Hello World");
    }

}
