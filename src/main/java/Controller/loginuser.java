package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.dao;
import DTO.Task;
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
					List<Task> tasks=d.getAllTaskByUserId(u.getUserid());
					req.setAttribute("tasks", tasks);
					req.getRequestDispatcher("home.jsp").include(req, resp);
				}
				else
				{
					req.setAttribute("message", "password wrong");
					req.getRequestDispatcher("login.jsp").include(req, resp);
				}
			}else
			{
				req.setAttribute("message", "email wrong");
				req.getRequestDispatcher("login.jsp").include(req, resp);
			}
			
			
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
