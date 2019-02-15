package cn.java.bean;

public class Liveroom {
	private int lid;
	private int nid;
	private int rid;
	private String rtype;
	private Double rprice;
	@Override
	public String toString() {
		return "Liveroom [lid=" + lid + ", nid=" + nid + ", rid=" + rid + ", rtype=" + rtype + ", rprice=" + rprice
				+ ", vid=" + vid + ", vname=" + vname + ", vtel=" + vtel + ", ndate1=" + ndate1 + ", ndate2=" + ndate2
				+ ", ldesc=" + ldesc + "]";
	}
	private int vid;
	private String vname;
	private String vtel;
	private String ndate1;
	private String ndate2;
	private String ldesc;
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
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
	public Double getRprice() {
		return rprice;
	}
	public void setRprice(Double rprice) {
		this.rprice = rprice;
	}
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	public String getVtel() {
		return vtel;
	}
	public void setVtel(String vtel) {
		this.vtel = vtel;
	}
	public String getNdate1() {
		return ndate1;
	}
	public void setNdate1(String ndate1) {
		this.ndate1 = ndate1;
	}
	public String getNdate2() {
		return ndate2;
	}
	public void setNdate2(String ndate2) {
		this.ndate2 = ndate2;
	}
	public String getLdesc() {
		return ldesc;
	}
	public void setLdesc(String ldesc) {
		this.ldesc = ldesc;
	}
	public Liveroom(int lid, int nid, int rid, String rtype, Double rprice, int vid, String vname, String vtel,
			String ndate1, String ndate2, String ldesc) {
		super();
		this.lid = lid;
		this.nid = nid;
		this.rid = rid;
		this.rtype = rtype;
		this.rprice = rprice;
		this.vid = vid;
		this.vname = vname;
		this.vtel = vtel;
		this.ndate1 = ndate1;
		this.ndate2 = ndate2;
		this.ldesc = ldesc;
	}
	public Liveroom() {
		
	}


	
}
