package Dao;

import bean.Users;
import utils.DBUtils;

public class UsersDAO {

    public static boolean saveUser(Users users,String identity) {
        String sql = "insert into user(email,username,password,identity)" +
                "values(?,?,?,?)";
        String sql1 = null;
        if (identity.equals("SuperAdministrator")) {
            sql1 = "insert into superadministrator(email,username,password)" +
                    "values(?,?,?)";
        } else if (identity.equals("Administrator")) {
            sql1 = "insert into administrator(email,username,password)" +
                    "values(?,?,?)";
        } else if (identity.equals("Teacher")) {
            sql1 = "insert into teacher(email,username,password)" +
                    "values(?,?,?)";
        } else if (identity.equals("ClassAdministrator")) {
            sql1 = "insert into classadministrator(email,username,password)" +
                    "values(?,?,?)";
        } else {
            sql1 = "insert into student(email,username,password)" +
                    "values(?,?,?)";
        }
        return DBUtils.save(sql,users.getEmail(),users.getUsername(),users.getPassword(),users.getIdentity())&&
                DBUtils.save(sql1,users.getEmail(),users.getUsername(),users.getPassword());
    }

    public Integer selectUsersEmailCount(String email) {
        String sql = "select count(*) from user a where email = ?";
        Integer count = DBUtils.getCount(sql, email);
        return count;
    }

    public Users getUserByEmailAndPassword(String email, String password) {
        String sql = "select email,username,password,identity from user where email = ? and password=?";
        return DBUtils.getSingleObj(Users.class, sql, email, password);
    }
}
