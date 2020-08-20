import java.sql.*;

public class MySQLDBPrac {

	public static void main(String[] args) {
		
		Connection conn;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver"); //����̹� �ε�
			conn = DriverManager.getConnection("jdbc:mysql://192.168.0.25:3306/java05"
					+ "?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8", 
					"java05", "java05"); //�ּ�:��Ʈ ,���̵�, ��й�ȣ
			
			System.out.println("DB ���� �Ϸ�");
			stmt = conn.createStatement(); //sql�� ó���� statement ��ü ����
			pstmt = conn.prepareStatement("delete from student where name='�̱���';");//�� ������ sql�� ó�� statement
//			pstmt.setString(1, "�ڻ���");
//			pstmt.setString(2, "0920829");
//			pstmt.setString(3, "���α׷���");
			pstmt.executeUpdate();
			
//			stmt.executeUpdate("insert into student (name, dept, id) values ('�ڻ���','���̿��޵���','1242205');"); //���ڵ��߰�
			
			printTable(stmt);
//			stmt.executeUpdate("update student set id='0189011' where name='�ƹ���'"); //������ ����
			
//			printTable(stmt);
//			stmt.executeUpdate("delete from student where name='��ö��'");
//
//			printTable(stmt);

//			ResultSet srs = stmt.executeQuery("select * from student"); //������ ����
//			
//			printData(srs, "name", "id", "dept");

			
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC ����̹� �ε� ����");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DB ���� ����");
		}

	}
	
	// ���ڵ��� �� ���� �� ȭ�鿡 ���
	private static void printData(ResultSet srs, String col1, String col2, String col3) throws SQLException {
		
		while(srs.next()) { //���� ���� �ִ°�? true ������ false
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
		
		while(srs.next()) { //���� ���� �ִ°�? true ������ false
			
				System.out.print(new String(srs.getString("name")));
				System.out.print("\t|\t" + srs.getString("id"));
				System.out.println("\t|\t" + new String(srs.getString("dept")));
		}
	}

}
