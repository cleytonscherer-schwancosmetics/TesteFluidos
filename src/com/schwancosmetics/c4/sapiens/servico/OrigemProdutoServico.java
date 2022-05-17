package com.schwancosmetics.c4.sapiens.servico;

import com.schwancosmetics.c4.sapiens.dao.OrigemProdutoDAO;
import com.schwancosmetics.c4.sapiens.entidade.OrigemProduto;

public class OrigemProdutoServico {

	private OrigemProdutoDAO origemProdutoDAO;
	
	public OrigemProdutoServico() {
		origemProdutoDAO = new OrigemProdutoDAO();
	}
	
	public OrigemProduto query(Integer codEmp, String codOri) {
		return origemProdutoDAO.query(codEmp, codOri);
	}
}
