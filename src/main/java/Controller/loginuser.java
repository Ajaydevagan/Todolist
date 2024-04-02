package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.dao;
import DTO.user;
@WebServlet("/loginuser")
public class loginuser extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("loginemail");
		String password=req.getParameter("loginpassword");
		
		dao d=new dao();
		try {
			user u=d.findByEmail(email);
			if(u!=null)
			{
				if(u.getUserpassword().equals(password))
				{
					req.getSession().setAttribute("user", u);
					req.getRequestDispatcher("home.jsp").include(req, resp);
				}
				else
				{
					req.getRequestDispatcher("login.jsp").include(req, resp);
				}
			}else
			{
				req.getRequestDispatcher("login.jsp").include(req, resp);
			}
			
			
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
