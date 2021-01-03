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
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/AddTeacherServlet")
public class AddTeacherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        TeacherDao teacherDao = new TeacherDao();
        boolean flag = teacherDao.addTeacherEmailAndUsernameAndPassword(email, username, password);
        if (flag) {
            List<Teacher> teachers = teacherDao.getAllTeacher();
            request.getSession().setAttribute("teachers",teachers);
            request.getRequestDispatcher("index.jsp").forward(request,response);
//            response.sendRedirect("index.jsp");
        } else {
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('添加失败！');");
            writer.write("window.location.href = '/javaweb/jsp/index.html'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
