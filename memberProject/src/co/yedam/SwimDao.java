package co.yedam;

import java.sql.*;
import java.util.*;
public class SwimDao {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	
	private void getConn() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, "jsp", "jsp");
		} catch (Exception  e) {
			e.printStackTrace();
			return;
		}
}
	List<Swim> swim(){
		getConn();
		List<Swim> list = new ArrayList<Swim>();
		String sql = "select * from swim order by mem_number";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Swim swim = new Swim();
				swim.setMemNumber(rs.getInt("mem_number"));
				swim.setMemName(rs.getString("mem_name"));
				swim.setMemPhone(rs.getString("mem_phone"));
				swim.setMemDay(rs.getString("mem_day"));
				swim.setGender(rs.getString("mem_gender"));
				
				list.add(swim);
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		} return list;
	} 
	boolean insertSwim(Swim swim) {
		getConn();
		String sql = "insert into swim(mem_number,mem_name,mem_phone,mem_day,mem_gender)\r\n"
				+ "values (Swim_swq.nextval,?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,swim.getMemName());
			psmt.setString(2,swim.getMemPhone());
			psmt.setString(3,swim.getMemDay());
			psmt.setString(4,swim.getGender());
			
			int r = psmt.executeUpdate();
			if(r>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} return false;
	}
	boolean updateSwim(Swim swim) {
		getConn();
		String sql = "update swim set mem_name = ? ,mem_phone = ?"
				+ " where  mem_number = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,swim.getMemName());
			psmt.setString(2,swim.getMemPhone());
			psmt.setInt(3,swim.getMemNumber());
			int r = psmt.executeUpdate();
			if(r>0) {
				return true;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	boolean deleteSwim(int mno) {
		getConn();
		String sql = "delete Swim where mem_number = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, mno);
			
			int r = psmt.executeUpdate();
			if(r>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	  return false;
		}
	String showDetail(int mno) {
		getConn();
		String sql = "select * from swim order by mem_number";
		return "asd";
	}
}