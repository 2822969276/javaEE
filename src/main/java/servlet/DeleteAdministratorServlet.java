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
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/DeleteAdministratorServlet")
public class DeleteAdministratorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");

        AdministratorDao administratorDao = new AdministratorDao();
        boolean flag = administratorDao.DeleteAdministratorByEmail(email);
        if (flag) {
            List<Administrator> administrators = administratorDao.getAllAdministrator();
            request.getSession().setAttribute("administrators",administrators);
            request.getRequestDispatcher("index.jsp").forward(request,response);
//            response.sendRedirect("index.jsp");
        } else {
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('删除失败！');");
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
