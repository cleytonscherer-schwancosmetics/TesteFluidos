package com.schwancosmetics.c4.sapiens.servico;

import com.schwancosmetics.c4.sapiens.dao.UsuarioDAO;
import com.schwancosmetics.c4.sapiens.entidade.Usuario;

public class UsuarioServico {
	
	private UsuarioDAO usuarioDAO;
	
	public UsuarioServico() {
		usuarioDAO = new UsuarioDAO();
	}
	
	public Usuario query(String nomUsu) {
		return usuarioDAO.query(nomUsu);
	}

}
