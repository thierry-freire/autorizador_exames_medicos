package br.com.autorizador.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "solicitacao_procedimento")
public class SolicitacaoProcedimento implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_sol_proc")
	private Long idSolProc;
	
	@Column(name = "idade")
	private int idade;
	
	@Column(name = "sexo")
	private String sexo;
	
	@Column(name = "permitido")
	private String permitido;
	
	@ManyToOne
	@JoinColumn(name = "id_procedimento", referencedColumnName = "id_procedimento")
	private Procedimentos procedimento;

	public Long getIdSolProc() {
		return idSolProc;
	}

	public void setIdSolProc(Long idSolProc) {
		this.idSolProc = idSolProc;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getPermitido() {
		return permitido;
	}

	public void setPermitido(String permitido) {
		this.permitido = permitido;
	}

	public Procedimentos getProcedimentos() {
		return procedimento;
	}

	public void setProcedimentos(Procedimentos procedimento) {
		this.procedimento = procedimento;
	}
	
}
