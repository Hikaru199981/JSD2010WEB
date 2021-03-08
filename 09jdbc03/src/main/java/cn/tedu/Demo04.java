package cn.tedu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 * 模拟用户注册
 */
public class Demo04 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名:");
        String username=sc.nextLine();
        System.out.println("请输入密码:");
        String password=sc.nextLine();

        //获取连接
        try (Connection conn=DBUtils.getConn()){
            Statement s=conn.createStatement();
            ResultSet rs=s.executeQuery(
                    "select id from user where username='"
                            +username+"';");
            if(rs.next()){ //满足条件说明查询到了
                System.out.println("用户名已存在!");
                return;
            }
            String sql="insert into user values(null,'"
                    +username+"','"+password+"');";
            //注意sql的String数据外围还有单引号
            s.executeUpdate(sql);
            System.out.println("注册成功!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
