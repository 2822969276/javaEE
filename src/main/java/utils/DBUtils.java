package utils;

import bean.Administrator;
import bean.Users;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.beanutils.BeanUtils;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.sql.Date;
import java.util.*;

public class DBUtils {
    public static Connection getConnection() throws Exception {
        //读取配置文件
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("utils/db.properties");
        Properties properties = new Properties();
        properties.load(in);

        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        return dataSource.getConnection();
    }

    public static void close(Connection conn, Statement ps, ResultSet rs) {
        if(rs != null){

            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(ps != null){

            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn != null){

            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static Integer getCount(String sql, Object...args) {
        Connection conn =null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Integer count=null;

        try {
            conn = DBUtils.getConnection();
            ps=conn.prepareStatement(sql);

            if (args != null && args.length > 0) {
                for (int i = 0; i < args.length; i++) {
                    ps.setObject(i+1,args[i]);
                }
            }

            rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn,ps,rs);
        }
        return count;
    }

    public static boolean save(String sql, Object...args) {
        Connection conn =null;
        PreparedStatement ps=null;
        Integer count = null;

        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);

            if (args != null && args.length > 0) {

                for (int i = 0; i < args.length; i++) {

                    ps.setObject(i+1,args[i]);

                }
            }
//            返回更新的记录数
            count = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn,ps,null);
        }
        return count!=null&&count>0?true:false;
    }
    public static boolean update(String sql, Object...args) {
        Connection conn =null;
        PreparedStatement ps=null;
        Integer count = null;
        ResultSet rs = null;

        try {
//        Connection connection1 = getConnection();

            conn = DBUtils.getConnection();
            ps=conn.prepareStatement(sql);


            if (args != null && args.length > 0) {
                for (int i = 0; i < args.length; i++) {
                    ps.setObject(i+1,args[i]);

                }
            }

            count = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, rs);
        }
        return count!=null&&count>0?true:false;


    }
    public static <T> T getSingleObj(Class<T> clazz, String sql, Object... args) {
        T bean = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);

            if (args != null && args.length > 0) {
                for (int i = 0; i < args.length; i++) {
                    ps.setObject(i+1,args[i]);

                }
            }

            rs= ps.executeQuery();

//        获取结果集的元数据
            ResultSetMetaData rsmd=rs.getMetaData();
//        获取当前结果集的列数
            int colnum = rsmd.getColumnCount();

            while(rs.next()){

                //key存放列名，value存放列值，for循环完成之后，rowMap存放了一条记录
                Map<String, Object> rowMap = new HashMap<String, Object>();
                for(int i = 1; i<=colnum;i++){
                    String columName = rsmd.getColumnLabel(i);
                    Object columValue = rs.getObject(columName);
                    rowMap.put(columName, columValue);

                }
                //创建一个User对象，给这个User对象属性赋值
                bean = clazz.newInstance();

                //          clazz  User.class字节码文件
                //            Class<User> clazz = User.class;

                //            根据列名，id  ==  给User对象 id属性赋值的方法名，setId，“set”+Id = setId，调用setId方法给user对象赋值，map中的value
                //            循环rowMap给User所有属性赋值 entry{key,value} [{"id":1},{username:"king"},{"birthday":"2020-06-06"}]
                for (Map.Entry<String, Object> entry : rowMap.entrySet()) {

                    String propertyName = entry.getKey();
                    Object propertyValue = entry.getValue();

                    /*//            获取给propertyName属性赋值的set方法     //setId
                    String methodName = "set" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
    //                对象获取自己类对应的字节码文件   User.class  user.getClass() Object
                    Method method = clazz.getMethod(methodName,propertyValue.getClass());
    //                调用方法给属性赋值
                    method.invoke(bean, propertyValue);
    */
                    BeanUtils.setProperty(bean,propertyName,propertyValue);


                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn,ps,rs);
        }
        return bean;
    }
    //    类型参数，类型变量，类型是可以变化   Teacher     Student
    public static <T> List<T> getList(Class<T> clazz, String sql, Object...args)  {
        List<T> userList= null;
        Connection conn =null;
        PreparedStatement ps=null;
        ResultSet rs=null;

        try {
//        Connection connection1 = getConnection();

            conn = DBUtils.getConnection();
//        String sql="select id,username,birthday from users where id = ? and username = ?";
            ps=conn.prepareStatement(sql);


            if (args != null && args.length > 0) {
                for (int i = 0; i < args.length; i++) {
                    ps.setObject(i+1,args[i]);

                }
            }


            rs= ps.executeQuery();

//        获取结果集的元数据
            ResultSetMetaData rsmd=rs.getMetaData();
//        获取当前结果集的列数
            int colnum = rsmd.getColumnCount();


            userList = new ArrayList<T>();

            while(rs.next()){

                //key存放列名，value存放列值，for循环完成之后，rowMap存放了一条记录
                Map<String, Object> rowMap = new HashMap<String, Object>();
                for(int i = 1; i<=colnum;i++){
                    String columName = rsmd.getColumnLabel(i);
                    Object columValue = rs.getObject(columName);
                    rowMap.put(columName, columValue);

                }
                //创建一个User对象，给这个User对象属性赋值
                T bean = clazz.newInstance();
//                User user = new User();
                //          clazz  User.class字节码文件
                //            Class<User> clazz = User.class;

                //            根据列名，id  ==  给User对象 id属性赋值的方法名，setId，“set”+Id = setId，调用setId方法给user对象赋值，map中的value
                //            循环rowMap给User所有属性赋值 entry{key,value} [{"id":1},{username:"king"},{"birthday":"2020-06-06"}]
                for (Map.Entry<String, Object> entry : rowMap.entrySet()) {

                    String propertyName = entry.getKey();
                    Object propertyValue = entry.getValue();

                    /*//            获取给propertyName属性赋值的set方法     //setId
                    String methodName = "set" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
    //                对象获取自己类对应的字节码文件   User.class  user.getClass() Object
                    Method method = clazz.getMethod(methodName,propertyValue.getClass());
    //                调用方法给属性赋值
                    method.invoke(bean, propertyValue);
    */
                    BeanUtils.setProperty(bean,propertyName,propertyValue);


                }

                userList.add(bean);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, rs);
        }
        return userList;
    }


}
