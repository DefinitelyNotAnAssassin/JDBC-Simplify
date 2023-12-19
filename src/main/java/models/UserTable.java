package main.java.models;

import main.java.fields.*;

public class UserTable extends Models {
    CharField name = new CharField("name", 50);
    IntegerField age = new IntegerField("age");

    public void createTable() {
        super.createTable();
    }
}
