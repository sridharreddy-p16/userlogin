package mainApp;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	
    public static Connection con;
	
	public static Connection createConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//System.out.println("Driver loaded");
		    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userlogin","root","root");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
	}


}
