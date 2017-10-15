package cn.itcast.ssm.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListFileServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = this.getServletContext().getRealPath("/WEB-INF/upload");	//获得上传的文件的目录
		Map map = new HashMap();
		fileList(new File(path),map);
		request.setAttribute("map", map);
		request.getRequestDispatcher("/WEB-INF/jsp/listfile.jsp").forward(request, response);
		
	}

	
	public void fileList(File file,Map map){
		if(!file.isFile()){//如果是目录
			File child[] = file.listFiles();//获得所有子文件
			if(child != null && child.length > 0){
				for(File f:child){
					fileList(f,map);
				}
			}
			
		}else{//如果是文件
			String filename = file.getName().substring(file.getName().indexOf("_")+1);	//得到文件的真实文件名
			//key：文件在服务器中的文件名（UUID_文件名.txt）
			//value：文件的真实文件名（文件名.txt）
			map.put(file.getName(), filename);
			//<a href="?file.getName()">fileName</a>
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	
	}
	

}
