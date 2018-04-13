import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/result")
public class View extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Model model = (Model)request.getAttribute("model");
        PrintWriter writer = response.getWriter();
        String cssTag = "<head><link rel='stylesheet' type='text/css' href='theme.css'></head>";
        writer.println(cssTag);
        writer.println("result: "+model.getResult());
        writer.close();
    }
}