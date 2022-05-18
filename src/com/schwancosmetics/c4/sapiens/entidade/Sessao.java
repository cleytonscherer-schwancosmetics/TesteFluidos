package com.schwancosmetics.c4.sapiens.entidade;

public class Sessao {
	
	private Integer numsec;
	private String  appusr;
	private String  comnam;
	private String  usrnam;
	private String  appnam;

	public Sessao() {
		this.appnam = " ";
		this.appusr = " ";
		this.comnam = " ";
		this.usrnam = " ";
		this.numsec = 0;
	}
	
	public Integer getNumSec() {
		return numsec;
	}
	
	public void setNumSec(Integer numsec) {
		this.numsec = numsec;
	}
	
	public String getAppUsr() {
		return appusr;
	}
	
	public void setAppUsr(String appusr) {
		this.appusr = appusr;
	}
	
	public String getComNam() {
		return comnam;
	}

	public void setComNam(String comnam) {
		this.comnam = comnam;
	}

	public String getUsrNam() {
		return usrnam;
	}

	public void setUsrNam(String usrnam) {
		this.usrnam = usrnam;
	}

	public String getAppNam() {
		return appnam;
	}

	public void setAppNam(String appnam) {
		this.appnam = appnam;
	}

	@Override
	public String toString() {
		return "Sessao [numsec=" + numsec + ", appusr=" + appusr + ", comnam=" + comnam + ", usrnam=" + usrnam
				+ ", appnam=" + appnam + "]";
	}
	
}
