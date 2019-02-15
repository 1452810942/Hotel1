package cn.java.service;

import cn.java.bean.Finance;

public class FinanceService {

	public static Finance returnFinance(int lid,double price,String source) {
		Finance finance = new Finance();
		finance.setLid(lid);
		finance.setFamount(price);
		finance.setFsource(source);
		return finance;
	}
}
