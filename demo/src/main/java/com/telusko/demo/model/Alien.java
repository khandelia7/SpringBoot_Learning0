package com.telusko.demo.model;

public class Alien {
	
	private int aid;
	
	private String aname;

	public Alien(int aid, String aname) {
		super();
		this.aid = aid;
		this.aname = aname;
	}

	/**
	 * @return the aid
	 */
	public int getAid() {
		return aid;
	}

	/**
	 * @param aid the aid to set
	 */
	public void setAid(int aid) {
		this.aid = aid;
	}

	/**
	 * @return the aname
	 */
	public String getAname() {
		return aname;
	}

	/**
	 * @param aname the aname to set
	 */
	public void setAname(String aname) {
		this.aname = aname;
	}
	
	// It will show value and not the address
	@Override
	public String toString() {
		return "Alien [aid=" + aid + ", aname=" + aname + "]";
	}
}