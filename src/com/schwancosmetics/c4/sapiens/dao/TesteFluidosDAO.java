package com.schwancosmetics.c4.sapiens.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import com.schwancosmetics.c4.sapiens.entidade.TesteFluidos;

public class TesteFluidosDAO {

	//private DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
    private Connection	conexao;
    private PreparedStatement stmt;
    private ResultSet	resultado;
    private Statement	stmt2;
    private ResultSet	datasComRegistros;
    
	private final static String SELECT_BY_DATGER = "SELECT USU_CODEMP, USU_CODORI, USU_NUMORP, USU_DATGER, USU_HORGER, USU_USUGER, USU_PESOG1, USU_PESOG2, USU_FLUIDE, "
													+ " USU_FLUMIN, USU_PERDIF, USU_QTDMAS, USU_QTDINGVOL,USU_TEXTURA, USU_DATALT, USU_HORALT, USU_USUALT, USU_NUMCAD, "
													+ " USU_SITTES, USU_TIPFOR, USU_REFCOR, USU_INGVOL, USU_TOLMIN, USU_TOLMAX, USU_CODPRO, USU_CODLOT, USU_CODCMP, "
													+ " USU_LOTCMP, USU_USERSO, USU_ID "
													+ " ,E900COP.SITORP "
													+ "  FROM USU_TTESFLU, E900COP "
													+ " WHERE USU_TTESFLU.USU_DATGER = ? "
													+ "   AND USU_TTESFLU.USU_CODORI = ? "
													+ "   AND USU_TTESFLU.USU_CODEMP = E900COP.CODEMP "
													+ "   AND USU_TTESFLU.USU_CODORI = E900COP.CODORI "
													+ "   AND USU_TTESFLU.USU_NUMORP = E900COP.NUMORP "
													+ " ORDER BY USU_TTESFLU.USU_ID ";
	
	private final static String SELECT_DATGER_45 = "SELECT DISTINCT USU_DATGER FROM USU_TTESFLU WHERE USU_CODORI = '45' ORDER BY USU_DATGER";
	
	private final static String SELECT_DATGER_50 = "SELECT DISTINCT USU_DATGER FROM USU_TTESFLU WHERE USU_CODORI = '50' ORDER BY USU_DATGER";
	
	private final static String SELECT_BY_ID    = "SELECT USU_CODEMP, USU_CODORI, USU_NUMORP, USU_DATGER, USU_HORGER, USU_USUGER, USU_PESOG1, USU_PESOG2, USU_FLUIDE, "
												+ " USU_FLUMIN, USU_PERDIF, USU_QTDMAS, USU_QTDINGVOL,USU_TEXTURA, USU_DATALT, USU_HORALT, USU_USUALT, USU_NUMCAD, "
												+ " USU_SITTES, USU_TIPFOR, USU_REFCOR, USU_INGVOL, USU_TOLMIN, USU_TOLMAX, USU_CODPRO, USU_CODLOT, USU_CODCMP, "
												+ " USU_LOTCMP, USU_USERSO, USU_ID "
												+ " ,E900COP.SITORP "
												+ "  FROM USU_TTESFLU, E900COP"
												+ " WHERE USU_ID = ? "
												+ "   AND USU_TTESFLU.USU_CODEMP = E900COP.CODEMP "
												+ "   AND USU_TTESFLU.USU_CODORI = E900COP.CODORI "
												+ "   AND USU_TTESFLU.USU_NUMORP = E900COP.NUMORP ";												
	
	private final static String SELECT_MIN_ID  = "SELECT MIN(USU_ID) AS USU_ID FROM USU_TTESFLU WHERE USU_DATGER = ? AND USU_CODORI = ? ";
	
	private final static String SELECT_MAX_ID  = "SELECT MAX(USU_ID) AS USU_ID FROM USU_TTESFLU WHERE USU_DATGER = ? AND USU_CODORI = ? ";
	
	private final static String SELECT_NEXT_ID = "SELECT USU_TTESFLU_SEQ.NEXTVAL AS USU_ID FROM DUAL";
	/* create sequence USU_TTESFLU_SEQ minvalue 1 maxvalue 9999999999 start with 1 increment by 1 NOCACHE cycle; */
	
	private final static String DELETE = "DELETE FROM USU_TTESFLU WHERE USU_ID = ?";
	
	private final static String INSERT = "INSERT INTO USU_TTESFLU "
										+ "(USU_CODEMP, USU_CODORI, USU_NUMORP, USU_DATGER,   USU_HORGER,  USU_USUGER, USU_PESOG1, USU_PESOG2, USU_FLUIDE, "
										+ " USU_FLUMIN, USU_PERDIF, USU_QTDMAS, USU_QTDINGVOL,USU_TEXTURA, USU_DATALT, USU_HORALT, USU_USUALT, USU_NUMCAD, "
										+ " USU_SITTES, USU_TIPFOR, USU_REFCOR, USU_INGVOL,   USU_TOLMIN,  USU_TOLMAX, USU_CODPRO, USU_CODLOT, USU_CODCMP, "
										+ " USU_LOTCMP, USU_USERSO, USU_ID) "
										+ " VALUES "
										+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	private final String UPDATE = "UPDATE USU_TTESFLU SET "
								+ " USU_CODEMP = ? "
								+ ",USU_CODORI = ? " 
								+ ",USU_NUMORP = ? "
								+ ",USU_DATGER = ? "
								+ ",USU_HORGER = ? "
								+ ",USU_USUGER = ? "
								+ ",USU_PESOG1 = ? "
								+ ",USU_PESOG2 = ? " 
								+ ",USU_FLUIDE = ? "
								+ ",USU_FLUMIN = ? "
								+ ",USU_PERDIF = ? "
								+ ",USU_QTDMAS = ? "
								+ ",USU_QTDINGVOL = ? "
								+ ",USU_TEXTURA= ? "
								+ ",USU_DATALT = ? "
								+ ",USU_HORALT = ? "
								+ ",USU_USUALT = ? "
								+ ",USU_NUMCAD = ? "
								+ ",USU_SITTES = ? " 
								+ ",USU_TIPFOR = ? "
								+ ",USU_REFCOR = ? "
								+ ",USU_INGVOL = ? "
								+ ",USU_TOLMIN = ? "
								+ ",USU_TOLMAX = ? "
								+ ",USU_CODPRO = ? "
								+ ",USU_CODLOT = ? "
								+ ",USU_CODCMP = ? "
								+ ",USU_LOTCMP = ? "
								+ ",USU_USERSO = ? "
								+ " WHERE USU_ID = ? ";
	
	/*
    public LocalDate convertToLocalDateViaSqlDate(Date dateToConvert) {
        return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
    }
    
    public Date convertToDateViaSqlDate(LocalDate dateToConvert) {
        return java.sql.Date.valueOf(dateToConvert);
    }
    */	
	
	public List<TesteFluidos> queryByDatGer(LocalDate data, String codOri) {
    	List<TesteFluidos> lista = new ArrayList<>();
        try {
        	conexao = Conexao.getInstance().getConnection();
            stmt = conexao.prepareStatement(SELECT_BY_DATGER);            
            stmt.setDate(1, Date.valueOf(data));            
            stmt.setString(2,codOri);
            
            resultado = stmt.executeQuery();

            while (resultado.next()) {
            	TesteFluidos teste = new TesteFluidos();

            	teste.setCodEmp( resultado.getInt("USU_CODEMP"));            	
            	teste.setCodOri( resultado.getString("USU_CODORI"));            	
            	teste.setNumOrp( resultado.getInt("USU_NUMORP"));
            	teste.setId(     resultado.getInt("USU_ID"    ));            	
            	teste.setDatGer(resultado.getDate("USU_DATGER").toLocalDate());            	
            	teste.setHorGer( resultado.getInt("USU_HORGER"));            	
            	teste.setUsuGer( resultado.getInt("USU_USUGER"));            	
            	teste.setPesoG1( resultado.getDouble("USU_PESOG1"));            	
            	teste.setPesoG2( resultado.getDouble("USU_PESOG2"));            	
            	teste.setFluIde(nvl(resultado.getDouble("USU_FLUIDE")));            	
            	teste.setFluMin( resultado.getDouble("USU_FLUMIN"));            	
            	teste.setPerDif( resultado.getDouble("USU_PERDIF"));            	
            	teste.setQtdMas( resultado.getDouble("USU_QTDMAS"));            	
            	teste.setQtdIngVol( resultado.getDouble("USU_QTDINGVOL"));            	
            	teste.setTextura(resultado.getString("USU_TEXTURA"));            	
            	teste.setDatAlt(resultado.getDate("USU_DATALT").toLocalDate());            	
            	teste.setHorAlt( resultado.getInt("USU_HORALT"));            	
            	teste.setUsuAlt( resultado.getInt("USU_USUALT"));            	
            	teste.setNumCad( resultado.getInt("USU_NUMCAD"));            	
            	teste.setSitTes( resultado.getInt("USU_SITTES"));            	
            	teste.setTipFor( resultado.getString("USU_TIPFOR"));            	
            	teste.setIngVol( resultado.getString("USU_INGVOL"));            	
            	teste.setRefCor( resultado.getLong("USU_REFCOR"));            	
            	teste.setTolMin(nvl(resultado.getDouble("USU_TOLMIN")));            	
                teste.setTolMax(nvl(resultado.getDouble("USU_TOLMAX")));                
            	teste.setCodPro( resultado.getString("USU_CODPRO"));            	
            	teste.setCodLot( resultado.getString("USU_CODLOT"));            	
            	teste.setCodCmp( resultado.getString("USU_CODCMP"));            	
            	teste.setLotCmp( resultado.getString("USU_LOTCMP"));           	
            	teste.setUserSO( resultado.getString("USU_USERSO"));
            	teste.setSitOrp( resultado.getString("SITORP"));
            	
            	lista.add(teste);
            } 
            stmt.close();
        } catch (SQLException e) {
        	String mensagem = e.getMessage();
        	JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);   
        }
        return lista;
    }	
	
	public TesteFluidos queryById(Integer id) {
		TesteFluidos teste = new TesteFluidos();
		
        try {
        	conexao = Conexao.getInstance().getConnection();
            stmt = conexao.prepareStatement(SELECT_BY_ID);            
            stmt.setInt(1, id);            
            resultado = stmt.executeQuery();

            if (resultado.next()) {  
            	teste.setCodEmp( resultado.getInt("USU_CODEMP"));            	
            	teste.setCodOri( resultado.getString("USU_CODORI"));
            	teste.setNumOrp( resultado.getInt("USU_NUMORP"));
            	teste.setId(     resultado.getInt("USU_ID"));
            	teste.setDatGer(resultado.getDate("USU_DATGER").toLocalDate());
            	teste.setHorGer( resultado.getInt("USU_HORGER"));
            	teste.setUsuGer( resultado.getInt("USU_USUGER"));
            	teste.setPesoG1( resultado.getDouble("USU_PESOG1"));
            	teste.setPesoG2( resultado.getDouble("USU_PESOG2"));
            	teste.setFluIde(nvl(resultado.getDouble("USU_FLUIDE")));
            	teste.setFluMin( resultado.getDouble("USU_FLUMIN"));
            	teste.setPerDif( resultado.getDouble("USU_PERDIF"));
            	teste.setQtdMas( resultado.getDouble("USU_QTDMAS"));
            	teste.setQtdIngVol( resultado.getDouble("USU_QTDINGVOL"));            	
            	teste.setTextura(resultado.getString("USU_TEXTURA"));            	
            	teste.setDatAlt(resultado.getDate("USU_DATALT").toLocalDate());
            	teste.setHorAlt( resultado.getInt("USU_HORALT"));
            	teste.setUsuAlt( resultado.getInt("USU_USUALT"));
            	teste.setNumCad( resultado.getInt("USU_NUMCAD"));
            	teste.setSitTes( resultado.getInt("USU_SITTES"));
            	teste.setTipFor( resultado.getString("USU_TIPFOR"));
            	teste.setIngVol( resultado.getString("USU_INGVOL"));
            	teste.setRefCor( resultado.getLong("USU_REFCOR"));
            	teste.setTolMin(nvl(resultado.getDouble("USU_TOLMIN")));
                teste.setTolMax(nvl(resultado.getDouble("USU_TOLMAX")));
            	teste.setCodPro( resultado.getString("USU_CODPRO"));
            	teste.setCodLot( resultado.getString("USU_CODLOT"));
            	teste.setCodCmp( resultado.getString("USU_CODCMP"));
            	teste.setLotCmp( resultado.getString("USU_LOTCMP"));
            	teste.setUserSO( resultado.getString("USU_USERSO"));
            	teste.setSitOrp( resultado.getString("SITORP"));
            } 
            stmt.close();
        } catch (SQLException e) {
        	String mensagem = e.getMessage();
        	JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE); 
        }
        return teste;
    }	
	
	public TesteFluidos first(LocalDate data, String codOri) {
		Integer id = this.firstId(data, codOri);
		return queryById(id);
	}
	
	public TesteFluidos last(LocalDate data, String codOri) {
		Integer id = this.lastId(data, codOri);
		return queryById(id);
	}
	
	public Double nvl(Double numero) {
		if (numero == null) return 0.00;
		return numero;
	}
	
	private Integer firstId(LocalDate data, String codOri) {
    	Integer id = -1;
        try {
        	conexao = Conexao.getInstance().getConnection();
            stmt = conexao.prepareStatement(SELECT_MIN_ID);            
            
            stmt.setDate(1, Date.valueOf(data));         
            stmt.setString(2,codOri);
            
            resultado = stmt.executeQuery();
            if (resultado.next()) {
            	id = resultado.getInt("USU_ID");
            } 
            stmt.close();
        } catch (SQLException e) {
        	String mensagem = e.getMessage();
        	JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);  
        }
        return id;		
	}
	
	private Integer lastId(LocalDate data, String codOri) {
    	Integer id = -1;
        try {
        	conexao = Conexao.getInstance().getConnection();
            stmt = conexao.prepareStatement(SELECT_MAX_ID);            
            
            stmt.setDate(1, Date.valueOf(data));
            stmt.setString(2,codOri);
            
            resultado = stmt.executeQuery();

            if (resultado.next()) {
            	id = resultado.getInt("USU_ID");
            } 
            stmt.close();
        } catch (SQLException e) {
        	String mensagem = e.getMessage();
        	JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);  
        }
        return id;		
	}	
	
	public void save(TesteFluidos testeFluidos) {
		try {
			if (testeFluidos.getId() == 0) {
				testeFluidos.setId(nextId());
				stmt = conexao.prepareStatement(INSERT);
			} else {
				stmt = conexao.prepareStatement(UPDATE);
			}

            stmt.setInt(    1, testeFluidos.getCodEmp()); // USU_CODEMP
            stmt.setString( 2, testeFluidos.getCodOri()); // USU_CODORI
            stmt.setInt(    3, testeFluidos.getNumOrp()); // USU_NUMORP
            stmt.setDate(   4, Date.valueOf(testeFluidos.getDatGer())); // USU_DATGER
            stmt.setInt(    5, testeFluidos.getHorGer()); // USU_HORGER
            stmt.setInt(    6, testeFluidos.getUsuGer()); // USU_USUGER
            stmt.setDouble( 7, testeFluidos.getPesoG1()); // USU_PESOG1
            stmt.setDouble( 8, testeFluidos.getPesoG2()); // USU_PESOG2
            stmt.setDouble( 9, testeFluidos.getFluIde()); // USU_FLUIDE
            stmt.setDouble(10, testeFluidos.getFluMin()); // USU_FLUMIN
            stmt.setDouble(11, testeFluidos.getPerDif()); // USU_PERDIF
            stmt.setDouble(12, testeFluidos.getQtdMas()); // USU_QTDMAS
            stmt.setDouble(13, testeFluidos.getQtdIngVol()); // USU_QTDINGVOL
            stmt.setString(14, testeFluidos.getTextura());// USU_TEXTURA
            stmt.setDate(  15, Date.valueOf(testeFluidos.getDatAlt())); // USU_DATALT
            stmt.setInt(   16, testeFluidos.getHorAlt()); // USU_HORALT
            stmt.setInt(   17, testeFluidos.getUsuAlt()); // USU_USUALT
            stmt.setInt(   18, testeFluidos.getNumCad()); // USU_NUMCAD
            stmt.setInt(   19, testeFluidos.getSitTes()); // USU_SITTES
            stmt.setString(20, testeFluidos.getTipFor()); // USU_TIPFOR
            stmt.setLong(  21, testeFluidos.getRefCor()); // USU_REFCOR
            stmt.setString(22, testeFluidos.getIngVol()); // USU_INGVOL
            stmt.setDouble(23, testeFluidos.getTolMin()); // USU_TOLMIN
            stmt.setDouble(24, testeFluidos.getTolMax()); // USU_TOLMAX
            stmt.setString(25, testeFluidos.getCodPro()); // USU_CODPRO
            stmt.setString(26, testeFluidos.getCodLot()); // USU_CODLOT

            stmt.setString(27, testeFluidos.getCodCmp()); // USU_CODCMP
            stmt.setString(28, testeFluidos.getLotCmp()); // USU_LOTCMP
            
            stmt.setString(29, testeFluidos.getUserSO()); // USU_USERSO
            
            stmt.setInt(   30, testeFluidos.getId());     // USU_ID

            stmt.executeUpdate();       
            stmt.close();
		} catch (SQLException e) {
        	String mensagem = e.getMessage();
        	JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE); 			
        }  
	}
	
	private Integer nextId() {
    	Integer id = 0;
        try {
        	conexao = Conexao.getInstance().getConnection();
            stmt = conexao.prepareStatement(SELECT_NEXT_ID);            
            resultado = stmt.executeQuery();           

            if (resultado.next()) {
            	id = resultado.getInt("USU_ID");
            } 
            stmt.close();
        } catch (SQLException e) {
        	String mensagem = e.getMessage();
        	JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);         	
        }
        id++;
        return id;		
	}
	
	public void delete(Integer id) {
        try {
        	conexao = Conexao.getInstance().getConnection();
            stmt = conexao.prepareStatement(DELETE);   
            stmt.setInt(1, id);
            resultado = stmt.executeQuery();           
            stmt.close();
        } catch (SQLException e) {
        	String mensagem = e.getMessage();
        	JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);         	
        }
	}
	
	public void queryDatasComRegistros(String codOri) {
        try {
        	conexao = Conexao.getInstance().getConnection();
            stmt2 = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            if (codOri.equals("45")) {
            	datasComRegistros = stmt2.executeQuery(SELECT_DATGER_45);
            } else {
            	datasComRegistros = stmt2.executeQuery(SELECT_DATGER_50);
            }

            datasComRegistros.last();
            
        } catch (SQLException e) {
        	String mensagem = e.getMessage();
        	JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);   
        }
    }	
	
	public LocalDate previous() {
		LocalDate data = LocalDate.now();
		try {
			if (datasComRegistros.previous()) {
				data = datasComRegistros.getDate("USU_DATGER").toLocalDate();
			}
		} catch (SQLException e) {
        	String mensagem = e.getMessage();
        	JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);   
        }
		return data;
	}

	public LocalDate next() {
		LocalDate data = LocalDate.now();
		try {
			if (datasComRegistros.next()) {
				data = datasComRegistros.getDate("USU_DATGER").toLocalDate();
			}
		} catch (SQLException e) {
        	String mensagem = e.getMessage();
        	JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);   
        }
		return data;
	}
	
	public LocalDate first() {
		LocalDate data = LocalDate.now();
		try {
			if (datasComRegistros.first()) {
				data = datasComRegistros.getDate("USU_DATGER").toLocalDate();
			}
		} catch (SQLException e) {
        	String mensagem = e.getMessage();
        	JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);   
        }
		return data;
	}
	
	public LocalDate last() {
		LocalDate data = LocalDate.now();
		try {
			if (datasComRegistros.last()) {
				data = datasComRegistros.getDate("USU_DATGER").toLocalDate();
			}
		} catch (SQLException e) {
        	String mensagem = e.getMessage();
        	JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);   
        }
		return data;
	}

	public void close() {
		try {
			stmt2.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
}
