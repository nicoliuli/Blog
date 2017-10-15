package cn.itcast.ssm.pojo;

import java.util.List;

public class User {
	private Integer id;	//用户id
	private String username;	//用户名
	private String password;	//用户密码
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
