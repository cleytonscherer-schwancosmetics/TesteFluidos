package com.schwancosmetics.c4.sapiens.excecao;

import javax.swing.JOptionPane;

public class DataInvalidaException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public DataInvalidaException(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
	}

}
