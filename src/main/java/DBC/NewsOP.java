package DBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class NewsOP {
    Statement statement = new DBC().getStatement();
    ResultSet find(String ID){
        try{
            String str = "";//查找是否存在消息记录
            ResultSet resultSet = statement.executeQuery(str);
            if(resultSet.next())
                return resultSet;
        }catch (Exception e) {
            System.out.println("NewsOP错误！");
        }
        return null;
    }

    int add(ArrayList<String> list){
        try{
            String str = "";//添加消息
            return statement.executeUpdate(str);
        }catch (Exception e) {
            System.out.println("NewsOP错误！");
        }
        return 0;
    }
    int dele(String ID){
        try{
            String str = "";//删除档案
            statement.executeUpdate(str);
            str = "";//删除某个语句
            return statement.executeUpdate(str);
        }catch (Exception e) {
            System.out.println("NewsOP错误！");
        }
        return 0;
    }
    int re(ArrayList<String> list){
        try{
            String str = "";//更改
            return statement.executeUpdate(str);
        }catch (Exception e) {
            System.out.println("NewsOP错误！");
        }
        return 0;
    }
}
