package cn.tedu;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 本类用于使用JDBC来增删改查数据库的数据
 * 单元测试，可以使用@Test在一个类中添加多个类似main方法的方法。
 * 需要导包org.junit.Test(Alt+insert自动下载并导包)
 * 点击左侧的播放即可使用。
 */
public class Demo03 {

    @Test
    public void test01() throws Exception {
        System.out.println("01");
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn= DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/newdb3?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true",
                "root","root"
        );
        Statement s=conn.createStatement();
        String sql=
                "insert into emp(empno,ename) values(101,'Tom');";
        s.executeUpdate(sql);
        conn.close();
        System.out.println("成功增加数据！");
    }
    @Test
    public void test02() throws Exception{
        System.out.println("02");
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn=DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/newdb3?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true",
                "root","root"
        );
        Statement s=conn.createStatement();
        String sql=
                "update emp set ename='Jerry' where ename='Tom';";
        s.executeUpdate(sql);
        conn.close();
        System.out.println("成功修改数据！");
    }
    @Test
    public void test03() throws Exception{
        System.out.println("03");
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn=DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/newdb3?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true",
                "root","root"
        );
        Statement s=conn.createStatement();
        String sql=
                "delete from emp where ename='Jerry'";
        s.executeUpdate(sql);
        conn.close();
        System.out.println("成功删除数据！");
    }
    @Test
    public void test04() throws Exception{
        System.out.println("04");
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn=DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/newdb3?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true",
                "root","root"
        );
        Statement s=conn.createStatement();
        String sql=
                "select * from emp";
        //执行查询SQL语句 ResultSet:结果集对象
        ResultSet rs=s.executeQuery(sql);
        //遍历结果集中的数据 通过字段名取出需要的数据
        while(rs.next()){
        //rs.next()返回一个boolean，表示有没有下一个元素，没有的话就遍历完成了
            String name=rs.getString("ename");
            double sal=rs.getDouble("sal");
            System.out.println(name+":"+sal);
        }
        conn.close();
    }
}
