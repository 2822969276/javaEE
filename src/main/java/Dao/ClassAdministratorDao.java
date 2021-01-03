package Dao;

import bean.ClassAdministrator;
import bean.Student;
import utils.DBUtils;

import java.util.List;

public class ClassAdministratorDao {
    public List<ClassAdministrator> getAllClassAdministrator() {

        String sql = "select * from classadministrator";
        return DBUtils.getList(ClassAdministrator.class, sql,null);
    }

    public boolean addClassAdministratorEmailAndUsernameAndPassword(String email, String username, String password) {

        String sql = "insert into classadministrator(email,username,password)\n" +
                "values(?,?,?);";
        String sql1 = "insert into user(email,username,password,identity)" +
                "values(?,?,?,?)";
        return DBUtils.update(sql, email, username, password)&&DBUtils.update(sql1, email, username, password,"ClassAdministrator");
    }

    public boolean ModifyClassAdministratorEmailAndUsernameAndPassword(String email, String username, String password) {

        String sql = "update  classadministrator set username = ? , password = ? where email=?";
        String sql1 = "update user set username = ? , password = ? where email=?";
        return DBUtils.update(sql, username, password, email) && DBUtils.update(sql1, username, password, email);
    }

    public boolean DeleteClassAdministratorByEmail(String email) {

        String sql = "delete from  classadministrator  where email=?";
        String sql1 = "delete from  user  where email=?";
        return DBUtils.update(sql, email) && DBUtils.update(sql1, email);
    }

    public ClassAdministrator getSingleClassAdministrator(String email) {

        String sql = "select * from classadministrator where email=?";
        return DBUtils.getSingleObj(ClassAdministrator.class, sql, email);
    }
}
