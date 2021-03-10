package DAOO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;



import model.User;

public class dao {

	public  boolean registeruser(User user){
		System.out.println("Running dao:: registerUser");
		String url="jdbc:mysql://localhost:3306/test";
		String db_User="root";
		String db_Password="root";
		Connection con;
		PreparedStatement psmt;
		String sql="insert into details values(?,?,?,?,?)";

		try{

			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,db_User,db_Password);
			psmt=con.prepareStatement(sql);
			psmt.setInt(1, user.getId());
			//psmt.setString(2, user.ge
			psmt.setString(2, user.getUsername());
			psmt.setString(3, user.getPassword());
			psmt.setInt(4, user.getPhone());
			psmt.setString(5, user.getAddress());
			int result=psmt.executeUpdate();
			if(result>0)
				return true;
				
		

			}
		
			catch(Exception e){
				e.printStackTrace();
			}
			System.out.println("Start of dao::registerUser");
			return false;
	
}
}
