package com.schwancosmetics.c4.sapiens.servico;

import com.schwancosmetics.c4.sapiens.dao.ReferenciaCorDAO;
import com.schwancosmetics.c4.sapiens.entidade.ReferenciaCor;

public class ReferenciaCorServico {
	
	private ReferenciaCorDAO referenciaCorDAO;
	
	public ReferenciaCorServico() {
		referenciaCorDAO = new ReferenciaCorDAO();
	}
	
	public ReferenciaCor query(Long refCor) {
		return referenciaCorDAO.query(refCor);
	}

}
