package com.schwancosmetics.c4.sapiens.entidade;

public class Usuario {
	
	private Integer	codUsu;
	
	private	String	nomUsu;
	
	private	Integer	numCad;
	
	private	Integer	codEmp;
	
	private	Integer	codFil;

	public Usuario() {	
	}

	public Integer getCodUsu() {
		return codUsu;
	}

	public void setCodUsu(Integer codUsu) {
		this.codUsu = codUsu;
	}

	public String getNomUsu() {
		return nomUsu;
	}

	public void setNomUsu(String nomUsu) {
		this.nomUsu = nomUsu;
	}
	
	public Integer getNumCad() {
		return numCad;
	}

	public void setNumCad(Integer numCad) {
		this.numCad = numCad;
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

	@Override
	public String toString() {
		return "Usuario [codUsu=" + codUsu + ", nomUsu=" + nomUsu + ", numCad=" + numCad + ", codEmp=" + codEmp
				+ ", codFil=" + codFil + "]";
	}
	
}
