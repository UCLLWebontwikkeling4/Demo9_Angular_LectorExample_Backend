import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Controller() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// fake json (should be replaced by making json of current status of stub or db)
		// { \"id\": 3, \"name\": \"Greetje Jongen\" }
		String heroes = "[" +
							"{ \"id\": 1, \"name\": \"Mieke Kemme\" }, " +
							"{ \"id\": 2, \"name\": \"Elke Steegmans\" }, " +
				"{ \"id\": 3, \"name\": \"Greetje Jongen\" } " +
						"]";
		// setting the response type to json
		response.setContentType("application/json");
		// setting the CORS request, CrossOriginResourceSharing
		// so that this url/response is accessible in another domain (angular application for example) 
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.getWriter().write(heroes);
	}
}
