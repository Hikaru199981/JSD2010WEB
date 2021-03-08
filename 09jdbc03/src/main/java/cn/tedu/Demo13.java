package cn.tedu;

import java.sql.*;

/**
 * 数据库&表相关元数据的获取
 */
public class Demo13 {
    public static void main(String[] args) {
        //元数据:数据库元数据 表相关元数据
        try (Connection conn=DBUtils.getConn()){
            //获取数据库元数据
            DatabaseMetaData dmd=conn.getMetaData();
            System.out.println("数据库名:"+dmd.getDatabaseProductName());
            System.out.println("数据库url:"+dmd.getURL());
            System.out.println("数据库驱动名:"+dmd.getDriverName());
            System.out.println("数据库用户名:"+dmd.getUserName());
            //获取表的元数据 需要先写查询
            String sql="select * from emp";
            Statement s=conn.createStatement();
            ResultSet rs=s.executeQuery(sql);
            //获取表相关元数据
            ResultSetMetaData rsmd=rs.getMetaData();
            int count=rsmd.getColumnCount(); //获取表字段数量
            //遍历每一个表字段的名称和类型
            for(int i=0;i<count;i++){
                String name=rsmd.getColumnName(i+1); //字段名
                String type=rsmd.getColumnTypeName(i+1); //类型
                System.out.println(name+":"+type);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
