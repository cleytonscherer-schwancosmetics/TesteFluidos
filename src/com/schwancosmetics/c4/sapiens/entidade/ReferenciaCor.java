package com.schwancosmetics.c4.sapiens.entidade;

public class ReferenciaCor {
	
	private Long 		refCor;
	
	private String 		desRef;
	
	private String 		tipFor;
	
	private Double 		fluIde;
	
	private Integer		codEmp;

	public ReferenciaCor() {
		
	}

	public ReferenciaCor(Long refCor, String desRef, String tipFor, Double fluIde, Integer codEmp) {
		this.refCor = refCor;
		this.desRef = desRef;
		this.tipFor = tipFor;
		this.fluIde = fluIde;
		this.codEmp = codEmp;
	}

	public Long getRefCor() {
		return refCor;
	}

	public void setRefCor(Long refCor) {
		this.refCor = refCor;
	}

	public String getDesRef() {
		return desRef;
	}

	public void setDesRef(String desRef) {
		this.desRef = desRef;
	}

	public String getTipFor() {
		return tipFor;
	}

	public void setTipFor(String tipFor) {
		this.tipFor = tipFor;
	}

	public Double getFluIde() {
		return fluIde;
	}

	public void setFluIde(Double fluIde) {
		this.fluIde = fluIde;
	}

	public Integer getCodEmp() {
		return codEmp;
	}

	public void setCodEmp(Integer codEmp) {
		this.codEmp = codEmp;
	}

	@Override
	public String toString() {
		return "ReferenciaCor [refCor=" + refCor + ", desRef=" + desRef + ", tipFor=" + tipFor + ", fluIde=" + fluIde
				+ ", codEmp=" + codEmp + "]";
	}	
}
