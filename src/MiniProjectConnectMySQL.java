import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MiniProjectConnectMySQL {
    public static void main(String[] args) {
        // make project files
        // run MySQL Workbench
        // connect to DataBase
        // Connection method, hostname, port, Username, password, default schema
        // Hostname: localhost port: 3306
        // Username: root
        // Default Schema : world
        // password : tbrs00002b
        // access to 'World' DB
        final String DB_URL = "jdbc:mysql://localhost/world";
        final String USER = "root";
        final String PASS = "tbrs00002b";
        String QUERY = "select ID ,Name ,Population " +
                "from city " +
                "Where 1 = 1 " +
                "and Population >= 9230000 ";
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            // insert
            QUERY = "insert into city (ID, Name, CountryCode, District, Population) " +
                    "Values (98765, 'Name', 'AFG', 'district', 100) ";
            int val = stmt.executeUpdate(QUERY);
            // select
            QUERY = "select ID, Name, CountryCode, District, Population " +
                    "from city " +
                    "Where 1 = 1 " +
                    "and Name = 'Name' ";
            ResultSet rs = stmt.executeQuery(QUERY);
            // resylt grid, check action output
            while (rs.next()) {
                // Retrieve by column name
                System.out.print("ID: " + rs.getInt("ID"));
                System.out.print(", Name: " + rs.getString("Name"));
                System.out.println(", Population: " + rs.getInt("Population"));

            }
            // update
            QUERY = "Update city " +
                    "set Population = 20000 " +
                    "Where Name = 'Name' ";
            val = stmt.executeUpdate(QUERY);
            // select
            System.out.println();
            // delete
            QUERY = "delete from city " +
                    "Where Name = 'Name' ";
            val = stmt.executeUpdate(QUERY);
            // select
            System.out.println();

            // Make new SQL tab for executing query
            // ResultSet rs = stmt.executeQuery(QUERY);
            // result grid, check action output
            // while (rs.next()) {
            // Retrieve by column name
            // System.out.print("ID: " + rs.getInt("ID"));
            // System.out.print(", Name: " + rs.getString("Name"));
            // System.out.println(", Population: " + rs.getInt("Population"));

            // }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        // Select * from City
        // print World.City

        return;
    }

}
