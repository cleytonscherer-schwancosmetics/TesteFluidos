package com.schwancosmetics.c4.sapiens.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

import javax.swing.JOptionPane;

public class Conexao {
	private static Conexao instance = null;
	
	private Connection conexao = null;	
	private int clients = 0;	
	private String driver = null;
	private String url    = null;
	private String user   = null;
	private String passwd = null;

	private Conexao() {
		try {			
			
			Properties prop = new Properties();
			prop.load(new FileInputStream("\\\\sch-wap-srv01\\Senior_prod\\Sapiens\\SapiensJava\\sapiens.properties"));
			//prop.load(new FileInputStream("sapiens.properties"));

			driver = prop.getProperty("jdbc.driver");
			url    = prop.getProperty("jdbc.url");
			user   = prop.getProperty("jdbc.username");
			passwd = prop.getProperty("jdbc.password");
			
			Class.forName(driver);
			conexao = DriverManager.getConnection(url,user,passwd);
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static Conexao getInstance() {
		if (instance == null) {
			instance = new Conexao();
		}
		return instance;
	}

	public Connection getConnection() {
		if (conexao == null) {
			String mensagem = "Sem conexão";
			JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);			
			throw new RuntimeException("conexão inexistente");
		}
		clients++;
		return conexao;
	}

	public void shutdown() {
		clients--;
		if (clients > 0) {
			return;
		}
		try {
			conexao.close();
			
			instance = null;
			conexao  = null;  
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
}
