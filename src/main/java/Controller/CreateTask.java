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

@WebServlet("/task")
public class CreateTask extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int taskid= Integer.parseInt(req.getParameter("taskid"));
		String tasktitle = req.getParameter("tasktitle");
		String taskdiscription = req.getParameter("taskdiscription");
		String taskpriority = req.getParameter("taskpriority");
		String taskduedate = req.getParameter("taskduedate");

		user u = (user) req.getSession().getAttribute("user");
		int userid = u.getUserid();

		Task t = new Task(taskid, tasktitle, taskdiscription, taskpriority, taskduedate, false, userid);

		dao d = new dao();
		try {
			int res = d.createTask(t);

			if (res > 0) {
				user user=(user) req.getSession().getAttribute("user");
				req.setAttribute("tasks", d.getAllTaskByUserId(user.getUserid()));
				req.getRequestDispatcher("home.jsp").include(req, resp);;
			} else {
				resp.getWriter().println("gundu");
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}
}
