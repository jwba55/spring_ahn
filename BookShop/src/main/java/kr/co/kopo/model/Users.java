package kr.co.kopo.model;

public class Users {
	private String id;
	private String password;
	private String name;
	private String tel;
	private int role;
	public String roleString;
	public static final int ADMIN = 99;
	public static final int USERS = 0;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public static String getRoleString(int role) {
		if(role == Users.ADMIN) return "admin";
		else if(role == Users.USERS) return "users";
		else
			return String.valueOf(role);
	}
}
