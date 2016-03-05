import DTO.UserData;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

/**
 * by Amila
 * on 2/29/2016.
 */
public class ParamCatcher extends HttpServlet {

    public static final String id = "id";
    public static final String name = "name";
    public static final String sessionVariable = "userDTO";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter printWriter = response.getWriter();
        HttpSession session = request.getSession();

        UserData user = new UserData(request.getParameter(id), request.getParameter(name));

        if (!Objects.isNull(session.getAttribute(sessionVariable))) {
            UserData oldUserData = (UserData) session.getAttribute(sessionVariable);
            printWriter.println("old user = " + oldUserData.toString());
        }

        if (!user.toString().equals("")) {
            session.setAttribute(sessionVariable, user);
            printWriter.println("new user = " + user.toString());
        }
    }
}
