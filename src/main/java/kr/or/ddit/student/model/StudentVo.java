package kr.or.ddit.student.model;

import java.util.Date;

public class StudentVo {
	
	private int id;		  //학생번호
	private String name;  //학생이름
	private int call_cnt; //호출횟수
	private Date reg_dt;
	private String addr1;
	private String addr2;
	private String zipcd;
	private String pic;
	private String picpath;
	private String picname;
	
	
	public String getPicname() {
		return picname;
	}



	public void setPicname(String picname) {
		this.picname = picname;
	}



	public String getAddr1() {
		return addr1;
	}



	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}



	public String getAddr2() {
		return addr2;
	}



	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}



	public String getZipcd() {
		return zipcd;
	}



	public void setZipcd(String zipcd) {
		this.zipcd = zipcd;
	}



	public String getPic() {
		return pic;
	}



	public void setPic(String pic) {
		this.pic = pic;
	}



	public String getPicpath() {
		return picpath;
	}



	public void setPicpath(String picpath) {
		this.picpath = picpath;
	}



	public StudentVo(){
		
	}
	
	
	
	public Date getReg_dt() {
		return reg_dt;
	}



	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCall_cnt() {
		return call_cnt;
	}
	public void setCall_cnt(int call_cnt) {
		this.call_cnt = call_cnt;
	}

	@Override
	public String toString() {
		return "StudentVo [id=" + id + ", name=" + name + ", call_cnt="
				+ call_cnt + "]";
	}
	
	
}
