package cn.java.bean;

public class Room {

	private int rid;
	private String rtype;
	private double rprice;
	private String rdesc;
	private String rstate;
	public Room() {
		
	}
	public Room(int rid, String rtype, double rprice, String rdesc, String rstate) {
		super();
		this.rid = rid;
		this.rtype = rtype;
		this.rprice = rprice;
		this.rdesc = rdesc;
		this.rstate = rstate;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getRtype() {
		return rtype;
	}
	public void setRtype(String rtype) {
		this.rtype = rtype;
	}
	public double getRprice() {
		return rprice;
	}
	public void setRprice(double rprice) {
		this.rprice = rprice;
	}
	public String getRdesc() {
		return rdesc;
	}
	public void setRdesc(String rdesc) {
		this.rdesc = rdesc;
	}
	public String getRstate() {
		return rstate;
	}
	public void setRstate(String rstate) {
		this.rstate = rstate;
	}
	
}
