package servlet;

import Dao.ClassAdministratorDao;
import Dao.TeacherDao;
import bean.ClassAdministrator;
import bean.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/SearchTeacherServlet")
public class SearchTeacherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");

        TeacherDao teacherDao = new TeacherDao();
        if (email.equals("")||email==null) {
            List<Teacher> teachers = teacherDao.getAllTeacher();
            request.getSession().setAttribute("teachers",teachers);
            request.getRequestDispatcher("老师基本信息管理.jsp").forward(request, response);
        } else {
            Teacher teacher = teacherDao.getSingleTeacher(email);
            List<Teacher> teachers = new ArrayList<Teacher>();
            teachers.add(teacher);
            request.getSession().setAttribute("teachers",teachers);
            request.getRequestDispatcher("老师基本信息管理.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
