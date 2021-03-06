package cn.tedu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 查询hero表里面的英雄名和类型 在控制台输出
 */
public class Demo03 {
    public static void main(String[] args) {
        try (Connection conn=DBUtils.getConn();){
            Statement s=conn.createStatement();
            String sql="select name,type from hero";
            ResultSet rs=s.executeQuery(sql);
            while (rs.next()){
                String name=rs.getString(1);
                //此处的数字表示的是上述select语句中name,type的顺序,从1开始,
                //不是数据库中本身的存储顺序。
                String type=rs.getString(2);
                System.out.println(name+":"+type);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
