package cn.java.bean;

public class Suggest {

	private int suid;
	private int lid;
	private int rid;
	private int vid;
	private String sudesc;
	private String sudate;
	public Suggest(int suid, int lid, int rid, int vid, String sudesc, String sudate) {
		super();
		this.suid = suid;
		this.lid = lid;
		this.rid = rid;
		this.vid = vid;
		this.sudesc = sudesc;
		this.sudate = sudate;
	}
	public Suggest(int lid, int rid, int vid, String sudesc, String sudate) {
		super();
		this.lid = lid;
		this.rid = rid;
		this.vid = vid;
		this.sudesc = sudesc;
		this.sudate = sudate;
	}
	public Suggest(){
		
	}
	public int getSuid() {
		return suid;
	}
	public void setSuid(int suid) {
		this.suid = suid;
	}
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}
	public String getSudesc() {
		return sudesc;
	}
	public void setSudesc(String sudesc) {
		this.sudesc = sudesc;
	}
	public String getSudate() {
		return sudate;
	}
	public void setSudate(String sdate) {
		this.sudate = sdate;
	}
	
}
