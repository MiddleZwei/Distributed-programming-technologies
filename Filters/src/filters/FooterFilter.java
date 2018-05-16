package filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

//@WebFilter(filterName = "footer",
//        urlPatterns = { "*.servlet" },
//        dispatcherTypes = { DispatcherType.REQUEST, DispatcherType.FORWARD })
public class FooterFilter implements Filter {

    public static final String FOOTER_CONTENT = "<div id=\"date\">Ama yo foota bae</div>";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse previousResponse, FilterChain filterChain) throws IOException, ServletException {
//        StringResponseWrapper wrapperResponse = new StringResponseWrapper(previousResponse);
//        filterChain.doFilter(servletRequest, previousResponse); // forward the response to the next filter in the chain
//        appendServletGeneratedResponse(previousResponse, wrapperResponse);
//        appendFooter(servletRequest, previousResponse);



        Locale locale = servletRequest.getLocale();
        StringResponseWrapper newResp = new StringResponseWrapper(
                (HttpServletResponse) previousResponse
        );
        filterChain.doFilter(servletRequest, newResp);
        StringWriter sw = newResp.getStringWriter();

        // Uzyskujemy treść wygenrowanej odpowiedzi
        String cont = sw.toString();

        // Teraz możemy zrobić cokolwiek z odpowiedzią
        // tu tylko dopiszemy do niej "stopkę"

        // Bierzemy strumień oryginalnej odpowiedzi
        PrintWriter out = previousResponse.getWriter();

        // Przepisujemy otrzymaną odpowiedź
        out.println(cont);

        // Dopisujemy stopkę
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.LONG,
                DateFormat.MEDIUM,
                locale);

        out.println("<hr><i><b>" + df.format(new Date()) + "</i></b>");
        out.close();



    }

    private void appendFooter(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException {
        PrintWriter writer = servletResponse.getWriter();
        writer.println(FOOTER_CONTENT);
        writer.close();
    }

    private void appendServletGeneratedResponse(ServletResponse servletResponse, StringResponseWrapper wrapperResponse) throws IOException {
        StringWriter wrapperResponseWriter = wrapperResponse.getStringWriter();
        String servletGeneratedResponse = wrapperResponseWriter.toString();
        PrintWriter originalResponseWriter = servletResponse.getWriter();
        originalResponseWriter.print(servletGeneratedResponse);
    }

    @Override
    public void destroy() {

    }
}
