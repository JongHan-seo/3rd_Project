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

	public int sign(MemberDTO dto) {
		conn = getConn();

		String sql = "insert into member values(?,?,serial_seq.nextval,?)";

		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPw());
			ps.setString(3, dto.getName());

			cnt = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;

	}

	String name = null;

	public String login(MemberDTO dto) {
		conn = getConn();
		String sql = "select name from member where id=? and pw=?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPw());
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

	public int idcheck(String id, String pw) {
		conn = getConn();
		cnt = 0;
		String sql = "select * from member where id=? and pw=?";

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

		int cnt = -1; // 실패의 의미 (=없다)

		try {
			// ? => 파라메터
			String sql = "insert into member values (?, ?, ?, ?)";

			// sql 넘겨주기
			ps = conn.prepareStatement(sql);

			// sql 받기
			// 위에 insert 문에 () 안에 num이 맨 앞에 있어도 ?부터 인덱스 1번
			// private으로 설정 되있어서 getter로 빼와야 해서 getId...
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getPhoneNumber());
			ps.setString(3, dto.getId());
			ps.setString(4, dto.getPw());
		

			cnt = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt; // 성공,실패를 cnt로 (int 형) 보여줘라
	}

}
