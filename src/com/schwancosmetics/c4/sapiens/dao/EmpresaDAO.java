package com.schwancosmetics.c4.sapiens.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import com.schwancosmetics.c4.sapiens.entidade.Empresa;

public class EmpresaDAO {

    private Connection conexao;
    private PreparedStatement stmt;
    private ResultSet  resultado;
    
	private static final String SELECT = "SELECT CODEMP, NOMEMP, SIGEMP FROM E070EMP WHERE CODEMP = ? ";
	
	public Empresa query(Integer codEmp) {
    	Empresa empresa = new Empresa();
        try {
        	conexao = Conexao.getInstance().getConnection();

            stmt = conexao.prepareStatement(SELECT);
            stmt.setInt(   1, codEmp);
            resultado = stmt.executeQuery();

            if (resultado.next()) {            	
            	empresa.setCodEmp(resultado.getInt(   "CODEMP"));
            	empresa.setNomEmp(resultado.getString("NOMEMP"));
            	empresa.setSigEmp(resultado.getString("SIGEMP"));

            }             
            stmt.close();
        } catch (SQLException e) {
        	String mensagem = e.getMessage();
        	JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE); 
        } catch (Exception e) {
        	String mensagem = "EmpresaDAO.query(): " + e.getMessage() + " | " + e.getCause() + " | " + e.getClass();        	
        	JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);         	
        }
        return empresa;
    }	
}
