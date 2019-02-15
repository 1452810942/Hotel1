package cn.java.bean;

public class Vip {

	private int vid;
	private String vname;
	private String vgender;
	private String vnumber;
	private String vtel;
	private String vpassword;
	public Vip() {
		
	}

	public Vip(int vid, String vname, String vgender, String vnumber, String vtel,String vpassword) {
		super();
		this.vid = vid;
		this.vname = vname;
		this.vgender = vgender;
		this.vnumber = vnumber;
		this.vtel = vtel;
		this.vpassword = vpassword;
	}

	public String getVpassword() {
		return vpassword;
	}

	public void setVpassword(String vpassword) {
		this.vpassword = vpassword;
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

	public String getVgender() {
		return vgender;
	}

	public void setVgender(String vgender) {
		this.vgender = vgender;
	}

	public String getVnumber() {
		return vnumber;
	}

	public void setVnumber(String vnumber) {
		this.vnumber = vnumber;
	}

	public String getVtel() {
		return vtel;
	}

	public void setVtel(String vtel) {
		this.vtel = vtel;
	}
	
}
