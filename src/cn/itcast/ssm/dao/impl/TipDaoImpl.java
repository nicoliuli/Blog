package cn.itcast.ssm.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.itcast.ssm.dao.ClassDao;
import cn.itcast.ssm.dao.TipDao;
import cn.itcast.ssm.dao.UserDao;
import cn.itcast.ssm.mapper.ClassMapper;
import cn.itcast.ssm.mapper.TipMapper;
import cn.itcast.ssm.mapper.UserMapper;
import cn.itcast.ssm.pojo.Classes;
import cn.itcast.ssm.pojo.Tip;
import cn.itcast.ssm.pojo.TipUser;
import cn.itcast.ssm.pojo.User;

@Repository("tipDao")
public class TipDaoImpl extends SqlSessionDaoSupport implements TipDao{
	
	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	//将用户添加的帖子分类插入到数据库
	@Override
	public void insertTip(Tip tip) throws Exception {
		this.getSqlSession().getMapper(TipMapper.class).insertTip(tip);
		
	}
	
	//查看我发表的所有帖子,根据用户id
	public List<Tip> getALlTip(int userid) throws Exception{
		return this.getSqlSession().getMapper(TipMapper.class).getALlTip(userid);
	}
	
	//根据tipid删除帖子 
	public void deleteTipById(TipUser tipUser) throws Exception{
		this.getSqlSession().getMapper(TipMapper.class).deleteTipById(tipUser);
	}
	
	
	//查询出帖子的详细内容,根据tipid和userid 
	public Tip getDeatil(TipUser tipUser) throws Exception{
		return this.getSqlSession().getMapper(TipMapper.class).getDetail(tipUser);
	}
	
	//当修改帖子分类时，根据userid查询出该用户所有的分类
	public List<String> getAllClassByUserId(int id) throws Exception{
		return this.getSqlSession().getMapper(TipMapper.class).getAllClassByUserId(id);
	}
	
	
	//根据userid和tipid修改tip内容
	public void updateTipById(TipUser tipUser) throws Exception{
		this.getSqlSession().getMapper(TipMapper.class).updateTipById(tipUser);
	}
	
	//首页，查看所有的tip
	public List<Tip> getTipList(int currentPage) throws Exception{
		List<Tip> tipList = this.getSqlSession().getMapper(TipMapper.class).getTipList(currentPage);
		return tipList;
	}
	
	//查看我的tip的详细内容，根据tipid和userid
	public Tip getNeirong(Tip tip) throws Exception{
		return this.getSqlSession().getMapper(TipMapper.class).getNeirong(tip);
	}
}
