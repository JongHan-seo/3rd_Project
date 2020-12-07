package frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;


public class FrontController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 실행 여기서 시킬 것임!
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String reqUrl = request.getRequestURI();
		String ctx = request.getContextPath();
		String command = reqUrl.substring(ctx.length());
		
		Controller controller = null;
		String nextView = null;
		
		HandlerMapping mappings = new HandlerMapping();
		controller = mappings.getController(command);
		
		if(controller != null) {
			nextView = controller.requestHandler(request, response);
		}
		
		if (nextView != null) {
			if(nextView.indexOf("redirect:") != -1) {
				response.sendRedirect(nextView.split(":")[1]);
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/"+nextView);
				rd.forward(request, response);
			}
		}
		
		
	}

}
