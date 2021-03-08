package cn.tedu;

import java.sql.Connection;
import java.sql.Statement;

/**
 * 批量执行sql语句的操作
 */
public class Demo06 {
    public static void main(String[] args) {
        //获取连接
        try(Connection conn=DBUtils.getConn()){
            String sql1="insert into user values(null,'aaa','123456');";
            String sql2="insert into user values(null,'bbb','123456');";
            String sql3="insert into user values(null,'ccc','123456');";
            Statement s=conn.createStatement();
//            s.executeUpdate(sql1);
//            s.executeUpdate(sql2);
//            s.executeUpdate(sql3);
            //批量操作
            s.addBatch(sql1);
            s.addBatch(sql2);
            s.addBatch(sql3);
            s.executeBatch(); //执行批量操作
            System.out.println("执行完成!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
