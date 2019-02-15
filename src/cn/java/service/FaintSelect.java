package cn.java.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.java.bean.Liveroom;
import cn.java.bean.Reservation;
import cn.java.bean.Staff;
import cn.java.bean.Vip;
/**
 * 模糊查找功能，模仿搜索引擎，对数据库中的每个字段进行模糊匹配
 * @author 1
 *
 */
public class FaintSelect {
	public static final String nameRegular = "[\\u4E00-\\u9FA5\\uf900-\\ufa2d·s]{2,20}";
	public static final String idCardRegular = "[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{4}";
	public static final String telRegular = "1[3,4,5,7,8]\\d{9}";
	public List<Reservation> faintSelectReservation(List<Reservation> list,String child){
		List<Reservation> results = new ArrayList<Reservation>();
		for(Reservation reservation : list) {
			if(search(child,reservation.getVname()) || search(child,reservation.getNtype()) || search(child,reservation.getRtype())) {
				results.add(reservation);
				continue;
			}
			if(search(child,String.valueOf(reservation.getVid())) || search(child,String.valueOf(reservation.getRid())) || search(child,reservation.getVtel()) || search(child,reservation.getVnumber()) || search(child,String.valueOf(reservation.getRprice()))) {
				results.add(reservation);
				continue;
			}
			if(search(child,reservation.getNtime()) || search(child,reservation.getNdate1()) || search(child,reservation.getNdate2())) {
				results.add(reservation);
				continue;
			}
		}
		return results;
	}
	public List<Liveroom> fainSelectLiveroom(List<Liveroom> list,String child){
		List<Liveroom> results = new ArrayList<Liveroom>();
		for(Liveroom lr : list) {
			if(search(child,lr.getRtype()) || search(child,lr.getVname()) ||  search(child,lr.getLdesc())) {
				System.out.println(lr.getVname());
				results.add(lr);
				continue;
			}
			System.out.println(results+"name");
			if(search(child,String.valueOf(lr.getLid())) || search(child,String.valueOf(lr.getNid())) || search(child,String.valueOf(lr.getRid())) || search(child,String.valueOf(lr.getVid())) || search(child,String.valueOf(lr.getRprice())) || search(child,lr.getVtel())) {
				results.add(lr);
				continue;
			}
			System.out.println("ndate1"+lr.getNdate1());
			System.out.println("ndate2"+lr.getNdate2());
			if(search(child,lr.getNdate1())) {
				results.add(lr);
				continue;
			}
			if(lr.getNdate2() != null && !"".equals(lr.getNdate2())) {
				if(search(child,lr.getNdate2())) {
					results.add(lr);
					continue;
				}
			}
		}
		
		return results;
		
	}
	public List<Vip> faintSelectVip(List<Vip> list, String child) {
		List<Vip> results = new ArrayList<Vip>();
		for(Vip lr : list) {
			if(search(child,lr.getVname()) || search(child,lr.getVgender()) ) {
				results.add(lr);
				continue;
			}
			if(search(child,String.valueOf(lr.getVid())) || search(child,lr.getVnumber()) ||  search(child,lr.getVtel())) {
			
				results.add(lr);
				continue;
			}
		}
		return results;
	}
	/**
	 * 模糊查找的核心函数
	 */
	public boolean search(String child,String father){
		  
		   Pattern pattern = Pattern.compile(child,Pattern.CASE_INSENSITIVE);
		   
		   Matcher matcher = pattern.matcher(father);
		      if(matcher.find()){
		        return true;
		      }
		                                                                             
		   return false;
		}
	public List<Staff> faintSelectStaff(List<Staff> list, String child) {
		List<Staff> results = new ArrayList<Staff>();
		for(Staff lr : list) {
			if(search(child,lr.getSname()) || search(child,lr.getSgender()) || search(child,lr.getSaddress()) ) {
				results.add(lr);
				continue;
			}
			if(search(child,String.valueOf(lr.getSid())) || search(child,lr.getStel()) || search(child,lr.getSdate()) || search(child,lr.getSpassword())) {
				results.add(lr);
				continue;
			}
			
		}
		return results;
	}
	
}
