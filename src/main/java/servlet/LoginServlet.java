package servlet;

import Dao.*;
import bean.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/LoginServlet")
public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UsersDAO usersDAO = new UsersDAO();
        Users user = usersDAO.getUserByEmailAndPassword(email, password);


        if (user != null && user.getIdentity().equals("SuperAdministrator")) {
            StudentDao studentDao = new StudentDao();
            List<Student> students = studentDao.getAllStudent();
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            session.setAttribute("students",students);

            ClassAdministratorDao classAdministratorDao = new ClassAdministratorDao();
            List<ClassAdministrator> classAdministrators = classAdministratorDao.getAllClassAdministrator();
            request.getSession().setAttribute("classAdministrators",classAdministrators);

            TeacherDao teacherDao = new TeacherDao();
            List<Teacher> teachers = teacherDao.getAllTeacher();
            request.getSession().setAttribute("teachers",teachers);

            AdministratorDao administratorDao = new AdministratorDao();
            List<Administrator> administrators = administratorDao.getAllAdministrator();
            request.getSession().setAttribute("administrators",administrators);
            response.sendRedirect("index.jsp");
        } else {
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('用户名或者密码错误！');");
            writer.write("window.location.href = '/javaweb/jsp/index.html'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }
}
