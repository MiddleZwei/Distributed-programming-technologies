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

    private static final String component1 = "component1";
    private static final String component2 = "component2";

    private static final String pattern = "^[0-9]+$";
    private static final Pattern regex = Pattern.compile(pattern);


    private static int getValue(String input){
        Matcher matcher = regex.matcher(input);
        if (!matcher.matches())
            throw new NullPointerException("The match has not been found");
        return Integer.parseInt(input);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        serviceImpl(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        serviceImpl(request, response);
    }

    private void serviceImpl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String input1 = request.getParameter(component1);
        String input2 = request.getParameter(component2);

        int comp1 = getValue(input1);
        int comp2 = getValue(input2);


        PrintWriter output = response.getWriter();

        int sum = comp1 + comp2;
        output.print("The sum: " + sum);
        output.close();
    }
}
