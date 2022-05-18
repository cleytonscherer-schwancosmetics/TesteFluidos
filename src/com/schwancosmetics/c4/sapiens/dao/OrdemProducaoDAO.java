package com.schwancosmetics.c4.sapiens.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.schwancosmetics.c4.sapiens.entidade.OrdemProducao;

public class OrdemProducaoDAO {

    private Connection 			conexao;
    private PreparedStatement 	stmt;
    private ResultSet  			resultado;
    
	private static final String SELECT_BY_NUMORP = "SELECT * FROM E900COP WHERE CODEMP = ? AND CODORI = ? AND NUMORP = ? ";

	
	private static final String SELECT_FOR_TRANSF = "SELECT DISTINCT E900COP.CODEMP, E900COP.CODORI, E900COP.NUMORP, E900COP.CODPRO, E900COP.RELPRD, E900COP.SITORP "
												+ "  FROM E900COP, USU_TE900CMO "
												+ " WHERE E900COP.CODEMP = ? "
												+ "   AND E900COP.CODORI = ? "
												+ "   AND E900COP.SITORP = 'A' "
												+ "   AND E900COP.CODEMP = USU_TE900CMO.USU_CODEMP "
												+ "   AND E900COP.CODORI = USU_TE900CMO.USU_CODORI "
												+ "   AND E900COP.NUMORP = USU_TE900CMO.USU_NUMORP "
												+ "   AND USU_TE900CMO.USU_INDSPA = 'S' "
												+ "   AND USU_TE900CMO.USU_COMTRA = 'N' "
												+ " ORDER BY E900COP.CODEMP, E900COP.CODORI, E900COP.NUMORP ";
	
    public OrdemProducao queryByNumOrp(Integer codEmp, String codOri, Integer numOrp) {

    	OrdemProducao op = new OrdemProducao();
        try {
        	conexao = Conexao.getInstance().getConnection();
            stmt = conexao.prepareStatement(SELECT_BY_NUMORP);
            stmt.setInt(   1, codEmp);
            stmt.setString(2, codOri);
            stmt.setInt(   3, numOrp);            
            resultado = stmt.executeQuery();     
                        
            if (resultado.next()) {            	
            	op.setCodEmp(resultado.getInt(   "CODEMP"));
            	op.setCodOri(resultado.getString("CODORI"));
            	op.setNumOrp(resultado.getInt(   "NUMORP"));
            	op.setCodPro(resultado.getString("CODPRO"));
            	op.setRelPrd(resultado.getString("RELPRD"));
            	op.setSitOrp(resultado.getString("SITORP"));   
            	
            }
            stmt.close();
        } catch (SQLException e) {
        	String mensagem = e.getMessage();
        	JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE); 
        }
        return op;
    }	
    
    public List<OrdemProducao> queryForTransf(Integer codEmp, String codOri) {
    	List <OrdemProducao> lista = new ArrayList<>();
    	
        try {
        	
        	conexao = Conexao.getInstance().getConnection();
        	
    		stmt = conexao.prepareStatement(SELECT_FOR_TRANSF);
            
            stmt.setInt(   1, codEmp);
            stmt.setString(2, codOri);

    		try {
    			resultado = stmt.executeQuery();     
    		} catch (Exception e) {
    			String mensagem;
            	mensagem = e.getStackTrace().toString();
            	JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
            	
            	mensagem = e.getMessage();
            	JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
            	
            	mensagem = e.getCause().toString();
            	JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);    			
    		}    

    		while (resultado.next()) {
            	OrdemProducao op = new OrdemProducao();
            	op.setCodEmp(resultado.getInt(   "CODEMP"));
            	op.setCodOri(resultado.getString("CODORI"));
            	op.setNumOrp(resultado.getInt(   "NUMORP"));
            	op.setCodPro(resultado.getString("CODPRO"));
            	op.setRelPrd(resultado.getString("RELPRD"));
            	op.setSitOrp(resultado.getString("SITORP"));   
            	
            	lista.add(op);
            }
            stmt.close();

        } catch (SQLException e) {
        	String mensagem;
        	mensagem = e.getMessage();
        	JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE); 
        } catch(Exception e) {
        	String mensagem;
        	mensagem = e.getStackTrace().toString();
        	JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
        	
        	mensagem = e.getMessage();
        	JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
        	
        	mensagem = e.getCause().toString();
        	JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
        	
        }
        return lista;
    }	
}
