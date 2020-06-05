import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get init parameters from web.xml
        String name = this.getServletContext().getInitParameter("name");

        // Add some attributes into servlet context.
        ServletContext context = this.getServletContext();
        context.setAttribute("user1", "Frances");
        context.setAttribute("user2", "Bill");

        PrintWriter out = response.getWriter();
        out.println("<h1>InitParams: [name]: " + name + "</h1>");
    }
}
