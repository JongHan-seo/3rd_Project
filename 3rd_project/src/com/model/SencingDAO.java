package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SencingDAO {Connection conn = null;
PreparedStatement ps = null;
ResultSet rs = null;
SencingDTO dto;
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

	String sql = "insert into sensing values(?,?,?)";

	try {
		ps = conn.prepareStatement(sql);

		
		ps.setString(1, dto.getGas());
		ps.setString(2, dto.getFeeding());
		ps.setString(3, dto.getFeedtime());

		cnt = ps.executeUpdate();

	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		close();
	}
	return cnt;

}

}