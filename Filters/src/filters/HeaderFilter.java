package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(
        urlPatterns = { "*.servlet", "*.html" },
        dispatcherTypes = { DispatcherType.REQUEST })
public class HeaderFilter implements Filter {

    public static final String HEADER = "<link rel='stylesheet' type='text/css' href='theme.css'>";

    @Override
    public void init(FilterConfig filterConfig) {}

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        PrintWriter writer = servletResponse.getWriter();
        writer.write(HEADER);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {}
}
