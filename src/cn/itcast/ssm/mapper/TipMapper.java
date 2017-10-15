package cn.itcast.ssm.mapper;

import java.util.List;

import cn.itcast.ssm.pojo.Tip;
import cn.itcast.ssm.pojo.TipUser;
import cn.itcast.ssm.pojo.User;

public interface TipMapper {
	//将用户发表的帖子插入到数据库中
	public void insertTip(Tip tip) throws Exception;
	
	//查看我发表的所有帖子,根据用户id
	public List<Tip> getALlTip(int userid) throws Exception;
	
	//根据tipid删除帖子 
	public void deleteTipById(TipUser tipUser) throws Exception;
	
	//查询出帖子的详细内容,根据tipid和userid 
	public Tip getDetail(TipUser tipUser) throws Exception;
	
	//当修改帖子分类时，根据userid查询出该用户所有的分类
	public List<String> getAllClassByUserId(int id) throws Exception;
	
	//根据userid和tipid修改tip内容
	public void updateTipById(TipUser tipUser) throws Exception;
	
	//首页，查看所有的tip
	public List<Tip> getTipList(int currentPage) throws Exception;
	
	//查看我的tip的信息，根据tipid和userid，返回Tip
	public Tip getNeirong(Tip tip) throws Exception;
}
