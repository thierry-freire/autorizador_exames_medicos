package br.com.autorizador.services;

import java.util.List;

import br.com.autorizador.domain.SolicitacaoProcedimento;
import br.com.autorizador.repository.SolicitacaoProcedimentoDao;

public class SolicitacaoProcedimentoServices {
	private SolicitacaoProcedimentoDao solicitacaoProcedimentoDao;

	public SolicitacaoProcedimentoServices() {
		solicitacaoProcedimentoDao = new SolicitacaoProcedimentoDao();
	}

	public List<SolicitacaoProcedimento> getSolicitacoes() {
		return solicitacaoProcedimentoDao.getSolicitacoes();
	}

	public void saveSolicitacao(SolicitacaoProcedimento solicitacaoProcedimento) throws Exception {
		switch (solicitacaoProcedimento.getProcedimentos().getIdProcedimento().intValue()) {
		case 1234:
			if (solicitacaoProcedimento.getIdade() >= 20 && solicitacaoProcedimento.getSexo().equals("M")) {
				solicitacaoProcedimento.setPermitido("S");
			} else {
				solicitacaoProcedimento.setPermitido("N");
			}
			break;
		case 4567:
			if ((solicitacaoProcedimento.getIdade() >= 20 && solicitacaoProcedimento.getSexo().equals("M"))
					|| (solicitacaoProcedimento.getIdade() >= 30 && solicitacaoProcedimento.getSexo().equals("F"))) {
				solicitacaoProcedimento.setPermitido("S");
			} else {
				solicitacaoProcedimento.setPermitido("N");
			}
			break;
		case 6789:
			if (solicitacaoProcedimento.getIdade() >= 10 && solicitacaoProcedimento.getSexo().equals("M")) {
				solicitacaoProcedimento.setPermitido("S");
			} else {
				solicitacaoProcedimento.setPermitido("N");
			}
			break;
		default:
			throw new Exception("Procedimento não existe");
		}

		solicitacaoProcedimentoDao.saveSolicitacao(solicitacaoProcedimento);
	}
}
