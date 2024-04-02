package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Blob;

import javax.sql.rowset.serial.SerialBlob;

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
	
	public static user findByEmail(String email) throws ClassNotFoundException, SQLException
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
}
