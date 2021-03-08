package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 * 再次练习Demo05
 */
public class Demo055 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名:");
        String username=sc.nextLine();
        System.out.println("请输入密码:");
        String password=sc.nextLine();

        try(Connection conn=DBUtils.getConn()){
            String sql="select id from user where username=? and password=?;";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                System.out.println("登陆成功!");
            }else{
                System.out.println("登陆失败!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
