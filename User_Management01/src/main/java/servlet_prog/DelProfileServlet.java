package servlet_prog;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

@SuppressWarnings("serial")
@WebServlet("/delete")
public class DelProfileServlet extends HttpServlet{

	@SuppressWarnings("unused")
	private DelProfileDAO delProfileDAO;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if(session==null) {
			req.setAttribute("mk", "Session Expired...<br>");
			req.getRequestDispatcher("logfail.jsp").forward(req, res);
		}else {
			String uname = req.getParameter("uname");
			boolean delProfile = new DelProfileDAO().delProfile(uname);
			if(delProfile) {
				req.setAttribute("msg", "Profile deleted successfully");
				req.getRequestDispatcher("logsuccess.jsp").forward(req, res);
			}
		}
	}

}
