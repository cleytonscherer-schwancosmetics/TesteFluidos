package com.schwancosmetics.c4.sapiens.servico;

import java.util.List;

import com.schwancosmetics.c4.sapiens.dao.OrdemProducaoDAO;
import com.schwancosmetics.c4.sapiens.entidade.OrdemProducao;

public class OrdemProducaoServico {

	private OrdemProducaoDAO ordemProducaoDAO;
	
	public OrdemProducaoServico() {
		ordemProducaoDAO = new OrdemProducaoDAO(); 
	}
	
	public OrdemProducao queryByNumOrp(Integer codEmp, String codOri, Integer numOrp) {		
		return ordemProducaoDAO.queryByNumOrp(codEmp, codOri, numOrp);
	}
	
	public List<OrdemProducao> queryForTransf(Integer codEmp, String codOri) {
		return ordemProducaoDAO.queryForTransf(codEmp, codOri);
	}	
	
}
