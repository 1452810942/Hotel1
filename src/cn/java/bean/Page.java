package cn.java.bean;

import java.util.ArrayList;
import java.util.List;

public class Page<T> {
	//每页显示的数据条数
	public static final int everyPageCount = 10;
//	//当前页数
//	private int currentPage;
//	//当前页显示的条数
//	private int currebtCount;
//	//总条数
//	private int totalCount;
	//总页数
	private int totalPage;
	//每页显示的数据
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
