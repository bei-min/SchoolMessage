package DBC;

import Execute.CharChange;
import Execute.News;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;

public class NewsOP {
    Statement statement = new DBC().getStatement();
    CharChange charChange = new CharChange();
    public News find(int ID){
        try{
            String str = "select * from 信息 where id = " + ID + ";";//查找是否存在消息记录
            ResultSet resultSet = statement.executeQuery(str);
            if(resultSet.next()){
                String title = charChange.UTF_to_ISO(resultSet.getString("title"));
                int f = resultSet.getInt("f");
                String Imgurl = charChange.UTF_to_ISO(resultSet.getString("image"));
                String content = charChange.UTF_to_ISO(resultSet.getString("content"));
                String person = charChange.UTF_to_ISO(resultSet.getString("person"));
                String classify = charChange.UTF_to_ISO(resultSet.getString("classify"));
                int point = resultSet.getInt("point");

                return new News(ID , title , f , Imgurl , content , person , classify , point);
            }
        }catch (Exception e) {
            System.out.println("NewsOPFind错误！");
        }
        return null;
    }

    public ArrayList<News> find(String table , String x){
        try{
            String str = null;
            if(table == "classify")
                str = "select * from 信息 where classify like '%" + x + "%';";
            else if(table == "person")
                str = "select * from 信息 where person = '" + x + "';";
            else if(table == "search")
                str = "select * from 信息 where content like '%" + x + "%'"+"or title like '%" + x  + "%';";
            else if(table == "ID")
                str = "select * from 信息 where id = " + Integer.parseInt(x) + ";";
            //System.out.println(str);
            ResultSet resultSet = statement.executeQuery(str);
            ArrayList<News> ans = new ArrayList<>();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String title = charChange.UTF_to_ISO(resultSet.getString("title"));
                int f = resultSet.getInt("f");
                String Imgurl = charChange.UTF_to_ISO(resultSet.getString("image"));
                String content = charChange.UTF_to_ISO(resultSet.getString("content"));
                String person = charChange.UTF_to_ISO(resultSet.getString("person"));
                String classify = charChange.UTF_to_ISO(resultSet.getString("classify"));
                int point = resultSet.getInt("point");
                News news = new News(id , title , f , Imgurl , content , person , classify , point);
                ans.add(news);
            }
            return ans;
        }catch (Exception e) {
            System.out.println("NewsOPFind错误！");
        }
        return null;
    }

    public int add(String title, String imgurl, String content, String person, String classify){
        try{
            String str = "insert into 信息 values (null,'" + title + "'," + "null" + ",'" + imgurl + "','" + content + "','" + person + "','" + classify + "'," + "null" + ");";//添加消息
            //System.out.println(str);
            return statement.executeUpdate(str);
        }catch (Exception e) {
            System.out.println("NewsOPADD错误！");
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
