package jukebox;

import java.sql.Date;

public class Podcasts {
	private int podid;
	private String podname;
	private String podceleb;
	private Date poddate;
	private int podep;
	public int getPodid() {
		return podid;
	}
	public void setPodid(int podid) {
		this.podid = podid;
	}
	public String getPodname() {
		return podname;
	}
	public void setPodname(String podname) {
		this.podname = podname;
	}
	public String getPodceleb() {
		return podceleb;
	}
	public void setPodceleb(String podceleb) {
		this.podceleb = podceleb;
	}
	public Date getPoddate() {
		return poddate;
	}
	public void setPoddate(Date poddate) {
		this.poddate = poddate;
	}
	public int getPodep() {
		return podep;
	}
	public void setPodep(int podep) {
		this.podep = podep;
	}
	public Podcasts(int podid, String podname, String podceleb, Date poddate, int podep) {
		super();
		this.podid = podid;
		this.podname = podname;
		this.podceleb = podceleb;
		this.poddate = poddate;
		this.podep = podep;
	}
	@Override
	public String toString() {
		return "Podcasts [podid=" + podid + ", podname=" + podname + ", podceleb=" + podceleb + ", poddate=" + poddate
				+ ", podep=" + podep + "]";
	}
	

}
