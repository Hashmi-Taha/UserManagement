package servlet_prog;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/log")
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String uname = req.getParameter("Uname");
		String pwd = req.getParameter("pwd");

		UserBean ub = new LoginDAO().login(uname, pwd);
		
		if(ub==null) {
			System.out.println("ub fail");
			req.setAttribute("mk", "Invalid Login Process...");
			RequestDispatcher rd = req.getRequestDispatcher("logfail.jsp");
			rd.forward(req, res);
		}else {
			ServletContext context = req.getServletContext();
			
			context.setAttribute("ubean", ub);
			System.out.println(ub);
			Cookie ck = new Cookie("uname", ub.getUname());
			res.addCookie(ck);
			
			RequestDispatcher rd = req.getRequestDispatcher("logsuccess.jsp");
			rd.forward(req, res);
		}

	}

}