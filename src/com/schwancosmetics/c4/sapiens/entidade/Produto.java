package com.schwancosmetics.c4.sapiens.entidade;

import java.io.Serializable;
import java.util.Objects;

public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer codEmp;
	
	private String 	codPro;
	
	private String 	desPro;
	
	private String 	desNfv;
	
	private String 	cplPro;
	
	private String 	uniMed;
	
	private String 	codOri;
	
	private String 	codFam;
	
	private Character	sitPro;
	
	private Long	refCor;

	public Produto() {
	}

	public Produto(Integer codEmp, String codPro) {
		this.codEmp = codEmp;
		this.codPro = codPro;
	}

	public Integer getCodEmp() {
		return codEmp;
	}

	public void setCodEmp(Integer codEmp) {
		this.codEmp = codEmp;
	}

	public String getCodPro() {
		return codPro;
	}

	public void setCodPro(String codPro) {
		this.codPro = codPro;
	}

	public String getDesPro() {
		return desPro;
	}

	public void setDesPro(String desPro) {
		this.desPro = desPro;
	}

	public String getDesNfv() {
		return desNfv;
	}

	public void setDesNfv(String desNfv) {
		this.desNfv = desNfv;
	}

	public String getCplPro() {
		return cplPro;
	}

	public void setCplPro(String cplPro) {
		this.cplPro = cplPro;
	}

	public String getUniMed() {
		return uniMed;
	}

	public void setUniMed(String uniMed) {
		this.uniMed = uniMed;
	}

	public String getCodOri() {
		return codOri;
	}

	public void setCodOri(String codOri) {
		this.codOri = codOri;
	}

	public String getCodFam() {
		return codFam;
	}

	public void setCodFam(String codFam) {
		this.codFam = codFam;
	}
	
	public Character getSitPro() {
		return sitPro;
	}

	public void setSitPro(Character sitPro) {
		this.sitPro = sitPro;
	}
	
	public Long getRefCor() {
		return refCor;
	}

	public void setRefCor(Long refCor) {
		this.refCor = refCor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codEmp, codPro);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(codEmp, other.codEmp) && Objects.equals(codPro, other.codPro);
	}

	@Override
	public String toString() {
		return "Produto [codEmp=" + codEmp + ", codPro=" + codPro + ", desPro=" + desPro + ", desNfv=" + desNfv
				+ ", cplPro=" + cplPro + ", uniMed=" + uniMed + ", codOri=" + codOri + ", codFam=" + codFam
				+ ", sitPro=" + sitPro + "]";
	}

	
	
	
}
