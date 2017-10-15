package cn.itcast.ssm.service;

import java.util.List;

import cn.itcast.ssm.pojo.Classes;
import cn.itcast.ssm.pojo.User;

public interface ClassService {
	//将用户添加的帖子分类插入到数据库
	public void addClass(Classes classes) throws Exception;
	
	//查询用户的分类 ,根据userid
	public List<Classes> getClassesByUserId(int id) throws Exception;
	
}
