package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestStuser {
	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate("create table st_user(id int primary key, firstName varchar(45), lastName varchar(45), gmailId varchar(45), UserId varchar(45), Dob varchar(45))");

		System.out.println(i + " table created");
		
		conn.close();
		stmt.close();
	}
}
