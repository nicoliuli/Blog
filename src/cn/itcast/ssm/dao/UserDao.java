package cn.itcast.ssm.dao;

import java.util.List;
import cn.itcast.ssm.pojo.User;

public interface UserDao {
	//用户注册时检查用户名是否存在
	public List<User> findUserByUsername(User u) throws Exception;
	
	//Ajax登录验证用户名
	public int testUsername(String username) throws Exception;
	
	//Ajax登录验证密码
	public int testPassword(String password) throws Exception;
	
	//将新注册的用户名添加到数据库
	public void insertUser(User u) throws Exception;
	
	//用户登录时判断用户的用户名和密码是正确
	public User findUsernameAndPassword(User u) throws Exception;
	
	//根据user_id查找用户的帖子分类 
	public List<String> getClassByUserId(User u) throws Exception;
}
