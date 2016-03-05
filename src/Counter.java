import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

/**
 * by Amila
 * on 2/29/2016.
 */
public class Counter extends HttpServlet {

    public static final String countAttribute = "numberOfUsers";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer count = 0;
        ServletContext servletContext = request.getSession().getServletContext();
        Object nou = servletContext.getAttribute(countAttribute);
        if (!Objects.isNull(nou)) {
            count = (Integer) nou;
        }
        servletContext.setAttribute(countAttribute, ++count);

        PrintWriter printWriter = response.getWriter();
        printWriter.write(count.toString());
    }
}
