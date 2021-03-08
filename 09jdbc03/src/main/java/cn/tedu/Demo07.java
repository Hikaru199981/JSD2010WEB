package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * 批量操作预编译的sql代码
 */
public class Demo07 {
    public static void main(String[] args) {
        try (Connection conn=DBUtils.getConn()){
            String sql="insert into user values(null,?,?)";
            //此处sql中不能加; 否则会变成(null,name1,pw1);,(null,name2,pw2);,...
            PreparedStatement ps=conn.prepareStatement(sql);
            for(int i=1;i<101;i++){
                ps.setString(1,"name"+i);
                ps.setString(2,"pw"+i);
                ps.addBatch(); //添加到批量操作
                if(i%20==0){ //每隔20次执行一次 避免内存溢出
                    ps.executeBatch(); //执行批量操作
                }
            }
//            ps.executeBatch(); //执行批量操作
            System.out.println("执行完成!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
