package cn.itcast.ssm.pojo;

import java.util.List;

//Tip和User的包装类
public class TipUser {
	private User user;
	private Tip tip;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Tip getTip() {
		return tip;
	}
	public void setTip(Tip tip) {
		this.tip = tip;
	}
	
}
