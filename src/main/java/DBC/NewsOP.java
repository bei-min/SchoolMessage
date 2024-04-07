package DBC;

import Execute.News;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;

public class NewsOP {
    Statement statement = new DBC().getStatement();
    public News find(int ID){
        try{
            String str = "select * from 信息 where id = " + ID + ";";//查找是否存在消息记录
            ResultSet resultSet = statement.executeQuery(str);
            if(resultSet.next()){
                String title = resultSet.getString("title");
                int f = resultSet.getInt("f");
                //System.out.println(title);
                String Imgurl = resultSet.getString("image");
                String content = resultSet.getString("content");
                String person = resultSet.getString("person");

                return new News(ID , title , f , Imgurl , content , person);
            }
        }catch (Exception e) {
            System.out.println("NewsOPFind错误！");
        }
        return null;
    }

    public int add(String title, int f, String imgurl, String content, String person){
        try{
            String str = "insert into 信息 values (null,'" + title + "'," + f + ",'" + imgurl + "','" + content + "','" + person + "');";//添加消息
            //System.out.println(str);
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

    public ArrayList<String> op(String Imgurl){
        ArrayList<String> imgurl = new ArrayList<>();
        String cnt = "";
        for (int i = 0 ; i < Imgurl.length() ; i ++) {
            if(Imgurl.charAt(i) == ','){
                imgurl.add(cnt);
                cnt = "";
            }
            else cnt += Imgurl.charAt(i);
        }
        return imgurl;
    }
}
