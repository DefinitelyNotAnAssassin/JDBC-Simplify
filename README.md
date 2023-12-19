## Java ORM Project
This project is a simple Object-Relational Mapping (ORM) framework built in Java. It provides a way to interact with your database using Java objects.

## Prerequisites
- Java 8 or higher
- Maven
- SQLite JDBC driver
- SLF4J API
## Setup
Clone the repository to your local machine.
Open the project in your favorite IDE (we recommend Visual Studio Code or IntelliJ IDEA).
Ensure that the SQLite JDBC driver and SLF4J API are included in your project's classpath. If you're using Maven, these dependencies should be automatically managed for you.
## Usage
### Connecting to a Database
To connect to a database, create an instance of the Database class and call the connect method with the name of your database file as a parameter.
```java
Database db = new Database();
db.connect("Database.db");
```
Creating a Table
To create a table, create an instance of your table class (which should extend the Models class) and call the createTable method.

```java
// PersonTable.java 
import main.java.fields.*;

public class PersonTable extends Models {
    CharField name = new CharField("name", 50);
    IntegerField age = new IntegerField("age");

    public void createTable() {
        super.createTable();
    }
}

// Main method

public static void main(String[] args){
  PersonTable persontable = new PersonTable();
  persontable.createTable();
  // Person Table created 
}
```

## Disconnecting from a Database
To disconnect from a database, call the disconnect method on your Database instance.
```java
db.disconnect();
```


## Building the Project
To build the project, run the build script in the pom.xml file:
```bash
mvn clean install
```
This will compile your code, run any tests, and package your project into a JAR file.

## Contributing
Contributions are welcome! Please read our contributing guidelines for details on how to contribute to this project.

## License
This project is licensed under the MIT License. See the LICENSE file for details.
