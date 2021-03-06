package cn.tedu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * 苯类用于演示JDBC的使用方式。
 * JDBC:Java DataBase Connectivity
 */
public class Demo01 {
    public static void main(String[] args) throws Exception {
        /*
           1.注册驱动
           2.获取数据库连接
           3.创建执行SQL语句对象
           4.执行SQL语句
           5.关闭资源
         */
        //1.注册驱动:告诉编译器使用的是哪个数据库
        Class.forName("com.mysql.cj.jdbc.Driver"); //未来换数据库需要修改此处的类名

        //2.获取数据库连接
        // url:连接数据库的路径(来自于 jdbc.properties) user:用户名 password:密码
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/newdb3?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true",
                "root","root");
//        System.out.println(conn); //输出检查一下配置有没有问题

        //3.创建执行SQL语句对象
        Statement s= conn.createStatement();
        //4.执行SQL语句
        String sql=
                "create table jdbct1(id int,name varchar(10));";
        s.execute(sql); //执行
        //5.关闭资源
        conn.close();
    }
}
