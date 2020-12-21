package com.communication;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.MemberDAO;

import com.model.SencingDAO;
import com.model.SencingDTO;

@WebServlet("/AppLogin")
public class UserAppLogin extends HttpServlet {
	MemberDAO dao = new MemberDAO();

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 스마트폰으로 로그인하는 기능은 여기서! (스마트폰의 기능에는 .do를 붙이지 말 것!)
		
		PrintWriter out = response.getWriter();
		SencingDAO sdao = new SencingDAO();
		SencingDTO sdtp = new SencingDTO();
		MemberDAO mdao = new MemberDAO();
		
		ArrayList<SencingDTO> readData;
		readData = sdao.readData();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		System.out.println(id + "/" + pw);
		boolean check = dao.login(id,pw);
		

		int check = mdao.idcheck(id, pw);
				
		if(check == 0) {
			out.print("false");
		}else {
			String a = "";
			for(int i = 0; i <= 9; i++) {
				a+= readData.get(i).getUptime()+":"+readData.get(i).getGas()+":"+readData.get(i).getTemp()+":"+readData.get(i).getWater()+":";
			}
			System.out.println(a);
			out.print(a);
		}

		
	}

}
