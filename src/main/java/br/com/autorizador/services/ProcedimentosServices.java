package br.com.autorizador.services;

import java.util.List;

import br.com.autorizador.domain.Procedimentos;
import br.com.autorizador.repository.ProcedimentosDAO;

public class ProcedimentosServices {
	private ProcedimentosDAO procedimentosDAO;
	
	public ProcedimentosServices() {
		procedimentosDAO = new ProcedimentosDAO();
	}
	
	public List<Procedimentos> getListProcedimentos() {
		return procedimentosDAO.getProcedimentos();
	}

}
