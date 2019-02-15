package cn.java.service;


import java.util.List;

import cn.java.bean.Page;

/**
 * 返回当前请求页的Page对象
 * @author 1
 *
 * @param <T>
 */
public class Paging<T> {
	
	public Page<T> getCurrentPage(int page,List<T> list) {
		int totalCount = list.size();
		//总页数
		int totalPage = (int) Math.ceil(1.0*totalCount/Page.everyPageCount);
		//定义计数器
		int counter = 1;
		//建立page对象，并且向其中封装数据
		Page<T> pageBean = new Page<T>(); 
		pageBean.setTotalPage(totalPage);
		for(T t : list) {
			if(((page-1)*10)+1 <=counter && counter <= page*10) {
				List<T> temporarilyList= pageBean.getProductList();
				temporarilyList.add(t);
				pageBean.setProductList(temporarilyList);
			}
			counter++;
		}
		return pageBean;
	}
}
