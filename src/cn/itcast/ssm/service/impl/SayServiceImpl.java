package cn.itcast.ssm.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.itcast.ssm.dao.ClassDao;
import cn.itcast.ssm.dao.SayDao;
import cn.itcast.ssm.dao.TipDao;
import cn.itcast.ssm.dao.UserDao;
import cn.itcast.ssm.mapper.UserMapper;
import cn.itcast.ssm.pojo.Classes;
import cn.itcast.ssm.pojo.Say;
import cn.itcast.ssm.pojo.Tip;
import cn.itcast.ssm.pojo.TipUser;
import cn.itcast.ssm.pojo.User;
import cn.itcast.ssm.service.ClassService;
import cn.itcast.ssm.service.SayService;
import cn.itcast.ssm.service.TipService;
import cn.itcast.ssm.service.UserService;
@Service("SayService")
public class SayServiceImpl implements SayService {
	@Resource(name="sayDao")
	private SayDao saydao;//注入
	
	//将用户的评论插入到say表中
	@Override
	public void say(Say say) throws Exception {
		saydao.say(say);
		
	}
	
	//查看所有的评论，根据tipid
	public List<Say> getAllSay(int tipid) throws Exception{
		return saydao.getAllSay(tipid);
	}
	

	
	public SayDao getSaydao() {
		return saydao;
	}

	public void setSaydao(SayDao saydao) {
		this.saydao = saydao;
	}
	
	
}
