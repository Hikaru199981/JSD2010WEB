package cn.tedu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 此类用于测试使用DBUtils获取Connection的方法
 */
public class Demo04 {
    public static void main(String[] args) {
        try (
                Connection conn=DBUtils.getConn();
                //JDK7以后，需要设置好JDK版本，否则会报错
        ){
            Statement s=conn.createStatement();
            //查询数据时只查询有用的字段数据
            ResultSet rs=s.executeQuery("select ename,sal from emp;");
            while (rs.next()){
                //通过字段名获取数据
//                String name=rs.getString("ename");
//                double sal=rs.getDouble("sal");
//                System.out.println(name+":"+sal);

                //通过字段的位置获取数据
                String name=rs.getString(1); //此处下标从1开始
                double sal=rs.getDouble(2);
                System.out.println(name+":"+sal);
            }
        } catch (Exception e) { //此处不要抛异常，要catch
            e.printStackTrace();
        }
    }
}
