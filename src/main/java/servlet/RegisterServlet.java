package servlet;

import Dao.UsersDAO;
import bean.Users;
import utils.DBUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet(urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        //获取请求参数email
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String identity = request.getParameter("identity");

        if (email.equals("")||identity==null) {
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('邮箱地址或者身份选择不能为空！');");
            writer.write("window.location.href = '/javaweb/jsp/index.html'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        } else {
            //        对数据封装成一个对象
            Users users = new Users(email, username, password, identity);

//       对Users进行操作
            UsersDAO usersDAO = new UsersDAO();
            Integer count = usersDAO.selectUsersEmailCount(email);

            if (count > 0) {
//            数据库中已经有相同的email用户了
//            通过response对象给客户端一个错误提示
                PrintWriter writer = response.getWriter();
                writer.write("<script>");
                writer.write("alert('申请的email已经被占用了！');");
                writer.write("window.location.href = '/javaweb/jsp/index.html'");
                writer.write("</script>");
                writer.flush();
                writer.close();
            } else {
                boolean flag = UsersDAO.saveUser(users,identity);

                if (flag) {
                    response.sendRedirect("/javaweb/jsp/index.html");
                } else {
                    request.getRequestDispatcher("/javaweb/jsp/index.jsp").forward(request,response);
                }

            }
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
