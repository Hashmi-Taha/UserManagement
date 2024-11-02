package servlet_prog;

import java.sql.*;
import java.util.*;

public class ViewProfileDAO {

	public ArrayList<UserBean> al = new ArrayList<>();

	public ArrayList<UserBean> retrieve() {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("select * from usermang");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				UserBean ub = new UserBean();
				ub.setUname(rs.getString(1));
				ub.setmid(rs.getString(2));
				ub.setPwd(rs.getString(3));
				al.add(ub);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return al;

	}
	
}
