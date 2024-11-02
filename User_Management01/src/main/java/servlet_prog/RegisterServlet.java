package servlet_prog;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {


protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    UserBean ub = new UserBean();

    // Fetch parameters and check for null
    String uname = req.getParameter("uname");
    String mid = req.getParameter("mid");
    String pwd = req.getParameter("pwd");

    if (uname == null || mid == null || pwd == null) {
        req.setAttribute("error", "All fields are required.");
        req.getRequestDispatcher("register.jsp").forward(req, res);
        return;
    }

    ub.setUname(uname);
    ub.setmid(mid);
    ub.setPwd(pwd);

    int t = new RegisterDAO().register(ub);

    if (t > 0) {
        req.setAttribute("mk", "User registered successfully...<br>");

        req.getRequestDispatcher("register.jsp").forward(req, res);

    } else {
        req.setAttribute("error", "Registration failed. Please try again.");
        
        req.getRequestDispatcher("registerfail.jsp").forward(req, res);

    }
    
    req.getRequestDispatcher("register.jsp").forward(req, res);
}}
