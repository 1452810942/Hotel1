package cn.java.bean;

public class Reservation {
	@Override
	public String toString() {
		return "Reservation [vid=" + vid + ", vname=" + vname + ", vtel=" + vtel + ", vnumber=" + vnumber + ", rid="
				+ rid + ", rtype=" + rtype + ", rprice=" + rprice + ", ntime=" + ntime + ", ntype=" + ntype
				+ ", ndate1=" + ndate1 + ", ndate2=" + ndate2 + "]";
	}
	private int nid;
	private int vid;
	private String vname;
	private String vtel;
	private String vnumber;
	private int rid;
	private String rtype;
	private Double rprice;
	private String ntime;
	private String ntype;
	private String ndate1;
	private String ndate2;
	
	public Reservation() {
		
	}

	public int getNid() {
		return nid;
	}

	public void setNid(int nid) {
		this.nid = nid;
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

	public String getVnumber() {
		return vnumber;
	}

	public void setVnumber(String vnumber) {
		this.vnumber = vnumber;
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

	public String getNtime() {
		return ntime;
	}

	public void setNtime(String ntime) {
		this.ntime = ntime;
	}

	public String getNtype() {
		return ntype;
	}

	public void setNtype(String ntype) {
		this.ntype = ntype;
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

	public Reservation(int nid, int vid, String vname, String vtel, String vnumber, int rid, String rtype,
			Double rprice, String ntime, String ntype, String ndate1, String ndate2) {
		super();
		this.nid = nid;
		this.vid = vid;
		this.vname = vname;
		this.vtel = vtel;
		this.vnumber = vnumber;
		this.rid = rid;
		this.rtype = rtype;
		this.rprice = rprice;
		this.ntime = ntime;
		this.ntype = ntype;
		this.ndate1 = ndate1;
		this.ndate2 = ndate2;
	}

	public Reservation(int vid, String vname, String vtel, String vnumber, int rid, String rtype, Double rprice,
			String ntime, String ntype, String ndate1, String ndate2) {
		super();
		this.vid = vid;
		this.vname = vname;
		this.vtel = vtel;
		this.vnumber = vnumber;
		this.rid = rid;
		this.rtype = rtype;
		this.rprice = rprice;
		this.ntime = ntime;
		this.ntype = ntype;
		this.ndate1 = ndate1;
		this.ndate2 = ndate2;
	}
	
}
	