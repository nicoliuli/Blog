package cn.itcast.ssm.pojo;

import java.io.Serializable;
import java.util.List;

//分装查询的信息
public class  Pager<T> implements Serializable {
	
	private static final long serialVersionUID = 1L;	//序列化id
	private int pageSize = 5;	//页面大小
	private int currentPage;	//要跳转的页数
	private int totalPage;	//总页数
	private int totalRecord;	//总记录数
	private int prePage;	//上一页
	private int nextPage;	//下一页
	private List<T> dataList;	//存放在页面显示的数据
	int bar[];	//进度条
	
	public Pager() {
		
	}
	public Pager(int pageSize, int currentPage, int totalPage, int totalRecord,
			List<T> dataList) {
		super();
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.totalPage = totalPage;
		this.totalRecord = totalRecord;
		this.dataList = dataList;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public List<T> getDataList() {
		return dataList;
	}
	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}
	public int getPrePage() {
		return prePage;
	}
	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public int[] getBar() {
		return bar;
	}
	public void setBar(int[] bar) {
		this.bar = bar;
	}
	
	
}
