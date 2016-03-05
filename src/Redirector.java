import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * by Amila
 * on 2/29/2016.
 */

public class Redirector extends HttpServlet {

    public static final String page = "Redirect";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getSession().setAttribute("userID", 12);
        response.sendRedirect(page + ".jsp");

        /*
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
        requestDispatcher.forward(request, response);
        */
    }
}
