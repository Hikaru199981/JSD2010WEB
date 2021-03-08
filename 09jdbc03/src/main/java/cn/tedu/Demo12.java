package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 * 使用球员&球队表
 * 在判断球队队名不重复之后再进行添加
 */
public class Demo12 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入球队名称:");
        String teamName=scanner.nextLine();
        System.out.println("请输入球员名称:");
        String playerName=scanner.nextLine();
        //获取连接
        try(Connection conn=DBUtils.getConn()){
            //1.查询是否存在球队
            String sql="select id from team where name=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,teamName);
            ResultSet rs=ps.executeQuery();
            int teamId;
            if(rs.next()){
                //满足条件说明有球队
                teamId=rs.getInt(1);
            }else {
                //没有球队,添加球队
                String tSql="insert into team values(null,?)";
                PreparedStatement tps=conn.prepareStatement(tSql,
                        Statement.RETURN_GENERATED_KEYS);
                tps.setString(1,teamName);
                tps.executeUpdate();
                ResultSet trs=tps.getGeneratedKeys();
                trs.next();
                teamId=trs.getInt(1);
            }
            //2.保存球员
            String pSql="insert into player values(null,?,?)";
            PreparedStatement pps=conn.prepareStatement(pSql,
                    Statement.RETURN_GENERATED_KEYS);
            pps.setString(1,playerName);
            pps.setInt(2,teamId);
            pps.executeUpdate();
            System.out.println("操作完成!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
