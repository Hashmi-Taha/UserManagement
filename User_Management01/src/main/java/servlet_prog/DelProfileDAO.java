package servlet_prog;

import java.sql.*;

public class DelProfileDAO {

    public boolean delProfile(String uname) {
    	Connection con = DBConnection.getCon();
        String sql = "DELETE FROM usermang WHERE uname = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setString(1, uname);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0; // returns true if a profile was deleted
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // handle the error appropriately in a real application
        }
    }
}
