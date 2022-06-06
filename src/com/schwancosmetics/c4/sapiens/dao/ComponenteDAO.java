package com.schwancosmetics.c4.sapiens.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.schwancosmetics.c4.sapiens.entidade.Componente;


public class ComponenteDAO {

    private Connection conexao;
    private PreparedStatement stmt;
    private ResultSet  resultado;
    
	private final String SELECT        = "SELECT * FROM USU_TE900CMO WHERE USU_CODEMP = ? AND USU_CODORI = ? AND USU_NUMORP = ? AND USU_COMTRA = 'N' ORDER BY USU_SEQCMP";
	private final String SELECT_BY_ID  = "SELECT * FROM USU_TE900CMO WHERE USU_CODEMP = ? AND USU_CODORI = ? AND USU_NUMORP = ? AND USU_SEQCMP = ?";
	private final String SELECT_MIN_ID = "SELECT MIN(USU_SEQCMP) AS USU_SEQCMP FROM USU_TE900CMO WHERE USU_CODEMP = ? AND USU_CODORI = ? AND USU_NUMORP = ?";
	private final String SELECT_MAX_ID = "SELECT MAX(USU_SEQCMP) AS USU_SEQCMP FROM USU_TE900CMO WHERE USU_CODEMP = ? AND USU_CODORI = ? AND USU_NUMORP = ?";
	
	private final String SELECT_BULK   = "SELECT * FROM USU_TE900CMO WHERE USU_CODEMP = ? AND USU_CODORI = ? AND USU_NUMORP = ? AND (USU_CODCMP LIKE '0601006%' OR USU_CODCMP LIKE '0707004%') ORDER BY USU_CODLOT";
	
	private final String SELECT_BY_LOTE= "SELECT * FROM USU_TE900CMO WHERE USU_CODEMP = ? AND USU_CODORI = ? AND USU_NUMORP = ? AND USU_CODCMP = ? AND USU_CODLOT = ? ORDER BY USU_CODDEP";
	
    public LocalDate convertToLocalDateViaSqlDate(Date dateToConvert) {
        return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
    }
    
    public Date convertToDateViaSqlDate(LocalDate dateToConvert) {
        return java.sql.Date.valueOf(dateToConvert);
    }	
	
	public List<Componente> queryAll(Integer codEmp, String codOri, Integer numOrp) {
    	List<Componente> lista = new ArrayList<>();
        try {
        	conexao = Conexao.getInstance().getConnection();
            stmt = conexao.prepareStatement(SELECT);
            stmt.setInt(   1, codEmp);
            stmt.setString(2, codOri);
            stmt.setInt(   3, numOrp);             
            resultado = stmt.executeQuery();

            while (resultado.next()) {
            	Componente componente = new Componente();
            	
            	componente.setCodEmp(resultado.getInt(   "USU_CODEMP"));            	
            	componente.setCodOri(resultado.getString("USU_CODORI"));            	
            	componente.setNumOrp(resultado.getInt(   "USU_NUMORP"));
            	componente.setSeqCmp(resultado.getInt(   "USU_SEQCMP"));            	
            	componente.setCodCmp(resultado.getString("USU_CODCMP"));            	
            	componente.setCodDer(resultado.getString("USU_CODDER"));
            	componente.setCodDep(resultado.getString("USU_CODDEP"));
            	componente.setCodLot(resultado.getString("USU_CODLOT"));
            	componente.setDepTra(resultado.getString("USU_DEPTRA"));
            	componente.setNumSep(resultado.getString("USU_NUMSEP"));
            	componente.setSeqEnt(resultado.getInt(   "USU_SEQENT"));
            	componente.setComTra(resultado.getString("USU_COMTRA").charAt(0));
            	componente.setIndSpa(resultado.getString("USU_INDSPA").charAt(0));
            	componente.setQtdPrv(resultado.getDouble("USU_QTDPRV"));
            	componente.setQtdSpa(resultado.getDouble("USU_QTDSPA"));
            	componente.setQtdSpa2(resultado.getDouble("USU_QTDSPA2"));
            	componente.setQtdTra(resultado.getDouble("USU_QTDTRA"));
            	componente.setDatFab(convertToLocalDateViaSqlDate(resultado.getDate("USU_DATFAB")));
            	componente.setDatVlt(convertToLocalDateViaSqlDate(resultado.getDate("USU_DATVLT")));
            	componente.setDatMov(convertToLocalDateViaSqlDate(resultado.getDate("USU_DATMOV")));
            	componente.setSeqMov(resultado.getInt("USU_SEQMOV"));
            	componente.setNumCad(resultado.getInt("USU_NUMCAD"));
            	componente.setCodEtg(resultado.getInt("USU_CODETG"));
            	
            	lista.add(componente);
            } 
            stmt.close();
        } catch (SQLException e) {
        	String mensagem = e.getMessage();
        	JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE); 
        }
        return lista;
    }	
	
	public Componente queryByID(Integer codEmp, String codOri, Integer numOrp, Integer seqCmp) {
		Componente componente = new Componente();
        try {
        	conexao = Conexao.getInstance().getConnection();
            stmt = conexao.prepareStatement(SELECT_BY_ID);
            stmt.setInt(   1, codEmp);
            stmt.setString(2, codOri);
            stmt.setInt(   3, numOrp);             
            stmt.setInt(   4, seqCmp);
            resultado = stmt.executeQuery();

            if (resultado.next()) {
            	componente.setCodEmp(resultado.getInt(   "USU_CODEMP"));
            	componente.setCodOri(resultado.getString("USU_CODORI"));
            	componente.setNumOrp(resultado.getInt(   "USU_NUMORP"));
            	componente.setSeqCmp(resultado.getInt(   "USU_SEQCMP"));
            	componente.setCodCmp(resultado.getString("USU_CODCMP"));
            	componente.setCodDer(resultado.getString("USU_CODDER"));
            	componente.setCodDep(resultado.getString("USU_CODDEP"));
            	componente.setCodLot(resultado.getString("USU_CODLOT"));
            	componente.setDepTra(resultado.getString("USU_DEPTRA"));
            	componente.setNumSep(resultado.getString("USU_NUMSEP"));
            	componente.setSeqEnt(resultado.getInt(   "USU_SEQENT"));
            	componente.setComTra(resultado.getString("USU_COMTRA").charAt(0));
            	componente.setIndSpa(resultado.getString("USU_INDSPA").charAt(0));
            	componente.setQtdPrv(resultado.getDouble("USU_QTDPRV"));
            	componente.setQtdSpa(resultado.getDouble("USU_QTDSPA"));
            	componente.setQtdSpa2(resultado.getDouble("USU_QTDSPA2"));
            	componente.setQtdTra(resultado.getDouble("USU_QTDTRA"));
            	componente.setDatFab(convertToLocalDateViaSqlDate(resultado.getDate("USU_DATFAB")));
            	componente.setDatVlt(convertToLocalDateViaSqlDate(resultado.getDate("USU_DATVLT")));
            	componente.setDatMov(convertToLocalDateViaSqlDate(resultado.getDate("USU_DATMOV")));
            	componente.setSeqMov(resultado.getInt("USU_SEQMOV"));
            	componente.setNumCad(resultado.getInt("USU_NUMCAD"));
            	componente.setCodEtg(resultado.getInt("USU_CODETG"));
            } 
            stmt.close();
        } catch (SQLException e) {
        	String mensagem = e.getMessage();
        	JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE); 
        }
        return componente;
    }    	
	
	private Integer firstSeqCmp(Integer codEmp, String codOri, Integer numOrp) {
		Integer seqCmp = 0;
        try {
        	conexao = Conexao.getInstance().getConnection();
            stmt = conexao.prepareStatement(SELECT_MIN_ID);
            stmt.setInt(   1, codEmp);
            stmt.setString(2, codOri);
            stmt.setInt(   3, numOrp);             
            resultado = stmt.executeQuery();

            if (resultado.next()) {
            	seqCmp = resultado.getInt(   "USU_SEQCMP");
            } 
            stmt.close();
        } catch (SQLException e) {
        	String mensagem = e.getMessage();
        	JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE); 
        }
        return seqCmp;
    }    	
	
	private Integer lastSeqCmp(Integer codEmp, String codOri, Integer numOrp) {
		Integer seqCmp = 0;
        try {
        	conexao = Conexao.getInstance().getConnection();
            stmt = conexao.prepareStatement(SELECT_MAX_ID);
            stmt.setInt(   1, codEmp);
            stmt.setString(2, codOri);
            stmt.setInt(   3, numOrp);             
            resultado = stmt.executeQuery();

            if (resultado.next()) {
            	seqCmp = resultado.getInt(   "USU_SEQCMP");
            } 
            stmt.close();
        } catch (SQLException e) {
        	String mensagem = e.getMessage();
        	JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE); 
        }
        return seqCmp;
    }        

	public Componente first(Integer codEmp, String codOri, Integer numOrp) {
		Integer seqCmp = this.firstSeqCmp(codEmp, codOri, numOrp);
		return queryByID(codEmp, codOri, numOrp, seqCmp);
	}
	
	public Componente last(Integer codEmp, String codOri, Integer numOrp) {
		Integer seqCmp = this.lastSeqCmp(codEmp, codOri, numOrp);
		return queryByID(codEmp, codOri, numOrp, seqCmp);
	}
	
	public List<Componente> queryBulk(Integer codEmp, String codOri, Integer numOrp) {
		List<Componente> lista = new ArrayList<>();
		
        try {
        	conexao = Conexao.getInstance().getConnection();
            stmt = conexao.prepareStatement(SELECT_BULK);
            stmt.setInt(   1, codEmp);
            stmt.setString(2, codOri);
            stmt.setInt(   3, numOrp);             

            resultado = stmt.executeQuery();

            while (resultado.next()) {
            	Componente componente = new Componente();
            	componente.setCodEmp(resultado.getInt(   "USU_CODEMP"));
            	componente.setCodOri(resultado.getString("USU_CODORI"));
            	componente.setNumOrp(resultado.getInt(   "USU_NUMORP"));
            	componente.setSeqCmp(resultado.getInt(   "USU_SEQCMP"));
            	componente.setCodCmp(resultado.getString("USU_CODCMP"));
            	componente.setCodDer(resultado.getString("USU_CODDER"));
            	componente.setCodDep(resultado.getString("USU_CODDEP"));
            	componente.setCodLot(resultado.getString("USU_CODLOT"));
            	componente.setDepTra(resultado.getString("USU_DEPTRA"));
            	componente.setNumSep(resultado.getString("USU_NUMSEP"));
            	componente.setSeqEnt(resultado.getInt(   "USU_SEQENT"));
            	componente.setComTra(resultado.getString("USU_COMTRA").charAt(0));
            	componente.setIndSpa(resultado.getString("USU_INDSPA").charAt(0));
            	componente.setQtdPrv(resultado.getDouble("USU_QTDPRV"));
            	componente.setQtdSpa(resultado.getDouble("USU_QTDSPA"));
            	componente.setQtdSpa2(resultado.getDouble("USU_QTDSPA2"));
            	componente.setQtdTra(resultado.getDouble("USU_QTDTRA"));
            	componente.setDatFab(convertToLocalDateViaSqlDate(resultado.getDate("USU_DATFAB")));
            	componente.setDatVlt(convertToLocalDateViaSqlDate(resultado.getDate("USU_DATVLT")));
            	componente.setDatMov(convertToLocalDateViaSqlDate(resultado.getDate("USU_DATMOV")));
            	componente.setSeqMov(resultado.getInt("USU_SEQMOV"));
            	componente.setNumCad(resultado.getInt("USU_NUMCAD"));
            	componente.setCodEtg(resultado.getInt("USU_CODETG"));
           	
            	lista.add(componente);
            } 
            stmt.close();
        } catch (SQLException e) {
        	String mensagem = e.getMessage();
        	JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE); 
        }
        return lista;
    }    	
	
	public Componente queryByLote(Integer codEmp, String codOri, Integer numOrp, String codCmp, String lotCmp) {
		Componente componente = null; /* new Componente(); */
        try {
        	conexao = Conexao.getInstance().getConnection();
            stmt = conexao.prepareStatement(SELECT_BY_LOTE);
            stmt.setInt(   1, codEmp);
            stmt.setString(2, codOri);
            stmt.setInt(   3, numOrp);             
            stmt.setString(4, codCmp);
            stmt.setString(5,  lotCmp);;
            resultado = stmt.executeQuery();

            if (resultado.next()) {
            	componente = new Componente();
            	
            	componente.setCodEmp(resultado.getInt(   "USU_CODEMP"));
            	componente.setCodOri(resultado.getString("USU_CODORI"));
            	componente.setNumOrp(resultado.getInt(   "USU_NUMORP"));
            	componente.setSeqCmp(resultado.getInt(   "USU_SEQCMP"));
            	componente.setCodCmp(resultado.getString("USU_CODCMP"));
            	componente.setCodDer(resultado.getString("USU_CODDER"));
            	componente.setCodDep(resultado.getString("USU_CODDEP"));
            	componente.setCodLot(resultado.getString("USU_CODLOT"));
            	componente.setDepTra(resultado.getString("USU_DEPTRA"));
            	componente.setNumSep(resultado.getString("USU_NUMSEP"));
            	componente.setSeqEnt(resultado.getInt(   "USU_SEQENT"));
            	componente.setComTra(resultado.getString("USU_COMTRA").charAt(0));
            	componente.setIndSpa(resultado.getString("USU_INDSPA").charAt(0));
            	componente.setQtdPrv(resultado.getDouble("USU_QTDPRV"));
            	componente.setQtdSpa(resultado.getDouble("USU_QTDSPA"));
            	componente.setQtdSpa2(resultado.getDouble("USU_QTDSPA2"));
            	componente.setQtdTra(resultado.getDouble("USU_QTDTRA"));
            	componente.setDatFab(convertToLocalDateViaSqlDate(resultado.getDate("USU_DATFAB")));
            	componente.setDatVlt(convertToLocalDateViaSqlDate(resultado.getDate("USU_DATVLT")));
            	componente.setDatMov(convertToLocalDateViaSqlDate(resultado.getDate("USU_DATMOV")));
            	componente.setSeqMov(resultado.getInt("USU_SEQMOV"));
            	componente.setNumCad(resultado.getInt("USU_NUMCAD"));
            	componente.setCodEtg(resultado.getInt("USU_CODETG"));
            } 
            stmt.close();
        } catch (SQLException e) {
        	String mensagem = e.getMessage();
        	JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE); 
        }
        return componente;
    }    	


}
