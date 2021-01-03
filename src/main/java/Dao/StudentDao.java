package Dao;


import bean.Student;
import utils.DBUtils;

import java.util.List;

public class StudentDao {
    public List<Student> getAllStudent() {
        String sql = "select * from student";
        return DBUtils.getList(Student.class, sql,null);
    }

    public boolean addStudentEmailAndUsernameAndPassword(String email, String username, String password) {
        String sql = "insert into student(email,username,password)\n" +
                "values(?,?,?);";
        String sql1 = "insert into user(email,username,password,identity)" +
                "values(?,?,?,?)";
        return DBUtils.update(sql, email, username, password)&&DBUtils.update(sql1, email, username, password,"Student");
    }

    public boolean ModifyStudentEmailAndUsernameAndPassword(String email, String username, String password) {
        String sql = "update  student set username = ? , password = ? where email=?";
        String sql1 = "update user set username = ? , password = ? where email=?";
        return DBUtils.update(sql, username, password, email) && DBUtils.update(sql1, username, password, email);

    }

    public boolean DeleteStudentByEmail(String email) {
        String sql = "delete from  student  where email=?";
        String sql1 = "delete from  user  where email=?";
        return DBUtils.update(sql, email) && DBUtils.update(sql1, email);
    }


    public Student getSingleStudentByEmail(String email) {
        String sql = "select * from student where email=?";
        return DBUtils.getSingleObj(Student.class, sql, email);
    }

    public boolean updateStudentReward(String email, String reward) {

        String sql = "update  student set reward = ? where email=?";
        return DBUtils.update(sql,reward, email);
    }

    public boolean ModifyStudentReward(String email, String reward) {
        String sql = "update  student set reward = ? where email=?";
        return DBUtils.update(sql, reward, email);

    }

}
