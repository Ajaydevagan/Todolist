package DTO;

public class user {
	private int userid;
	private String username;
	private String useremail;
	private long usercontact;
	private byte[] userimage;
	private String userpassword;
	
	public user() {
		
	}
	
	public user(int userid, String username, String useremail, long usercontact, byte[] userimage,
			String userpassword) {
		super();
		this.userid = userid;
		this.username = username;
		this.useremail = useremail;
		this.usercontact = usercontact;
		this.userimage = userimage;
		this.userpassword = userpassword;
	}
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public long getUsercontact() {
		return usercontact;
	}
	public void setUsercontact(long usercontact) {
		this.usercontact = usercontact;
	}
	public byte[] getImage() {
		return userimage;
	}
	public void setImage(byte[] image) {
		this.userimage = image;
	}
	public String getUserpassword() {
		return userpassword;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}


}
