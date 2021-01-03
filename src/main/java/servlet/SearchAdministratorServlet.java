package servlet;

import Dao.AdministratorDao;
import Dao.TeacherDao;
import bean.Administrator;
import bean.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/SearchAdministratorServlet")
public class SearchAdministratorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");

        AdministratorDao administratorDao = new AdministratorDao();
        if (email.equals("")||email==null) {
            List<Administrator> administrators = administratorDao.getAllAdministrator();
            request.getSession().setAttribute("administrators",administrators);
            request.getRequestDispatcher("管理员基本信息管理.jsp").forward(request, response);
        } else {
            Administrator administrator = administratorDao.getSingleAdministrator(email);
            List<Administrator> administrators = new ArrayList<Administrator>();
            administrators.add(administrator);
            request.getSession().setAttribute("administrators",administrators);
            request.getRequestDispatcher("管理员基本信息管理.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
