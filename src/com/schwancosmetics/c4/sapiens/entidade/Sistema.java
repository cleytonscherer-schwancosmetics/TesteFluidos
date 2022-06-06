package com.schwancosmetics.c4.sapiens.entidade;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.schwancosmetics.c4.sapiens.servico.EmpresaServico;
import com.schwancosmetics.c4.sapiens.servico.FilialServico;
import com.schwancosmetics.c4.sapiens.servico.UsuarioServico;

public class Sistema {
	
	private Integer 		codEmp;
	
	private Integer			codFil;
	
	private LocalDate		datSis;
	
	private Integer 		horSis;
	
	private Integer			codUsu;
	
	private	Integer			numCad;
	
	private	String			usrNam;
	
	private Empresa			empresa;
	private EmpresaServico 	empresaServico;
	
	private Filial			filial;
	private FilialServico	filialServico;
	
	private	Usuario			usuario;
	private	UsuarioServico	usuarioServico;
	
	DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");
	
	private static	Sistema	sistema;	

	private Sistema() {
		
		usrNam = System.getProperty("user.name").toUpperCase();
		System.out.println("UsrNam: " + usrNam);
		
		usuario = new Usuario();
		usuarioServico = new UsuarioServico();
		usuario = usuarioServico.query(usrNam);
		this.codUsu = usuario.getCodUsu();
		
		empresa = new Empresa();
		empresaServico = new EmpresaServico();		
		empresa = empresaServico.query(usuario.getCodEmp());		
		this.codEmp = empresa.getCodEmp();	
		
		filial = new Filial();
		filialServico = new FilialServico();
		filial = filialServico.query(usuario.getCodEmp(), usuario.getCodFil());
		this.codEmp = filial.getCodFil();
		
		this.numCad = usuario.getNumCad();
		
		/*
		horSis = 0;
		
		LocalTime lt = LocalTime.now();
		String strlt = lt.format(timeFormat);
		String strHora   = strlt.substring(0, 2);
		String strMinuto = strlt.substring(3, 5);		
		
		horSis = (60 * Integer.parseInt(strHora)) + Integer.parseInt(strMinuto);
		*/
	}
	
	public static Sistema getInstance() {
		if (sistema == null) {
			sistema = new Sistema();
		}
		return sistema;
	}

	public Integer codEmp() {
		return codEmp;
	}

	public Integer codFil() {
		return codFil;
	}
	
	public LocalDate datSis() {
		return LocalDate.now();
	}

	public Integer horSis() {
		horSis = 0;
		
		LocalTime lt = LocalTime.now();
		String strlt = lt.format(timeFormat);
		String strHora   = strlt.substring(0, 2);
		String strMinuto = strlt.substring(3, 5);		
		
		horSis = (60 * Integer.parseInt(strHora)) + Integer.parseInt(strMinuto);
		
		return horSis;
	}

	public Integer codUsu() {
		return codUsu;
	}

	public Integer numCad() {
		return numCad;
	}
	
	public String usrNam() {
		return usrNam;
	}

	@Override
	public String toString() {
		return "Sistema [codEmp=" + codEmp + ", datSis=" + datSis + ", horSis=" + horSis + ", codUsu=" + codUsu
				+ ", numCad=" + numCad + "]";
	}
	
	
	

}
