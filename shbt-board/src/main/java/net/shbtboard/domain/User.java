package net.shbtboard.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	@JsonProperty
	private long id;
	
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
		
		return newId.equals(id);
	}	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", pw=" + pw + ", userNm=" + userNm + ", email=" + email + "]";
	}
}
