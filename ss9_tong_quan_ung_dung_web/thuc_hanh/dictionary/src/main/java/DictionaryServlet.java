import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "DictionaryServlet", urlPatterns = "/dictionary")
public class DictionaryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String txtSearch = request.getParameter("txtSearch");
        Map<String, String> map = new HashMap<>();
        map.put("hello", "Xin chào");
        map.put("how", "Thế nào");
        map.put("book", "Quyển vở");
        map.put("computer", "Máy tính");
        String result = map.get(txtSearch);
        if (result == null){
            String error = "Not Found";
            request.setAttribute("error",error);
        } else {
            request.setAttribute("result", result);
            request.setAttribute("txtSearch",txtSearch);
        }
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
