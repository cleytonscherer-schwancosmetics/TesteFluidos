package com.schwancosmetics.c4.sapiens.excecao;

import javax.swing.JOptionPane;

public class OrdemProducaoNaoIniciadaException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public OrdemProducaoNaoIniciadaException(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
	}

}
