package com.communication;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AppInsert")
public class UserAppMemberInsert extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 스마트폰으로 회원가입(회원가입 성공시 cnt 1반환, 아니면 -1반환)
		
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		System.out.println(id + "/" + pw);
		
		out.print("HI");
	}

}
