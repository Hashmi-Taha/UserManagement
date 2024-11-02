package servlet_prog;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class RegisterDAO {

	public int b = 0;

	public int register(UserBean ub) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("insert into usermang values(?,?,?)");
			ps.setString(1, ub.getUname());
			ps.setString(2, ub.getmid());
			ps.setString(3, ub.getPwd());
			b = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return b;

	}

}
