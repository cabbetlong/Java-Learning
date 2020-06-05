import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 模拟一个登陆页面，熟悉POST获取表单的用法
 */
@WebServlet(
        description = "Login Servlet",
        urlPatterns = "/login", // 这里的效果与在web.xml中指定url-pattern标签一样
        initParams = { // 定义一些初始化参数，通过 getServletConfig().getInitparameter()函数获取
                @WebInitParam(name = "user", value = "cabbet"),
                @WebInitParam(name = "password", value = "123")
        })
public class PostMethodForm extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");

        String userID = getServletConfig().getInitParameter("user");
        String password = getServletConfig().getInitParameter("password");

        if (userID.equals(user) && password.equals(pwd)) {
            response.sendRedirect("LoginSuccess.jsp"); // 重定向到登陆成功页面
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
            PrintWriter out = response.getWriter();
            out.println("<font color=red>用户名或密码错误！</font>");
            rd.include(request, response); // 在登陆页面输出提示信息
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
