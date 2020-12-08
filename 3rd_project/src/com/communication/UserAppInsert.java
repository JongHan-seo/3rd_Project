package com.communication;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.MemberDAO;
import com.model.MemberDTO;

@WebServlet("/UserAppInsert")
public class UserAppInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String phoneNumber = request.getParameter("pin");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		System.out.println(name);
		System.out.println(id);
		System.out.println(pw);
		
		MemberDTO dto = new MemberDTO();

		dto.setName(name);
		dto.setPhoneNumber(phoneNumber);
		dto.setId(id);
		dto.setPw(pw);

		MemberDAO dao = new MemberDAO();

		int cnt = dao.Insert(dto);
		System.out.println(cnt);

		String ctx = request.getContextPath(); // = mvc1

		if (cnt > 0) {

		} else {

			throw new ServletException("error");
		}

	}
}