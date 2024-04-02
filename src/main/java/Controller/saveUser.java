package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.dao;
import DTO.user;

@WebServlet("/saveuser")
@MultipartConfig(maxFileSize = 10 * 1024 * 1024)
public class saveUser extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("userid"));
		String name = req.getParameter("username");
		String email = req.getParameter("useremail");
		long contact = Long.parseLong(req.getParameter("usercontact"));
		String password = req.getParameter("userpassword");
		byte[] image = req.getPart("userimage").getInputStream().readAllBytes();
		user u = new user(id, name, email, contact, image, password);
		dao d = new dao();
		try {
			int res = d.saveuser(u); 
			if (res > 0) {
				resp.sendRedirect("login.jsp");
			} else {
				resp.sendRedirect("signup.jsp");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
