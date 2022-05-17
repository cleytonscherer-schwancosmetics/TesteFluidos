package com.schwancosmetics.c4.sapiens.entidade;

public class OrigemProduto {

	private Integer	codEmp;
	
	private String 	codOri;
	
	private String 	desOri;
	
	private Character tipPro;

	public OrigemProduto() {		
	}

	public OrigemProduto(Integer codEmp, String codOri, String desOri, Character tipPro) {
		this.codEmp = codEmp;
		this.codOri = codOri;
		this.desOri = desOri;
		this.tipPro = tipPro;
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

	public String getDesOri() {
		return desOri;
	}

	public void setDesOri(String desOri) {
		this.desOri = desOri;
	}

	public Character getTipPro() {
		return tipPro;
	}

	public void setTipPro(Character tipPro) {
		this.tipPro = tipPro;
	}

	@Override
	public String toString() {
		return "OrigemProduto [codEmp=" + codEmp + ", codOri=" + codOri + ", desOri=" + desOri + ", tipPro=" + tipPro + "]";
	}	
	
}
