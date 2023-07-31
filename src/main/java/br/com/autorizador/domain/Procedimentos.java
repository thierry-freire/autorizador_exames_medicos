package br.com.autorizador.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "procedimentos")
public class Procedimentos implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_PROCEDIMENTO")
	private Long idProcedimento;
	
	@Column(name = "NOME_PROCEDIMENTO")
	private String nomeProcedimento;

	public Long getIdProcedimento() {
		return idProcedimento;
	}

	public void setIdProcedimento(Long idProcedimento) {
		this.idProcedimento = idProcedimento;
	}

	public String getNomeProcedimento() {
		return nomeProcedimento;
	}

	public void setNomeProcedimento(String nomeProcedimento) {
		this.nomeProcedimento = nomeProcedimento;
	}

}
