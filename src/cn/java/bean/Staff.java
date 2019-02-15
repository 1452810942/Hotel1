package cn.java.bean;
/**
 * 员工类 的Javabean
 * @author 1
 *
 */
public class Staff {
	private int sid;
	private String sname;
	private String sgender;
	private String stel;
	private String saddress;
	private String sdate;
	private String spassword;
	public Staff(int sid, String sname, String sgender, String stel, String saddress, String sdate, String password) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.sgender = sgender;
		this.stel = stel;
		this.saddress = saddress;
		this.sdate = sdate;
		this.spassword = password;
	}
	@Override
	public String toString() {
		return "Staff [sid=" + sid + ", sname=" + sname + ", sgender=" + sgender + ", stel=" + stel + ", saddress="
				+ saddress + ", sdate=" + sdate + ", spassword=" + spassword + "]";
	}
	public Staff() {
		
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSgender() {
		return sgender;
	}
	public void setSgender(String sgender) {
		this.sgender = sgender;
	}
	public String getStel() {
		return stel;
	}
	public void setStel(String stel) {
		this.stel = stel;
	}
	public String getSaddress() {
		return saddress;
	}
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public String getSpassword() {
		return spassword;
	}
	public void setSpassword(String password) {
		this.spassword = password;
	}
	
}
