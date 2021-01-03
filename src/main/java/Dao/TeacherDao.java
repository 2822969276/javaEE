package Dao;

import bean.ClassAdministrator;
import bean.Teacher;
import utils.DBUtils;

import java.util.List;

public class TeacherDao {
    public List<Teacher> getAllTeacher() {

        String sql = "select * from teacher";
        return DBUtils.getList(Teacher.class, sql,null);
    }

    public boolean addTeacherEmailAndUsernameAndPassword(String email, String username, String password) {

        String sql = "insert into teacher(email,username,password)\n" +
                "values(?,?,?);";
        String sql1 = "insert into user(email,username,password,identity)" +
                "values(?,?,?,?)";
        return DBUtils.update(sql, email, username, password)&&DBUtils.update(sql1, email, username, password,"Teacher");
    }

    public boolean ModifyTeacherEmailAndUsernameAndPassword(String email, String username, String password) {

        String sql = "update  teacher set username = ? , password = ? where email=?";
        String sql1 = "update user set username = ? , password = ? where email=?";
        return DBUtils.update(sql, username, password, email) && DBUtils.update(sql1, username, password, email);
    }

    public boolean DeleteTeacherByEmail(String email) {

        String sql = "delete from  teacher  where email=?";
        String sql1 = "delete from  user  where email=?";
        return DBUtils.update(sql, email) && DBUtils.update(sql1, email);
    }

    public Teacher getSingleTeacher(String email) {

        String sql = "select * from teacher where email=?";
        return DBUtils.getSingleObj(Teacher.class, sql, email);
    }
}
