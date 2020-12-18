package com.communication;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.SencingDAO;
import com.model.SencingDTO;

@WebServlet("/AppLogin")
public class UserAppLogin extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 스마트폰으로 로그인하는 기능은 여기서! (스마트폰의 기능에는 .do를 붙이지 말 것!)
		
		PrintWriter out = response.getWriter();
		SencingDAO sdao = new SencingDAO();
		SencingDTO sdtp = new SencingDTO();
		ArrayList<SencingDTO> readData;
		readData = sdao.readData();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		System.out.println(id + "/" + pw);
		
		out.print("true");
	}

}
