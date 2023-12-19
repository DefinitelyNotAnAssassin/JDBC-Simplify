package main.java.models;

import main.java.fields.*;

public class HouseTable extends Models {
    CharField address = new CharField("address", 100);
    ForeignKey owner = new ForeignKey("owner", UserTable.class);

    public void createTable() {
        super.createTable();
    }
}