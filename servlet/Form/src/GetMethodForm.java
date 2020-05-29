import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet(name = "GetMethodForm")
public class GetMethodForm extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        * <!DOCTYPE html>
        <html>
        <body>
        <h1>Get方法获取表单</h1>
        <p>First name: </p>
        <p>Last name: </p>
        </body>
        </html>
        * */
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        PrintWriter out = response.getWriter();

        String title = "Get方法获取表单";
        String docType = "<!DOCTYPE html";
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");

        String display = docType + "<html>\n<body>\n<h1 align=\"center\">" + title
                + "</h1>\n<p>First name: " + firstName
                + "</p>\n<p>Last name: " + lastName + "</p>\n</body></html>";

        out.write(display);
    }
}
