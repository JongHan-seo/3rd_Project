package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.MemberDAO;

public class LoginController implements Controller {


	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String ctx = request.getContextPath();
		
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		MemberDAO mdao = new MemberDAO();
		String name = mdao.login(id, pw);
		
		
		if(name != null) {
			HttpSession session = request.getSession();
			session.setAttribute("name", name);
		}else {
			out.print("fail");
		}
		
		return "main.jsp";
	}

	
	
}
