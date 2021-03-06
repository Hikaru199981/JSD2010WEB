package cn.tedu;

import java.sql.Connection;
import java.sql.Statement;

/**
 * 创建hero表  有id,name,type字段
 */
public class Demo01 {
    public static void main(String[] args) {
        try (Connection conn=DBUtils.getConn()){
            Statement s=conn.createStatement();
            String sql=
                    "create table hero(id int,name varchar(10),type varchar(10))";
            s.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
