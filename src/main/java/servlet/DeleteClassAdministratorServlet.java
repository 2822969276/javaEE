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
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/DeleteClassAdministratorServlet")
public class DeleteClassAdministratorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        ClassAdministratorDao classAdministratorDao = new ClassAdministratorDao();
        boolean flag = classAdministratorDao.DeleteClassAdministratorByEmail(email);
        if (flag) {
            List<ClassAdministrator> classAdministrators = classAdministratorDao.getAllClassAdministrator();
            request.getSession().setAttribute("classAdministrators",classAdministrators);
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
