package Server_Side;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;



public class SQL_Connect{
     public static void main(String[] args){
          final String url = "jdbc:mysql://localhost:3300/Users_Data";
          final String user = "root";
          final String password = "!Boma-ye0531";

          try {
               //Class.forName("com.mysql.jdbc.Driver");

               String send_code = null;
               String table_name = null;

               final Connection conn = DriverManager.getConnection(url, user, password);

               final PreparedStatement ps = conn.prepareStatement(send_code);
               ps.executeUpdate();




          } catch (final Exception e) {
               System.out.println(e.getMessage().toString());
               }


     }

}




