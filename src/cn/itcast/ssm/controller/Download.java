package cn.itcast.ssm.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Download extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String filename = request.getParameter("filename");	//UUID_a.txt
		filename = new String(filename.getBytes("iso-8859-1"),"utf-8");
		String realname = filename.substring(filename.indexOf("_")+1);	//a.txt
		
		System.out.println(filename);
		System.out.println(realname);
		
		//得到文件的实际路径
		String path = this.getServletContext().getRealPath("/WEB-INF/upload")+File.separator+getPath(filename)+File.separator+filename;
		System.out.println("path:"+path);
		File file = new File(path);
		
		if(!file.exists()){	//所下载的文件不存在
			System.out.println("文件不存在");
			//跳转
			return;
		}
		response.setHeader("content-disposition", "attachment;filename="+URLEncoder.encode(realname,"UTF-8"));
		response.setContentLength((int)file.length());
		InputStream in = null;
		OutputStream out = null;
		try{ 
			in = new FileInputStream(file);//读文件
			int len = 0;
			byte []buf = new byte[1024];
			out = response.getOutputStream();
			while((len = in.read(buf)) > 0)
			{
				out.write(buf,0,len);//写入response对象
			}
		}finally{//关闭流
			if(in != null){
				try{
					in.close();
				}catch(Exception e){}
			}
			if(out != null){
				try{
					out.close();
				}catch(Exception e){}
			}
		}
		
	}

	
	//由于存储的时候根据文件名计算出文件保存的路径，所以下载的时候也根据文件名得到文件存储在哪个目录下，返回目录名
	public String getPath(String filename){
		int hashcode = filename.hashCode();
		int dir1 = hashcode&15;	//哈希值的低4位
		int dir2 = (hashcode>>4)&15;	//哈希值的5-8位
		String savepath = dir1+File.separator+dir2;
		return savepath;
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

	
}
