package main.java;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import java.io.IOException;
import java.lang.reflect.Method;
import main.java.models.Models;
import java.util.Enumeration;

import org.reflections.Reflections;
import java.util.Set;

public class Manage {
    public static void main(String[] args) {
        if (args.length > 0) {
            String command = args[0];
            if ("migrate".equals(command)) {
                try {

                    // Get all classes in the project
                    Reflections reflections = new Reflections("main.java.models");
                    Set<Class<?>> classes = reflections.getSubTypesOf(Object.class);
                    System.out.println("Number of classes: " + classes.size());

                    for (Class<?> clazz : classes) {
                        System.out.println("Loaded class: " + clazz.getName());
                        // Check if the class has a createTable method
                        Method createTableMethod = clazz.getMethod("createTable");
                        if (createTableMethod != null) {
                            // Invoke the createTable method
                            createTableMethod.invoke(clazz.newInstance());
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}