package cn.itcast.ssm.service.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;


import cn.itcast.ssm.dao.ClassDao;
import cn.itcast.ssm.dao.TipDao;
import cn.itcast.ssm.dao.UserDao;
import cn.itcast.ssm.mapper.UserMapper;
import cn.itcast.ssm.pojo.Classes;
import cn.itcast.ssm.pojo.Pager;
import cn.itcast.ssm.pojo.Tip;
import cn.itcast.ssm.pojo.TipUser;
import cn.itcast.ssm.pojo.User;
import cn.itcast.ssm.service.ClassService;
import cn.itcast.ssm.service.TipService;
import cn.itcast.ssm.service.UserService;
import cn.itcast.ssm.util.BigDataPager;
import cn.itcast.ssm.util.JdbcUtils;


@Service("TipService")
public class TipServiceImpl implements TipService {
	@Resource(name="tipDao")
	private TipDao tipdao;//注入
	
	//将用户添加的帖子插入到数据库
	@Override
	public void insertTip(Tip tip) throws Exception {
		tipdao.insertTip(tip);
		
	}
	
	//查看我发表的所有帖子,根据用户id
	public List<Tip> getALlTip(int userid) throws Exception{
		return tipdao.getALlTip(userid);
	}
	
	//根据tipid删除帖子 
	public void deleteTipById(TipUser tipUser) throws Exception{
		tipdao.deleteTipById(tipUser);
	}
	
	//查询出帖子的详细内容,根据tipid和userid 
	public Tip getDetail(TipUser tipUser) throws Exception{
		return tipdao.getDeatil(tipUser);
	}
	
	//当修改帖子分类时，根据userid查询出该用户所有的分类
	public List<String> getAllClassByUserId(int id) throws Exception{
		return tipdao.getAllClassByUserId(id);
	}
	
	//根据userid和tipid修改tip内容
	public void updateTipById(TipUser tipUser) throws Exception{
		tipdao.updateTipById(tipUser);
	}
	
	//首页，查看所有的tip
	public Pager<Tip> getTipList(int currentPage, int pageSize) throws Exception{
		
		int count = BigDataPager.getCount();//数据库的总记录数，通过count(*)查询到
		int totalPage = BigDataPager.getTotalPage(pageSize,count);	//得到总页数
		int prePage = 0;
		int nextPage = 0;
		int bar[] = null;

		
		prePage = BigDataPager.getPrePage(currentPage);	//上一页
		nextPage = BigDataPager.getNextpage(currentPage, totalPage);	//下一页

		//生成分页条
		bar = BigDataPager.getBar(totalPage, currentPage);
		
		int limit = BigDataPager.getLimit(currentPage, pageSize);	//limit

		Pager pager = new Pager();
		pager.setCurrentPage(currentPage);	//要查找的页数,通过request得到
		pager.setPageSize(pageSize);	//页面大小
		pager.setTotalPage(totalPage);	//总页数	，通过count(*) / pageSize查询到
		pager.setTotalRecord(count);	//总记录数，通过count(*)查询到
		pager.setPrePage(prePage);
		pager.setNextPage(nextPage);
		pager.setBar(bar);
		List<Tip> list = tipdao.getTipList(limit);	//应该使用mybatis
		pager.setDataList(list);	//查询结果，通过查询数据库得到
		return pager;
	}
	public TipDao getTipdao() {
		return tipdao;
	}

	public void setTipdao(TipDao tipdao) {
		this.tipdao = tipdao;
	}
	
	//查看我的tip的信息，根据tipid和userid，返回Tip
	public Tip getNeirong(Tip tip) throws Exception{
		return this.tipdao.getNeirong(tip);
	}
	
	/****************************************************************/

	//查询学生信息
	/*public List<Tip> getTip(int pageNum, int pageSize) throws Exception{
		PreparedStatement pstm = null;
		String sql = null;
		ResultSet rs = null;
		Connection conn = null;
		
		List<Tip> list = new ArrayList();

		int limit = (pageNum-1)* pageSize;
		sql = "select * from tip limit " + limit +","+pageSize;
		System.out.println(sql);
		conn = JdbcUtils.getConnection();
		pstm = conn.prepareStatement(sql);
		rs = pstm.executeQuery();
		while(rs.next()){
			int id = rs.getInt(1);
			int user_id = rs.getInt(2);
			String clazz = rs.getString(3);
			Date time = rs.getDate(4);
			String title = rs.getString(5);
			String detail = rs.getString(6);
			
			Tip tip = new Tip();
			tip.setId(id);
			tip.setUserid(user_id);
			tip.setClasses(clazz);
			tip.setTime(time);
			tip.setTitle(title);
			tip.setDetail(detail);
			list.add(tip);
		}

		return list;
		
	}*/

}
