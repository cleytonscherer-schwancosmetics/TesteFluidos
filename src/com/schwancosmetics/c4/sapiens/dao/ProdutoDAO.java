package com.schwancosmetics.c4.sapiens.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.schwancosmetics.c4.sapiens.entidade.Produto;

public class ProdutoDAO {

    private Connection conexao;
    private PreparedStatement stmt;
    private ResultSet  resultado;
    
	private final String SELECT = "SELECT * FROM E075PRO WHERE CODEMP = ? AND CODPRO = ?";
	
    public Produto query(Integer codEmp, String codPro) {
    	Produto produto = new Produto();
        try {
        	conexao = Conexao.getInstance().getConnection();
            stmt = conexao.prepareStatement(SELECT);
            stmt.setInt(   1, codEmp);
            stmt.setString(2, codPro);
            resultado = stmt.executeQuery();

            if (resultado.next()) {            	
            	produto.setCodEmp(resultado.getInt(   "CODEMP"));
            	produto.setCodPro(resultado.getString("CODPRO"));
            	produto.setDesPro(resultado.getString("DESPRO"));
            	produto.setDesNfv(resultado.getString("DESNFV"));
            	produto.setCplPro(resultado.getString("CPLPRO"));
            	produto.setCodFam(resultado.getString("CODFAM"));
            	produto.setCodOri(resultado.getString("CODORI"));
            	produto.setUniMed(resultado.getString("UNIMED"));
            	produto.setSitPro(resultado.getString("SITPRO").charAt(0));
            	produto.setRefCor(resultado.getLong(  "USU_REFCOR"));
            } 
            
            stmt.close();
        } catch (SQLException e) {
        	String mensagem = e.getMessage();
        	JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE); 
        }
        return produto;
    }	
}
