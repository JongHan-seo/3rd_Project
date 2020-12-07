package frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/"+nextView+".jsp");
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/main.html");
		rd.forward(request, response);
		
		// 김병길입니다.
	}

}
