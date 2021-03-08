package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 * 获取预编译的sql对象的自增主键值
 */
public class Demo10 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("请输入用户名:");
        String username= scan.nextLine();
        try (Connection conn=DBUtils.getConn()){
            String sql="insert into user values(null,?,'abc')";
            PreparedStatement ps=conn.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
            //加参Statement.RETURN_GENERATED_KEYS
            ps.setString(1,username);
            ps.executeUpdate();
            //获取装着主键值的结果集
            ResultSet rs=ps.getGeneratedKeys();
            rs.next();
            int id=rs.getInt(1);
            System.out.println("执行完成!id="+id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
