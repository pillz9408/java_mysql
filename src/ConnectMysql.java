import java.sql.*;

public class ConnectMysql {
   static final String DB_URL = "jdbc:mysql://localhost/world";
   static final String USER = "root";
   static final String PASS = "tbrs00002b";
   static final String QUERY = "SELECT CountryCode, Language, IsOfficial, Percentage " +
                                " From countrylanguage" ;

   public static void main(String[] args) {
      // Open a connection
      try {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement stmt = conn.createStatement(); // 워크벤치에서 sql query에디터창을 꺼내주는 명령어. 
        ResultSet rs = stmt.executeQuery(QUERY); // 쿼리를 실행
         // Extract data from result set
         while (rs.next()) {
            // Retrieve by column name
            System.out.print("CountryCode: " + rs.getString("CountryCode"));
            System.out.print(", Language: " + rs.getString("Language"));
            System.out.print(", IsOfficial " + rs.getString("IsOfficial"));
            System.out.println(", Percentage " + rs.getInt("Percentage"));
         }
      } catch (SQLException e) {
          e.printStackTrace();
      } 
   }
}