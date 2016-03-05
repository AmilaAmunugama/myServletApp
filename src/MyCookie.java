import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * by Amila
 * on 2/29/2016.
 */
public class MyCookie extends HttpServlet {

    public static final String cookieName = "myCookie";
    public static final String sessionCookie = "JSESSIONID";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter printWriter = response.getWriter();
        Cookie[] cookies = request.getCookies();
        if (cookies == null || cookies.length == 0) {
            printWriter.println("No cookies");
        } else {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(sessionCookie)) {
                    continue;
                }
                String output = String.format("Cookie Found, name = %s and value = %s", cookie.getName(), cookie.getValue());
                printWriter.println(output);
            }
        }

        Cookie newCookie = new Cookie(cookieName, (new Date()).toString());
        response.addCookie(newCookie);
    }
}
