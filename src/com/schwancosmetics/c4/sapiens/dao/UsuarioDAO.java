package com.schwancosmetics.c4.sapiens.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.schwancosmetics.c4.sapiens.entidade.Usuario;

public class UsuarioDAO {
    private Connection 			conexao;
    private PreparedStatement 	stmt;
    private ResultSet  			resultado;
    
	private static final String SELECT = "SELECT E099USU.NUMCAD "
										+ "     ,E099USU.EMPATI "
										+ "     ,E099USU.FILATI "
										+ "     ,R999USU.NOMUSU "
										+ "     ,R999USU.CODUSU "
										+ " FROM E099USU ,R999USU "
										+ "WHERE E099USU.CODUSU = R999USU.CODUSU "
										+ "  AND UPPER(R999USU.NOMUSU) = ? ";
	
	public UsuarioDAO() {
        try {
        	conexao = Conexao.getInstance().getConnection();
        } catch (Exception e) {        	        	
        	String mensagem = "UsuarioDAO() " + e.getMessage() + " " + e.getCause() + " " + e.getClass();
        	JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
        }		
	}
	
	public Usuario query(String nomUsu) {
    	
    	Usuario usuario = new Usuario();
        try {
        	conexao = Conexao.getInstance().getConnection();
            stmt = conexao.prepareStatement(SELECT);
            stmt.setString(   1, nomUsu);
            resultado = stmt.executeQuery();

            if (resultado.next()) {
            	usuario.setNomUsu(resultado.getString("NOMUSU"));
            	usuario.setCodUsu(resultado.getInt("CODUSU"));            	
            	usuario.setCodEmp(resultado.getInt("EMPATI"));
            	usuario.setCodFil(resultado.getInt("FILATI"));
            	usuario.setNumCad(resultado.getInt("NUMCAD"));
            	
            }             
            stmt.close();
        } catch (SQLException e) {
        	String mensagem = e.getMessage();
        	JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE); 
        } catch (Exception e) {        	        	
        	String mensagem = "UsuarioDAO.query() " + e.getMessage() + " " + e.getCause() + " " + e.getClass();
        	JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return usuario;
    }
}
