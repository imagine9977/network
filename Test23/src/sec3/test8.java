package sec3;
import java.sql.Connection;
import java.sql.PreparedStatement;;
public class test8 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//원인1: url인 "jdbc:mysql://localhost:3306"에서 데이터베이스 이름이 지정되지 않아서 연결이 불가능
			//조치: jdbc:mysql://localhost:3306/kh 로 수정
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","1234"); 
			//수정: DriverManger.getConnection("jdbc:mysql://localhost:3306","root","1234");
			
			// 원인2: query에 대한 sql 부분이 아직 지정되지 않아서 해당 query 실행할 수 없다
			//수정 :  String query = "select emp_id, emp_name from employee";
			PreparedStatement st = conn.prepareStatement(query);
			
			//원인 3: ResultSet rs는 st.executeUpdate문장에서 executeUpdate는 int를 반환하므로 
			//rs=st.excuteQuery();
			//원인 4: while(rs) 문장에서 다음 레코드를 지칭해야 레코드가 끝날때까지 반복수행할 수 없으므러 진행되지 못한다
			//반복 수행이 될 수 있게 하도록 while(rs.next())
			//원인 5: empID, empName가 아닌 emp_id, emp_name 컬럼이 존재하므로 해당 컬럼에 접근 할 수 없다
			// emp_id, emp_name으로 변경
		} catch (Exception e) {
			// TODO: handle exception
		} 
			
		
	}
}
