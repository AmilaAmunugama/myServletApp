import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * by Amila
 * on 2/29/2016.
 */

public class Redirector extends HttpServlet {

    public static final String page = "/Redirect.jsp";
    public static final String dateParam = "today";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat();
        dateFormat.applyPattern("YYYYMMDD");
        String date = dateFormat.format(currentDate);
        request.setAttribute(dateParam, date);
        request.getRequestDispatcher(page).forward(request, response);

    }
}
