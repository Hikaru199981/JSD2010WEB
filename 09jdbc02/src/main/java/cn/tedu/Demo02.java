package cn.tedu;

import java.sql.Connection;
import java.sql.Statement;

/**
 * 插入 1,诸葛亮,法师    2,孙尚香,射手
 */
public class Demo02 {
    public static void main(String[] args) {
        try (Connection conn=DBUtils.getConn();){
            Statement s=conn.createStatement();
            String sql=
                    "insert into hero values(1,'诸葛亮','法师'),(2,'孙尚香','射手')";
            s.executeUpdate(sql);
            System.out.println("修改完毕!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
