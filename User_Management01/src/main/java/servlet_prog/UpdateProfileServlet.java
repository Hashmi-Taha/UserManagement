package servlet_prog;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update")
@SuppressWarnings("serial")
public class UpdateProfileServlet extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		Cookie[] ck = req.getCookies();

		if (ck == null) {
			req.setAttribute("mk", "Session Expired...<br>");
			req.getRequestDispatcher("logfail.jsp").forward(req, res);
		} else {
			String uname = ck[0].getValue();
			req.setAttribute("uname", uname);
			UserBean ub = (UserBean) req.getServletContext().getAttribute("ubean");
			try {
				
				ub.setmid(req.getParameter("mid"));
				ub.setUname(uname);
				
				int k = new EditProfileDAO().edit(ub);
				System.out.println(k);

				if (k > 0) {
					req.setAttribute("msg", "Profile Updated Successfully...<br>");
					req.getRequestDispatcher("logsuccess.jsp").forward(req, res);
				}
				
			} catch (Exception e) {
				req.setAttribute("mk", "First You Have to Login...<br>");
				req.getRequestDispatcher("logfail.jsp").forward(req, res);

			}
		}

	}
}
