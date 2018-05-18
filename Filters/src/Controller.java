import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "add", urlPatterns = "/add.servlet")
public class Controller extends HttpServlet {
    private static final String operand1 = "operand1";
    private static final String operand2 = "operand2";

    public Controller() {}

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int param1 = Integer.parseInt(request.getParameter(operand1));
        int param2 = Integer.parseInt(request.getParameter(operand2));

        Model model = new Logic(param1, param2).getModel();

        ServletContext context = getServletContext();
        request.setAttribute("model", model);

        RequestDispatcher dispatcher = context.getRequestDispatcher("/result.servlet");
        dispatcher.forward(request, response);
    }

}