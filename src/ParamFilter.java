import javax.servlet.*;
import java.io.IOException;
import java.util.Objects;

/**
 * by Amila
 * on 3/5/2016.
 */
public class ParamFilter implements Filter {

    public static final String id = "id";
    public static final String name = "name";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String idParam = servletRequest.getParameter(id);
        String nameParam = servletRequest.getParameter(name);
        if (!Objects.isNull(idParam) && !Objects.isNull(nameParam)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            String errorMessage = String.format("Include '%s' and '%s' parameters in the request", id, name);
            servletResponse.getWriter().println(errorMessage);
        }

    }

    @Override
    public void destroy() {

    }
}
