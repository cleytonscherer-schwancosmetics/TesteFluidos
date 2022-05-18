package com.schwancosmetics.c4.sapiens.servico;

import java.util.List;

import com.schwancosmetics.c4.sapiens.dao.SessaoDAO;
import com.schwancosmetics.c4.sapiens.entidade.Sessao;

public class SessaoServico {

	private SessaoDAO sessaoDAO;
	
	public SessaoServico() {
		sessaoDAO = new SessaoDAO();
	}
	
	public void killSession(Integer numSec) {
		sessaoDAO.killSession(numSec);
	}
	
	public List<Sessao> getSessao(String codUsu) {
		return sessaoDAO.getSessao(codUsu);
	}
}
