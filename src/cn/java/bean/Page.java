package cn.java.bean;

import java.util.ArrayList;
import java.util.List;

public class Page<T> {
	//ÿҳ��ʾ����������
	public static final int everyPageCount = 10;
//	//��ǰҳ��
//	private int currentPage;
//	//��ǰҳ��ʾ������
//	private int currebtCount;
//	//������
//	private int totalCount;
	//��ҳ��
	private int totalPage;
	//ÿҳ��ʾ������
	private List<T> productList = new ArrayList<T>();
	
	public Page(int totalPage, List<T> productList) {
		super();
		this.totalPage = totalPage;
		this.productList = productList;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getProductList() {
		return productList;
	}

	public void setProductList(List<T> productList) {
		this.productList = productList;
	}

	@Override
	public String toString() {
		return "Page [totalPage=" + totalPage + ", productList=" + productList + "]";
	}

	public Page() {
		
	}
}
