package cn.itcast.ssm.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.itcast.ssm.dao.UserDao;
import cn.itcast.ssm.mapper.ClassMapper;
import cn.itcast.ssm.mapper.UserMapper;
import cn.itcast.ssm.pojo.User;

@Repository("userDao")
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{
	
	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	//用户注册时检查用户名是否存在
	@Override
	public List<User> findUserByUsername(User u) throws Exception {
		
		return this.getSqlSession().getMapper(UserMapper.class).findUserByUsername(u);
	}
	
	//用户登录时判断用户的用户名和密码是正确
	@Override
	public User findUsernameAndPassword(User u) throws Exception {
		
		return this.getSqlSession().getMapper(UserMapper.class).findUsernameAndPassword(u);
	}
	
	//将新注册的用户名添加到数据库
	@Override
	public void insertUser(User u) throws Exception {
		this.getSqlSession().getMapper(UserMapper.class).insertUser(u);
		
	}

	//根据user_id查找用户的帖子分类 
	public List<String> getClassByUserId(User u) throws Exception{
		return this.getSqlSession().getMapper(UserMapper.class).getClassByUserId(u);
	}

	//Ajax测试登录密码
	@Override
	public int testPassword(String password) throws Exception {
		
		return this.getSqlSession().getMapper(UserMapper.class).testPassword(password);
	}
	//Ajax测试登录用户名
	@Override
	public int testUsername(String username) throws Exception {
		
		return this.getSqlSession().getMapper(UserMapper.class).testUsername(username);
	}
	
}
