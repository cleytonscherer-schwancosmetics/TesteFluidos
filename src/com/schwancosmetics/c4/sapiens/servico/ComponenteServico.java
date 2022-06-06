package com.schwancosmetics.c4.sapiens.servico;

import java.util.List;

import com.schwancosmetics.c4.sapiens.dao.ComponenteDAO;
import com.schwancosmetics.c4.sapiens.entidade.Componente;

public class ComponenteServico {
	
	private ComponenteDAO componenteDAO;

	public ComponenteServico() {
		componenteDAO = new ComponenteDAO(); 
	}

	public List<Componente> queryAll(Integer codEmp, String codOri, Integer numOrp) {
		return componenteDAO.queryAll(codEmp, codOri, numOrp);
	}
	
	public Componente queryById(Integer codEmp, String codOri, Integer numOrp, Integer seqCmp) {
		return componenteDAO.queryByID(codEmp, codOri, numOrp, seqCmp);
	}	
	
	public Componente first(Integer codEmp, String codOri, Integer numOrp) {
		return componenteDAO.first(codEmp, codOri, numOrp);
	}
	
	public Componente last(Integer codEmp, String codOri, Integer numOrp) {
		return componenteDAO.last(codEmp, codOri, numOrp);
	}
	
	public List<Componente> queryBulk(Integer codEmp, String codOri, Integer numOrp) {
		return componenteDAO.queryBulk(codEmp, codOri, numOrp);
	}
	
	public Componente queryByLote(Integer codEmp, String codOri, Integer numOrp, String codCmp, String lotCmp) {
		return componenteDAO.queryByLote(codEmp, codOri, numOrp, codCmp, lotCmp);
	}
}
