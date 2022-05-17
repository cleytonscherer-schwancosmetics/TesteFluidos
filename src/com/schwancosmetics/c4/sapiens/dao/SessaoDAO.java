package com.schwancosmetics.c4.sapiens.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.schwancosmetics.c4.sapiens.entidade.Sessao;

public class SessaoDAO {

	private final String SELECT     = "SELECT NUMSEC, COMNAM, USRNAM, APPNAM, APPUSR FROM R911SEC WHERE Upper(USRNAM) = APPUSR AND UPPER(USRNAM) = UPPER(?) ";
	
	private final String DELETE_MOD = "DELETE R911MOD WHERE NUMSEC = ?";
	
	private final String DELETE_SEC = "DELETE R911SEC WHERE NUMSEC = ?";
	
    private PreparedStatement stmt;
    private Connection        conexao;
    private ResultSet         resultado;
    
	public void killSession(Integer numsec) {
		try {
			conexao = Conexao.getInstance().getConnection();
            stmt = conexao.prepareStatement(DELETE_MOD);
            stmt.setInt(1, numsec);
            stmt.executeUpdate();
            
            stmt = conexao.prepareStatement(DELETE_SEC);
            stmt.setInt(1, numsec);
            stmt.executeUpdate();
            stmt.close();			
		} catch (SQLException e) {
        	String mensagem = e.getMessage();
        	JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE); 			
		}		
	}
	
    public List<Sessao> getSessao(String codUsu) {
    	conexao = Conexao.getInstance().getConnection();
    	List<Sessao>lista = new ArrayList<Sessao>();
        try {        	
            stmt = conexao.prepareStatement(SELECT);
            stmt.setString(1, codUsu);

            resultado = stmt.executeQuery();  
            
            while (resultado.next()) {
            	Sessao sessao = new Sessao();
            	
            	sessao.setNumSec(resultado.getInt(   "NUMSEC"));
                sessao.setAppNam(resultado.getString("APPNAM"));
                sessao.setAppUsr(resultado.getString("APPUSR"));
                sessao.setComNam(resultado.getString("COMNAM"));
                sessao.setUsrNam(resultado.getString("USRNAM"));

                lista.add(sessao);  
                
            }          
            stmt.close();
        } catch (SQLException e) {
        	String mensagem = e.getMessage();
        	JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);         	
        }
        return lista;
    }   
}
