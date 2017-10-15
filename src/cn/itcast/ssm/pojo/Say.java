package cn.itcast.ssm.pojo;

import java.util.List;

public class Say {
	private int id;	//评论者的id
	private String username;//评论者的username
	private int tipid;	//评论的tip的id
	private int userid;	//被评论者的id
	private String detail;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTipid() {
		return tipid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setTipid(int tipid) {
		this.tipid = tipid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
}
