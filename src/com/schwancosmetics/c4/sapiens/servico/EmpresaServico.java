package com.schwancosmetics.c4.sapiens.servico;

import com.schwancosmetics.c4.sapiens.dao.EmpresaDAO;
import com.schwancosmetics.c4.sapiens.entidade.Empresa;

public class EmpresaServico {
	
	private EmpresaDAO empresaDAO;
	
	public EmpresaServico() {
		empresaDAO = new EmpresaDAO();
	}
	
	public Empresa query(Integer codEmp) {
		return empresaDAO.query(codEmp);
	}

}
