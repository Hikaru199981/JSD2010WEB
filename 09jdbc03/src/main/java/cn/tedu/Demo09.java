package cn.tedu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 获取自增主键值
 */
public class Demo09 {
    public static void main(String[] args) {
        //获取连接
        try (Connection conn=DBUtils.getConn()){
            String sql="insert into user values(null,'诸葛亮','123456')";
            Statement s=conn.createStatement();
            s.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
            //得到装着主键值的结果集
            ResultSet rs=s.getGeneratedKeys();
            rs.next(); //让油标移动一格
            int id=rs.getInt(1);
            System.out.println("执行完成!id="+id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
