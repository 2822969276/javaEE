package Dao;

import bean.Administrator;
import bean.Teacher;
import bean.Users;
import utils.DBUtils;

import java.util.List;

public class AdministratorDao {

    public List<Administrator> getAllAdministrator() {

        String sql = "select * from administrator";
        return DBUtils.getList(Administrator.class, sql,null);
    }

    public boolean addAdministratorEmailAndUsernameAndPassword(String email, String username, String password) {

        String sql = "insert into administrator(email,username,password)\n" +
                "values(?,?,?);";
        String sql1 = "insert into user(email,username,password,identity)" +
                "values(?,?,?,?)";
        return DBUtils.update(sql, email, username, password)&&DBUtils.update(sql1, email, username, password,"Administrator");
    }

    public boolean ModifyAdministratorEmailAndUsernameAndPassword(String email, String username, String password) {

        String sql = "update  administrator set username = ? , password = ? where email=?";
        String sql1 = "update user set username = ? , password = ? where email=?";
        return DBUtils.update(sql, username, password, email) && DBUtils.update(sql1, username, password, email);
    }

    public boolean DeleteAdministratorByEmail(String email) {

        String sql = "delete from  administrator  where email=?";
        String sql1 = "delete from  user  where email=?";
        return DBUtils.update(sql, email) && DBUtils.update(sql1, email);
    }

    public Administrator getSingleAdministrator(String email) {

        String sql = "select * from administrator where email=?";
        return DBUtils.getSingleObj(Administrator.class, sql, email);
    }
}
