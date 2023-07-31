package br.com.autorizador.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.autorizador.domain.Procedimentos;
import br.com.autorizador.domain.SolicitacaoProcedimento;
import br.com.autorizador.services.ProcedimentosServices;
import br.com.autorizador.services.SolicitacaoProcedimentoServices;

/**
 * Servlet implementation class AuthorizerController
 */
@WebServlet("/api/authorizer")
public class AuthorizerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ProcedimentosServices procedimentosServices;
	private SolicitacaoProcedimentoServices solicitacaoProcedimentoServices;
       
    public AuthorizerController() {
        super();
        procedimentosServices = new ProcedimentosServices();
        solicitacaoProcedimentoServices = new SolicitacaoProcedimentoServices();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("method");
		
		switch (action) {
		case "procedimentos":
			getProcedimentos(request, response);
			break;
		case "solicitacoes":
			getSolicitacoes(request, response);
			break;
		default:
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new Gson();
		BufferedReader reader = request.getReader();
		
		SolicitacaoProcedimento solicitacaoProcedimento = gson.fromJson(reader, SolicitacaoProcedimento.class);
		
		try {
			solicitacaoProcedimentoServices.saveSolicitacao(solicitacaoProcedimento);
		} catch (Exception e) {
			response.setStatus(400);
			e.printStackTrace();
		}
		
		response.setStatus(201);
	}
	
	public void getProcedimentos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Procedimentos> procedimentos = procedimentosServices.getListProcedimentos();
		Gson gson = new Gson();
		
		String json = gson.toJson(procedimentos);     
		
        response.getWriter().print(json);
	}
	
	public void getSolicitacoes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<SolicitacaoProcedimento> procedimentos = solicitacaoProcedimentoServices.getSolicitacoes();
		Gson gson = new Gson();
		
		String json = gson.toJson(procedimentos);     
		
        response.getWriter().print(json);
	}

}
