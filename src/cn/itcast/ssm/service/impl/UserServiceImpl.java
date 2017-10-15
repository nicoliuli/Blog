package cn.itcast.ssm.service.impl;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import cn.itcast.ssm.dao.UserDao;
import cn.itcast.ssm.mapper.UserMapper;
import cn.itcast.ssm.pojo.User;
import cn.itcast.ssm.service.UserService;
import cn.itcast.ssm.util.CreateMD5;
@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource(name="userDao")
	private UserDao userdao;//注入
	
	//用户注册时检查用户名是否存在
	@Override
	public List<User> findUserByUsername(User u) throws Exception {
		
		return userdao.findUserByUsername(u);
	}
	
	//用户登录时判断用户的用户名和密码是正确
	@Override
	public User findUsernameAndPassword(User u) throws Exception {
		
		return userdao.findUsernameAndPassword(u);
	}
	
	//将新注册的用户名添加到数据库
	@Override
	public void insertUser(User u) throws Exception {
		userdao.insertUser(u);
		
	}
	
	//根据user_id查找用户的帖子分类 
	public List<String> getClassByUserId(User u) throws Exception{
		return userdao.getClassByUserId(u);
	}

	public UserDao getUserdao() {
		return userdao;
	}

	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}
	
	//Ajax测试登录密码
	@Override
	public int testPassword(HttpServletRequest request) throws Exception {
		String password = CreateMD5.getMD5(request.getParameter("password"));
		int count = userdao.testPassword(password);
		return count;
	}
	
	//Ajax测试登录用户名
	@Override
	public int testUsername(HttpServletRequest request) throws Exception {
		String username = request.getParameter("username");
		
		int count = userdao.testUsername(username);
		return count;
	}

	

	

}
