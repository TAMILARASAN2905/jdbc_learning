import java.sql.*;

public class Main {
    /* Seven Steps
        1.Import the package
        2.Load and register the driver(MySql or postgres or ...)
        3.Establish a connection
        4.create a statement(statement, PreParedStatement, CallableStatement)
        5.Execute the statement
        6.Process the result
        7.Close the connection
    */
    public static void main(String[] args) {
/*        // Step : 1
          ✅ Legacy Approach (Pre-Java 6 / JDBC 4.0)

       Option 1: Load the driver class dynamically
        Class.forName("com.mysql.cj.jdbc.Driver"); // Loads and registers the MySQL JDBC driver manually

       Option 2: Manually create and register the driver
         Driver driver = new com.mysql.cj.jdbc.Driver(); // Create an instance of the driver
         DriverManager.registerDriver(driver);           // Register the driver with DriverManager

         🚫 Note:
         In modern Java (Java 6 and above), this step is OPTIONAL.
         JDBC uses the Service Provider Mechanism to auto-load drivers
         if the driver JAR (like MySQL Connector/J) is on the classpath.
         So you can directly use DriverManager.getConnection(...) without manually loading the driver.*/
        try {
//         Establish a connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbclearning", "root", "root");

//         create a statement
            Statement statement = connection.createStatement();
            String sql = "Select * from student;";

//         Execute the statement
            ResultSet resultSet = statement.executeQuery(sql);

            /*Process the result*/
//            resultSet.next(); //Skipping header
//            System.out.println(resultSet.getInt("id") + " " + resultSet.getString(2));
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + " " + resultSet.getString(2));
            }
          /*Close the Connection*/
            connection.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Exception occurred during connection");
        }
    }
}
