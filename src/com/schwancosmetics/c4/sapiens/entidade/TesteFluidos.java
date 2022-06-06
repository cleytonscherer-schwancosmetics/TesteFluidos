package com.schwancosmetics.c4.sapiens.entidade;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class TesteFluidos {

	private Integer 	id;
	
	private Integer 	codEmp;
	
	private String		codOri;
	
	private Integer		numOrp;
	
	private	LocalDate	datGer;

	private	Integer		horGer;
	
	private	Integer		usuGer;
	
	private Double		pesoG1;
	
	private Double		pesoG2;
	
	private Double		fluIde;
	
	private Double		fluMin;
	
	private	Double		perDif;
	
	private	Double		qtdMas;
	
	private double 		qtdIngVol;
	
	private	String		textura;
	
	private	LocalDate	datAlt;

	private	Integer		horAlt;
	
	private	Integer		usuAlt;
	
	private	Integer		numCad;
	
	private Integer 	sitTes;
	
	private String		tipFor;
	
	private Long		refCor;
	
	private String		ingVol;
	
	private Double		tolMin;
	
	private Double	 	tolMax;	
	
	private String		codPro;
	
	private String		codLot;
	
	private String 		codCmp;
	
	private String 		lotCmp;
	
	private String		userSO;
	
	private String		sitOrp;
	
	private DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public TesteFluidos() {
		this.setId(0); 
		this.setCodEmp(0);
		this.setCodOri(" ");
		this.setNumOrp(0);
		this.setDatGer(LocalDate.now());
		this.setHorGer(0);
		this.setUsuGer(0);
		this.setPesoG1(0.00);
		this.setPesoG2(0.00);
		this.setFluIde(0.00);
		this.setFluMin(0.00);
		this.setPerDif(0.00);
		this.setQtdMas(0.00);
		this.setQtdIngVol(0.00);		
		this.setTextura(" ");
		this.setDatAlt(LocalDate.now());
		this.setHorAlt(0);
		this.setUsuAlt(0);
		this.setNumCad(0);
		this.setSitTes(0);
		this.setTipFor(" ");
		this.setRefCor(0L);
		this.setIngVol(" ");
		this.setTolMin(0.00);
		this.setTolMax(0.00);
		this.setCodPro(" ");		
		this.setCodLot(" ");		
		this.setCodCmp(" ");		
		this.setLotCmp(" ");	
		this.setUserSO(" ");
		this.setSitOrp(" ");
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public LocalDate getDatGer() {
		return datGer;
	}

	public void setDatGer(LocalDate datGer) {
		this.datGer = datGer;
	}

	public Integer getHorGer() {
		return horGer;
	}

	public void setHorGer(Integer horGer) {
		this.horGer = horGer;
	}

	public Integer getUsuGer() {
		return usuGer;
	}

	public void setUsuGer(Integer usuGer) {
		this.usuGer = usuGer;
	}

	public Double getPesoG1() {
		return pesoG1;
	}

	public void setPesoG1(Double pesoG1) {
		this.pesoG1 = pesoG1;
	}

	public Double getPesoG2() {
		return pesoG2;
	}

	public void setPesoG2(Double pesoG2) {
		this.pesoG2 = pesoG2;
	}

	public Double getFluIde() {
		return fluIde;
	}

	public void setFluIde(Double fluIde) {
		this.fluIde = fluIde;
	}

	public Double getFluMin() {
		return this.fluMin;
	}

	public void setFluMin(Double fluMin) {
		this.fluMin = truncateTo(fluMin,2);
	}

	public Double getPerDif() {
		return perDif;
	}

	public void setPerDif(Double perDif) {
		this.perDif = truncateTo(perDif,2);
	}

	public Double getQtdMas() {
		return qtdMas;
	}

	public void setQtdMas(Double qtdMas) {
		this.qtdMas = qtdMas;
	}

	public Double getQtdIngVol() {
		return qtdIngVol;
	}

	public void setQtdIngVol(Double qtdIngVol) {
		this.qtdIngVol = qtdIngVol;
	}
	
	public String getTextura() {
		return textura;
	}

	public void setTextura(String textura) {
		this.textura = textura;
	}

	public LocalDate getDatAlt() {
		return datAlt;
	}

	public void setDatAlt(LocalDate datAlt) {
		this.datAlt = datAlt;
	}

	public Integer getHorAlt() {
		return horAlt;
	}

	public void setHorAlt(Integer horAlt) {
		this.horAlt = horAlt;
	}

	public Integer getUsuAlt() {
		return usuAlt;
	}

	public void setUsuAlt(Integer usuAlt) {
		this.usuAlt = usuAlt;
	}

	public Integer getNumCad() {
		return numCad;
	}

	public void setNumCad(Integer numCad) {
		this.numCad = numCad;
	}

	public Integer getSitTes() {
		return sitTes;
	}

	public void setSitTes(Integer sitTes) {
		this.sitTes = sitTes;
	}

	public String getTipFor() {
		return tipFor;
	}

	public void setTipFor(String tipFor) {
		this.tipFor = tipFor;
	}

	public Long getRefCor() {
		return refCor;
	}

	public void setRefCor(Long refCor) {
		this.refCor = refCor;
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

	public String getCodPro() {
		return codPro;
	}

	public void setCodPro(String codPro) {
		this.codPro = codPro;
	}

	public String getCodLot() {
		return codLot;
	}

	public void setCodLot(String codLot) {
		this.codLot = codLot;
	}
	
	public String getCodCmp() {
		return codCmp;
	}

	public void setCodCmp(String codCmp) {
		this.codCmp = codCmp;
	}

	public String getLotCmp() {
		return lotCmp;
	}

	public void setLotCmp(String lotCmp) {
		this.lotCmp = lotCmp;
	}

	public void setQtdIngVol(double qtdIngVol) {
		this.qtdIngVol = qtdIngVol;
	}
	
	public String getUserSO() {
		return userSO;
	}

	public void setUserSO(String userSO) {
		this.userSO = userSO;
	}
	
	public String getSitOrp() {
		return sitOrp;
	}

	public void setSitOrp(String sitOrp) {
		this.sitOrp = sitOrp;
	}

	public void calculo() {
		if (this.getPesoG1() != 0.00) { 
			this.setFluMin(((this.getPesoG1() - this.getPesoG2()) / this.getPesoG1()) * 100.00);

		} else {
			this.setFluMin(0.00);
		}

		if (this.getFluIde() != 0.00) {
			this.setPerDif(	((this.getFluMin() - this.getFluIde()) / this.getFluIde()) * 100.00);
		} else {
			this.setPerDif(0.00);
		}

		if (this.getFluIde() != 0.00) {
			this.setQtdIngVol((this.getQtdMas() * this.getFluMin()) / this.getFluIde());
		} else {
			this.setQtdIngVol(0.00);
		}

		this.setQtdIngVol(	(this.getQtdMas() * (100 - this.getFluMin()) / (100 - this.getFluIde())) - this.getQtdMas());
	}	
	

	@Override
	public String toString() {
		return "TesteFluidos [id=" + id + ", codEmp=" + codEmp + ", codOri=" + codOri + ", numOrp=" + numOrp
				+ ", datGer=" + datGer.format(formatoData) + ", horGer=" + horGer + ", usuGer=" + usuGer + ", pesoG1=" + pesoG1
				+ ", pesoG2=" + pesoG2 + ", fluIde=" + fluIde + ", fluMin=" + fluMin + ", perDif=" + perDif
				+ ", qtdMas=" + qtdMas + ", qtdIngVol=" + qtdIngVol + ", textura=" + textura + ", datAlt=" + datAlt.format(formatoData) 
				+ ", horAlt=" + horAlt + ", usuAlt=" + usuAlt + ", numCad=" + numCad + ", sitTes=" + sitTes
				+ ", tipFor=" + tipFor + ", refCor=" + refCor + ", ingVol=" + ingVol + ", tolMin=" + tolMin
				+ ", tolMax=" + tolMax + ", codPro=" + codPro + ", codLot=" + codLot + ", codCmp=" + codCmp 
				+ ", lotCmp=" + lotCmp + ", userSO=" + userSO + ", sitOrp=" + sitOrp + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TesteFluidos other = (TesteFluidos) obj;
		return Objects.equals(id, other.id);
	}
	
	private double truncateTo(double unroundedNumber, int decimalPlaces ){
	    int truncatedNumberInt = (int)( unroundedNumber * Math.pow( 10, decimalPlaces ) );
	    double truncatedNumber = (double)( truncatedNumberInt / Math.pow( 10, decimalPlaces ) );
	    return truncatedNumber;
	}	
	
}
