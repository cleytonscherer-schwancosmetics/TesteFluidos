package com.schwancosmetics.c4.sapiens.entidade;

import java.util.Objects;

public class OrdemProducao {

	private Integer codEmp;
	
	private String 	codOri;
	
	private Integer	numOrp;
	
	private String 	codPro;
	
	private String 	relPrd;
	
	private String	sitOrp;

	public OrdemProducao() {
	
	}

	public OrdemProducao(Integer codEmp, String codOri, Integer numOrp) {
		this.codEmp = codEmp;
		this.codOri = codOri;
		this.numOrp = numOrp;
	}

	public Integer getCodEmp() {
		return codEmp;
	}

	public void setCodEmp(Integer codEmp) {
		this.codEmp = codEmp;
	}

	public String getCodOri() {
		return codOri;
	}

	public void setCodOri(String codOri) {
		this.codOri = codOri;
	}

	public Integer getNumOrp() {
		return numOrp;
	}

	public void setNumOrp(Integer numOrp) {
		this.numOrp = numOrp;
	}

	public String getCodPro() {
		return codPro;
	}

	public void setCodPro(String codPro) {
		this.codPro = codPro;
	}

	public String getRelPrd() {
		return relPrd;
	}

	public void setRelPrd(String relPrd) {
		this.relPrd = relPrd;
	}

	public String getSitOrp() {
		return sitOrp;
	}

	public void setSitOrp(String sitOrp) {
		this.sitOrp = sitOrp;
	}

	@Override
	public String toString() {
		return "OrdemProducao [codEmp=" + codEmp + ", codOri=" + codOri + ", numOrp=" + numOrp + ", codPro=" + codPro
				+ ", relPrd=" + relPrd + ", sitOrp=" + sitOrp + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(codEmp, codOri, numOrp);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdemProducao other = (OrdemProducao) obj;
		return Objects.equals(codEmp, other.codEmp) && Objects.equals(codOri, other.codOri)
				&& Objects.equals(numOrp, other.numOrp);
	}
}
