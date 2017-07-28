package net.shbtboard.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class User extends AbstractEntity {
	
	@Column(nullable=false, length=20, unique=true)
	@JsonProperty
	private String userId;
	
	@JsonIgnore
	private String pw;
	
	@JsonProperty
	private String userNm;
	
	@JsonProperty
	private String email;
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserId() {
		return userId;
	}
	public void setPw(String pw) {
		this.pw = pw;
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
	
	public boolean matchPassword(String newPw) {
		
		if(newPw == null) {
			return false;
		}
		
		return newPw.equals(pw);
	}
	
	public boolean matchId(Long newId) {
		
		if(newId == null) {
			return false;
		}
		
		return newId.equals(getId());
	}

	@Override
	public String toString() {
		return "User [" + super.toString() + "userId=" + userId + ", pw=" + pw + ", userNm=" + userNm + ", email=" + email + "]";
	}
}
