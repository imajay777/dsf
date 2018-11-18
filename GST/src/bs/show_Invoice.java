package bs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class show_Invoice {
	Connection connection = null;
	ResultSet set_com;
	
	public void commonMethodForSt(String query) {
		try {
			Statement st = connection.createStatement();
			set_com = st.executeQuery(query);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}	
	}
public void show_Invoice() {
		
		try {
			Class.forName("org.h2.Driver");
			connection = DriverManager.getConnection("jdbc:h2:~/test","sa","");
			System.out.print("Connection Successful for showing invoices");
//			JOptionPane.showMessageDialog(null, "Transport Connection Successful");
			
			commonMethodForSt("SELECT * FROM INVOICE_TABLE");
			while(set_com.next()) {
				System.out.println(set_com.getInt(1)+" "+set_com.getString(2)+" "+set_com.getString(3)+" "+set_com.getString(4)+" "+set_com.getString(5)+" "+set_com.getString(6)+" "+set_com.getString(7)+" "+set_com.getString(8)+" "+set_com.getString(9));
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
			}
		}
	}
}
