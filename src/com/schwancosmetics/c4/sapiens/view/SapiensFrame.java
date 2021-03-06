package com.schwancosmetics.c4.sapiens.view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class SapiensFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private static String 	versao = "1.1.2";
	
	private JDesktopPane 	desktop;
	private JMenuBar     	menuBar;
	private JMenu        	menuSapiens, menuSair;
	private JMenuItem 		menuItemSair;
	private JMenuItem 		menuItemTesteFluidosOrigem45;
	private JMenuItem 		menuItemTesteFluidosOrigem50;

	private JInternalFrame frameInterno;
	
	public SapiensFrame() {
		super();
		setTitle("Schwan Cosmetics C4 - Teste de Fluidos - " + versao);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				// Conexao.getInstance().shutdown();
			}
		});		

		desktop = new JDesktopPane();
		setContentPane(desktop);
		
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0,0,tela.width, tela.height);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		
		//ImageIcon icone = new ImageIcon("\\\\sch-wap-srv01\\Senior_prod\\Sapiens\\Imagens\\Logos_2021\\Fundo_Branco\\Logo - Icone_Black.jpg");
		ImageIcon icone = new ImageIcon("\\\\sch-wap-srv01\\Senior_prod\\Sapiens\\Imagens\\icones\\3335660.png");
		setIconImage(icone.getImage());		

		inicializaTela();
	}
	
	private void inicializaTela() {
	
		menuBar = new JMenuBar();

		menuSapiens = new JMenu("Cadastro");
		menuBar.add(menuSapiens);

		/* Origem 45 */
		menuItemTesteFluidosOrigem45 = new JMenuItem("Teste Fluidos Origem 45");
		menuItemTesteFluidosOrigem45.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {          
				frameInterno = TesteFluidosOrigem45Frame.getInstance(); 
				
				if (frameInterno.getParent() != desktop) {
					desktop.add(frameInterno);
				}
				frameInterno.setVisible(true);
				try {
					frameInterno.setSelected(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e, "Erro", JOptionPane.ERROR_MESSAGE);               
				}            
			}
		});
		menuSapiens.add(menuItemTesteFluidosOrigem45);		
		
		/* Origem 50 */
		menuItemTesteFluidosOrigem50 = new JMenuItem("Teste Fluidos Origem 50");
		menuItemTesteFluidosOrigem50.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {          
				frameInterno = TesteFluidosOrigem50Frame.getInstance(); 
				
				if (frameInterno.getParent() != desktop) {
					desktop.add(frameInterno);
				}
				frameInterno.setVisible(true);
				try {
					frameInterno.setSelected(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e, "Erro", JOptionPane.ERROR_MESSAGE);               
				}            
			}
		});
		menuSapiens.add(menuItemTesteFluidosOrigem50);			

		menuSair = new JMenu("Sair");
		menuBar.add(menuSair);

		menuItemSair = new JMenuItem("Sair");
		menuItemSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				System.exit(0);
			}
		});
		menuSair.add(menuItemSair);

		setJMenuBar(menuBar);   
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				SapiensFrame sapiensFrame = new SapiensFrame();
				sapiensFrame.setVisible(true);
			}
		});
	}	
}


/***************************************************************************************************************\
 * v1.0.1 - Adicionado grava????o do lote do componente LotCmp na tabela de Teste de Fluido
 *          Adicionado grava????o do Usu??rio do S.O. (userSO na tabela Teste de Fluido)
 *          Corrigido a atualiza????o da hora do registro do sistema
 *         
 * v1.1.0 - Criado uma tela de cadastro por origem (45, 50)     
 *          Ao alterar um registro, o campo n??mero O.P. ficar?? desabilitado
 *
 * v1.1.1 - Corre????o da Toler??ncia M??nima = -10 e M??xima = +10 quando a OP for de origem 50.
 *          Os bot??es Editar e Excluir somente ficar??o ativos quando a OP estiver com situa????o Ativa.
 *         
 * v1.1.2 - A fun????o calculo() agora tamb??m ?? chamada ao sair do TextField de Qtde. Massa
 *          Adicionada uma Exception para quando a OP n??o tem um Bulk valido (0601006 ou 07007004)
 *          
\***************************************************************************************************************/
