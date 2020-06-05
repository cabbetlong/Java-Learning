import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/SetCookies")
public class SetCookies extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie myFirstCookie = new Cookie("MyFirstCookie", "1");
        myFirstCookie.setComment("This is a comment.");
        myFirstCookie.setMaxAge(24*60*60); // 1 day
        myFirstCookie.setVersion(1);

        // set path to make it accessible only to this servlet, GetCookies page cannot get this cookies because of this attribute
        myFirstCookie.setPath("/SetCookies");
        response.addCookie(myFirstCookie); // adding cookie to this response

        Cookie mySecondCookie = new Cookie("MySecondCookie", "2");
        mySecondCookie.setComment("This is also a comment.");
        mySecondCookie.setMaxAge(48*60*60); // 1 day
        mySecondCookie.setVersion(2);
        response.addCookie(mySecondCookie); // adding cookie to this response

        PrintWriter out = response.getWriter();
        out.println("<h1 style=\"color: blue;\">Set cookies successfully!</h1>");
    }
}
