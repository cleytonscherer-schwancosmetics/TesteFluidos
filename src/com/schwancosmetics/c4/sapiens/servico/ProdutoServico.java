package com.schwancosmetics.c4.sapiens.servico;

import com.schwancosmetics.c4.sapiens.dao.ProdutoDAO;
import com.schwancosmetics.c4.sapiens.entidade.Produto;

public class ProdutoServico {

	private ProdutoDAO produtoDAO;
	
	public ProdutoServico() {
		produtoDAO = new ProdutoDAO(); 
	}
	
	public Produto query(Integer codEmp, String codPro) {
		return produtoDAO.query(codEmp, codPro);
	}

}
