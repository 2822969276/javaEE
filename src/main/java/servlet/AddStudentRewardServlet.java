package servlet;

import Dao.StudentDao;
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

@WebServlet(urlPatterns = "/AddStudentRewardServlet")
public class AddStudentRewardServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String reward = request.getParameter("reward");

        StudentDao studentDao = new StudentDao();
        boolean flag = studentDao.updateStudentReward(email, reward);
        if (flag) {
            List<Student> students = studentDao.getAllStudent();
            HttpSession session = request.getSession();
            session.setAttribute("students", students);
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
