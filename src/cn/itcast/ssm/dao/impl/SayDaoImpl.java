package cn.itcast.ssm.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.itcast.ssm.dao.ClassDao;
import cn.itcast.ssm.dao.SayDao;
import cn.itcast.ssm.dao.TipDao;
import cn.itcast.ssm.dao.UserDao;
import cn.itcast.ssm.mapper.ClassMapper;
import cn.itcast.ssm.mapper.SayMapper;
import cn.itcast.ssm.mapper.TipMapper;
import cn.itcast.ssm.mapper.UserMapper;
import cn.itcast.ssm.pojo.Classes;
import cn.itcast.ssm.pojo.Say;
import cn.itcast.ssm.pojo.Tip;
import cn.itcast.ssm.pojo.TipUser;
import cn.itcast.ssm.pojo.User;

@Repository("sayDao")
public class SayDaoImpl extends SqlSessionDaoSupport implements SayDao{
	
	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	//将用户的评论插入say表中
	@Override
	public void say(Say say) throws Exception {
		this.getSqlSession().getMapper(SayMapper.class).say(say);
		
	}
	
	//查看所有的评论，根据tipid
	@Override
	public List<Say> getAllSay(int tipid) throws Exception{
		return this.getSqlSession().getMapper(SayMapper.class).getAllSay(tipid);
	}
	
}
