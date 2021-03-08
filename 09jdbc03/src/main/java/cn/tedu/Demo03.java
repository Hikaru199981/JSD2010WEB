package cn.tedu;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 演示读取resource中的.properties文件的方法
 */
public class Demo03 {
    public static void main(String[] args) throws IOException {
        //创建读取配置文件的属性对象
        Properties p=new Properties();
        //获取resource目录下的文件输入流
        InputStream ips=Demo03.class.getClassLoader()
                .getResourceAsStream("my.properties");
        //让配置文件和属性对象建立关系 异常抛出
        p.load(ips);
        //读取配置文件中的数据
        String name=p.getProperty("name");
        //属性配置文件中只能获取出字符串类型
        String age=p.getProperty("age");
        System.out.println(name+":"+age);
    }
}
