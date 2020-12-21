package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SencingDAO {Connection conn = null;
PreparedStatement ps = null;
ResultSet rs = null;
SencingDTO sdto;
int cnt = 0;

static {
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	} catch (Exception e) {
		e.printStackTrace();
	}

}

public Connection getConn() {

	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "hr";
	String password = "hr";

	try {
		conn = DriverManager.getConnection(url, user, password);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return conn;
}

public void close() {

	try {
		if (rs != null) {
			rs.close();
		}
		if (ps != null) {
			ps.close();
		}
		if (conn != null) {
			conn.close();
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
}

public void insert(String gas, String temp, String water, String uptime) {
	conn = getConn();

	String sql = "insert into sencing(gas, temp, water, uptime, upsys) values(?,?,?,?,sysdate)";

	try {
		ps = conn.prepareStatement(sql);
		
		ps.setString(1, gas);
		ps.setString(2, temp);
		ps.setString(3, water);
		ps.setString(4, uptime);

		cnt = ps.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		close();
	}

}


// 최근데이터 10개 출력
String temp = null;
public ArrayList<SencingDTO> readData() {
	conn = getConn();
	String sql = "select * from(select * from(select gas,temp,water,uptime from sencing order by upsys desc) where rownum <= 10) order by rownum desc";
	ArrayList<SencingDTO> list = new ArrayList<>();
	
	try {
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();

		while (rs.next()) {
			sdto = new SencingDTO();
			sdto.setUptime(rs.getString("uptime"));
			sdto.setTemp(rs.getString("temp"));
			sdto.setGas(rs.getString("gas"));
			sdto.setWater(rs.getString("water"));
			list.add(sdto);
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		close();
	}
	return list;

}


}