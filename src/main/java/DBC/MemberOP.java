package DBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MemberOP {
    Statement statement = new DBC().getStatement();
    boolean find(String name){
        try{
            String str = "";//查找是否存在改昵称的记录
            ResultSet resultSet = statement.executeQuery(str);
            if(resultSet.next())
                return true;
        }catch (Exception e) {
            System.out.println("MemberOP错误！");
        }
        return false;
    }
    boolean find(String name, String password){
        try{
            String str = "";//查找昵称与密码符合的sql语句
            ResultSet resultSet = statement.executeQuery(str);
            if(resultSet.next())
                return true;
        }catch (Exception e) {
            System.out.println("MemberOP错误！");
        }
        return false;
    }
    int add(String name , String password){
        if(!find(name)){
            try{
                String str = "";//添加档案
                statement.executeUpdate(str);
                str = "";//添加语句
                return statement.executeUpdate(str);
            }catch (Exception e) {
                System.out.println("MemberOP错误！");
            }
        }
        else{
            System.out.println("该账户已存在！");
        }
        return 0;
    }
    int dele(String name , String password){
        if(find(name , password)){
            try{
                String str = "";//删除档案
                statement.executeUpdate(str);
                str = "";//删除某个语句
                return statement.executeUpdate(str);
            }catch (Exception e) {
                System.out.println("MemberOP错误！");
            }
        }
        else{
            System.out.println("查无此人！");
        }
        return 0;
    }
    int re(String name , String password){
        if(find(name , password)){
            try{
                String str = "";//更改档案（表名）
                statement.executeUpdate(str);
                str = "";//更改语句
                return statement.executeUpdate(str);
            }catch (Exception e) {
                System.out.println("MemberOP错误！");
            }
        }
        else{
            System.out.println("查无此人！");
        }
        return 0;
    }
}
