package co.yedam;

import java.sql.*;
// 1. ojdbc 라이브러리.
// 2. connection 객체 접속.
// 3. PreparedStatatement 객체 쿼리실행
// 4. 결과 => 화면출력, 기능수행.
public class AppTest {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return;
		}
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Connection conn = DriverManager.getConnection(url,"jsp","jsp");
			
			String sql1 = "select * from emp";
			String sql2 = "insert into emp (emp_no,emp_name,emp_phone,email,salary)";
			sql2 += "values (emp_seq.nextval, ?,?,?,?)";
			PreparedStatement psmt = conn.prepareStatement(sql2);
			psmt.setString(1,"홍길동");
			psmt.setString(2,"12-3456-7890");
			psmt.setString(3, "gildong@email");
			psmt.setInt(4,3000);
			
			int r = psmt.executeUpdate(); // insert ,delete, update 일 경우.
			System.out.println("등록된 건수 : " + r);
			
			psmt = conn.prepareStatement(sql1);
			ResultSet rs = psmt.executeQuery(); // select  일 경우. 
			while(rs.next()) {
				System.out.println(rs.getInt("emp_no"));
				System.out.println(rs.getString("emp_name"));
				System.out.println(rs.getString("email"));
				System.out.println(rs.getString("emp_phone"));
				System.out.println(rs.getDate("hire_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("end of prog.");
	}
}
