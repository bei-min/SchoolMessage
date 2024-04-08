package DBC;

import Execute.CharChange;
import Execute.GetTime;
import Execute.News;
import Execute.Record;

import java.sql.*;

public class MemberOP {
    Statement statement = new DBC().getStatement();
    CharChange charChange = new CharChange();
    public Record find(String name){
        try{
            String str = "select * from 用户 where username = '" + name + "';"; //查找是否存在昵称的记录
            ResultSet resultSet = statement.executeQuery(str);
            if(resultSet.next()){
                int id = resultSet.getInt("id");
                String username = charChange.UTF_to_ISO(resultSet.getString("username"));
                String email = charChange.UTF_to_ISO(resultSet.getString("email"));
                String Imgurl = charChange.UTF_to_ISO(resultSet.getString("Imgurl"));
                String reginTime = charChange.UTF_to_ISO(resultSet.getString("reginTime"));
                int estate = resultSet.getInt("estate");
                int browse = resultSet.getInt("browse");
                int praise = resultSet.getInt("praise");
                int collect = resultSet.getInt("collect");
                Record record = new Record(id , username , email , Imgurl , reginTime , estate , browse , praise , collect);
                return record;
            }
        }catch (Exception e) {
            System.out.println("MemberOPfind1错误！");
        }
        return null;
    }
    public boolean find(String name, String password){
        try{
            String str = "select * from 用户 where username = '"+ name +"' and password = '" + password +"';";//查找昵称与密码符合的sql语句
            ResultSet resultSet = statement.executeQuery(str);
            if(resultSet.next())
                return true;
        }catch (Exception e) {
            System.out.println("MemberOPFind错误！");
        }
        return false;
    }
    public int add(String name , String password, String email){
        try{
            String str = "insert into 用户 values (null,'"+name+"','"+password+"','"+email+"', '[]' , '" + (new GetTime().getTime()) + "' , 0 , 0 , 0 , 0);";//添加语句
            //System.out.println(str);
            return statement.executeUpdate(str);
        }catch (Exception e) {
            System.out.println("MemberOP错误！");
        }
        return 0;
    }
    int dele(String name , String password){
        if(find(name , password)){
            try{
                String str = "drop table "+name+";";//删除档案
                statement.executeUpdate(str);
                str = "delete from 用户 where username = " + name +"and password = " + password + ";";//删除某个语句
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
    int re(String name , String oldname ,String email , String password){
        if(find(oldname) != null){
            try{
                String str = "RENAME TABLE " + oldname +"to " + name+";";//更改档案（表名）
                statement.executeUpdate(str);
                str = "update 用户 set username ="+name+",email = " + email +",password = " + password +"where name = " + oldname+";";//更改语句
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
