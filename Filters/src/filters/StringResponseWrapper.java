package filters;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class StringResponseWrapper extends HttpServletResponseWrapper {

//    private StringWriter stringWriter = null;
//
//    public StringResponseWrapper(ServletResponse servletResponse) {
//        super((HttpServletResponse) servletResponse);
//    }
//
//    public StringResponseWrapper(HttpServletResponse servletResponse){
//        super(servletResponse);
//    }
//
//    @Override
//    public PrintWriter getWriter() throws IOException {
//        if (stringWriter == null) {
//            stringWriter = new StringWriter();
//        }
//        return new PrintWriter(stringWriter);
//    }
//
//    public ServletOutputStream getOutputStream() throws IOException {
//        return super.getOutputStream();
//    }
//
//    public StringWriter getStringWriter() {
//        return stringWriter;
//    }

    private StringWriter stringWriter = null;

    public StringResponseWrapper(HttpServletResponse response) {
        super(response);
    }


    public PrintWriter getWriter() {
        if (stringWriter == null) stringWriter = new StringWriter();
        return new PrintWriter(stringWriter);
    }

    public ServletOutputStream getOutputStream() {
        throw new IllegalStateException(
                "getOutputStream() not allowed for StringResponseWrapper"
        );
    }

    public StringWriter getStringWriter() {
        return stringWriter;
    }
}
