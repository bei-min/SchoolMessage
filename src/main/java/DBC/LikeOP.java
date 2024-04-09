package DBC;

import Execute.CharChange;

import java.sql.ResultSet;
import java.sql.Statement;

public class LikeOP {
    Statement statement = new DBC().getStatement();
    boolean find(int RID , String Name){
        try{
            String str = "select * from 点赞 where RID = " + RID + " and Name = '" + Name + "';";//查找是否存在消息记录
            ResultSet resultSet = statement.executeQuery(str);
            if(resultSet.next()) {
                return true;
            }
        }catch (Exception e) {
            System.out.println(" LikeOP错误！");
        }
        return false;
    }
    public int Add(int RID , String Name){
        if(!find(RID , Name)){
            try{
                String str = "insert into 点赞 values (" + RID + ",'" + Name + "');";//添加消息
                //System.out.println(str);
                return statement.executeUpdate(str);
            }catch (Exception e) {
                System.out.println("LikeOPADD错误！");
            }
        }
        else{
            System.out.println("重复点赞");
        }
        return 0;
    }

    public int sum(int RID){
        try{
            String str = "select count(RID) from 点赞 where RID = " + RID + ";";//添加消息
            //System.out.println(str);
            ResultSet resultSet =  statement.executeQuery(str);
            if(resultSet.next())
                return resultSet.getInt("count(RID)");
        }catch (Exception e) {
            System.out.println("CollectionOPADD错误！");
        }
        return 0;
    }
}
