package com.schwancosmetics.c4.sapiens.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
//import java.util.logging.Logger;

import javax.swing.JOptionPane;

//import com.schwancosmetics.c4.sapiens.Mensagem;
import com.schwancosmetics.c4.sapiens.entidade.Componente;


public class ComponenteDAO {

	//private static final Logger LOGGER = Logger.getLogger(ComponenteDAO.class.getName());
	//private static final Mensagem LOGGER = new Mensagem();
	
    private Connection conexao;
    private PreparedStatement stmt;
    private ResultSet  resultado;
    
	private final String SELECT        = "SELECT * FROM USU_TE900CMO WHERE USU_CODEMP = ? AND USU_CODORI = ? AND USU_NUMORP = ? AND USU_COMTRA = 'N' ORDER BY USU_SEQCMP";
	private final String SELECT_BY_ID  = "SELECT * FROM USU_TE900CMO WHERE USU_CODEMP = ? AND USU_CODORI = ? AND USU_NUMORP = ? AND USU_SEQCMP = ?";
	private final String SELECT_MIN_ID = "SELECT MIN(USU_SEQCMP) AS USU_SEQCMP FROM USU_TE900CMO WHERE USU_CODEMP = ? AND USU_CODORI = ? AND USU_NUMORP = ?";
	private final String SELECT_MAX_ID = "SELECT MAX(USU_SEQCMP) AS USU_SEQCMP FROM USU_TE900CMO WHERE USU_CODEMP = ? AND USU_CODORI = ? AND USU_NUMORP = ?";
	
	private final String SELECT_BULK   = "SELECT * FROM USU_TE900CMO WHERE USU_CODEMP = ? AND USU_CODORI = ? AND USU_NUMORP = ? AND (USU_CODCMP LIKE '0601006%' OR USU_CODCMP LIKE '07070%') ORDER BY USU_CODLOT";
	
    public LocalDate convertToLocalDateViaSqlDate(Date dateToConvert) {
        return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
    }
    
    public Date convertToDateViaSqlDate(LocalDate dateToConvert) {
        return java.sql.Date.valueOf(dateToConvert);
    }	
	
	public List<Componente> queryAll(Integer codEmp, String codOri, Integer numOrp) {
		/*
		LOGGER.info("#ComponenteDAO.queryAll(inicio);");
    	LOGGER.info("codEmp: [" + codEmp + "]");
    	LOGGER.info("codOri: [" + codOri + "]");
    	LOGGER.info("numOrp: [" + numOrp + "]");
    	*/
        
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
            	
            	//LOGGER.info("USU_CODEMP");
            	componente.setCodEmp(resultado.getInt(   "USU_CODEMP"));
            	
            	//LOGGER.info("USU_CODORI");
            	componente.setCodOri(resultado.getString("USU_CODORI"));
            	
            	//LOGGER.info("USU_NUMORP");
            	componente.setNumOrp(resultado.getInt(   "USU_NUMORP"));
            	
            	//LOGGER.info("USU_SEQCMP");
            	componente.setSeqCmp(resultado.getInt(   "USU_SEQCMP"));
            	
            	//LOGGER.info("USU_CODCMP");
            	componente.setCodCmp(resultado.getString("USU_CODCMP"));
            	
            	//LOGGER.info("USU_CODDER");
            	componente.setCodDer(resultado.getString("USU_CODDER"));
            	
            	//LOGGER.info("USU_CODDEP");
            	componente.setCodDep(resultado.getString("USU_CODDEP"));
            	
            	//LOGGER.info("USU_CODLOT");
            	componente.setCodLot(resultado.getString("USU_CODLOT"));
            	
            	//LOGGER.info("USU_DEPTRA");
            	componente.setDepTra(resultado.getString("USU_DEPTRA"));
            	
            	//LOGGER.info("USU_NUMSEP");
            	componente.setNumSep(resultado.getString("USU_NUMSEP"));
            	
            	//LOGGER.info("USU_SEQENT");
            	componente.setSeqEnt(resultado.getInt(   "USU_SEQENT"));
            	
            	//LOGGER.info("USU_COMTRA");
            	componente.setComTra(resultado.getString("USU_COMTRA").charAt(0));
            	
            	//LOGGER.info("USU_INDSPA");
            	componente.setIndSpa(resultado.getString("USU_INDSPA").charAt(0));
            	
            	//LOGGER.info("USU_QTDPRV");
            	componente.setQtdPrv(resultado.getDouble("USU_QTDPRV"));
            	
            	//LOGGER.info("USU_QTDSPA");
            	componente.setQtdSpa(resultado.getDouble("USU_QTDSPA"));
            	
            	//LOGGER.info("USU_QTDSPA2");
            	componente.setQtdSpa2(resultado.getDouble("USU_QTDSPA2"));
            	
            	//LOGGER.info("USU_QTDTRA");
            	componente.setQtdTra(resultado.getDouble("USU_QTDTRA"));
            	
            	//LOGGER.info("USU_DATFAB");
            	componente.setDatFab(convertToLocalDateViaSqlDate(resultado.getDate("USU_DATFAB")));
            	
            	//LOGGER.info("USU_DATVLT");
            	componente.setDatVlt(convertToLocalDateViaSqlDate(resultado.getDate("USU_DATVLT")));
            	
            	//LOGGER.info("USU_DATMOV");
            	componente.setDatMov(convertToLocalDateViaSqlDate(resultado.getDate("USU_DATMOV")));
            	
            	//LOGGER.info("USU_SEQMOV");
            	componente.setSeqMov(resultado.getInt("USU_SEQMOV"));
            	
            	//LOGGER.info("USU_NUMCAD");
            	componente.setNumCad(resultado.getInt("USU_NUMCAD"));
            	
            	//LOGGER.info("USU_CODETG");
            	componente.setCodEtg(resultado.getInt("USU_CODETG"));
            	
            	lista.add(componente);
            	//LOGGER.info("----------------------------------------------------------------------------------------------");
            	
            	//LOGGER.info(componente.toString());
            } 
            stmt.close();
        } catch (SQLException e) {
        	//LOGGER.info("Erro  : " + e.getMessage());
        	String mensagem = e.getMessage();
        	JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE); 
        }
        //LOGGER.info("#ComponenteDAO.queryAll(fim);");
        return lista;
    }	
	
	public Componente queryByID(Integer codEmp, String codOri, Integer numOrp, Integer seqCmp) {
		Componente componente = new Componente();
		/*
		LOGGER.info("#ComponenteDAO.queryByID(inicio);");
    	LOGGER.info("codEmp: [" + codEmp + "]");
    	LOGGER.info("codOri: [" + codOri + "]");
    	LOGGER.info("numOrp: [" + numOrp + "]");
    	LOGGER.info("seqCmp: [" + seqCmp + "]");
    	*/
    	
        try {
        	conexao = Conexao.getInstance().getConnection();
            stmt = conexao.prepareStatement(SELECT_BY_ID);
            stmt.setInt(   1, codEmp);
            stmt.setString(2, codOri);
            stmt.setInt(   3, numOrp);             
            stmt.setInt(   4, seqCmp);
            resultado = stmt.executeQuery();

            if (resultado.next()) {
            	//LOGGER.info("USU_CODEMP");
            	componente.setCodEmp(resultado.getInt(   "USU_CODEMP"));
            	
            	//LOGGER.info("USU_CODORI");
            	componente.setCodOri(resultado.getString("USU_CODORI"));
            	
            	//LOGGER.info("USU_NUMORP");
            	componente.setNumOrp(resultado.getInt(   "USU_NUMORP"));
            	
            	//LOGGER.info("USU_SEQCMP");
            	componente.setSeqCmp(resultado.getInt(   "USU_SEQCMP"));
            	
            	//LOGGER.info("USU_CODCMP");
            	componente.setCodCmp(resultado.getString("USU_CODCMP"));
            	
            	//LOGGER.info("USU_CODDER");
            	componente.setCodDer(resultado.getString("USU_CODDER"));
            	
            	//LOGGER.info("USU_CODDEP");
            	componente.setCodDep(resultado.getString("USU_CODDEP"));
            	
            	//LOGGER.info("USU_CODLOT");
            	componente.setCodLot(resultado.getString("USU_CODLOT"));
            	
            	//LOGGER.info("USU_DEPTRA");
            	componente.setDepTra(resultado.getString("USU_DEPTRA"));
            	
            	//LOGGER.info("USU_NUMSEP");
            	componente.setNumSep(resultado.getString("USU_NUMSEP"));
            	
            	//LOGGER.info("USU_SEQENT");
            	componente.setSeqEnt(resultado.getInt(   "USU_SEQENT"));
            	
            	//LOGGER.info("USU_COMTRA");
            	componente.setComTra(resultado.getString("USU_COMTRA").charAt(0));
            	
            	//LOGGER.info("USU_INDSPA");
            	componente.setIndSpa(resultado.getString("USU_INDSPA").charAt(0));
            	
            	//LOGGER.info("USU_QTDPRV");
            	componente.setQtdPrv(resultado.getDouble("USU_QTDPRV"));
            	
            	//LOGGER.info("USU_QTDSPA");
            	componente.setQtdSpa(resultado.getDouble("USU_QTDSPA"));
            	
            	//LOGGER.info("USU_QTDSPA2");
            	componente.setQtdSpa2(resultado.getDouble("USU_QTDSPA2"));
            	
            	//LOGGER.info("USU_QTDTRA");
            	componente.setQtdTra(resultado.getDouble("USU_QTDTRA"));
            	
            	//LOGGER.info("USU_DATFAB");
            	componente.setDatFab(convertToLocalDateViaSqlDate(resultado.getDate("USU_DATFAB")));
            	
            	//LOGGER.info("USU_DATVLT");
            	componente.setDatVlt(convertToLocalDateViaSqlDate(resultado.getDate("USU_DATVLT")));
            	
            	//LOGGER.info("USU_DATMOV");
            	componente.setDatMov(convertToLocalDateViaSqlDate(resultado.getDate("USU_DATMOV")));
            	
            	//LOGGER.info("USU_SEQMOV");
            	componente.setSeqMov(resultado.getInt("USU_SEQMOV"));
            	
            	//LOGGER.info("USU_NUMCAD");
            	componente.setNumCad(resultado.getInt("USU_NUMCAD"));
            	
            	//LOGGER.info("USU_CODETG");
            	componente.setCodEtg(resultado.getInt("USU_CODETG"));
            	
            	//LOGGER.info(componente.toString());
            } 
            stmt.close();
        } catch (SQLException e) {
        	//LOGGER.info("Erro  : " + e.getMessage());
        	String mensagem = e.getMessage();
        	JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE); 
        }
        //LOGGER.info("#ComponenteDAO.queryByID(fim);");
        return componente;
    }    	
	
	private Integer firstSeqCmp(Integer codEmp, String codOri, Integer numOrp) {
		Integer seqCmp = 0;
		/*
		LOGGER.info("#ComponenteDAO.first(inicio);");
    	LOGGER.info("codEmp: [" + codEmp + "]");
    	LOGGER.info("codOri: [" + codOri + "]");
    	LOGGER.info("numOrp: [" + numOrp + "]");
    	*/
    	
        try {
        	conexao = Conexao.getInstance().getConnection();
            stmt = conexao.prepareStatement(SELECT_MIN_ID);
            stmt.setInt(   1, codEmp);
            stmt.setString(2, codOri);
            stmt.setInt(   3, numOrp);             
            resultado = stmt.executeQuery();

            if (resultado.next()) {
            	//LOGGER.info("USU_SEQCMP");
            	seqCmp = resultado.getInt(   "USU_SEQCMP");
            } 
            stmt.close();
        } catch (SQLException e) {
        	//LOGGER.info("Erro  : " + e.getMessage());
        	String mensagem = e.getMessage();
        	JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE); 
        }
        //LOGGER.info("#ComponenteDAO.first(fim);");
        return seqCmp;
    }    	
	
	private Integer lastSeqCmp(Integer codEmp, String codOri, Integer numOrp) {
		Integer seqCmp = 0;
		/*
		LOGGER.info("#ComponenteDAO.last(inicio);");
    	LOGGER.info("codEmp: [" + codEmp + "]");
    	LOGGER.info("codOri: [" + codOri + "]");
    	LOGGER.info("numOrp: [" + numOrp + "]");
    	*/
    	
        try {
        	conexao = Conexao.getInstance().getConnection();
            stmt = conexao.prepareStatement(SELECT_MAX_ID);
            stmt.setInt(   1, codEmp);
            stmt.setString(2, codOri);
            stmt.setInt(   3, numOrp);             
            resultado = stmt.executeQuery();

            if (resultado.next()) {
            	//LOGGER.info("USU_SEQCMP");
            	seqCmp = resultado.getInt(   "USU_SEQCMP");
            } 
            stmt.close();
        } catch (SQLException e) {
        	//LOGGER.info("Erro  : " + e.getMessage());
        	String mensagem = e.getMessage();
        	JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE); 
        }
        //LOGGER.info("#ComponenteDAO.last(fim);");
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
		
		//Componente componente = new Componente();
		/*
		LOGGER.info("#ComponenteDAO.queryByID(inicio);");
    	LOGGER.info("codEmp: [" + codEmp + "]");
    	LOGGER.info("codOri: [" + codOri + "]");
    	LOGGER.info("numOrp: [" + numOrp + "]");
    	LOGGER.info("seqCmp: [" + seqCmp + "]");
    	*/
    	//lista = null;
        try {
        	conexao = Conexao.getInstance().getConnection();
            stmt = conexao.prepareStatement(SELECT_BULK);
            stmt.setInt(   1, codEmp);
            stmt.setString(2, codOri);
            stmt.setInt(   3, numOrp);             

            resultado = stmt.executeQuery();

            while (resultado.next()) {
            	Componente componente = new Componente();
            	
            	//LOGGER.info("USU_CODEMP");
            	componente.setCodEmp(resultado.getInt(   "USU_CODEMP"));
            	
            	//LOGGER.info("USU_CODORI");
            	componente.setCodOri(resultado.getString("USU_CODORI"));
            	
            	//LOGGER.info("USU_NUMORP");
            	componente.setNumOrp(resultado.getInt(   "USU_NUMORP"));
            	
            	//LOGGER.info("USU_SEQCMP");
            	componente.setSeqCmp(resultado.getInt(   "USU_SEQCMP"));
            	
            	//LOGGER.info("USU_CODCMP");
            	componente.setCodCmp(resultado.getString("USU_CODCMP"));
            	
            	//LOGGER.info("USU_CODDER");
            	componente.setCodDer(resultado.getString("USU_CODDER"));
            	
            	//LOGGER.info("USU_CODDEP");
            	componente.setCodDep(resultado.getString("USU_CODDEP"));
            	
            	//LOGGER.info("USU_CODLOT");
            	componente.setCodLot(resultado.getString("USU_CODLOT"));
            	
            	//LOGGER.info("USU_DEPTRA");
            	componente.setDepTra(resultado.getString("USU_DEPTRA"));
            	
            	//LOGGER.info("USU_NUMSEP");
            	componente.setNumSep(resultado.getString("USU_NUMSEP"));
            	
            	//LOGGER.info("USU_SEQENT");
            	componente.setSeqEnt(resultado.getInt(   "USU_SEQENT"));
            	
            	//LOGGER.info("USU_COMTRA");
            	componente.setComTra(resultado.getString("USU_COMTRA").charAt(0));
            	
            	//LOGGER.info("USU_INDSPA");
            	componente.setIndSpa(resultado.getString("USU_INDSPA").charAt(0));
            	
            	//LOGGER.info("USU_QTDPRV");
            	componente.setQtdPrv(resultado.getDouble("USU_QTDPRV"));
            	
            	//LOGGER.info("USU_QTDSPA");
            	componente.setQtdSpa(resultado.getDouble("USU_QTDSPA"));
            	
            	//LOGGER.info("USU_QTDSPA2");
            	componente.setQtdSpa2(resultado.getDouble("USU_QTDSPA2"));
            	
            	//LOGGER.info("USU_QTDTRA");
            	componente.setQtdTra(resultado.getDouble("USU_QTDTRA"));
            	
            	//LOGGER.info("USU_DATFAB");
            	componente.setDatFab(convertToLocalDateViaSqlDate(resultado.getDate("USU_DATFAB")));
            	
            	//LOGGER.info("USU_DATVLT");
            	componente.setDatVlt(convertToLocalDateViaSqlDate(resultado.getDate("USU_DATVLT")));
            	
            	//LOGGER.info("USU_DATMOV");
            	componente.setDatMov(convertToLocalDateViaSqlDate(resultado.getDate("USU_DATMOV")));
            	
            	//LOGGER.info("USU_SEQMOV");
            	componente.setSeqMov(resultado.getInt("USU_SEQMOV"));
            	
            	//LOGGER.info("USU_NUMCAD");
            	componente.setNumCad(resultado.getInt("USU_NUMCAD"));
            	
            	//LOGGER.info("USU_CODETG");
            	componente.setCodEtg(resultado.getInt("USU_CODETG"));
            	
            	//LOGGER.info(componente.toString());
            	
            	lista.add(componente);
            } 
            stmt.close();
        } catch (SQLException e) {
        	//LOGGER.info("Erro  : " + e.getMessage());
        	String mensagem = e.getMessage();
        	JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE); 
        }
        //LOGGER.info("#ComponenteDAO.queryByID(fim);");
        return lista;
    }    	

}
