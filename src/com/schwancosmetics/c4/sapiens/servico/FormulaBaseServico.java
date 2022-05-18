package com.schwancosmetics.c4.sapiens.servico;

import com.schwancosmetics.c4.sapiens.dao.FormulaBaseDAO;
import com.schwancosmetics.c4.sapiens.entidade.FormulaBase;

public class FormulaBaseServico {

	private FormulaBaseDAO formulaBaseDAO;
	
	public FormulaBaseServico() {
		formulaBaseDAO = new FormulaBaseDAO(); 
	}
	
	public FormulaBase query(Integer codEmp, String tipFor) {
		return formulaBaseDAO.query(codEmp, tipFor);
	}
}
