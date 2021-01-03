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
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/SearchStudentServlet")
public class SearchStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");

        StudentDao studentDao = new StudentDao();
        if (email.equals("")||email==null) {
            List<Student> students = studentDao.getAllStudent();
            HttpSession session = request.getSession();
            session.setAttribute("students", students);
            request.getRequestDispatcher("学生基本信息管理.jsp").forward(request, response);
        } else {
            Student student = studentDao.getSingleStudentByEmail(email);
            List<Student> students = new ArrayList<Student>();
            students.add(student);
            request.getSession().setAttribute("students",students);
            request.getRequestDispatcher("学生基本信息管理.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
