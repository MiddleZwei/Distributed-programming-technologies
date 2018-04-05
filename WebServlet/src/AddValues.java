import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/add")
public class AddValues extends HttpServlet {

    private static final String COMPONENT1 = "component1";
    private static final String COMPONENT2 = "component2";

    private static final String INTEGER_PATTERN = "^[0-9]+$";
    private static final Pattern INTEGER_REGEX = Pattern.compile(INTEGER_PATTERN);


    private static int value(String input){
        Matcher matcher = INTEGER_REGEX.matcher(input);
        if (!matcher.matches())
            throw new NullPointerException("The match has not been found");
        return Integer.parseInt(input);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        serviceImpl(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        serviceImpl(request, response);
    }

    private void serviceImpl(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String component1Input = request.getParameter(COMPONENT1);
        String component2Input = request.getParameter(COMPONENT2);

        int component1 = value(component1Input);
        int component2 = value(component2Input);

        PrintWriter output = null;
        try {
            output = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int total = component1 + component2;
        output.print("total: " + total);
        output.close();
    }

    public static void main(String[] args) {

    }
}
