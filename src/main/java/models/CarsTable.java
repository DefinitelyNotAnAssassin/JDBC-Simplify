package main.java.models;

import main.java.fields.*;

public class CarsTable extends Models {
    CharField make = new CharField("make", 50);
    CharField model = new CharField("model", 50);
    IntegerField year = new IntegerField("year");
    ForeignKey owner = new ForeignKey("owner", UserTable.class);

    public void createTable() {
        super.createTable();
    }
}
