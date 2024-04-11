package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.dao;
import DTO.Task;
import DTO.user;

@WebServlet("/delete")
public class DeleteId extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int taskid=Integer.parseInt(req.getParameter("taskid"));
		dao d=new dao();
		try {
			user user=(user) req.getSession().getAttribute("user");
			if(user!=null ) {
				Task ts=d.getTask(taskid);
				if(ts.getUserid() == user.getUserid()) {
					int res=d.deleteid(taskid);
					req.setAttribute("tasks", d.getAllTaskByUserId(user.getUserid()));
					req.getRequestDispatcher("home.jsp").include(req, resp);
				}
				else {
					resp.sendRedirect("login.jsp");
				}
			}
			else {
				resp.sendRedirect("login.jsp");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
