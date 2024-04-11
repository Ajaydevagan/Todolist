package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Blob;

import javax.servlet.RequestDispatcher;
import javax.sql.rowset.serial.SerialBlob;

import DTO.Task;
import DTO.user;

public class dao {
	public static Connection getconnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "root");
		return con;
	}

	public static int saveuser(user u) throws ClassNotFoundException, SQLException {
		Connection con = getconnection();
		PreparedStatement ps = con.prepareStatement("insert into user values(?,?,?,?,?,?)");
		ps.setInt(1, u.getUserid());
		ps.setString(2, u.getUsername());
		ps.setString(3, u.getUseremail());
		ps.setLong(4, u.getUsercontact());
		ps.setBlob(5, new SerialBlob(u.getImage()));
		ps.setString(6, u.getUserpassword());
		return ps.executeUpdate();

	}
	
	public  user findByEmail(String email) throws ClassNotFoundException, SQLException
	{
		Connection con=getconnection();
		PreparedStatement ps = con.prepareStatement("select * from user where useremail=?");
		try {
			ps.setString(1, email);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				user u=new user();
				u.setUserid(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setUseremail(rs.getString(3));
				u.setUsercontact(rs.getLong(4));
				Blob img= rs.getBlob(5);
				byte[] image=img.getBytes(1,(int)img.length());
				u.setImage(image);
				u.setUserpassword(rs.getString(6));
				return u;
			}
			else
			{
				return null;
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int createTask(Task t) throws ClassNotFoundException, SQLException
	{
		Connection con=getconnection();
		PreparedStatement ps=con.prepareStatement("insert into task values(?,?,?,?,?,?,?)");
		ps.setInt(1, t.getTaskid());
		ps.setString(2, t.getTasktitle());
		ps.setString(3, t.getTaskdescription());
		ps.setString(4, t.getTaskpriority());
		ps.setString(5, t.getTaskduedate());
		ps.setBoolean(6, t.isTaskstatus());
		ps.setInt(7, t.getUserid());
		
		int res=ps.executeUpdate();
		return res;
	
	}
	//displaying the task 
	public List<Task> getAllTaskByUserId(int userId) throws ClassNotFoundException, SQLException
	{
		Connection con=getconnection();
		PreparedStatement pr=con.prepareStatement("select * from task where userid=?");
		pr.setInt(1, userId);
		ResultSet rs= pr.executeQuery();
		List<Task> tasks=new ArrayList<>();
		while(rs.next())
		{
			Task task=new Task(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getBoolean(6));
			tasks.add(task);
		}
		return tasks;
	}
	//delete task
	public int deleteid(int id) throws ClassNotFoundException, SQLException
	{
		Connection con=getconnection();
		PreparedStatement ps = con.prepareStatement("delete from task where taskid=?");
		ps.setInt(1, id);
		int res=ps.executeUpdate();
		return res;
	}
	//edit task
	public Task getTask(int id) throws ClassNotFoundException, SQLException
	{
		Connection con=getconnection();
		PreparedStatement ps=con.prepareStatement("select * from task where taskid=?");
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		rs.next();
		Task t=new Task(id,rs.getString(2), rs.getString(3),rs.getString(4), rs.getString(5), false, rs.getInt(7));
		return t;
	}
	//update task
	public int updatetask(Task task) throws ClassNotFoundException, SQLException
	{
		Connection con=getconnection();
		PreparedStatement ps=con.prepareStatement("update task set tasktittle=?,taskdiscription=?,taskpriority=?,taskduedate=?,taskstatus=? where taskid=?");
		ps.setString(1,task.getTasktitle());
		ps.setString(2, task.getTaskdescription());
		ps.setString(3, task.getTaskpriority());
		ps.setString(4, task.getTaskduedate());
		ps.setBoolean(5, task.isTaskstatus());
		ps.setInt(6, task.getTaskid());
		
		int res=ps.executeUpdate();
		return res;
	}
}
