
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class Controller extends HttpServlet {
    private static final String operand1 = "operand1";
    private static final String operand2 = "operand2";

    public Controller() {}

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int param1 = Integer.parseInt(request.getParameter(operand1));
        int param2 = Integer.parseInt(request.getParameter(operand2));
        System.out.println("Params: "+ param1 + ", "+ param2);

        Model model = new Logic(param1, param2).getModel();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        System.out.println("Result from model:" + model.getResult());
        response.getWriter().write(Integer.toString(model.getResult()));

//        ServletContext context = getServletContext();
//        request.setAttribute("model", model);

//        RequestDispatcher dispatcher = context.getRequestDispatcher("/result");
//        dispatcher.forward(request, response);
    }

}