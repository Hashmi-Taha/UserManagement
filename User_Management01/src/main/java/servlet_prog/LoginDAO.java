package servlet_prog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {
	public UserBean ub = null;

	public UserBean login(String uN, String pD) {
	    try {
	        Connection con = DBConnection.getCon();
	        PreparedStatement ps = con.prepareStatement("select * from usermang where uname=? AND pwd=?");
	        ps.setString(1, uN);
	        ps.setString(2, pD);
	        
	        System.out.println("Executing query with uname: " + uN + " and pwd: " + pD);
	        
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            ub = new UserBean();
	            ub.setUname(rs.getString(1));
	            ub.setPwd(rs.getString(2));
	        } else {
	            System.out.println("No user found with the provided credentials.");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return ub;
	}

}
