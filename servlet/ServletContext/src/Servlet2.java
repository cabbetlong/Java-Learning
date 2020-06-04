import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        Enumeration<String> contextAttrNames = context.getAttributeNames();

        PrintWriter out = response.getWriter();

        // According to the result, there are some default attributes in servlet context
        while (contextAttrNames.hasMoreElements()) {
            String name = contextAttrNames.nextElement();
            out.println("<p>name: " + name + ", value: " + context.getAttribute(name) +"</p>");
        }
    }
}
