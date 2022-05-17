package com.schwancosmetics.c4.sapiens.entidade;

import java.io.Serializable;

public class FormulaBase implements Serializable {

	private static final long serialVersionUID = 1L;

	private String 		tipFor;
	
	private String 		desFor;
	
	private Integer		codEmp;
	
	private String 		ingVol;
	
	private Double	 	tolMin;
	
	private Double	 	tolMax;

	public FormulaBase() {	
	}

	public FormulaBase(String tipFor, String desFor, Integer codEmp, String ingVol, Double tolMin, Double tolMax) {
		this.tipFor = tipFor;
		this.desFor = desFor;
		this.codEmp = codEmp;
		this.ingVol = ingVol;
		this.tolMin = tolMin;
		this.tolMax = tolMax;
	}

	public String getTipFor() {
		return tipFor;
	}

	public void setTipFor(String tipFor) {
		this.tipFor = tipFor;
	}

	public String getDesFor() {
		return desFor;
	}

	public void setDesFor(String desFor) {
		this.desFor = desFor;
	}

	public Integer getCodEmp() {
		return codEmp;
	}

	public void setCodEmp(Integer codEmp) {
		this.codEmp = codEmp;
	}

	public String getIngVol() {
		return ingVol;
	}

	public void setIngVol(String ingVol) {
		this.ingVol = ingVol;
	}

	public Double getTolMin() {
		return tolMin;
	}

	public void setTolMin(Double tolMin) {
		this.tolMin = tolMin;
	}

	public Double getTolMax() {
		return tolMax;
	}

	public void setTolMax(Double tolMax) {
		this.tolMax = tolMax;
	}

	@Override
	public String toString() {
		return "FormulaBase [tipFor=" + tipFor + ", desFor=" + desFor + ", codEmp=" + codEmp + ", ingVol=" + ingVol
				+ ", tolMin=" + tolMin + ", tolMax=" + tolMax + "]";
	}
	
}
