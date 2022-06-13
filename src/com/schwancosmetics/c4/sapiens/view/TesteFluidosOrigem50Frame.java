package com.schwancosmetics.c4.sapiens.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
//import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import com.schwancosmetics.c4.sapiens.entidade.Componente;
import com.schwancosmetics.c4.sapiens.entidade.FormulaBase;
import com.schwancosmetics.c4.sapiens.entidade.OrdemProducao;
//import com.schwancosmetics.c4.sapiens.entidade.OrigemProduto;
import com.schwancosmetics.c4.sapiens.entidade.Produto;
import com.schwancosmetics.c4.sapiens.entidade.ReferenciaCor;
import com.schwancosmetics.c4.sapiens.entidade.Sistema;
import com.schwancosmetics.c4.sapiens.entidade.TesteFluidos;
import com.schwancosmetics.c4.sapiens.excecao.ComponenteBulkNaoEncontradoException;
import com.schwancosmetics.c4.sapiens.excecao.DataFuturaException;
import com.schwancosmetics.c4.sapiens.excecao.DataInvalidaException;
import com.schwancosmetics.c4.sapiens.excecao.DataNaoInformadaException;
import com.schwancosmetics.c4.sapiens.excecao.LoteComponenteNaoFazParteDaOPException;
import com.schwancosmetics.c4.sapiens.excecao.LoteComponenteNaoInformadoException;
import com.schwancosmetics.c4.sapiens.excecao.OrdemProducaoCanceladaException;
import com.schwancosmetics.c4.sapiens.excecao.OrdemProducaoFinalizadaException;
import com.schwancosmetics.c4.sapiens.excecao.OrdemProducaoNaoEncontradaException;
import com.schwancosmetics.c4.sapiens.excecao.OrdemProducaoNaoInformadaException;
import com.schwancosmetics.c4.sapiens.excecao.OrdemProducaoNaoIniciadaException;
import com.schwancosmetics.c4.sapiens.excecao.OrdemProducaoNaoLiberadaException;
import com.schwancosmetics.c4.sapiens.excecao.OrdemProducaoSuspensaException;
//import com.schwancosmetics.c4.sapiens.excecao.OrigemProdutoInvalidaException;
//import com.schwancosmetics.c4.sapiens.excecao.OrigemProdutoNaoInformadaException;
import com.schwancosmetics.c4.sapiens.excecao.ReferenciaCorNaoEncontradaException;
import com.schwancosmetics.c4.sapiens.servico.ComponenteServico;
import com.schwancosmetics.c4.sapiens.servico.FormulaBaseServico;
import com.schwancosmetics.c4.sapiens.servico.OrdemProducaoServico;
//import com.schwancosmetics.c4.sapiens.servico.OrigemProdutoServico;
import com.schwancosmetics.c4.sapiens.servico.ProdutoServico;
import com.schwancosmetics.c4.sapiens.servico.ReferenciaCorServico;
import com.schwancosmetics.c4.sapiens.servico.TesteFluidosServico;

public class TesteFluidosOrigem50Frame extends JInternalFrame {

	private static Sistema SISTEMA;

	private static final long serialVersionUID = 1L;

	private static TesteFluidosOrigem50Frame testeFluidosFrame;

	public static TesteFluidosOrigem50Frame getInstance() {
		if (testeFluidosFrame == null) {
			testeFluidosFrame = new TesteFluidosOrigem50Frame();
		}
		return testeFluidosFrame;
	}

	private final String CODORI_50 = "50";
	
	private static final int DATGER_WIDTH = 70;
	private static final int HORGER_WIDTH = 40;
	private static final int CODORI_WIDTH = 45;
	private static final int NUMORP_WIDTH = 70;
	private static final int CODPRO_WIDTH = 90;
	private static final int CODLOT_WIDTH = 80;	
	private static final int CODCMP_WIDTH = 90;
	private static final int LOTCMP_WIDTH = 100; //70;	
	private static final int FORBAS_WIDTH = 90;
	private static final int REFCOR_WIDTH = 90;
	private static final int DESCOR_WIDTH = 250;
	private static final int PESOG1_WIDTH = 70;
	private static final int PESOG2_WIDTH = 70;
	private static final int FLUIDE_WIDTH = 65;
	private static final int FLUMIN_WIDTH = 65;
	private static final int PERDIF_WIDTH = 75;
	private static final int QTDMAS_WIDTH = 90;
	private static final int QTDING_WIDTH = 90;
	private static final int TOLMIN_WIDTH = 65;
	private static final int TOLMAX_WIDTH = 70;
	private static final int INGVOL_WIDTH = 90;	
	private static final int SEQREG_WIDTH = 70;
	private static final int SITORP_WIDTH = 25;
	private static final int TABELA_WIDTH = DATGER_WIDTH + HORGER_WIDTH + CODORI_WIDTH + NUMORP_WIDTH + CODPRO_WIDTH + CODLOT_WIDTH + CODCMP_WIDTH + LOTCMP_WIDTH + FORBAS_WIDTH + REFCOR_WIDTH + DESCOR_WIDTH + PESOG1_WIDTH + PESOG2_WIDTH + FLUIDE_WIDTH + FLUMIN_WIDTH + PERDIF_WIDTH + QTDMAS_WIDTH + QTDING_WIDTH + TOLMIN_WIDTH + TOLMAX_WIDTH + INGVOL_WIDTH + SEQREG_WIDTH + SITORP_WIDTH + 20;

	private static final int POS_X = 10;
	private static final int POS_X_DATGER = POS_X;
	private static final int POS_X_HORGER = POS_X + DATGER_WIDTH;
	private static final int POS_X_CODORI = POS_X + DATGER_WIDTH + HORGER_WIDTH;
	private static final int POS_X_NUMORP = POS_X + DATGER_WIDTH + HORGER_WIDTH + CODORI_WIDTH;
	private static final int POS_X_CODPRO = POS_X + DATGER_WIDTH + HORGER_WIDTH + CODORI_WIDTH + NUMORP_WIDTH;
	private static final int POS_X_CODLOT = POS_X + DATGER_WIDTH + HORGER_WIDTH + CODORI_WIDTH + NUMORP_WIDTH + CODPRO_WIDTH;	
	private static final int POS_X_CODCMP = POS_X + DATGER_WIDTH + HORGER_WIDTH + CODORI_WIDTH + NUMORP_WIDTH + CODPRO_WIDTH + CODLOT_WIDTH;
	private static final int POS_X_LOTCMP = POS_X + DATGER_WIDTH + HORGER_WIDTH + CODORI_WIDTH + NUMORP_WIDTH + CODPRO_WIDTH + CODLOT_WIDTH + CODCMP_WIDTH;
	private static final int POS_X_FORBAS = POS_X + DATGER_WIDTH + HORGER_WIDTH + CODORI_WIDTH + NUMORP_WIDTH + CODPRO_WIDTH + CODLOT_WIDTH + CODCMP_WIDTH + LOTCMP_WIDTH;
	private static final int POS_X_REFCOR = POS_X + DATGER_WIDTH + HORGER_WIDTH + CODORI_WIDTH + NUMORP_WIDTH + CODPRO_WIDTH + CODLOT_WIDTH + CODCMP_WIDTH + LOTCMP_WIDTH + FORBAS_WIDTH;
	private static final int POS_X_DESCOR = POS_X + DATGER_WIDTH + HORGER_WIDTH + CODORI_WIDTH + NUMORP_WIDTH + CODPRO_WIDTH + CODLOT_WIDTH + CODCMP_WIDTH + LOTCMP_WIDTH + FORBAS_WIDTH + REFCOR_WIDTH;
	private static final int POS_X_PESOG1 = POS_X + DATGER_WIDTH + HORGER_WIDTH + CODORI_WIDTH + NUMORP_WIDTH + CODPRO_WIDTH + CODLOT_WIDTH + CODCMP_WIDTH + LOTCMP_WIDTH + FORBAS_WIDTH + REFCOR_WIDTH + DESCOR_WIDTH;
	private static final int POS_X_PESOG2 = POS_X + DATGER_WIDTH + HORGER_WIDTH + CODORI_WIDTH + NUMORP_WIDTH + CODPRO_WIDTH + CODLOT_WIDTH + CODCMP_WIDTH + LOTCMP_WIDTH + FORBAS_WIDTH + REFCOR_WIDTH + DESCOR_WIDTH + PESOG1_WIDTH;
	private static final int POS_X_FLUIDE = POS_X + DATGER_WIDTH + HORGER_WIDTH + CODORI_WIDTH + NUMORP_WIDTH + CODPRO_WIDTH + CODLOT_WIDTH + CODCMP_WIDTH + LOTCMP_WIDTH + FORBAS_WIDTH + REFCOR_WIDTH + DESCOR_WIDTH + PESOG1_WIDTH + PESOG2_WIDTH;
	private static final int POS_X_FLUMIN = POS_X + DATGER_WIDTH + HORGER_WIDTH + CODORI_WIDTH + NUMORP_WIDTH + CODPRO_WIDTH + CODLOT_WIDTH + CODCMP_WIDTH + LOTCMP_WIDTH + FORBAS_WIDTH + REFCOR_WIDTH + DESCOR_WIDTH + PESOG1_WIDTH + PESOG2_WIDTH + FLUIDE_WIDTH;
	private static final int POS_X_PERDIF = POS_X + DATGER_WIDTH + HORGER_WIDTH + CODORI_WIDTH + NUMORP_WIDTH + CODPRO_WIDTH + CODLOT_WIDTH + CODCMP_WIDTH + LOTCMP_WIDTH + FORBAS_WIDTH + REFCOR_WIDTH + DESCOR_WIDTH + PESOG1_WIDTH + PESOG2_WIDTH + FLUIDE_WIDTH + FLUMIN_WIDTH;
	private static final int POS_X_QTDMAS = POS_X + DATGER_WIDTH + HORGER_WIDTH + CODORI_WIDTH + NUMORP_WIDTH + CODPRO_WIDTH + CODLOT_WIDTH + CODCMP_WIDTH + LOTCMP_WIDTH + FORBAS_WIDTH + REFCOR_WIDTH + DESCOR_WIDTH + PESOG1_WIDTH + PESOG2_WIDTH + FLUIDE_WIDTH + FLUMIN_WIDTH + PERDIF_WIDTH;
	private static final int POS_X_QTDING = POS_X + DATGER_WIDTH + HORGER_WIDTH + CODORI_WIDTH + NUMORP_WIDTH + CODPRO_WIDTH + CODLOT_WIDTH + CODCMP_WIDTH + LOTCMP_WIDTH + FORBAS_WIDTH + REFCOR_WIDTH + DESCOR_WIDTH + PESOG1_WIDTH + PESOG2_WIDTH + FLUIDE_WIDTH + FLUMIN_WIDTH + PERDIF_WIDTH + QTDMAS_WIDTH;
	private static final int POS_X_TOLMIN = POS_X + DATGER_WIDTH + HORGER_WIDTH + CODORI_WIDTH + NUMORP_WIDTH + CODPRO_WIDTH + CODLOT_WIDTH + CODCMP_WIDTH + LOTCMP_WIDTH + FORBAS_WIDTH + REFCOR_WIDTH + DESCOR_WIDTH + PESOG1_WIDTH + PESOG2_WIDTH + FLUIDE_WIDTH + FLUMIN_WIDTH + PERDIF_WIDTH + QTDMAS_WIDTH + QTDING_WIDTH;
	private static final int POS_X_TOLMAX = POS_X + DATGER_WIDTH + HORGER_WIDTH + CODORI_WIDTH + NUMORP_WIDTH + CODPRO_WIDTH + CODLOT_WIDTH + CODCMP_WIDTH + LOTCMP_WIDTH + FORBAS_WIDTH + REFCOR_WIDTH + DESCOR_WIDTH + PESOG1_WIDTH + PESOG2_WIDTH + FLUIDE_WIDTH + FLUMIN_WIDTH + PERDIF_WIDTH + QTDMAS_WIDTH + QTDING_WIDTH + TOLMIN_WIDTH;
	private static final int POS_X_INGVOL = POS_X + DATGER_WIDTH + HORGER_WIDTH + CODORI_WIDTH + NUMORP_WIDTH + CODPRO_WIDTH + CODLOT_WIDTH + CODCMP_WIDTH + LOTCMP_WIDTH + FORBAS_WIDTH + REFCOR_WIDTH + DESCOR_WIDTH + PESOG1_WIDTH + PESOG2_WIDTH + FLUIDE_WIDTH + FLUMIN_WIDTH + PERDIF_WIDTH + QTDMAS_WIDTH + QTDING_WIDTH + TOLMIN_WIDTH + TOLMAX_WIDTH;
	private static final int POS_X_SEQREG = POS_X + DATGER_WIDTH + HORGER_WIDTH + CODORI_WIDTH + NUMORP_WIDTH + CODPRO_WIDTH + CODLOT_WIDTH + CODCMP_WIDTH + LOTCMP_WIDTH + FORBAS_WIDTH + REFCOR_WIDTH + DESCOR_WIDTH + PESOG1_WIDTH + PESOG2_WIDTH + FLUIDE_WIDTH + FLUMIN_WIDTH + PERDIF_WIDTH + QTDMAS_WIDTH + QTDING_WIDTH + TOLMIN_WIDTH + TOLMAX_WIDTH + INGVOL_WIDTH;

	private String[] colunasTestes = { "Data", "Hora", "Origem", "Ord. Prod.", "Produto O.P.", "Lote O.P.", "Bulk", "Lote Bulk", 	"Fórmula Base", "Cor Referência", "Textura", 
			"Peso G1(g)", "Peso G2(g)", "% ideal", "% Mina", "% Diferença", "Qtde. Massa(g)", "Qtde.Ing.Vol.(g)", "% Tol. Min.", " % Tol. Max.", "Ingred. Volátil", "Seq.", "Sit." };

	private static final int POS_X_COLUNA_1 = 10;

	private static final int POS_Y_LINHA_1 = 10;
	private static final int POS_Y_LINHA_2 = 30;
	private static final int POS_Y_LINHA_3 = 65;
	//private static final int POS_Y_LINHA_4 = 85;

	private static final int COMPRIMENTO_BOTAO = 95;
	// private static final int COMPRIMENTO_TEXTO = 90;
	// private static final int COMPRIMENTO_LABEL = 90;
	private static final int ALTURA_BOTAO = 25;
	private static final int ALTURA_LINHA = 20;
	// private final int ALTURA_LINHA_GRANDE = 40;
	private int ALTURA_GRIDE = 0;

	private DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private JPanel painelSuperior;
	private JPanel painelCentral;
	private JPanel painelInferior;

	private JTextField tfData;
	private JTextField tfCodOri;
	private JTextField tfNumOrp;
	private JTextField tfPesoG1;
	private JTextField tfPesoG2;
	private JTextField tfQtdeMassa;
	private JTextField tfCodPro;
	private JTextField tfCodLot;
	
	private JTextField tfCodCmp;
	private JTextField tfLotCmp;
	//private JComboBox<String>  cbLotCmp;
	
	private JTextField tfRefCor;
	private JTextField tfTextura;
	private JTextField tfFluIde;
	private JTextField tfFluMin;
	private JTextField tfDesFor;
	private JTextField tfPerDif;
	private JTextField tfQtdIngVol;
	private JTextField tfTolMin;
	private JTextField tfTolMax;
	private JTextField tfIngVol;
	private JTextField tfSeqReg;

	private JButton botaoPesquisar;
	private JButton botaoAdicionar;
	private JButton botaoGravar;
	private JButton botaoExcluir;
	private JButton botaoCancelar;
	private JButton botaoEditar;
	private JButton botaoSair;

	private JButton botaoPrimeiro;
	private JButton botaoAnterior;
	private JButton botaoProximo;
	private JButton botaoUltimo;

	private Font fonte = new Font("Arial", Font.BOLD, 12);

	private ModoTela modoTela;

	private JTable tabelaTesteFluidos;
	private JScrollPane spTesteFluidos;

	private DefaultTableModel modeloTesteFluidos;

	private TesteFluidosServico testeFluidosServico;
	private OrdemProducaoServico ordemProducaoServico;
	private ProdutoServico produtoServico;
	private ReferenciaCorServico referenciaCorServico;
	private FormulaBaseServico formulaBaseServico;
	//private OrigemProdutoServico origemProdutoServico;
	private ComponenteServico componenteServico;

	private TesteFluidos testeFluidos;
	private OrdemProducao ordemProducao;
	private Produto produto;
	private ReferenciaCor referenciaCor;
	private FormulaBase formulaBase;
	//private OrigemProduto origemProduto;
	
	//private List<String> lotesDeComponente = new ArrayList<>();
	
	private LocalDate primeiraData;
	private LocalDate ultimaData;

	private TesteFluidosOrigem50Frame() {
		super("Teste de Fluídos - Origem 50", 
				false,  // resizeble
				true,   // closable
				false,  // maximizable
				false); // iconifiable
		
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(5, 5, tela.width - 10, tela.height - 95);
		// setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);

		ALTURA_GRIDE = tela.height - 280;
		
		/*
		 * não funciona com java 8 try { setMaximum(true); } catch
		 * (PropertyVetoException e) { e.printStackTrace(); }
		 */

		SISTEMA = Sistema.getInstance();

		testeFluidosServico = new TesteFluidosServico();
		ordemProducaoServico = new OrdemProducaoServico();
		produtoServico = new ProdutoServico();
		referenciaCorServico = new ReferenciaCorServico();
		formulaBaseServico = new FormulaBaseServico();
		//origemProdutoServico = new OrigemProdutoServico();
		componenteServico = new ComponenteServico();

		testeFluidos = new TesteFluidos();
		ordemProducao = new OrdemProducao();
		produto = new Produto();
		referenciaCor = new ReferenciaCor();
		formulaBase = new FormulaBase();
		//origemProduto = new OrigemProduto();

		testeFluidosServico.queryDatasComRegistros(CODORI_50);
		primeiraData = testeFluidosServico.first();
		ultimaData   = testeFluidosServico.last();
		
		inicializaComponentes();
		defineEventos();
		
		queryByDatGer(ultimaData);
	
		defineModoTela(ModoTela.CONSULTA);
	}

	private void inicializaComponentes() {

		Container container = getContentPane();
		container.setLayout(new BorderLayout());

		/********************************************************************************************/

		painelSuperior = new JPanel();
		painelSuperior.setLayout(new FlowLayout());
		painelSuperior.setBorder(BorderFactory.createLineBorder(Color.black));

		criar_BotaoPrimeiro();

		criar_BotaoAnterior();

		criar_BotaoProximo();

		criar_BotaoUltimo();

		container.add("North", painelSuperior);

		/*********************************************************************************************/

		painelCentral = new JPanel();
		painelCentral.setLayout(null);
		// painelCentral.setBorder(BorderFactory.createLineBorder(Color.black));

		criar_DatGer();

		criar_BotaoPesquisar();

		criar_TCodOri();

		criar_NumOrp();

		criar_CodPro();

		criar_CodLot();
		
		criar_CodCmp();
		
		criar_LotCmp();

		criar_DesFor();

		criar_CorRef();

		criar_DesCor();

		criar_FluIde();

		criar_FluMin();

		criar_PerDif();

		criar_PesoG1();

		criar_PesoG2();

		criar_QtdeMassa();

		criar_QtdeIngVol();

		criar_TolMin();

		criar_TolMax();

		criar_IngVol();

		criar_Seq();

		/*************************************************************************************/

		criar_TabelaTesteFluidos();

		container.add("Center", painelCentral);

		/*********************************************************************************************/

		painelInferior = new JPanel();
		painelInferior.setLayout(new FlowLayout());
		painelInferior.setBorder(BorderFactory.createLineBorder(Color.black));

		criar_BotaoAdicionar();

		criar_BotaoEditar();

		criar_BotaoExcluir();

		criar_BotaoCancelar();

		criar_BotaoGravar();

		criar_BotaoSair();

		container.add("South", painelInferior);
	}

	private void criar_CodLot() {
		JLabel labelLote = new JLabel("Lote O.P.");
		labelLote.setHorizontalAlignment(JLabel.CENTER);
		labelLote.setBounds(POS_X_CODLOT, POS_Y_LINHA_1, CODLOT_WIDTH, ALTURA_LINHA);
		painelCentral.add(labelLote);

		tfCodLot = new JTextField(20);
		tfCodLot.setBounds(POS_X_CODLOT, POS_Y_LINHA_2, CODLOT_WIDTH, ALTURA_LINHA);
		tfCodLot.setHorizontalAlignment(JTextField.CENTER);
		tfCodLot.setEditable(false);
		painelCentral.add(tfCodLot);
	}

	private void criar_LotCmp() {
		JLabel labelLotCmp = new JLabel("Lote Bulk");
		labelLotCmp.setHorizontalAlignment(JLabel.CENTER);
		labelLotCmp.setBounds(POS_X_LOTCMP, POS_Y_LINHA_1, CODLOT_WIDTH, ALTURA_LINHA);
		painelCentral.add(labelLotCmp);

		/*
		cbLotCmp = new JComboBox<String>();
		cbLotCmp.setBounds(POS_X_LOTCMP, POS_Y_LINHA_2, LOTCMP_WIDTH, ALTURA_LINHA);
		//cbLotCmp.setHorizontalAlignment(JTextField.CENTER);
		cbLotCmp.setEditable(false);
		painelCentral.add(cbLotCmp);
		*/
		
		tfLotCmp = new JTextField();
		tfLotCmp.setBounds(POS_X_LOTCMP, POS_Y_LINHA_2, LOTCMP_WIDTH, ALTURA_LINHA);
		tfLotCmp.setHorizontalAlignment(JTextField.CENTER);
		tfLotCmp.setEditable(true);
		painelCentral.add(tfLotCmp);		
		
		tfLotCmp.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				tfLotCmp.setSelectionStart(0);
				tfLotCmp.setSelectionEnd(tfLotCmp.getText().length());
			}

			public void focusLost(FocusEvent fe) { 
				try {
					//consisteLotCmp();
					consisteEntradas();
					
				} catch (LoteComponenteNaoInformadoException e) {
					tfLotCmp.requestFocusInWindow();					
				} catch (LoteComponenteNaoFazParteDaOPException e) {
					tfLotCmp.requestFocusInWindow();
				} catch (ReferenciaCorNaoEncontradaException e) {
					tfNumOrp.requestFocusInWindow();
				} catch (OrdemProducaoNaoInformadaException e) {
					tfNumOrp.requestFocusInWindow();
				} catch (OrdemProducaoNaoEncontradaException e) {
					tfNumOrp.requestFocusInWindow();
				} catch (OrdemProducaoCanceladaException e) {
					tfNumOrp.requestFocusInWindow();
				} catch (OrdemProducaoFinalizadaException e) {
					tfNumOrp.requestFocusInWindow();
				} catch (OrdemProducaoSuspensaException e) {
					tfNumOrp.requestFocusInWindow();
				} catch (OrdemProducaoNaoIniciadaException e) {
					tfNumOrp.requestFocusInWindow();
				} catch (OrdemProducaoNaoLiberadaException e) {
					tfNumOrp.requestFocusInWindow();
				} catch (ComponenteBulkNaoEncontradoException e) {
					tfNumOrp.requestFocusInWindow();
				} 			
			}
		});
		
		tfLotCmp.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if ((c == KeyEvent.VK_ENTER) || (c == KeyEvent.VK_TAB)) {
					tfPesoG1.requestFocusInWindow();
				}
			}
		});
	}

	
	private void criar_DesFor() {
		JLabel labelFormulaBase = new JLabel("Formula Base");
		labelFormulaBase.setHorizontalAlignment(JLabel.CENTER);
		labelFormulaBase.setBounds(POS_X_FORBAS, POS_Y_LINHA_1, FORBAS_WIDTH, ALTURA_LINHA);
		painelCentral.add(labelFormulaBase);

		tfDesFor = new JTextField(20);
		tfDesFor.setBounds(POS_X_FORBAS, POS_Y_LINHA_2, FORBAS_WIDTH, ALTURA_LINHA);
		tfDesFor.setHorizontalAlignment(JTextField.CENTER);
		tfDesFor.setEditable(false);
		painelCentral.add(tfDesFor);
	}

	private void criar_CorRef() {
		JLabel labelCorRef = new JLabel("Cor Referência");
		labelCorRef.setHorizontalAlignment(JLabel.CENTER);
		labelCorRef.setBounds(POS_X_REFCOR, POS_Y_LINHA_1, REFCOR_WIDTH, ALTURA_LINHA);
		painelCentral.add(labelCorRef);

		tfRefCor = new JTextField(20);
		tfRefCor.setBounds(POS_X_REFCOR, POS_Y_LINHA_2, REFCOR_WIDTH, ALTURA_LINHA);
		tfRefCor.setHorizontalAlignment(JTextField.CENTER);
		tfRefCor.setEditable(false);
		painelCentral.add(tfRefCor);
	}

	private void criar_DesCor() {
		JLabel labelDesCor = new JLabel("Textura");
		labelDesCor.setHorizontalAlignment(JLabel.CENTER);
		labelDesCor.setBounds(POS_X_DESCOR, POS_Y_LINHA_1, DESCOR_WIDTH, ALTURA_LINHA);
		painelCentral.add(labelDesCor);

		tfTextura = new JTextField(20);
		tfTextura.setBounds(POS_X_DESCOR, POS_Y_LINHA_2, DESCOR_WIDTH, ALTURA_LINHA);
		tfTextura.setHorizontalAlignment(JTextField.LEFT);
		tfTextura.setEditable(false);
		painelCentral.add(tfTextura);
	}

	private void criar_FluIde() {
		JLabel labelFluIde = new JLabel("% Ideal");
		labelFluIde.setHorizontalAlignment(JLabel.CENTER);
		labelFluIde.setBounds(POS_X_FLUIDE, POS_Y_LINHA_1, FLUIDE_WIDTH, ALTURA_LINHA);
		painelCentral.add(labelFluIde);

		tfFluIde = new JTextField(20);
		tfFluIde.setBounds(POS_X_FLUIDE, POS_Y_LINHA_2, FLUIDE_WIDTH, ALTURA_LINHA);
		tfFluIde.setHorizontalAlignment(JTextField.CENTER);
		tfFluIde.setEditable(false);
		painelCentral.add(tfFluIde);
	}

	private void criar_FluMin() {
		JLabel labelFluMin = new JLabel("% Mina");
		labelFluMin.setHorizontalAlignment(JLabel.CENTER);
		labelFluMin.setBounds(POS_X_FLUMIN, POS_Y_LINHA_1, FLUMIN_WIDTH, ALTURA_LINHA);
		painelCentral.add(labelFluMin);

		tfFluMin = new JTextField(20);
		tfFluMin.setBounds(POS_X_FLUMIN, POS_Y_LINHA_2, FLUMIN_WIDTH, ALTURA_LINHA);
		tfFluMin.setHorizontalAlignment(JTextField.CENTER);
		tfFluMin.setEditable(false);
		painelCentral.add(tfFluMin);
	}

	private void criar_PerDif() {
		JLabel labelPerDif = new JLabel("% Diferença");
		labelPerDif.setHorizontalAlignment(JLabel.CENTER);
		labelPerDif.setBounds(POS_X_PERDIF, POS_Y_LINHA_1, PERDIF_WIDTH, ALTURA_LINHA);
		painelCentral.add(labelPerDif);

		tfPerDif = new JTextField(20);
		tfPerDif.setBounds(POS_X_PERDIF, POS_Y_LINHA_2, PERDIF_WIDTH, ALTURA_LINHA);
		tfPerDif.setHorizontalAlignment(JTextField.CENTER);
		tfPerDif.setEditable(false);
		tfPerDif.setFont(fonte);
		painelCentral.add(tfPerDif);
	}

	private void criar_Seq() {
		JLabel labelSeq = new JLabel("Seq.");
		labelSeq.setHorizontalAlignment(JLabel.CENTER);
		labelSeq.setBounds(POS_X_SEQREG, POS_Y_LINHA_1, SEQREG_WIDTH, ALTURA_LINHA);
		painelCentral.add(labelSeq);

		tfSeqReg = new JTextField(20);
		tfSeqReg.setText(" ");
		tfSeqReg.setBounds(POS_X_SEQREG, POS_Y_LINHA_2, SEQREG_WIDTH, ALTURA_LINHA);
		tfSeqReg.setHorizontalAlignment(JTextField.CENTER);
		tfSeqReg.setEditable(false);
		painelCentral.add(tfSeqReg);
	}

	private void criar_IngVol() {
		JLabel labelIngVol = new JLabel("Ingred. Volátil");
		labelIngVol.setHorizontalAlignment(JLabel.CENTER);
		labelIngVol.setBounds(POS_X_INGVOL, POS_Y_LINHA_1, INGVOL_WIDTH, ALTURA_LINHA);
		painelCentral.add(labelIngVol);

		tfIngVol = new JTextField(20);
		tfIngVol.setText(" ");
		tfIngVol.setBounds(POS_X_INGVOL, POS_Y_LINHA_2, INGVOL_WIDTH, ALTURA_LINHA);
		tfIngVol.setHorizontalAlignment(JTextField.CENTER);
		tfIngVol.setEditable(false);
		painelCentral.add(tfIngVol);
	}

	private void criar_TolMax() {
		JLabel labelTolMax = new JLabel("% Tol. Max.");
		labelTolMax.setHorizontalAlignment(JLabel.CENTER);
		labelTolMax.setBounds(POS_X_TOLMAX, POS_Y_LINHA_1, TOLMAX_WIDTH, ALTURA_LINHA);
		painelCentral.add(labelTolMax);

		tfTolMax = new JTextField(20);
		tfTolMax.setText("0");
		tfTolMax.setBounds(POS_X_TOLMAX, POS_Y_LINHA_2, TOLMAX_WIDTH, ALTURA_LINHA);
		tfTolMax.setHorizontalAlignment(JTextField.CENTER);
		tfTolMax.setEditable(false);
		painelCentral.add(tfTolMax);
	}

	private void criar_TolMin() {
		JLabel labelTolMin = new JLabel("% Tol. Min.");
		labelTolMin.setHorizontalAlignment(JLabel.CENTER);
		labelTolMin.setBounds(POS_X_TOLMIN, POS_Y_LINHA_1, TOLMIN_WIDTH, ALTURA_LINHA);
		painelCentral.add(labelTolMin);

		tfTolMin = new JTextField(20);
		tfTolMin.setText("0");
		tfTolMin.setBounds(POS_X_TOLMIN, POS_Y_LINHA_2, TOLMIN_WIDTH, ALTURA_LINHA);
		tfTolMin.setHorizontalAlignment(JTextField.CENTER);
		tfTolMin.setEditable(false);
		painelCentral.add(tfTolMin);
	}

	private void criar_QtdeIngVol() {
		JLabel labelQtdeCicl = new JLabel("Qtde.Ing.Vol.(g)");
		labelQtdeCicl.setHorizontalAlignment(JLabel.CENTER);
		labelQtdeCicl.setBounds(POS_X_QTDING, POS_Y_LINHA_1, QTDING_WIDTH, ALTURA_LINHA);
		painelCentral.add(labelQtdeCicl);

		tfQtdIngVol = new JTextField(20);
		tfQtdIngVol.setText("0");
		tfQtdIngVol.setBounds(POS_X_QTDING, POS_Y_LINHA_2, QTDING_WIDTH, ALTURA_LINHA);
		tfQtdIngVol.setHorizontalAlignment(JTextField.CENTER);
		tfQtdIngVol.setEditable(false);
		painelCentral.add(tfQtdIngVol);
	}

	private void criar_BotaoPesquisar() {
		botaoPesquisar = new JButton("Pesquisar");
		botaoPesquisar.setBounds(POS_X_HORGER, POS_Y_LINHA_2, HORGER_WIDTH, ALTURA_BOTAO);
		painelCentral.add(botaoPesquisar);

		botaoPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				tabelaTesteFluidos.requestFocusInWindow();
				queryByDatGer(LocalDate.parse(tfData.getText(), formatoData));
			}
		});
	}

	private void criar_BotaoUltimo() {
		botaoUltimo = new JButton(">|");
		painelSuperior.add(botaoUltimo);

		botaoUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				ultimo();
			}
		});
	}

	private void criar_BotaoProximo() {
		botaoProximo = new JButton(">");
		painelSuperior.add(botaoProximo);

		botaoProximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				proximo();
			}
		});
	}

	private void criar_BotaoAnterior() {
		botaoAnterior = new JButton("<");
		painelSuperior.add(botaoAnterior);

		botaoAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				anterior();
			}
		});
	}

	private void criar_BotaoPrimeiro() {
		botaoPrimeiro = new JButton("|<");
		painelSuperior.add(botaoPrimeiro);

		botaoPrimeiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {				
				primeiro();
			}
		});
	}

	private void criar_QtdeMassa() {

		JLabel labelQtdeMassa = new JLabel("Qtde. Massa(g)");
		labelQtdeMassa.setHorizontalAlignment(JLabel.CENTER);
		labelQtdeMassa.setBounds(POS_X_QTDMAS, POS_Y_LINHA_1, QTDMAS_WIDTH, ALTURA_LINHA);
		painelCentral.add(labelQtdeMassa);

		tfQtdeMassa = new JTextField(20);
		tfQtdeMassa.setText("0");
		tfQtdeMassa.setBounds(POS_X_QTDMAS, POS_Y_LINHA_2, QTDMAS_WIDTH, ALTURA_LINHA);
		tfQtdeMassa.setHorizontalAlignment(JTextField.CENTER);
		tfQtdeMassa.setEditable(true);
		painelCentral.add(tfQtdeMassa);

		tfQtdeMassa.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != KeyEvent.VK_ENTER)
						&& (c != ',')) {
					e.consume(); // ignore event
				}
				if (c == KeyEvent.VK_ENTER) {
					botaoGravar.requestFocusInWindow();
				}
			}
		});

		tfQtdeMassa.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				tfQtdeMassa.setSelectionStart(0);
				tfQtdeMassa.setSelectionEnd(tfQtdeMassa.getText().length());
			}

			public void focusLost(FocusEvent e) {
				if (modoTela != ModoTela.CONSULTA) {
					consisteQtdeMassa();
				}
			}
		});
	}

	private void criar_PesoG2() {
		JLabel labelPesoG2 = new JLabel("Peso G2(g)");
		labelPesoG2.setHorizontalAlignment(JLabel.CENTER);
		labelPesoG2.setBounds(POS_X_PESOG2, POS_Y_LINHA_1, PESOG2_WIDTH, ALTURA_LINHA);
		painelCentral.add(labelPesoG2);

		tfPesoG2 = new JTextField(20);
		tfPesoG2.setText("0,00");
		tfPesoG2.setBounds(POS_X_PESOG2, POS_Y_LINHA_2, PESOG2_WIDTH, ALTURA_LINHA);
		tfPesoG2.setHorizontalAlignment(JTextField.CENTER);
		tfPesoG2.setEditable(true);
		painelCentral.add(tfPesoG2);

		tfPesoG2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != KeyEvent.VK_ENTER)
						&& (c != ',')) {
					e.consume(); // ignore event
				}
				if (c == KeyEvent.VK_ENTER) {
					tfQtdeMassa.requestFocusInWindow();
				}
			}
		});

		tfPesoG2.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				tfPesoG2.setSelectionStart(0);
				tfPesoG2.setSelectionEnd(tfPesoG2.getText().length());
			}

			public void focusLost(FocusEvent e) {
				if (modoTela != ModoTela.CONSULTA) {
					consistePesoG2();
				}
			}
		});
	}

	private void criar_PesoG1() {
		JLabel labelPesoG1 = new JLabel("Peso G1(g)");
		labelPesoG1.setHorizontalAlignment(JLabel.CENTER);
		labelPesoG1.setBounds(POS_X_PESOG1, POS_Y_LINHA_1, PESOG1_WIDTH, ALTURA_LINHA);
		painelCentral.add(labelPesoG1);

		tfPesoG1 = new JTextField(20);
		tfPesoG1.setText("0,00");
		tfPesoG1.setBounds(POS_X_PESOG1, POS_Y_LINHA_2, PESOG1_WIDTH, ALTURA_LINHA);
		tfPesoG1.setHorizontalAlignment(JTextField.CENTER);
		tfPesoG1.setEditable(true);
		painelCentral.add(tfPesoG1);

		tfPesoG1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != KeyEvent.VK_ENTER)
						&& (c != ',')) {
					e.consume(); // ignore event
				}
				if (c == KeyEvent.VK_ENTER) {
					tfPesoG2.requestFocusInWindow();
				}
			}
		});

		tfPesoG1.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				tfPesoG1.setSelectionStart(0);
				tfPesoG1.setSelectionEnd(tfPesoG1.getText().length());
			}

			public void focusLost(FocusEvent e) {
				if (modoTela != ModoTela.CONSULTA) {
					consistePesoG1();
				}
			}
		});
	}

	private void criar_CodPro() {

		JLabel labelProduto = new JLabel("Produto O.P.");
		labelProduto.setHorizontalAlignment(JLabel.CENTER);
		labelProduto.setBounds(POS_X_CODPRO, POS_Y_LINHA_1, CODPRO_WIDTH, ALTURA_LINHA);
		painelCentral.add(labelProduto);

		tfCodPro = new JTextField(20);
		tfCodPro.setBounds(POS_X_CODPRO, POS_Y_LINHA_2, CODPRO_WIDTH, ALTURA_LINHA);
		tfCodPro.setHorizontalAlignment(JTextField.CENTER);
		tfCodPro.setEditable(false);
		painelCentral.add(tfCodPro);
	}

	private void criar_CodCmp() {

		JLabel labelCodCmp = new JLabel("Bulk");
		labelCodCmp.setHorizontalAlignment(JLabel.CENTER);
		labelCodCmp.setBounds(POS_X_CODCMP, POS_Y_LINHA_1, CODCMP_WIDTH, ALTURA_LINHA);
		painelCentral.add(labelCodCmp);

		tfCodCmp = new JTextField(20);
		tfCodCmp.setBounds(POS_X_CODCMP, POS_Y_LINHA_2, CODCMP_WIDTH, ALTURA_LINHA);
		tfCodCmp.setHorizontalAlignment(JTextField.CENTER);
		tfCodCmp.setEditable(false);
		painelCentral.add(tfCodCmp);
	}
	
	private void criar_NumOrp() {

		JLabel labelOP = new JLabel("Ord. Prod.");
		labelOP.setHorizontalAlignment(JLabel.CENTER);
		labelOP.setBounds(POS_X_NUMORP, POS_Y_LINHA_1, NUMORP_WIDTH, ALTURA_LINHA);
		painelCentral.add(labelOP);

		tfNumOrp = new JTextField(20);
		tfNumOrp.setText("0");
		tfNumOrp.setBounds(POS_X_NUMORP, POS_Y_LINHA_2, NUMORP_WIDTH, ALTURA_LINHA);
		tfNumOrp.setHorizontalAlignment(JTextField.CENTER);
		tfNumOrp.setEditable(true);
		painelCentral.add(tfNumOrp);

		tfNumOrp.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				tfNumOrp.setSelectionStart(0);
				tfNumOrp.setSelectionEnd(tfNumOrp.getText().length());
			}

			public void focusLost(FocusEvent fe) {
				if (modoTela != ModoTela.CONSULTA) {
					try {
						//consisteOrdemProducao();
						consisteEntradas();
					} catch (ReferenciaCorNaoEncontradaException e) {
						tfNumOrp.requestFocusInWindow();
					} catch (OrdemProducaoNaoInformadaException e) {
						tfNumOrp.requestFocusInWindow();
					} catch (OrdemProducaoNaoEncontradaException e) {
						tfNumOrp.requestFocusInWindow();
					} catch (OrdemProducaoCanceladaException e) {
						tfNumOrp.requestFocusInWindow();
					} catch (OrdemProducaoFinalizadaException e) {
						tfNumOrp.requestFocusInWindow();
					} catch (OrdemProducaoSuspensaException e) {
						tfNumOrp.requestFocusInWindow();
					} catch (OrdemProducaoNaoIniciadaException e) {
						tfNumOrp.requestFocusInWindow();
					} catch (OrdemProducaoNaoLiberadaException e) {
						tfNumOrp.requestFocusInWindow();
					} catch (ComponenteBulkNaoEncontradoException e) {
						tfNumOrp.requestFocusInWindow();
					} catch (LoteComponenteNaoInformadoException e) {
						tfLotCmp.requestFocusInWindow();
					} catch (LoteComponenteNaoFazParteDaOPException e) {
						tfLotCmp.requestFocusInWindow();
					}					
				}
			}
		});

		tfNumOrp.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != KeyEvent.VK_ENTER)
						&& (c != KeyEvent.VK_TAB)) {
					e.consume(); // ignore event
				}
				if ((c == KeyEvent.VK_ENTER) || (c == KeyEvent.VK_TAB)) {
					tfLotCmp.requestFocusInWindow();
				}
			}
		});
	}

	private void criar_TCodOri() {
		JLabel labelOrigem = new JLabel("Origem");
		labelOrigem.setHorizontalAlignment(JLabel.CENTER);
		labelOrigem.setBounds(POS_X_CODORI, POS_Y_LINHA_1, CODORI_WIDTH, ALTURA_LINHA);
		painelCentral.add(labelOrigem);

		tfCodOri = new JTextField(10);
		tfCodOri.setText(CODORI_50);
		tfCodOri.setBounds(POS_X_CODORI, POS_Y_LINHA_2, CODORI_WIDTH, ALTURA_LINHA);
		tfCodOri.setEditable(true);
		tfCodOri.setHorizontalAlignment(JTextField.CENTER);
		tfCodOri.requestFocusInWindow();
		painelCentral.add(tfCodOri);

		/*
		tfCodOri.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				tfCodOri.setSelectionStart(0);
				tfCodOri.setSelectionEnd(tfCodOri.getText().length());
			}

			public void focusLost(FocusEvent fe) {
				if (modoTela != ModoTela.CONSULTA) {
					try {
						consisteOrigemProduto();
					} catch (OrigemProdutoNaoInformadaException e) {
						tfCodOri.setText("45");
						tfCodOri.requestFocusInWindow();
					} catch (OrigemProdutoInvalidaException e) {
						tfCodOri.setText("45");
						tfCodOri.requestFocusInWindow();
					}
				}
			}
		});		

		tfCodOri.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != KeyEvent.VK_ENTER)
						&& (c != KeyEvent.VK_TAB)) {
					e.consume(); // ignore event
				}
				if ((c == KeyEvent.VK_ENTER) || (c == KeyEvent.VK_TAB)) {
					tfNumOrp.requestFocusInWindow();
				}
			}
		});
		*/
	}

	private void criar_DatGer() {
		JLabel labelData = new JLabel("Data");
		labelData.setHorizontalAlignment(JLabel.CENTER);
		labelData.setBounds(POS_X_DATGER, POS_Y_LINHA_1, DATGER_WIDTH, ALTURA_LINHA);
		painelCentral.add(labelData);

		try {
			tfData = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		tfData.setText(LocalDate.now().format(formatoData));
		tfData.setBounds(POS_X_DATGER, POS_Y_LINHA_2, DATGER_WIDTH, ALTURA_LINHA);
		tfData.setEditable(true);
		tfData.setHorizontalAlignment(JTextField.CENTER);
		painelCentral.add(tfData);

		tfData.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				tfData.setSelectionStart(0);
				tfData.setSelectionEnd(tfData.getText().length());
			}

			public void focusLost(FocusEvent fe) {
				if (modoTela != ModoTela.CONSULTA) {
					try {
						consisteData();
					} catch (DataNaoInformadaException e) {
						tfData.requestFocusInWindow();
					} catch (DataInvalidaException e) {
						tfData.requestFocusInWindow();
					} catch (DataFuturaException e) {
						tfData.requestFocusInWindow();
					}
				}
			}
		});

		tfData.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != '/') && (c != KeyEvent.VK_ENTER)
						&& (c != KeyEvent.VK_TAB)) {
					e.consume(); // ignore event
				}				
				if ((c == KeyEvent.VK_ENTER) || (c == KeyEvent.VK_TAB)) {
					tfNumOrp.requestFocusInWindow();
				}
			}
		});
	}

	private void criar_TabelaTesteFluidos() {
		modeloTesteFluidos = new DefaultTableModel(null, colunasTestes) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};

		tabelaTesteFluidos = new JTable();
		tabelaTesteFluidos.setModel(modeloTesteFluidos);
		tabelaTesteFluidos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabelaTesteFluidos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabelaTesteFluidos.getTableHeader().setResizingAllowed(false);
		tabelaTesteFluidos.setRowHeight(ALTURA_LINHA);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);

		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(JLabel.RIGHT);

		DefaultTableCellRenderer perDifNormal = new DefaultTableCellRenderer();
		perDifNormal.setBackground(tabelaTesteFluidos.getBackground());
		perDifNormal.setForeground(tabelaTesteFluidos.getForeground());

		DefaultTableCellRenderer perDifPositivo = new DefaultTableCellRenderer();
		perDifPositivo.setBackground(Color.GREEN);
		perDifPositivo.setForeground(Color.BLUE);

		DefaultTableCellRenderer perDifNegativo = new DefaultTableCellRenderer();
		perDifNegativo.setBackground(Color.RED);
		perDifNegativo.setForeground(Color.WHITE);
		
		int coluna = 0;

		// Data
		tabelaTesteFluidos.getColumnModel().getColumn(coluna).setPreferredWidth(DATGER_WIDTH);
		tabelaTesteFluidos.getColumnModel().getColumn(coluna).setCellRenderer(centerRenderer);
		coluna++;

		// Hora
		tabelaTesteFluidos.getColumnModel().getColumn(coluna).setPreferredWidth(HORGER_WIDTH);
		tabelaTesteFluidos.getColumnModel().getColumn(coluna).setCellRenderer(centerRenderer);
		coluna++;

		// Origem
		tabelaTesteFluidos.getColumnModel().getColumn(coluna).setPreferredWidth(CODORI_WIDTH);
		tabelaTesteFluidos.getColumnModel().getColumn(coluna).setCellRenderer(centerRenderer);
		coluna++;

		// Número O.P.
		tabelaTesteFluidos.getColumnModel().getColumn(coluna).setPreferredWidth(NUMORP_WIDTH);
		tabelaTesteFluidos.getColumnModel().getColumn(coluna).setCellRenderer(centerRenderer);
		coluna++;

		// Produto
		tabelaTesteFluidos.getColumnModel().getColumn(coluna).setPreferredWidth(CODPRO_WIDTH);
		tabelaTesteFluidos.getColumnModel().getColumn(coluna).setCellRenderer(centerRenderer);
		coluna++;

		// Lote
		tabelaTesteFluidos.getColumnModel().getColumn(coluna).setPreferredWidth(CODLOT_WIDTH);
		tabelaTesteFluidos.getColumnModel().getColumn(coluna).setCellRenderer(centerRenderer);
		coluna++;

		// Componente / Bulk
		tabelaTesteFluidos.getColumnModel().getColumn(coluna).setPreferredWidth(CODCMP_WIDTH);
		tabelaTesteFluidos.getColumnModel().getColumn(coluna).setCellRenderer(centerRenderer);
		coluna++;

		// Lote Componente / Lote Bulk
		tabelaTesteFluidos.getColumnModel().getColumn(coluna).setPreferredWidth(LOTCMP_WIDTH);
		tabelaTesteFluidos.getColumnModel().getColumn(coluna).setCellRenderer(centerRenderer);
		coluna++;
		
		// Fórmula Base
		tabelaTesteFluidos.getColumnModel().getColumn(coluna).setPreferredWidth(FORBAS_WIDTH);
		tabelaTesteFluidos.getColumnModel().getColumn(coluna).setCellRenderer(centerRenderer);
		coluna++;

		// Cor Referência
		tabelaTesteFluidos.getColumnModel().getColumn(coluna).setPreferredWidth(REFCOR_WIDTH);
		tabelaTesteFluidos.getColumnModel().getColumn(coluna).setCellRenderer(centerRenderer);
		coluna++;

		// Textura
		tabelaTesteFluidos.getColumnModel().getColumn(coluna).setPreferredWidth(DESCOR_WIDTH);
		// tabelaTesteFluidos.getColumnModel().getColumn(coluna).setCellRenderer(
		coluna++;
		// centerRenderer );

		// Peso G1(g)
		tabelaTesteFluidos.getColumnModel().getColumn(coluna).setPreferredWidth(PESOG1_WIDTH);
		tabelaTesteFluidos.getColumnModel().getColumn(coluna).setCellRenderer(centerRenderer);
		coluna++;

		// Peso G2(g)
		tabelaTesteFluidos.getColumnModel().getColumn(coluna).setPreferredWidth(PESOG2_WIDTH);
		tabelaTesteFluidos.getColumnModel().getColumn(coluna).setCellRenderer(centerRenderer);
		coluna++;

		// % ideal
		tabelaTesteFluidos.getColumnModel().getColumn(coluna).setPreferredWidth(FLUIDE_WIDTH);
		tabelaTesteFluidos.getColumnModel().getColumn(coluna).setCellRenderer(centerRenderer);
		coluna++;

		// % Mina
		tabelaTesteFluidos.getColumnModel().getColumn(coluna).setPreferredWidth(FLUMIN_WIDTH);
		tabelaTesteFluidos.getColumnModel().getColumn(coluna).setCellRenderer(centerRenderer);
		coluna++;

		// % Diferença
		tabelaTesteFluidos.getColumnModel().getColumn(coluna).setPreferredWidth(PERDIF_WIDTH);
		tabelaTesteFluidos.getColumnModel().getColumn(coluna).setCellRenderer(centerRenderer);
		coluna++;

		// Qtde. Massa(g)
		tabelaTesteFluidos.getColumnModel().getColumn(coluna).setPreferredWidth(QTDMAS_WIDTH);
		tabelaTesteFluidos.getColumnModel().getColumn(coluna).setCellRenderer(centerRenderer);
		coluna++;

		// Qtde. Ingrediente Volatil (g)
		tabelaTesteFluidos.getColumnModel().getColumn(coluna).setPreferredWidth(QTDING_WIDTH);
		tabelaTesteFluidos.getColumnModel().getColumn(coluna).setCellRenderer(centerRenderer);
		coluna++;

		// Tol. Min.
		tabelaTesteFluidos.getColumnModel().getColumn(coluna).setPreferredWidth(TOLMIN_WIDTH);
		tabelaTesteFluidos.getColumnModel().getColumn(coluna).setCellRenderer(centerRenderer);
		coluna++;

		// Tol. Max.
		tabelaTesteFluidos.getColumnModel().getColumn(coluna).setPreferredWidth(TOLMAX_WIDTH);
		tabelaTesteFluidos.getColumnModel().getColumn(coluna).setCellRenderer(centerRenderer);
		coluna++;

		// Ingred. Volátil
		tabelaTesteFluidos.getColumnModel().getColumn(coluna).setPreferredWidth(INGVOL_WIDTH);
		tabelaTesteFluidos.getColumnModel().getColumn(coluna).setCellRenderer(centerRenderer);
		coluna++;

		// Seq. (ID)
		tabelaTesteFluidos.getColumnModel().getColumn(coluna).setPreferredWidth(SEQREG_WIDTH);
		tabelaTesteFluidos.getColumnModel().getColumn(coluna).setCellRenderer(centerRenderer);
		
		coluna++;
		// Sit. Ord. Prod.
		tabelaTesteFluidos.getColumnModel().getColumn(coluna).setPreferredWidth(SITORP_WIDTH);
		tabelaTesteFluidos.getColumnModel().getColumn(coluna).setCellRenderer(centerRenderer);
		coluna++;
		
		spTesteFluidos = new JScrollPane(tabelaTesteFluidos);
		spTesteFluidos.setBounds(POS_X_COLUNA_1, POS_Y_LINHA_3, TABELA_WIDTH, ALTURA_GRIDE);
		painelCentral.add(spTesteFluidos);

		tabelaTesteFluidos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if ((tabelaTesteFluidos.getRowCount() > 0) && tabelaTesteFluidos.getSelectedRow() >= 0) {
					sincronizarLinhaAtual();
				}
			}
		});
	}

	private void criar_BotaoAdicionar() {

		botaoAdicionar = new JButton("Adicionar");
		botaoAdicionar.setPreferredSize(new Dimension(COMPRIMENTO_BOTAO, ALTURA_BOTAO));
		painelInferior.add(botaoAdicionar);

		botaoAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				adicionar();
			}
		});
	}

	private void criar_BotaoEditar() {

		botaoEditar = new JButton("Editar");
		botaoEditar.setPreferredSize(new Dimension(COMPRIMENTO_BOTAO, ALTURA_BOTAO));
		painelInferior.add(botaoEditar);

		botaoEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				editar();
			}
		});
	}

	private void criar_BotaoExcluir() {
		botaoExcluir = new JButton("Excluir");
		botaoExcluir.setPreferredSize(new Dimension(COMPRIMENTO_BOTAO, ALTURA_BOTAO));
		painelInferior.add(botaoExcluir);

		botaoExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				excluir();
			}
		});
	}

	private void criar_BotaoCancelar() {

		botaoCancelar = new JButton("Cancelar");
		botaoCancelar.setPreferredSize(new Dimension(COMPRIMENTO_BOTAO, ALTURA_BOTAO));
		painelInferior.add(botaoCancelar);

		botaoCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				cancelar();
			}
		});
	}

	private void criar_BotaoGravar() {

		botaoGravar = new JButton("Gravar");
		botaoGravar.setPreferredSize(new Dimension(COMPRIMENTO_BOTAO, ALTURA_BOTAO));
		painelInferior.add(botaoGravar);

		botaoGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				gravar();
			}
		});
	}

	private void criar_BotaoSair() {

		botaoSair = new JButton("Sair");
		botaoSair.setPreferredSize(new Dimension(COMPRIMENTO_BOTAO, ALTURA_BOTAO));
		painelInferior.add(botaoSair);

		botaoSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				sair();
			}
		});
	}

	private void defineEventos() {
		/*
		 * tfNumOrp.getDocument().addDocumentListener(new DocumentListener() { public
		 * void changedUpdate(DocumentEvent e) { // query(); }
		 * 
		 * public void removeUpdate(DocumentEvent e) { // query(); }
		 * 
		 * public void insertUpdate(DocumentEvent e) { // query(); } });
		 * 
		 * tfNumOrp.addFocusListener(new FocusListener() { public void
		 * focusGained(FocusEvent e) {
		 * 
		 * };
		 * 
		 * public void focusLost(FocusEvent e) {
		 * 
		 * }; });
		 */
	}

	public void teclasDeAtalho(KeyEvent evt) {
		/*
		 * if (evt.getKeyCode() == KeyEvent.VK_ENTER) { this.OK(); }
		 */

		if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
			this.cancelar();
		}
	}

	private void ultimo() {
		LocalDate data = this.testeFluidosServico.last(); 

		tfData.setText(data.format(formatoData));
		queryByDatGer(data);
		defineModoTela(ModoTela.CONSULTA);
	}

	private void anterior() {
		LocalDate data = this.testeFluidosServico.previous(); 

		tfData.setText(data.format(formatoData));
		queryByDatGer(data);
		defineModoTela(ModoTela.CONSULTA);
	}

	private void proximo() {
		LocalDate data = this.testeFluidosServico.next(); 
				
		tfData.setText(data.format(formatoData));
		queryByDatGer(data);
		
		defineModoTela(ModoTela.CONSULTA);
	}

	private void primeiro() {
		LocalDate data = this.testeFluidosServico.first(); 

		tfData.setText(data.format(formatoData));
		queryByDatGer(data);
		defineModoTela(ModoTela.CONSULTA);
	}

	private String doubleToString(Double valor, int decimal) {
		String formato;
		switch (decimal) {
		case 0:
			formato = "#0";
			break;
		case 1:
			formato = "#,#0.0";
			break;
		case 2:
			formato = "#,##0.00";
			break;
		case 3:
			formato = "#,###0.000";
			break;
		case 4:
			formato = "#,####0.0000";
			break;
		case 5:
			formato = "#,#####0.00000";
			break;
		default:
			formato = "#0";
		}
		DecimalFormat formatoDecimal = new DecimalFormat(formato);
		formatoDecimal.setRoundingMode(RoundingMode.HALF_UP);
		return formatoDecimal.format(valor);
	}

	private void queryByDatGer(LocalDate datGer) {

		modeloTesteFluidos.setRowCount(0);
		//lotesDeComponente.clear();

		testeFluidos = new TesteFluidos();
		
		List<TesteFluidos> lista = testeFluidosServico.queryByDatGer(datGer, CODORI_50);

		for (TesteFluidos teste : lista) {
			
			this.testeFluidos.setCodEmp(teste.getCodEmp());
			this.testeFluidos.setId(teste.getId());
			this.testeFluidos.setCodOri(teste.getCodOri());
			this.testeFluidos.setNumOrp(teste.getNumOrp());			
			this.testeFluidos.setCodPro(teste.getCodPro());
			this.testeFluidos.setCodLot(teste.getCodLot());			
			this.testeFluidos.setCodCmp(teste.getCodCmp());
			this.testeFluidos.setLotCmp(teste.getLotCmp());			
			this.testeFluidos.setTextura(teste.getTextura());
			this.testeFluidos.setRefCor(teste.getRefCor());
			this.testeFluidos.setTipFor(teste.getTipFor());
			this.testeFluidos.setIngVol(teste.getIngVol());
			this.testeFluidos.setSitTes(teste.getSitTes());
			this.testeFluidos.setDatGer(teste.getDatGer());
			this.testeFluidos.setHorGer(teste.getHorGer());
			this.testeFluidos.setUsuGer(teste.getUsuGer());
			this.testeFluidos.setDatAlt(teste.getDatAlt());
			this.testeFluidos.setHorAlt(teste.getHorAlt());
			this.testeFluidos.setUsuAlt(teste.getUsuAlt());
			this.testeFluidos.setPesoG1(teste.getPesoG1());
			this.testeFluidos.setPesoG2(teste.getPesoG1());
			this.testeFluidos.setFluIde(teste.getFluIde());
			this.testeFluidos.setFluMin(teste.getFluIde());
			this.testeFluidos.setPerDif(teste.getPerDif());
			this.testeFluidos.setQtdMas(teste.getQtdMas());
			
			this.testeFluidos.setQtdIngVol(teste.getQtdIngVol());
			
			this.testeFluidos.setTolMin(teste.getTolMin());
			this.testeFluidos.setTolMax(teste.getTolMax());
			
			this.testeFluidos.setSitOrp(teste.getSitOrp());

			referenciaCor = referenciaCorServico.query(teste.getRefCor()); 
			formulaBase = formulaBaseServico.query(teste.getCodEmp(), teste.getTipFor());

			String desFor = formulaBase.getDesFor();

			modeloTesteFluidos.addRow(new Object[] { 
					teste.getDatGer().format(formatoData), // Data
					toHoraMinuto(teste.getHorGer()),
					teste.getCodOri(), // Origem
					teste.getNumOrp(), // Número OP					
					teste.getCodPro(), // Produto
					teste.getCodLot(), // Lote
					teste.getCodCmp(), // Componente
					teste.getLotCmp(), // Lote Componente
					desFor, // Tipo
					teste.getRefCor(), // Referencia Cor
					teste.getTextura(),
					doubleToString(teste.getPesoG1(), 4), // Peso G1
					doubleToString(teste.getPesoG2(), 4), // Peso Ge2
					doubleToString(teste.getFluIde(), 2), // Fluido Ideal
					doubleToString(teste.getFluMin(), 2), // Fluido Mina
					doubleToString(teste.getPerDif(), 2), // % Diferença
					doubleToString(teste.getQtdMas(), 0), // Qtde Massa
					doubleToString(teste.getQtdIngVol(), 0), // Qtde Ingrediente Volatil
					doubleToString(teste.getTolMin(), 2), // Tolerancia Min
					doubleToString(teste.getTolMax(), 2), // Tolerancia Max
					teste.getIngVol(), // Ingrediente Volatil					
					teste.getId(),     // Seq 
					teste.getSitOrp()  // Situação Ordem Prod.
			});  

			int lastRow = tabelaTesteFluidos.convertRowIndexToView(modeloTesteFluidos.getRowCount() - 1);
			tabelaTesteFluidos.setRowSelectionInterval(lastRow, lastRow);
			
			tabelaTesteFluidos.getColumn("% Diferença").setCellRenderer(new DefaultTableCellRenderer() {				
				
				private static final long serialVersionUID = 1L;

				@Override
				public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

					String strPerDif = (String) tabelaTesteFluidos.getValueAt(row, 15); // 15 = % Diferença
					String strTolMin = (String) tabelaTesteFluidos.getValueAt(row, 18); // 18 = % Tol. Min.
					String strTolMax = (String) tabelaTesteFluidos.getValueAt(row, 19); // 19 = % Tol. Max.
					
					Double perDif = Double.parseDouble(strPerDif.replace(",", "."));
					Double tolMin = Double.parseDouble(strTolMin.replace(",", "."));
					Double tolMax = Double.parseDouble(strTolMax.replace(",", "."));

					setText(doubleToString(perDif, 2));
					setHorizontalAlignment(JLabel.CENTER);
					
					if (perDif == 0.00) {
						setBackground(tabelaTesteFluidos.getBackground());
						setForeground(tabelaTesteFluidos.getForeground());
					} else {
						if ((perDif >= tolMin) && (perDif <= tolMax)) {
							setForeground(Color.BLUE);
							setBackground(Color.GREEN);
							//tfQtdeMassa.setEditable(false);
						} else {
							setForeground(Color.WHITE);
							setBackground(Color.RED);
							//tfQtdeMassa.setEditable(true);
						}
					}
					return this;
				}
			});
		}
		sincronizarLinhaAtual();
	}
	
	private void consisteEntradas() throws 
			ReferenciaCorNaoEncontradaException, 
			OrdemProducaoNaoInformadaException,
			OrdemProducaoNaoEncontradaException, 
			OrdemProducaoCanceladaException, 
			OrdemProducaoFinalizadaException,
			OrdemProducaoSuspensaException, 
			OrdemProducaoNaoIniciadaException, 
			OrdemProducaoNaoLiberadaException,
			ComponenteBulkNaoEncontradoException,
			LoteComponenteNaoInformadoException, 
			LoteComponenteNaoFazParteDaOPException {
		
		consisteOrdemProducao();
		
		consisteLotCmp();
	}

	private void consisteData() throws DataNaoInformadaException, DataInvalidaException, DataFuturaException {
		if (tfData.getText().trim().length() == 0) {
			String mensagem = "Data deve ser informada!";
			throw new DataNaoInformadaException(mensagem);
		} else {

			LocalDate data = LocalDate.now();
			LocalDate dataAtual = LocalDate.now();

			try {
				data = LocalDate.parse(tfData.getText(), formatoData);
			} catch (Exception e) {
				String mensagem = "Data inválida! " + tfData.getText();
				throw new DataInvalidaException(mensagem);
			}

			if (data.isAfter(dataAtual)) {
				String mensagem = "Data futura inválida!";
				throw new DataFuturaException(mensagem);
			}
		}
	}

	/*
	private void consisteOrigemProduto() throws OrigemProdutoNaoInformadaException, OrigemProdutoInvalidaException {
		if (tfCodOri.getText().trim().length() == 0) {
			String mensagem = "Origem deve ser informada!";
			throw new OrigemProdutoNaoInformadaException(mensagem);

		} else {
			origemProduto = new OrigemProduto();
			origemProduto = origemProdutoServico.query(SISTEMA.codEmp(), tfCodOri.getText().trim());

			if (origemProduto.getCodOri() == null) {
				String mensagem = "Origem " + tfCodOri.getText() + " não encontrada.";
				throw new OrigemProdutoInvalidaException(mensagem);
			} else {

				if (!origemProduto.getTipPro().equals('P')) {
					String mensagem = "Origem " + tfCodOri.getText() + " não é de produção";
					throw new OrigemProdutoInvalidaException(mensagem);
				}
			}
		}
	}
	*/

	protected void consisteOrdemProducao() throws 
					ReferenciaCorNaoEncontradaException, 
					OrdemProducaoNaoInformadaException,
					OrdemProducaoNaoEncontradaException, 
					OrdemProducaoCanceladaException, 
					OrdemProducaoFinalizadaException,
					OrdemProducaoSuspensaException, 
					OrdemProducaoNaoIniciadaException, 
					OrdemProducaoNaoLiberadaException,
					ComponenteBulkNaoEncontradoException {

		if (tfNumOrp.getText().trim().length() == 0) {
			tfNumOrp.setText("0");
			String mensagem = "Número da O.P. deve ser informado!";
			throw new OrdemProducaoNaoInformadaException(mensagem);
		} else {

			String codOri  = tfCodOri.getText().trim();
			Integer numOrp = Integer.parseInt(tfNumOrp.getText().trim());

			if (numOrp == 0) {
				String mensagem = "Número da O.P. deve ser informado!";
				throw new OrdemProducaoNaoInformadaException(mensagem);
			} else {

				this.ordemProducao = new OrdemProducao();
				this.ordemProducao = ordemProducaoServico.queryByNumOrp(SISTEMA.codEmp(), codOri, numOrp);

				if (this.ordemProducao.getNumOrp() == null) {
					String mensagem = "O.P. " + tfCodOri.getText() + " / " + tfNumOrp.getText() + " não encontrada.";
					throw new OrdemProducaoNaoEncontradaException(mensagem);
				} else {

					this.testeFluidos.setCodEmp(ordemProducao.getCodEmp());
					this.testeFluidos.setCodOri(ordemProducao.getCodOri());
					this.testeFluidos.setNumOrp(ordemProducao.getNumOrp());
					this.testeFluidos.setCodPro(ordemProducao.getCodPro());
					this.testeFluidos.setCodLot(ordemProducao.getRelPrd());
					/*
					this.testeFluidos.setCodCmp(" ");
					this.testeFluidos.setLotCmp(" ");
					*/
					
					List<Componente> lista = componenteServico.queryBulk(ordemProducao.getCodEmp(), ordemProducao.getCodOri(), ordemProducao.getNumOrp());					
					
					//cbLotCmp.removeAllItems();
					//lotesDeComponente.clear();
					
					if (lista.size() <= 0) {
						//lotesDeComponente.add(ordemProducao.getRelPrd());					
					} else {
						for(Componente cmp : lista) {
							this.testeFluidos.setCodCmp(cmp.getCodCmp());							
							//lotesDeComponente.add(cmp.getCodLot());
						}
					}
					
					if (lista.size() == 1) {
						Componente cmp = lista.get(0);
						this.testeFluidos.setLotCmp(cmp.getCodLot());
					}
					
					sincronizarTela();

					if (this.ordemProducao.getNumOrp() == 0) {
						String mensagem = "O.P. deve ser informada!";
						throw new OrdemProducaoNaoInformadaException(mensagem);
					}

					if (this.ordemProducao.getSitOrp().equals("C")) {
						String mensagem = "O.P. " + tfCodOri.getText() + " / " + tfNumOrp.getText() + " está Cancelada.";
						throw new OrdemProducaoCanceladaException(mensagem);
					}

					if (this.ordemProducao.getSitOrp().equals("F")) {
						String mensagem = "O.P. " +	tfCodOri.getText() + " / " + tfNumOrp.getText() + " está Finalizada."; 
						throw new OrdemProducaoFinalizadaException(mensagem); 
					}

					if (this.ordemProducao.getSitOrp().equals("E")) {
						String mensagem = "O.P. " + tfCodOri.getText() + " / " + tfNumOrp.getText() + " não está Liberada.";
						throw new OrdemProducaoNaoLiberadaException(mensagem);
					}

					if (this.ordemProducao.getSitOrp().equals("S")) {
						String mensagem = "O.P. " + tfCodOri.getText() + " / " + tfNumOrp.getText() + " está Suspensa.";
						throw new OrdemProducaoSuspensaException(mensagem);
					}

					if (this.ordemProducao.getSitOrp().equals("L")) {
						String mensagem = "O.P. " + tfCodOri.getText() + " / " + tfNumOrp.getText()
								+ " não foi iniciada.";
						throw new OrdemProducaoNaoIniciadaException(mensagem);
					}

					this.produto = produtoServico.query(testeFluidos.getCodEmp(), testeFluidos.getCodCmp());
					
					if (produto.getCodPro() == null) {
						String mensagem = "O.P. " + tfCodOri.getText() + " / " + tfNumOrp.getText()
						+ " não tem um Componente Bulk válido.";
						throw new ComponenteBulkNaoEncontradoException(mensagem);						
					} else {
						this.referenciaCor = referenciaCorServico.query(produto.getRefCor());	
					}
					
					

					if (referenciaCor.getRefCor() == null) {
						String mensagem = "Referência Cor não encontrada no cadastro do Produto " + produto.getCodPro();
						throw new ReferenciaCorNaoEncontradaException(mensagem);

					} else {
						this.testeFluidos.setRefCor(referenciaCor.getRefCor());
						this.testeFluidos.setTipFor(referenciaCor.getTipFor());
						this.testeFluidos.setFluIde(referenciaCor.getFluIde());
						this.testeFluidos.setTextura(referenciaCor.getDesRef());

						this.formulaBase = formulaBaseServico.query(SISTEMA.codEmp(), referenciaCor.getTipFor());
						
						/*
						this.testeFluidos.setTolMin(formulaBase.getTolMin());
						this.testeFluidos.setTolMax(formulaBase.getTolMax());
						
						if (this.testeFluidos.getCodOri().equals("50")) {
							this.testeFluidos.setTolMin(-10.0);
							this.testeFluidos.setTolMax(+10.0);
						}
						*/
						
						this.testeFluidos.setIngVol(formulaBase.getIngVol());
						
						sincronizarTela();
					}
				}
			}
		}
	}
	
	private void consisteLotCmp() throws 
					LoteComponenteNaoInformadoException, 
					LoteComponenteNaoFazParteDaOPException {
	
		if (tfLotCmp.getText().trim().length() == 0) {
			String mensagem = "Lote do Bulk deve ser informado!";
			throw new LoteComponenteNaoInformadoException(mensagem);
		} else {
			String aLotCmp = tfLotCmp.getText().trim().toUpperCase();
			
			tfLotCmp.setText(aLotCmp);
			
			Componente componente = new Componente();
			
			componente = componenteServico.queryByLote(testeFluidos.getCodEmp(), 
														testeFluidos.getCodOri(), 
														testeFluidos.getNumOrp(), 
														testeFluidos.getCodCmp(), 
														aLotCmp);
			if (componente == null) {
				String mensagem = "Lote do Bulk " + aLotCmp 
						+ " do componente " + tfCodCmp.getText()
						+ " não faz parte da O.P. " + tfCodOri.getText() + " / " + tfNumOrp.getText();
				throw new LoteComponenteNaoFazParteDaOPException(mensagem);
			} else {
				testeFluidos.setLotCmp(componente.getCodLot());
			}
		}
	}

	private void consistePesoG1() {
		if (tfPesoG1.getText().trim().length() == 0) {
			String mensagem = "Peso G1 deve ser informado!";
			JOptionPane.showMessageDialog(this, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
		}

		Double pesoG1 = Double.valueOf(tfPesoG1.getText().trim().replace(",", "."));
		this.testeFluidos.setPesoG1(pesoG1);

		calculo();
	}

	private void consistePesoG2() {
		if (tfPesoG2.getText().trim().length() == 0) {
			String mensagem = "Peso G2 deve ser informado!";
			JOptionPane.showMessageDialog(this, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
		}

		Double pesoG2 = Double.valueOf(tfPesoG2.getText().trim().replace(",", "."));
		this.testeFluidos.setPesoG2(pesoG2);

		this.calculo();
	}

	private void consisteQtdeMassa() {
		if (tfQtdeMassa.getText().trim().length() == 0) {
			String mensagem = "Quantidade de Massa deve ser informada!";
			JOptionPane.showMessageDialog(this, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
		}

		Double qtdeMassa = Double.valueOf(tfQtdeMassa.getText().trim().replace(",", "."));
		this.testeFluidos.setQtdMas(qtdeMassa);
		
		this.calculo();
	}

	private void defineModoTela(ModoTela modoTela) {
		this.modoTela = modoTela;
		if (this.modoTela == ModoTela.CONSULTA) {
			
			/*
			System.out.println("-----------------------------------------------------------------------------------------------------------");
			System.out.println(testeFluidos.toString());
			*/
			
			botaoAdicionar.setEnabled(true);

			if (testeFluidos.getId() > 0) {
				if (testeFluidos.getSitOrp().equals("A")) {
					botaoEditar.setEnabled(true);
					botaoExcluir.setEnabled(true);
				} else {
					botaoEditar.setEnabled(false);
					botaoExcluir.setEnabled(false);					
				}				
			} else {
				botaoEditar.setEnabled(false);
				botaoExcluir.setEnabled(false);
			}
			
			botaoGravar.setEnabled(false);
			botaoCancelar.setEnabled(false);
			botaoSair.setEnabled(true);
			botaoPrimeiro.setEnabled(true);
			botaoAnterior.setEnabled(true);
			botaoProximo.setEnabled(true);
			botaoUltimo.setEnabled(true);
			botaoPesquisar.setEnabled(true);

			this.setClosable(true);

			tfData.setEditable(true);
			tfCodOri.setEditable(false);
			tfNumOrp.setEditable(false);
			tfPesoG1.setEditable(false);
			tfPesoG2.setEditable(false);
			tfQtdeMassa.setEditable(false);
			tfLotCmp.setEditable(false);

			tabelaTesteFluidos.setEnabled(true);
			tabelaTesteFluidos.setRowSelectionAllowed(true);

			tfData.requestFocusInWindow();
			modoBotoes();
		}
		if (this.modoTela == ModoTela.ADICIONAR || this.modoTela == ModoTela.EDITAR) {
			
			botaoAdicionar.setEnabled(false);
			botaoEditar.setEnabled(false);
			botaoGravar.setEnabled(true);
			botaoExcluir.setEnabled(false);
			botaoCancelar.setEnabled(true);
			botaoSair.setEnabled(false);
			botaoPrimeiro.setEnabled(false);
			botaoAnterior.setEnabled(false);
			botaoProximo.setEnabled(false);
			botaoUltimo.setEnabled(false);
			botaoPesquisar.setEnabled(false);

			this.setClosable(false);

			tfData.setEditable(false);
			tfCodOri.setEditable(false);
			tfNumOrp.setEditable(true);
			tfPesoG1.setEditable(true);
			tfPesoG2.setEditable(true);
			tfQtdeMassa.setEditable(false);
			tfLotCmp.setEditable(true);

			tabelaTesteFluidos.setEnabled(false);
			tabelaTesteFluidos.setRowSelectionAllowed(false);

			tfNumOrp.requestFocusInWindow();

		}
		if (this.modoTela == ModoTela.ALTERADO) {
			botaoGravar.setEnabled(true);
		}
		
		if (this.modoTela == ModoTela.EDITAR) {
			
			tfNumOrp.setEditable(false);
			tfLotCmp.setEditable(false);
			
			if (testeFluidos.getPerDif() == 0.00) {
				//setBackground(tabelaTesteFluidos.getBackground());
				//setForeground(tabelaTesteFluidos.getForeground());
				tfQtdeMassa.setEditable(false);
			}
			if (testeFluidos.getPesoG1() > 0.0 && testeFluidos.getPesoG2() > 0.0) {
				if ((testeFluidos.getPerDif() >= testeFluidos.getTolMin()) && (testeFluidos.getPerDif() <= testeFluidos.getTolMax())) {
					//setForeground(Color.BLUE);
					//setBackground(Color.GREEN);
					tfQtdeMassa.setEditable(false);
				} else {
					//setForeground(Color.WHITE);
					//setBackground(Color.RED);
					tfQtdeMassa.setEditable(true);
				}
			} else {
				tfQtdeMassa.setEditable(false);
			}
		}
	}

	private void modoBotoes() {
		LocalDate data = LocalDate.parse(tfData.getText(), formatoData);
		
		if (primeiraData != null && !primeiraData.equals(ultimaData)) {
			if (data.isEqual(primeiraData)) {
				botaoPrimeiro.setEnabled(false);
				botaoAnterior.setEnabled(false);
			} else {
				botaoPrimeiro.setEnabled(true);
				botaoAnterior.setEnabled(true);
			}
			if (data.isEqual(ultimaData)) {
				botaoProximo.setEnabled(false);
				botaoUltimo.setEnabled(false);
			} else {
				botaoProximo.setEnabled(true);
				botaoUltimo.setEnabled(true);
			}
		} else {
			botaoPrimeiro.setEnabled(false);
			botaoAnterior.setEnabled(false);
			botaoProximo.setEnabled(false);
			botaoUltimo.setEnabled(false);
		}
	}

	private void adicionar() {
		this.testeFluidos = new TesteFluidos();

		this.testeFluidos.setCodEmp(SISTEMA.codEmp());
		this.testeFluidos.setCodOri(CODORI_50);
		this.testeFluidos.setDatGer(SISTEMA.datSis());
		this.testeFluidos.setHorGer(SISTEMA.horSis());
		this.testeFluidos.setUsuGer(SISTEMA.codUsu());
		this.testeFluidos.setUsuAlt(SISTEMA.codUsu());
		this.testeFluidos.setHorAlt(SISTEMA.horSis());
		this.testeFluidos.setNumCad(SISTEMA.numCad());
		this.testeFluidos.setUserSO(SISTEMA.usrNam());
		this.testeFluidos.setSitTes(1);
		
		this.testeFluidos.setTolMin(-10.0);
		this.testeFluidos.setTolMax(+10.0);

		//cbLotCmp.removeAll();
		//lotesDeComponente.clear();
		
		defineModoTela(ModoTela.ADICIONAR);
		sincronizarTela();
		tfNumOrp.requestFocusInWindow();
	}

	private void gravar() {
		testeFluidosServico.save(this.testeFluidos);
	
		testeFluidosServico.queryDatasComRegistros(CODORI_50);
		primeiraData = testeFluidosServico.first();
		ultimaData   = testeFluidosServico.last();

		
		queryByDatGer(ultimaData);
		
		defineModoTela(ModoTela.CONSULTA);
	}

	private void excluir() {

		Object[] options = { "Cancelar" , "Excluir" };
		String titulo   = "Exclusão de registro";
		String mensagem = "Quer mesmo excluir o registro?";
		
		int opcao = JOptionPane.showOptionDialog(this, mensagem, titulo, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE , null, options, options[0]);
		
		if (opcao == 1) { // 1 == SIM
			testeFluidosServico.delete(testeFluidos.getId());

			LocalDate data = testeFluidos.getDatGer();
			queryByDatGer(data);			
			defineModoTela(ModoTela.CONSULTA);
		}
	}

	private void cancelar() {
		//cbLotCmp.removeAllItems();
		//lotesDeComponente.clear();
		sincronizarLinhaAtual();
		defineModoTela(ModoTela.CONSULTA);
	}

	private void editar() {
		defineModoTela(ModoTela.EDITAR);
		this.testeFluidos.setSitTes(2);
		tfPesoG2.requestFocusInWindow();
	}

	private void sair() {

		testeFluidosServico.close();
		defineModoTela(ModoTela.CONSULTA);
		setVisible(false);
	}

	private void sincronizarTela() {
		
		produto = produtoServico.query(testeFluidos.getCodEmp(), testeFluidos.getCodPro());
		formulaBase = formulaBaseServico.query(testeFluidos.getCodEmp(), testeFluidos.getTipFor());

		tfData.setText(testeFluidos.getDatGer().format(formatoData));
		tfCodOri.setText(testeFluidos.getCodOri());
		tfNumOrp.setText(testeFluidos.getNumOrp().toString());
		
		tfCodPro.setText(testeFluidos.getCodPro());
		tfCodLot.setText(testeFluidos.getCodLot());
		
		tfCodCmp.setText(testeFluidos.getCodCmp());
	
		/*
		cbLotCmp.removeAllItems();
		for(String lote : lotesDeComponente) {
			cbLotCmp.addItem(lote);
		}
		*/
		tfLotCmp.setText(testeFluidos.getLotCmp());
		
		tfDesFor.setText(formulaBase.getDesFor());
		tfRefCor.setText(testeFluidos.getRefCor().toString());
		tfTextura.setText(testeFluidos.getTextura());

		tfFluIde.setText(doubleToString(testeFluidos.getFluIde(), 2));
		tfFluMin.setText(doubleToString(testeFluidos.getFluMin(), 2));
		tfPerDif.setText(doubleToString(testeFluidos.getPerDif(), 2));
		tfPesoG1.setText(doubleToString(testeFluidos.getPesoG1(), 4));
		tfPesoG2.setText(doubleToString(testeFluidos.getPesoG2(), 4));
		tfQtdeMassa.setText(doubleToString(testeFluidos.getQtdMas(), 0));
		//tfQtdIngVol.setText(doubleToString(testeFluidos.getQtdCic(), 0));
		tfQtdIngVol.setText(doubleToString(testeFluidos.getQtdIngVol(), 0));
		tfTolMin.setText(doubleToString(testeFluidos.getTolMin(), 2));
		tfTolMax.setText(doubleToString(testeFluidos.getTolMax(), 2));

		tfIngVol.setText(testeFluidos.getIngVol());
		tfSeqReg.setText(testeFluidos.getId().toString());

		if (testeFluidos.getPerDif() == 0.00) {
			tfPerDif.setForeground(tfFluIde.getForeground());
			tfPerDif.setBackground(tfFluIde.getBackground());
		} else {
			if ((testeFluidos.getPerDif() >= testeFluidos.getTolMin())
					&& (testeFluidos.getPerDif() <= testeFluidos.getTolMax())) {
				tfPerDif.setBackground(Color.GREEN);
				tfPerDif.setForeground(Color.BLUE);
				// tfPerDif.setFont(fonte);
			} else {
				tfPerDif.setBackground(Color.RED);
				tfPerDif.setForeground(Color.WHITE);
				// tfPerDif.setFont(fonte);
			}
		}
	}

	protected void sincronizarLinhaAtual() {
		
		if (tabelaTesteFluidos.getRowCount() > 0) {
			Integer id = (Integer) tabelaTesteFluidos.getValueAt(tabelaTesteFluidos.getSelectedRow(), 21); // 21 = ID (Seq.)
			testeFluidos = testeFluidosServico.queryById(id);

			/*
			lotesDeComponente.clear();
			lotesDeComponente.add(testeFluidos.getLotCmp());
			*/
		} else {
			testeFluidos = new TesteFluidos();
			LocalDate data = LocalDate.parse(tfData.getText(), formatoData);
			testeFluidos.setDatGer(data);
		}
		
		defineModoTela(ModoTela.CONSULTA);
		sincronizarTela();
	}

	private String toHoraMinuto(Integer numero) {
		Integer hora = numero / 60;
		Integer minuto = numero % 60;

		return hora.toString() + ":" + minuto.toString();
	}

	private void calculo() {
		
		testeFluidos.calculo();
		
		sincronizarTela();
		
		if (testeFluidos.getPerDif() == 0.00) {
			//setBackground(tabelaTesteFluidos.getBackground());
			//setForeground(tabelaTesteFluidos.getForeground());
			tfQtdeMassa.setEditable(false);
		} 
		if (testeFluidos.getPesoG1() > 0.0 && testeFluidos.getPesoG2() > 0.0) { 
			if ((testeFluidos.getPerDif() >= testeFluidos.getTolMin()) && (testeFluidos.getPerDif() <= testeFluidos.getTolMax())) {
				//setForeground(Color.BLUE);
				//setBackground(Color.GREEN);
				tfQtdeMassa.setEditable(false);
			} else {
				//setForeground(Color.WHITE);
				//setBackground(Color.RED);
				tfQtdeMassa.setEditable(true);
			}
		} else {
			tfQtdeMassa.setEditable(false);
		}
	}
}