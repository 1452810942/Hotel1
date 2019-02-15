package cn.java.bean;

public class Finance {

	private int fid;
	private int lid;
	private String fsource;
	private double famount;
	public Finance(int fid, int lid, String fsource, double famount) {
		super();
		this.fid = fid;
		this.lid = lid;
		this.fsource = fsource;
		this.famount = famount;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getFsource() {
		return fsource;
	}
	public void setFsource(String fsource) {
		this.fsource = fsource;
	}
	public double getFamount() {
		return famount;
	}
	public void setFamount(double famount) {
		this.famount = famount;
	}
	public Finance() {
		
	}
}
