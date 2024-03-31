package DBC;

import Execute.News;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;

public class NewsOP {
    Statement statement = new DBC().getStatement();
    ResultSet find(int ID){
        try{
            String str = "select id from 信息 where id = " + ID + ";";//查找是否存在消息记录
            ResultSet resultSet = statement.executeQuery(str);
            if(resultSet.next())
                return resultSet;
        }catch (Exception e) {
            System.out.println("NewsOP错误！");
        }
        return null;
    }

    int add(int id ,String classify , String description , String data){
        try{
            String str = "insert into 信息 values (null,"+","+classify+","+description+","+data+",null,null"+");";//添加消息
            return statement.executeUpdate(str);
        }catch (Exception e) {
            System.out.println("NewsOP错误！");
        }
        return 0;
    }
    int dele(int ID){
        try{
            String str = "delete from 信息 where id = " + ID  + ";";//删除语句 信息表
            return statement.executeUpdate(str);
        }catch (Exception e) {
            System.out.println("NewsOP错误！");
        }
        return 0;
    }
    int re(int id , String description , String data){
        try{
            String str = "update 信息 set description = "+description+",image = " + data +"where id = " +id+";";//更改
            return statement.executeUpdate(str);
        }catch (Exception e) {
            System.out.println("NewsOP错误！");
        }
        return 0;
    }

    public ArrayList<News> show(){
        ArrayList<News> res = new ArrayList<>();
        try{
            String str = "select * from 信息 order by id desc limit 1; ";//更改
            ResultSet resultSet = statement.executeQuery(str);
            //System.out.println(resultSet.next());
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String classify = resultSet.getString("classify");
                String description = resultSet.getString("description");
//                String image = resultSet.getString("image");
//                String document = resultSet.getString("document");
//                String video = resultSet.getString("video");
                News news = new News(id , classify , description , null , null , null);
                //System.out.println(news);
                res.add(news);
            }
        }catch (Exception e) {
            System.out.println("NewsOPshow错误！");
        }
        return res;
    }
}
