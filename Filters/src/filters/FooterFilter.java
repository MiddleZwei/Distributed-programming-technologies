package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@WebFilter(urlPatterns = { "*.servlet", "*.html" },
        dispatcherTypes = { DispatcherType.REQUEST }
        )
public class FooterFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse previousResponse, FilterChain filterChain) throws IOException, ServletException {


        StringResponseWrapper newResp = new StringResponseWrapper((HttpServletResponse) previousResponse);

        filterChain.doFilter(servletRequest, newResp);

        StringWriter sw = newResp.getStringWriter();
        String cont = sw.toString();
        PrintWriter out = previousResponse.getWriter();
        out.println(cont);

        Locale locale = servletRequest.getLocale();
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.MEDIUM, locale);

        out.println("<hr><i><b>" + df.format(new Date()) + "</i></b>");
        out.close();


    }

    @Override
    public void destroy() {}
}
