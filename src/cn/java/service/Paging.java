package cn.java.service;


import java.util.List;

import cn.java.bean.Page;

/**
 * ���ص�ǰ����ҳ��Page����
 * @author 1
 *
 * @param <T>
 */
public class Paging<T> {
	
	public Page<T> getCurrentPage(int page,List<T> list) {
		int totalCount = list.size();
		//��ҳ��
		int totalPage = (int) Math.ceil(1.0*totalCount/Page.everyPageCount);
		//���������
		int counter = 1;
		//����page���󣬲��������з�װ����
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
