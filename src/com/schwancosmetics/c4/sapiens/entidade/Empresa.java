package com.schwancosmetics.c4.sapiens.entidade;

public class Empresa {
	
	private Integer codEmp;
	
	private String	nomEmp;
	
	private String	sigEmp;

	public Empresa() {
   	}

	public Integer getCodEmp() {
		return codEmp;
	}

	public void setCodEmp(Integer codEmp) {
		this.codEmp = codEmp;
	}

	public String getNomEmp() {
		return nomEmp;
	}

	public void setNomEmp(String nomEmp) {
		this.nomEmp = nomEmp;
	}

	public String getSigEmp() {
		return sigEmp;
	}

	public void setSigEmp(String sigEmp) {
		this.sigEmp = sigEmp;
	}

	@Override
	public String toString() {
		return "Empresa [codEmp=" + codEmp + ", nomEmp=" + nomEmp + ", sigEmp=" + sigEmp + "]";
	}
	
}
