package com.schwancosmetics.c4.sapiens.servico;

import java.time.LocalDate;
import java.util.List;

import com.schwancosmetics.c4.sapiens.dao.TesteFluidosDAO;
import com.schwancosmetics.c4.sapiens.entidade.Sistema;
import com.schwancosmetics.c4.sapiens.entidade.TesteFluidos;

public class TesteFluidosServico {
	
	private static Sistema SISTEMA;
	
	private TesteFluidosDAO testeFluidosDAO;
	
	public TesteFluidosServico() {
		testeFluidosDAO = new TesteFluidosDAO(); 
		SISTEMA = Sistema.getInstance();
	}
	
	public List<TesteFluidos> queryByDatGer(LocalDate data) {
		return testeFluidosDAO.queryByDatGer(data);
	}
	
	public TesteFluidos queryById(Integer id) {
		return testeFluidosDAO.queryById(id);
	}
	
	public void save(TesteFluidos testeFluidos) {		
		testeFluidos.setDatAlt(SISTEMA.datSis());
		testeFluidos.setHorAlt(SISTEMA.horSis());
		testeFluidos.setUsuAlt(SISTEMA.codUsu());
		testeFluidos.calculo();
		
		testeFluidosDAO.save(testeFluidos);
	}
	
	public void delete(Integer id) {
		testeFluidosDAO.delete(id);
	}

	public void queryDatasComRegistros() {
		testeFluidosDAO.queryDatasComRegistros();
	}
	
	public LocalDate first() {
		return testeFluidosDAO.first();
	}
	
	public LocalDate last() {
		return testeFluidosDAO.last();
	}
	
	public LocalDate previous() {
		return testeFluidosDAO.previous();
	}
	
	public LocalDate next() {
		return testeFluidosDAO.next();
	}
	
	public void close() {
		testeFluidosDAO.close();
	}
}
 