package cn.itcast.ssm.mapper;

import java.util.List;

import cn.itcast.ssm.pojo.Say;
import cn.itcast.ssm.pojo.Tip;
import cn.itcast.ssm.pojo.TipUser;
import cn.itcast.ssm.pojo.User;

public interface SayMapper {
	
	//将用户的评论插入say表中
	public void say(Say say) throws Exception;
	
	//查看所有的评论，根据tipid
	public List<Say> getAllSay(int tipid) throws Exception;
	
	// 删除评论，根据tipid，评论者的id，评论内容detail
	public void delSay(Say say) throws Exception;
	
}
