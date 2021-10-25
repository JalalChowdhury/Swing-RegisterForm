package WithLogin;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;



public class DataBaseConnect {
	private Connection con;
	private Statement st ;
	private ResultSet rs;
	private int found = 0;
	
	public DataBaseConnect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cse_50th","root", "");
			st = con.createStatement();
			
		}catch(Exception e) {
			System.err.println("Error : " +e);
		}
	}

	public void RegisterInsert(String queryInsert) {
		try {
			st.executeUpdate(queryInsert);
			JOptionPane.showMessageDialog(null,"Register Complete !!!");
			
		} catch(Exception ex) {
			JOptionPane.showMessageDialog(null,"Not Inserted !!!"+ex);
		}
		
	}

	public void LoginMethod(String logQuery, String logUserName, String logPass) {
		try {
			rs = st.executeQuery(logQuery);
			while(rs.next()) {
				String dbUserName = rs.getString(2);
				String dbPass = rs.getString(4);
				if(logUserName.equals(dbUserName) && logPass.equals(dbPass)) {
					found = 1;
					
					break;
				}
			}
			
			if(found==1) {
				JOptionPane.showMessageDialog(null, "Welcome to CSE of website");
				//new window 
				new MainWindow();
			}
			else {
				JOptionPane.showMessageDialog(null, "UserName or pasword are incorrect");
				
			}
		} catch(Exception e) {
			
		}
		
	}

}