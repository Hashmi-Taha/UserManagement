package servlet_prog;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/edit")
@SuppressWarnings("serial")
public class EditProfileServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException {
		
		Cookie[] ck = req.getCookies();
		
		if(ck==null) {
			req.setAttribute("mk", "Session Expired...<br>");
			req.getRequestDispatcher("logfail.jsp").forward(req, res);
		}else {
			String uname = ck[0].getValue();
			req.setAttribute("taha", uname);
			req.getRequestDispatcher("editprofile.jsp").forward(req, res);
		}
	}

}
