package com.schwancosmetics.c4.sapiens.servico;

import com.schwancosmetics.c4.sapiens.dao.FilialDAO;
import com.schwancosmetics.c4.sapiens.entidade.Filial;

public class FilialServico {
	private FilialDAO filialDAO;
	
	public FilialServico() {
		filialDAO = new FilialDAO();
	}
	
	public Filial query(Integer codEmp, Integer codFil) {
		return filialDAO.query(codEmp, codFil);
	}
}
