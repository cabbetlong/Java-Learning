import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/GetCookies")
public class GetCookies extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String title = "Get Cookies";
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"zh-CN\">");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>" + title + "</title>");
        out.println("</head>\n<body>\n<h1>Cookies:</h1>\n<table>\n<tr>\n" +
                "<th>Name</th>\n<th>Value</th>\n<th>Comment</th>\n" +
                "<th>Max Age</th>\n<th>Version</th>\n<th>Path</th>\n</tr>");

        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies) {
            out.println("<tr>");

            out.println("<td>" + c.getName() + "</td>");
            out.println("<td>" + c.getValue() + "</td>");
            out.println("<td>" + c.getComment() + "</td>");
            out.println("<td>" + c.getMaxAge() + "</td>");
            out.println("<td>" + c.getVersion() + "</td>");
            out.println("<td>" + c.getPath() + "</td>");
            out.println("</tr>");
        }
        out.println("</table>\n</body>\n</html>");
    }
}
