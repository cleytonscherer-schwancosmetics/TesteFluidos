package com.schwancosmetics.c4.sapiens.entidade;

public class Filial {

	private	Integer	codEmp;
	
	private Integer codFil;
	
	private String	nomFil;
	
	private String	sigFil;

	public Filial() {

	}
	
	public Integer getCodEmp() {
		return codEmp;
	}

	public void setCodEmp(Integer codEmp) {
		this.codEmp = codEmp;
	}

	public Integer getCodFil() {
		return codFil;
	}

	public void setCodFil(Integer codFil) {
		this.codFil = codFil;
	}

	public String getNomFil() {
		return nomFil;
	}

	public void setNomFil(String nomFil) {
		this.nomFil = nomFil;
	}

	public String getSigFil() {
		return sigFil;
	}

	public void setSigFil(String sigFil) {
		this.sigFil = sigFil;
	}

	@Override
	public String toString() {
		return "Filial [codFil=" + codFil + ", nomFil=" + nomFil + ", sigFil=" + sigFil + "]";
	}
}
