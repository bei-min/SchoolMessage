package DBC;

import java.sql.ResultSet;
import java.sql.Statement;

public class DiscussOP {
    Statement statement = new DBC().getStatement();
    boolean find(int RID , String Name , String Content){
        try{
            String str = "select * from 讨论 where RID = " + RID + " and Name = '" + Name + "' and Content = '" + Content + "';";//查找是否存在消息记录
            ResultSet resultSet = statement.executeQuery(str);
            if(resultSet.next()) {
                return true;
            }
        }catch (Exception e) {
            System.out.println(" DiscussOP错误！");
        }
        return false;
    }
    public int Add(int RID , String Name , String Content){
        if(!find(RID , Name , Content)){
            try{
                String str = "insert into 点赞 values (" + RID + ",'" + Name + "','" + Content + "');";//添加消息
                //System.out.println(str);
                return statement.executeUpdate(str);
            }catch (Exception e) {
                System.out.println(" DiscussOP错误！");
            }
        }
        else{
            System.out.println("发布了相同的评论");
        }
        return 0;
    }
}
