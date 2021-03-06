package cn.tedu;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 数据库工具类。
 * 本类用于封装获取链接的代码，一面未来写错。
 */
public class DBUtils {
    public static Connection getConn() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver"); //未来换数据库需要修改此处的类名
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/newdb3?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true",
                "root","root");
        //此处url中的newdb3为目前需要使用的数据库名称，未来还可以再修改
        return conn;
    }
}
