package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 * 模拟用户登录
 * 使用预编译的SQL执行对象,解决SQL注入漏洞
 */
public class Demo05 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名:");
        String username=sc.nextLine();
        System.out.println("请输入密码:");
        //如果输入' or '1'='1 会出现bug
        String password=sc.nextLine();

        try(Connection conn=DBUtils.getConn()){
//            Statement s=conn.createStatement();
//            String sql="select username from user where username='"
//                    +username+"' and password='"+password+"';";
//            ResultSet rs=s.executeQuery(sql);

            //使用预编译的SQL执行对象,解决SQL注入漏洞
            String sql="select id from user where username=? and password=?";
            //此处sql语句将变量使用"?"替代,最后不能有";"
            //由于预编译的SQL执行对象提前将SQL语句的逻辑部分编译锁死,用户输入的
            //内容不会对原有逻辑造成改动,从而解决了SQL注入的问题
            PreparedStatement ps=conn.prepareStatement(sql);
            //替换"?"
            ps.setString(1,username);
            ps.setString(2,password);
            ResultSet rs=ps.executeQuery(); //这里千万不能在括号里写sql

            if(rs.next()){
                System.out.println("恭喜!登陆成功!");
            }else {
                System.out.println("登陆失败!用户名密码错误!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
