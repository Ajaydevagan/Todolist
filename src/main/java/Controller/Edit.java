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
@WebServlet("/edittask")
public class Edit extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int taskid=Integer.parseInt(req.getParameter("taskid"));
		dao d=new dao();
		try {
			Task t=d.getTask(taskid);
			if(t!=null)
			{
				req.setAttribute("uptask", t);
				req.getRequestDispatcher("edit.jsp").include(req, resp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
