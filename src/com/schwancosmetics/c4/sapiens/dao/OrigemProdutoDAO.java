package com.schwancosmetics.c4.sapiens.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.schwancosmetics.c4.sapiens.entidade.OrigemProduto;

public class OrigemProdutoDAO {
	
    private Connection 			conexao;
    private PreparedStatement 	stmt;
    private ResultSet  			resultado;
    
	private static final String SELECT = "SELECT * FROM E083ORI WHERE CODEMP = ? AND CODORI = ?";
	
    public OrigemProduto query(Integer codEmp, String codOri) {
    	OrigemProduto origemProduto = new OrigemProduto();
        try {
        	conexao = Conexao.getInstance().getConnection();
            stmt = conexao.prepareStatement(SELECT);
            stmt.setInt(   1, codEmp);
            stmt.setString(2, codOri);
            resultado = stmt.executeQuery();

            if (resultado.next()) {            	
            	origemProduto.setCodEmp(resultado.getInt(   "CODEMP"));
            	origemProduto.setCodOri(resultado.getString("CODORI"));
            	origemProduto.setDesOri(resultado.getString("DESORI"));
            	origemProduto.setTipPro(resultado.getString("TIPPRO").charAt(0));
            }             
            stmt.close();
        } catch (SQLException e) {
        	String mensagem = e.getMessage();
        	JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE); 
        }
        return origemProduto;
    }
}

