package Server_Side;

import java.sql.*;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class SQL_Connect{
     public static void main(String[] args){
          final String url = "jdbc:mysql://localhost:3300/Users_Data";
          final String user = "root";
          final String password = "!Boma-ye0531";
          String send_code = null;

          //SQLサービス起動
          {
               try {
                    ProcessBuilder start_pb = new ProcessBuilder("cmd", "/c", "NET START MYSQL80");
                    start_pb.redirectErrorStream(true);

                    Process process=start_pb.start();


                    // 結果を受け取る
                    try (BufferedReader r = new BufferedReader(new InputStreamReader(process.getInputStream(), Charset.defaultCharset()))) {
                         String line;
                         while ((line = r.readLine()) != null) {
                              System.out.println(line);
                         }
                    }
                    int result = process.exitValue();
                    System.out.printf("result=%d%n", result);

               } catch (Exception e) {
                    System.out.println(e.toString());
               }
          }


          try {
               //DB接続
               Connection conn = DriverManager.getConnection(url, user, password);
               //ステートメントインスタンス化
               Statement ps = conn.createStatement();
               //SQL作成クラスインスタンス化
               //引数にテーブル名を割り当て
               SQL_Code qql_coder = new SQL_Code("u_data");



               //INSERT発行
               {
                    send_code = null;
                    String[] testcode = {"2", "komei2"};
                    send_code = qql_coder.INSERT_CALL(testcode);
                    ps.execute(send_code);
                    //発行SQL文確認
                    System.out.println(send_code);
               }


               //SELECT発行
               {
                    send_code = null;
                    send_code = qql_coder.SELECT_CALL();
                    ResultSet get_info = ps.executeQuery(send_code);

                    //SELECT結果取得
                    while (get_info.next()) {
                         int code1 = get_info.getInt(1);
                         String code2 = get_info.getString(2);
                         System.out.println(code1 + " " + code2);
                    }
                    //発行SQL文確認
                    System.out.println(send_code);
               }






               //DELETE発行
               {
                    send_code = null;
                    String[] testcode = {"id", "=", "1"};
                    send_code = qql_coder.DEL_CALL(testcode);
                    ps.execute(send_code);
                    //発行SQL文確認
                    System.out.println(send_code);
               }

               //SQLサービス起動
               {
                    try {
                         ProcessBuilder stop_pb = new ProcessBuilder("cmd", "/c", "NET STOP MYSQL80");
                         stop_pb.redirectErrorStream(true);

                         Process process=stop_pb.start();


                         // 結果を受け取る
                         try (BufferedReader r = new BufferedReader(new InputStreamReader(process.getInputStream(), Charset.defaultCharset()))) {
                              String line;
                              while ((line = r.readLine()) != null) {
                                   System.out.println(line);
                              }
                         }
                         int result = process.exitValue();
                         System.out.printf("result=%d%n", result);

                    } catch (Exception e) {
                         System.out.println(e.toString());
                    }
               }





          } catch (final Exception e) {
               System.out.println(e.getMessage().toString());
               }


     }

}




