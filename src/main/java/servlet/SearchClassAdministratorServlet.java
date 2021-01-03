package servlet;

import Dao.ClassAdministratorDao;
import Dao.StudentDao;
import bean.ClassAdministrator;
import bean.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/SearchClassAdministratorServlet")
public class SearchClassAdministratorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");

        ClassAdministratorDao classAdministratorDao = new ClassAdministratorDao();
        if (email.equals("")||email==null) {
            List<ClassAdministrator> classAdministrators = classAdministratorDao.getAllClassAdministrator();
            request.getSession().setAttribute("classAdministrators",classAdministrators);
            request.getRequestDispatcher("班级管理员基本信息管理.jsp").forward(request, response);
        } else {
            ClassAdministrator classAdministrator = classAdministratorDao.getSingleClassAdministrator(email);
            List<ClassAdministrator> classAdministrators = new ArrayList<ClassAdministrator>();
            classAdministrators.add(classAdministrator);
            request.getSession().setAttribute("classAdministrators",classAdministrators);
            request.getRequestDispatcher("班级管理员基本信息管理.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
