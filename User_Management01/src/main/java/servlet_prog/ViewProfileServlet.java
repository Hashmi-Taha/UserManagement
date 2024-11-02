package servlet_prog;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.util.*;

@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewProfileServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);

		if (hs == null) {
			req.setAttribute("mk", "Session Expired...<br>");
			req.getRequestDispatcher("logfail.jsp").forward(req, res);
		} else {
			ArrayList<UserBean> al = new ViewProfileDAO().retrieve();
			hs.setAttribute("alist", al);
			req.getRequestDispatcher("viewprofile.jsp").forward(req, res);
		}
	}
}