package servlet_prog;

import java.sql.*;

public class EditProfileDAO {

	public int k = 0;

	public int edit(UserBean ub) {

		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("update usermang set mid=? where uname=?");
			System.out.println(ub.getmid());
			System.out.println(ub.getUname());
			System.out.println(ub.getPwd());
			ps.setString(1, ub.getmid());
			ps.setString(2, ub.getUname());

			k = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;

	}
	
}
