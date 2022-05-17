package com.schwancosmetics.c4.sapiens.entidade;

import java.time.LocalDate;
import java.util.Objects;

public class Componente {
	
	private Integer codEmp;
	
	private	String	codOri;
	
	private	Integer	numOrp;
	
	private	Integer	seqCmp;
	
	private String 	codCmp;
	
	private	String	codDer;
	
	private	Double	qtdPrv;
	
	private	Double	qtdTra;
	
	private	Double	qtdSpa;
	
	private Double	qtdSpa2;
	
	private	LocalDate datFab;
	
	private	LocalDate	datVlt;
	
	private	String	codDep;
	
	private	String	codLot;
	
	private Character	comTra;
	
	private	String	depTra;
	
	private String	numSep;
	
	private	Integer	seqEnt;
	
	private	LocalDate	datMov;
	
	private	Integer	seqMov;
	
	private	Character	indSpa;
	
	private	Integer	numCad;
	
	private Integer codEtg;
	
	public Componente() {
	}

	public Componente(Integer codEmp, String codOri, Integer numOrp, Integer seqCmp) {
		this.codEmp = codEmp;
		this.codOri = codOri;
		this.numOrp = numOrp;
		this.seqCmp = seqCmp;
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

	public Integer getSeqCmp() {
		return seqCmp;
	}

	public void setSeqCmp(Integer seqCmp) {
		this.seqCmp = seqCmp;
	}

	public String getCodCmp() {
		return codCmp;
	}

	public void setCodCmp(String codCmp) {
		this.codCmp = codCmp;
	}

	public String getCodDer() {
		return codDer;
	}

	public void setCodDer(String codDer) {
		this.codDer = codDer;
	}

	public Double getQtdPrv() {
		return qtdPrv;
	}

	public void setQtdPrv(Double qtdPrv) {
		this.qtdPrv = qtdPrv;
	}

	public Double getQtdTra() {
		return qtdTra;
	}

	public void setQtdTra(Double qtdTra) {
		this.qtdTra = qtdTra;
	}

	public Double getQtdSpa() {
		return qtdSpa;
	}

	public void setQtdSpa(Double qtdSpa) {
		this.qtdSpa = qtdSpa;
	}

	public Double getQtdSpa2() {
		return qtdSpa2;
	}

	public void setQtdSpa2(Double qtdSpa2) {
		this.qtdSpa2 = qtdSpa2;
	}

	public LocalDate getDatFab() {
		return datFab;
	}

	public void setDatFab(LocalDate datFab) {
		this.datFab = datFab;
	}

	public LocalDate getDatVlt() {
		return datVlt;
	}

	public void setDatVlt(LocalDate datVlt) {
		this.datVlt = datVlt;
	}

	public String getCodDep() {
		return codDep;
	}

	public void setCodDep(String codDep) {
		this.codDep = codDep;
	}

	public String getCodLot() {
		return codLot;
	}

	public void setCodLot(String codLot) {
		this.codLot = codLot;
	}

	public Character getComTra() {
		return comTra;
	}

	public void setComTra(Character comTra) {
		this.comTra = comTra;
	}

	public String getDepTra() {
		return depTra;
	}

	public void setDepTra(String depTra) {
		this.depTra = depTra;
	}

	public String getNumSep() {
		return numSep;
	}

	public void setNumSep(String numSep) {
		this.numSep = numSep;
	}

	public Integer getSeqEnt() {
		return seqEnt;
	}

	public void setSeqEnt(Integer seqEnt) {
		this.seqEnt = seqEnt;
	}

	public LocalDate getDatMov() {
		return datMov;
	}

	public void setDatMov(LocalDate datMov) {
		this.datMov = datMov;
	}

	public Integer getSeqMov() {
		return seqMov;
	}

	public void setSeqMov(Integer seqMov) {
		this.seqMov = seqMov;
	}

	public Character getIndSpa() {
		return indSpa;
	}

	public void setIndSpa(Character indSpa) {
		this.indSpa = indSpa;
	}

	public Integer getNumCad() {
		return numCad;
	}

	public void setNumCad(Integer numCad) {
		this.numCad = numCad;
	}

	public Integer getCodEtg() {
		return codEtg;
	}

	public void setCodEtg(Integer codEtg) {
		this.codEtg = codEtg;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(codEmp, codOri, numOrp, seqCmp);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Componente other = (Componente) obj;
		return Objects.equals(codEmp, other.codEmp) && Objects.equals(codOri, other.codOri)
				&& Objects.equals(numOrp, other.numOrp) && Objects.equals(seqCmp, other.seqCmp);
	}

	@Override
	public String toString() {
		return "Componente [codEmp=" + codEmp + ", codOri=" + codOri + ", numOrp=" + numOrp + ", seqCmp=" + seqCmp
				+ ", codCmp=" + codCmp + ", codDer=" + codDer + ", qtdPrv=" + qtdPrv + ", qtdTra=" + qtdTra
				+ ", qtdSpa=" + qtdSpa + ", qtdSpa2=" + qtdSpa2 + ", datFab=" + datFab + ", datVlt=" + datVlt
				+ ", codDep=" + codDep + ", codLot=" + codLot + ", comTra=" + comTra + ", depTra=" + depTra
				+ ", numSep=" + numSep + ", seqEnt=" + seqEnt + ", datMov=" + datMov + ", seqMov=" + seqMov
				+ ", indSpa=" + indSpa + ", numCad=" + numCad + ", codEtg=" + codEtg + "]";
	}
	
	
	
}
