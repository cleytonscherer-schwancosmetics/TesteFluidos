package com.schwancosmetics.c4.sapiens.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.schwancosmetics.c4.sapiens.entidade.ReferenciaCor;

public class ReferenciaCorDAO {

    private Connection conexao;
    private PreparedStatement stmt;
    private ResultSet  resultado;
    
	private final String SELECT = "SELECT * FROM USU_TREFCOR WHERE USU_REFCOR = ?";
	
	public ReferenciaCor query(Long codRef) {
    	ReferenciaCor referenciaCor = new ReferenciaCor();
        try {
        	conexao = Conexao.getInstance().getConnection();
            stmt = conexao.prepareStatement(SELECT);
            stmt.setLong(1, codRef);
            resultado = stmt.executeQuery();

            if (resultado.next()) {            	
            	referenciaCor.setRefCor(resultado.getLong(  "USU_REFCOR"));
            	referenciaCor.setDesRef(resultado.getString("USU_DESREF"));
            	referenciaCor.setTipFor(resultado.getString("USU_TIPFOR"));
            	referenciaCor.setFluIde(resultado.getDouble("USU_FLUIDE"));
            } 
            stmt.close();
        } catch (SQLException e) {
        	String mensagem = e.getMessage();
        	JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE); 
        }
        return referenciaCor;
    }
}
