package persistencia;
import java.sql.*;
import javax.swing.*;

public class Agente {

	public static Connection dbConnector(){
		Connection conn=null;
		try{
			Class.forName("org.sqlite.JDBC");
			String url = "jdbc:sqlite:Test.sqlite";
			conn=DriverManager.getConnection(url);
			//JOptionPane.showMessageDialog(null, "Conexion correcta");
			return conn;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
	
	public static boolean checkUser(Connection conn, String name, String pass) throws SQLException {
        String sql = "SELECT * FROM Users WHERE Name = ? AND Pass = ?";
        PreparedStatement stm = null;
        ResultSet rs = null;
 
        try{
        	stm = conn.prepareStatement(sql);
        	stm.setString(1, name);
        	stm.setString(2, pass);
        	
        	rs = stm.executeQuery();
        	
        	if(rs.next()) {
        		return true;
        	}
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }finally {
        	stm.close();
        	rs.close();
        }
        return false;
    }
	
	public static void main(String args[]) {
		Connection con = dbConnector();
		
	}
}
