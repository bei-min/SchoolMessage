package DBC;

import java.sql.ResultSet;
import java.sql.Statement;

public class CollectionOP {
    Statement statement = new DBC().getStatement();
    boolean find(int RID , String Name){
        try{
            String str = "select * from 收藏 where RID = " + RID + " and Name = '" + Name + "';";//查找是否存在消息记录
            ResultSet resultSet = statement.executeQuery(str);
            if(resultSet.next()) {
                return true;
            }
        }catch (Exception e) {
            System.out.println(" CollectionOP错误！");
        }
        return false;
    }
    public int Add(int RID , String Name){
        if(!find(RID , Name)){
            try{
                String str = "insert into 收藏 values (" + RID + ",'" + Name + "');";//添加消息
                //System.out.println(str);
                return statement.executeUpdate(str);
            }catch (Exception e) {
                System.out.println("CollectionOPADD错误！");
            }
        }
        else{
            System.out.println("重复收藏");
        }
        return 0;
    }

    public int sum(int RID){
        try{
            String str = "select count(RID) from 收藏 where RID = " + RID + ";";//添加消息
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
