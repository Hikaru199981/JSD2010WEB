package cn.tedu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 检查DBUtils是否封装正确
 */
public class Demo01 {
    public static void main(String[] args) {
        //获取连接
        try(Connection conn=DBUtils.getConn()){
            Statement s=conn.createStatement();
            ResultSet rs=s.executeQuery("select ename from emp");
            while (rs.next()){
                String name=rs.getString(1);
                System.out.println(name);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
