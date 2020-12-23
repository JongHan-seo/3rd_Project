package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.MemberDAO;

@WebServlet("/check.do")
public class IdCheckController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");

		System.out.println(id);

		MemberDAO mdao = new MemberDAO();
		int cnt = mdao.idcheck(id);
		System.out.println(cnt);

		if (cnt > 0) {
			out.print("1");
		} else {
			out.print("0");
		}
	}

}
