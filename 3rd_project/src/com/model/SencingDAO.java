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

public int sign(SencingDTO dto) {
	conn = getConn();

	String sql = "insert into sencing values(?,?,?)";

	try {
		ps = conn.prepareStatement(sql);

		
		ps.setString(1, dto.getGas());
		ps.setString(2, dto.getFeeding());
		ps.setString(3, dto.getUptime());

		cnt = ps.executeUpdate();

	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		close();
	}
	return cnt;

}

public void insert(String gas, String temp, String water) {
	conn = getConn();

	String sql = "insert into sencing(gas, temp, water, count) values(?,?,?,count_seq.nextval)";

	try {
		ps = conn.prepareStatement(sql);
		
		ps.setString(1, gas);
		ps.setString(2, temp);
		ps.setString(3, water);

		cnt = ps.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		close();
	}

}


String temp = null;

public ArrayList<SencingDTO> readData() {
	conn = getConn();
	String sql = "select * from sencing";
	ArrayList<SencingDTO> list = new ArrayList<>();
	
	try {
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();

		while (rs.next()) {
			sdto = new SencingDTO();
			sdto.setCount(rs.getString("count"));
			sdto.setTemp(rs.getString("temp"));
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