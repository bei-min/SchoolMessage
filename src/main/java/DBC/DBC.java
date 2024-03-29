package DBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBC {
    Statement statement;
    DBC(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/main", "root", "Gaowc2004");
            statement = connection.createStatement();
        }catch (Exception e){
            System.out.println("连接数据库失败！");
        }
    }
    Statement getStatement(){
        return statement;
    }
}
