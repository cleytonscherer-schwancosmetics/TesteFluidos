package com.schwancosmetics.c4.sapiens.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import com.schwancosmetics.c4.sapiens.entidade.FormulaBase;

public class FormulaBaseDAO {

    private Connection conexao;
    private PreparedStatement stmt;
    private ResultSet  resultado;
    
	private final String SELECT = "SELECT * FROM USU_TFORMBASE WHERE USU_CODEMP = ? AND USU_TIPFOR = ?";
	
	public FormulaBase query(Integer codEmp, String tipFor) {
    	FormulaBase formulaBase = new FormulaBase();
    	
        try {
        	conexao = Conexao.getInstance().getConnection();
            stmt = conexao.prepareStatement(SELECT);
            stmt.setInt(   1, codEmp);
            stmt.setString(2, tipFor);
            resultado = stmt.executeQuery();

            if (resultado.next()) {
            	formulaBase.setCodEmp(resultado.getInt(   "USU_CODEMP"));
            	formulaBase.setTipFor(resultado.getString("USU_TIPFOR"));
            	formulaBase.setDesFor(resultado.getString("USU_DESFOR"));
            	formulaBase.setIngVol(resultado.getString("USU_INGVOL"));
            	formulaBase.setTolMin(resultado.getDouble("USU_TOLMIN"));
            	formulaBase.setTolMax(resultado.getDouble("USU_TOLMAX"));
            	
            } 
            stmt.close();
        } catch (SQLException e) {
        	String mensagem = e.getMessage();
        	JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE); 
        }
        return formulaBase;
	}
}
