package cn.tedu;

import com.alibaba.druid.pool.DruidDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * 使用数据库连接池封装Connection对象。
 * 相关信息从jdbc.properties中读取。
 * 如果想要测试此类，只需看Demo01能否正常运行。
 */
public class DBUtils {
    private static DruidDataSource dds;
    static{
        //创建读取配置文件的属性对象
        Properties p=new Properties();
        //获取resource目录下的文件输入流
        InputStream ips=Demo03.class.getClassLoader()
                .getResourceAsStream("jdbc.properties");
        //让配置文件和属性对象建立关系 异常抛出
        try {
            p.load(ips);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //读取配置文件中的数据
        String driver=p.getProperty("db.driver");
        String url=p.getProperty("db.url");
        String username=p.getProperty("db.username");
        String password=p.getProperty("db.password");
        String maxActive=p.getProperty("db.maxActive");
        String initialSize=p.getProperty("db.initialSize");

        //创建数据库连接池对象
        dds=new DruidDataSource();
        //设置数据库连接信息
        dds.setDriverClassName(driver);
        dds.setUrl(url);
        dds.setUsername(username);
        dds.setPassword(password);
        dds.setInitialSize(Integer.parseInt(initialSize));//设置初始连接数量
        dds.setMaxActive(Integer.parseInt(maxActive));//设置最大连接数量
    }

    public static Connection getConn() throws Exception{
        //因为以上代码只需执行一次,所以放入静态块中;
        //只有获取连接是每次都需要重新做的,放在此处。
        Connection conn=dds.getConnection();
        return conn;
    }
}
