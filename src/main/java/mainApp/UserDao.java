package mainApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class UserDao {
	
	public int registerUser(UserBean user) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO user" +
            "  (first_name, last_name,address, email, username, password,) VALUES " +
            " (?, ?, ?, ?, ?,?);";
        int result=0;
        try {
        Connection connection= DbConnection.createConnection();
        
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
            
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getAddress());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getUserName());
            preparedStatement.setString(6, user.getPassword());

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            // process sql exception
            e.printStackTrace();
        }
        return result;
    }
	
	public int userLogin(String uname, String upass) {
		 int result =0;
		 try {
		        Connection connection= DbConnection.createConnection();
		        if(connection!=null) {
		        	
		        PreparedStatement stmt = connection.prepareStatement("select * from user where username = "+uname);
		        ResultSet rs = stmt.executeQuery();
				if(rs.next())
					result=1;
				stmt.close();
				}
		        else
		        	result=0;
				
				connection.close();
				
		 }catch(SQLException se) {
			 se.printStackTrace();
		 }
		 return result;
	}
}
