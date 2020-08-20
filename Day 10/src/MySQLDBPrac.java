import java.sql.*;

public class MySQLDBPrac {

	public static void main(String[] args) {
		
		Connection conn;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver"); //드라이버 로드
			conn = DriverManager.getConnection("jdbc:mysql://192.168.0.25:3306/java05"
					+ "?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8", 
					"java05", "java05"); //주소:포트 ,아이디, 비밀번호
			
			System.out.println("DB 연결 완료");
			stmt = conn.createStatement(); //sql문 처리용 statement 객체 생성
			pstmt = conn.prepareStatement("delete from student where name='이기자';");//더 간단한 sql문 처리 statement
//			pstmt.setString(1, "박상혁");
//			pstmt.setString(2, "0920829");
//			pstmt.setString(3, "프로그래밍");
			pstmt.executeUpdate();
			
//			stmt.executeUpdate("insert into student (name, dept, id) values ('박상혁','바이오메디컬','1242205');"); //레코드추가
			
			printTable(stmt);
//			stmt.executeUpdate("update student set id='0189011' where name='아무개'"); //데이터 수정
			
//			printTable(stmt);
//			stmt.executeUpdate("delete from student where name='김철수'");
//
//			printTable(stmt);

//			ResultSet srs = stmt.executeQuery("select * from student"); //쿼리문 전달
//			
//			printData(srs, "name", "id", "dept");

			
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 에러");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DB 연결 에러");
		}

	}
	
	// 레코드의 각 열의 값 화면에 출력
	private static void printData(ResultSet srs, String col1, String col2, String col3) throws SQLException {
		
		while(srs.next()) { //다음 행이 있는가? true 없으면 false
			if(col1 != "") {
				System.out.print(new String(srs.getString("name")));
			}
			if(col2 != "") {
				System.out.print("\t|\t" + srs.getString("id"));
			}
			if(col3 != "") {
				System.out.println("\t|\t" + new String(srs.getString("dept")));
			} else {
				System.out.println();
			}
		}
	}
	
	private static void printTable(Statement stmt) throws SQLException {
		ResultSet srs = stmt.executeQuery("select * from student");
		
		while(srs.next()) { //다음 행이 있는가? true 없으면 false
			
				System.out.print(new String(srs.getString("name")));
				System.out.print("\t|\t" + srs.getString("id"));
				System.out.println("\t|\t" + new String(srs.getString("dept")));
		}
	}

}
