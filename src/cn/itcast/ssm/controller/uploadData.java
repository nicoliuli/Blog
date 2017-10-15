package cn.itcast.ssm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.ssm.pojo.Data;

import net.sf.json.JSONObject;


public class uploadData extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		Data d = new Data();
		d.setHasUpload(ProgressListenerImpl.hasUpload);
		d.setItem(ProgressListenerImpl.item);
		d.setTotal(ProgressListenerImpl.total);
		d.setPresent((double)ProgressListenerImpl.hasUpload / (double)ProgressListenerImpl.total);
		System.out.println("上传的百分比："+d.getPresent()+"+++++++++");
		JSONObject obj = JSONObject.fromObject(d);
		PrintWriter pw = response.getWriter();
		pw.print(obj.toString());
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

	
}
