<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- oracle db의 student 테이블을 조회하여 화면에 출력 -->
<%
//DB작업에 필요한 객체 변수 선언


		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;   // 쿼리문이 'select'일 경우 필요
		String name = "";
		try {
			// 1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. DB접속 => Connection객체 생성
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "pc20";
			String pass = "java";
			conn = DriverManager.getConnection(url, user, pass);
			
			// 3. Statement객체 생성 
			//    (Statement객체는 Connection객체를 이용해서 생성한다.)
			stmt = conn.createStatement();
			
			// 4. SQL문을 Statement객체를 이용하여 실행하고
			//	  실행 결과를 ResultSet객체에 저장한다.
			StringBuffer sql = new StringBuffer();
			sql.append("select * ");
			sql.append(" from student2 ");
			sql.append(" where id =  ");
			sql.append(" (select round(dbms_random.value(1, (select count(*) from student2)), 0) ");
			sql.append(" from dual) ");
			
			
			
			rs = stmt.executeQuery(sql.toString());
			
			// 5. 결과 처리 ==> ResultSet객체에 저장되어 있는 자료를
			//		반복문을 이용하여 차례로 읽어와 처리한다.
			
			// ResultSet객체에 담겨 있는 데이터(레코드)에 접근하기위해
			// 현재 작업을 진행하는 레코드를 가리키는 것이 있는데
			// 이것을 커서(Cursor)라한다. 
			// next()메서드는 이 커서의 위치를 다음 레코드 위치로 
			// 이동시키고 그 자리에 데이터가 있으면 true, 없으면 false를
			// 반환한다.
			
			while(rs.next()){
				// 컬럼의 데이터를 가져오기 위해서는 
				// 'get자료형이름()' 메서드를 사용하는데
				// 이 메서드의 매개값으로 '컬럼명' 또는 '컬럼번호'를
				// 지정하면 된다. (컬럼번호는 1번부터 시작한다.)
				name = rs.getString("name");
				/* out.write(rs.getInt("id") + "/");
				out.write(rs.getString("name") + "/");
				
					System.out.println("rs.getInt : " +  rs.getInt("CALL_CNT"));
				
				out.write(rs.getInt("CALL_CNT"));
				out.write("=======================");
				out.write(0);
				out.write("======================="); */
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally{
			// 6. 사용했던 자원 반납
			if(rs!=null) try { rs.close();	} catch (SQLException e2) {	}
			if(stmt!=null) try { stmt.close();	} catch (SQLException e2) {	}
			if(conn!=null) try { conn.close();	} catch (SQLException e2) {	}
			
		}
%>
<canvas id="student" width="200" height="200" style="border:1px solid #000000;"></canvas>
<canvas id="student2" width="200" height="200" style="border:1px solid #000000;"></canvas>

</body>
<script>
	var canvas = document.getElementById("student");
	var context = canvas.getContext("2d");
	context.beginPath();
	context.arc(100, 100, 100, 0, 2 * Math.PI);
	context.strokeStyle = 'blue'; 
	context.lineWidth = 3; 
	context.stroke();
	context.font = "60px Arial";
	context.fillText("<%=name%>", 10, 115);
</script>
</html>