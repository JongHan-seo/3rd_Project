package com.model;

import java.sql.*;

public class MemberDAO {
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	MemberDTO dto;
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

	public int sign(String name, String id, String pw) {
		conn = getConn();
		cnt = 0;
		String sql = "insert into member(name, phone, id, pw) values(?,'-',?,?)";

		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, name);
			ps.setString(2, id);
			ps.setString(3, pw);

			cnt = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		System.out.println(cnt);
		return cnt;

	}

	String name = null;

	public String login(String id, String pw) {
		conn = getConn();
		String sql = "select name from member where id=? and pw=?";

		System.out.println(id+ "/"+pw);
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			rs = ps.executeQuery();

			if (rs.next()) {
				name = rs.getString("name");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return name;

	}

	public int idcheck(String id) {
		conn = getConn();
		cnt = 0;
		String sql = "select * from member where id=?";

		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, id);

			rs = ps.executeQuery();

			if (rs.next()) {
				cnt++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}
	
	public int idcheck(String id, String pw) {
		conn = getConn();
		cnt = 0;
		String sql = "select * from member where id=? and pw = ?";

		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, id);
			ps.setString(2, pw);

			rs = ps.executeQuery();

			if (rs.next()) {
				cnt++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	String serialCode = null;

	public String getCode(MemberDTO dto) {
		conn = getConn();
		String sql = "select serialcode from member where id=? and pw=?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPw());
			rs = ps.executeQuery();

			if (rs.next()) {
				serialCode = rs.getString("serialcode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return serialCode;

	}

	public int Insert(MemberDTO dto) {
		conn = getConn();
		cnt = 0;
		try {
			String sql = "insert into member values (?, ?, ?, ?, ?)";

			ps = conn.prepareStatement(sql);

			ps.setString(1, dto.getName());
			ps.setString(2, dto.getPhon());
			ps.setString(3, dto.getAddress());
			ps.setString(4, dto.getId());
			ps.setString(5, dto.getPw());

			cnt = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}

}
