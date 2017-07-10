package net.shbtboard.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable=false, length=20, unique=true)
	private String userId;
	
	private String pw;
	private String userNm;
	private String email;
	
	public long getId() {
		return id;
	}	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getPw() {
		return pw;
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void update(User newUser) {
		this.pw = newUser.pw;
		this.userNm = newUser.userNm;
		this.email = newUser.email;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", pw=" + pw + ", userNm=" + userNm + ", email=" + email + "]";
	}
}
