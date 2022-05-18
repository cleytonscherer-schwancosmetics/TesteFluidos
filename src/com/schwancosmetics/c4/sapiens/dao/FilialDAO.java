package com.schwancosmetics.c4.sapiens.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import com.schwancosmetics.c4.sapiens.entidade.Filial;

public class FilialDAO {
    private Connection conexao;
    private PreparedStatement stmt;
    private ResultSet  resultado;
    
	private static final String SELECT = "SELECT CODEMP, CODFIL, NOMFIL, SIGFIL FROM E070FIL WHERE CODEMP = ? AND CODFIL = ? ";
	
	public FilialDAO() {
        try {
        	conexao = Conexao.getInstance().getConnection();
        } catch (Exception e) {
        	String mensagem = "FilialDAO() " + e.getMessage() + " " + e.getCause() + " " + e.getClass();        	
        	JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);         	
        }		
	}
	
	public Filial query(Integer codEmp, Integer codFil) {
   	
    	Filial filial = new Filial();
        try {
        	conexao = Conexao.getInstance().getConnection();
            stmt = conexao.prepareStatement(SELECT);
            stmt.setInt(   1, codEmp);
            stmt.setInt(   2, codFil);
            resultado = stmt.executeQuery();

            if (resultado.next()) {            	
            	filial.setCodEmp(resultado.getInt(   "CODEMP"));
            	filial.setCodFil(resultado.getInt(   "CODFIL"));
            	filial.setNomFil(resultado.getString("NOMFIL"));
            	filial.setSigFil(resultado.getString("SIGFIL"));

            }             
            stmt.close();
        } catch (SQLException e) {
        	String mensagem = e.getMessage();
        	JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE); 
        } catch (Exception e) {
        }
        return filial;
    }	

}
