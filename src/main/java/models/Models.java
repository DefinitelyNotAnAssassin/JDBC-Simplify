package main.java.models;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import main.java.database.*;
import main.java.fields.*;

public class Models {
    protected void createTable() {
        System.out.println("Creating table for " + this.getClass().getSimpleName());
        Database db = new Database();
        db.connect("Database.db");
        StringBuilder sql = new StringBuilder("CREATE TABLE IF NOT EXISTS " + this.getClass().getSimpleName() + " (");
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.getType() == CharField.class) {
                sql.append(field.getName()).append(" VARCHAR(255), "); // assuming max length of 255
            } else if (field.getType() == IntegerField.class) {
                sql.append(field.getName()).append(" INT, ");
            } else if (field.getType() == ForeignKey.class) {
                ForeignKey foreignKey = null;
                try {
                    foreignKey = (ForeignKey) field.get(this);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                Class<?> relatedModel = foreignKey.getRelatedModel();

                sql.append(field.getName()).append(" INT, ");
                sql.append("FOREIGN KEY (").append(field.getName()).append(") REFERENCES ")
                        .append(relatedModel.getSimpleName()).append("(id), ");
            }
        }
        sql.delete(sql.length() - 2, sql.length()).append(");");
        db.createTable(sql.toString());
    }
}