import java.sql.*;

public class MiniProjectConnectMysqlCountry {
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
        String QUERY = "Select Code, Name, Capital, Continent " +
                "from country " +
                "Where 1 = 1 " +
                "and Name like '%an%' ";
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            // Make new SQL tab for executing query
            ResultSet rs = stmt.executeQuery(QUERY);
            // result grid, check action output
            while (rs.next()) {
                // Retrieve by column name
                System.out.print("Code: " + rs.getString("Code"));
                System.out.print(", Name: " + rs.getString("Name"));
                System.out.print(", Capital: " + rs.getInt("Capital"));
                System.out.println(", Continent: " + rs.getString("Continent"));

            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // Select * from City
        // print World.City

        return;
    }

}