package cn.itcast.ssm.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.itcast.ssm.dao.ClassDao;
import cn.itcast.ssm.dao.UserDao;
import cn.itcast.ssm.mapper.UserMapper;
import cn.itcast.ssm.pojo.Classes;
import cn.itcast.ssm.pojo.User;
import cn.itcast.ssm.service.ClassService;
import cn.itcast.ssm.service.UserService;
@Service("ClassService")
public class ClassServiceImpl implements ClassService {
	@Resource(name="classDao")
	private ClassDao classdao;//注入

	public ClassDao getClassdao() {
		return classdao;
	}

	public void setClassdao(ClassDao classdao) {
		this.classdao = classdao;
	}
	
	//将用户添加的帖子分类插入到数据库
	@Override
	public void addClass(Classes classes) throws Exception {
		classdao.addClass(classes);
		
	}
	
	//查询用户的分类 ,根据userid
	@Override
	public List<Classes> getClassesByUserId(int id) throws Exception{
		return classdao.getClassesByUserId(id);
	}
	
	
}
