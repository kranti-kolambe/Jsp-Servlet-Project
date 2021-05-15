package com.khk;

public class User {
	private int uid;
	private String userName;
	private String email;
	private String psw;
	private String city;
	private String status;
	public User(int uid, String userName, String email, String psw, String city, String status) {
		super();
		this.uid = uid;
		this.userName = userName;
		this.email = email;
		this.psw = psw;
		this.city = city;
		this.status = status;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", userName=" + userName + ", email=" + email + ", psw=" + psw + ", city=" + city
				+ ", status=" + status + "]";
	}

	
}
