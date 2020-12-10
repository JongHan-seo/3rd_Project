package com.firebase;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/firebase_test")
public class firebase_test extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		App app = new App();
		try {
			app.init();
			app.makeDatabaseConn();
			app.select();
//			app.insert();
//			app.update();
//			app.delete();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
