package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 * 案例演示获取自增主键值的作用.
 * 使用球员&球队表
 */
public class Demo11 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入球队名称:");
        String teamName=scanner.nextLine();
        System.out.println("请输入球员名称:");
        String playerName=scanner.nextLine();
        //获取连接
        try(Connection conn=DBUtils.getConn()){
            //1.把得到的球队名保存到球队表中 同时获取出自增id
            String sql="insert into team values(null,?)";
            PreparedStatement ps=conn.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,teamName);
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            rs.next();
            int id=rs.getInt(1);
            System.out.println("id:"+id);
            //2.把球员名和球队自增的id一起保存到球员表中
            String pSql="insert into player values (null,?,?)";
            //这里需要新建一个变量储存sql语句,否则后面的ps还是默认读取第一个sql
            PreparedStatement pps=conn.prepareStatement(pSql);
            pps.setString(1,playerName);
            pps.setInt(2,id);
            pps.executeUpdate();
            System.out.println("创建完成!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
