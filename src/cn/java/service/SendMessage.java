package cn.java.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import cn.java.bean.Page;
import net.sf.json.JSONObject;
/**
 * 避免数据冗余，将servlet中的向前端返回JSON的片段抽离出来
 * @author 1
 *
 * @param <T>
 */
public class SendMessage<T> {

	public void send(Paging<T> Paging,HttpServletResponse response,List<T> list,String page) throws IOException {
		Page<T> PageBean =  Paging.getCurrentPage(Integer.parseInt(page), list);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("totalPage", PageBean.getTotalPage());
		map.put("productList", PageBean.getProductList());
		map.put("isSearch", false);
		JSONObject jb = JSONObject.fromObject(map);
		PrintWriter pw = response.getWriter();
		pw.write(jb.toString());
		pw.flush();
		pw.close();
	}
	public Map<String,Object> getmap(Paging<T> Paging,List<T> list,String page) {
		Page<T> PageBean =  Paging.getCurrentPage(Integer.parseInt(page), list);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("totalPage", PageBean.getTotalPage());
		map.put("productList", PageBean.getProductList());
		return map;
		
	}
	public void sendType(Map<String,Object> map,HttpServletResponse response,boolean type,boolean isSearch) throws IOException {
		
		map.put("type", type);
		map.put("isSearch", isSearch);
		 JSONObject ja = JSONObject.fromObject(map);
		 PrintWriter pw = response.getWriter();
		 pw.write(ja.toString());
		 pw.flush();
		 pw.close();
	}
}
