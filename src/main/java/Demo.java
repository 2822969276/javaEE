import utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Demo {
    public static void main(String[] args) {


        System.out.println(Demo.class);
//        Connection conn =null;
//        PreparedStatement ps=null;
//        ResultSet rs=null;
//
//        String sql = "select * from user";
//        try {
//            conn = DBUtils.getConnection();
//            ps = conn.prepareStatement(sql);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                String e=rs.getString(1);
//                String us = rs.getString(2);
//                String pass = rs.getString(3);
//                String id = rs.getString(4);
//                System.out.println(e);
//                System.out.println(us);
//                System.out.println(pass);
//                System.out.println(id);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally {
//            DBUtils.close(conn,ps,rs);
//        }
    }
}
