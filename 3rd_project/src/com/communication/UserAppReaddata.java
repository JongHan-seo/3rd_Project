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

@WebServlet("/AppData")
public class UserAppReaddata extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// data 10개 보내기
		SencingDAO sdao = new SencingDAO();
		SencingDTO sdtp = new SencingDTO();
		
		PrintWriter out = response.getWriter();
		
		String data = request.getParameter("data");
		ArrayList<SencingDTO> readData;
		
		readData = sdao.readData();
		String a = "";
		for(int i = 0; i <= 9; i++) {
			a+= readData.get(i).getUptime()+":"+readData.get(i).getGas()+":"+readData.get(i).getTemp()+":"+readData.get(i).getWater()+":";
		}
		System.out.println(a);
		out.print(a);
		
	}

}
