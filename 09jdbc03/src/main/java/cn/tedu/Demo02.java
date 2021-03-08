package cn.tedu;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 数据库连接池的使用
 */
public class Demo02 {
    public static void main(String[] args) throws SQLException {
        //创建数据库连接池对象
        DruidDataSource dds=new DruidDataSource();
        //设置数据库连接信息
        dds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dds.setUrl("jdbc:mysql://localhost:3306/newdb3?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true");
        dds.setUsername("root");
        dds.setPassword("root");
        //设置初始连接数量
        dds.setInitialSize(3);
        //设置最大连接数量
        dds.setMaxActive(5);
        //获取连接 异常抛出
        Connection conn=dds.getConnection();
        System.out.println(conn);
    }
}
