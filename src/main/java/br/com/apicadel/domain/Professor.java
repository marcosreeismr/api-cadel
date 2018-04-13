package br.com.apicadel.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import br.com.apicadel.domain.enums.Sexo;

@Entity
public class Professor extends Pessoa {
	private static final long serialVersionUID = 1L;

	@ManyToMany
	@JoinTable(name = "professor_disciplina", joinColumns = @JoinColumn(name = "professor_id"), inverseJoinColumns = @JoinColumn(name = "disciplina_id"))
	private List<Disciplina> disciplinas = new ArrayList<>();

	@OneToMany(mappedBy = "professor")
	private List<Aula> aulas = new ArrayList<>();

	@Column(columnDefinition = "int default 10")
	private Integer notificacaoEmail;

	@ManyToMany
	@JoinTable(name = "professor_turma", joinColumns = @JoinColumn(name = "professor_id"), inverseJoinColumns = @JoinColumn(name = "turma_id"))
	private List<Turma> turmas = new ArrayList<>();

	public Professor() {
	}

	public Professor(Long id, String nome, String cpf, String matricula, String email, Sexo sexo, boolean ativo,
			Integer notificacaoEmail) {
		super(id, nome, cpf, matricula, email, sexo);
		this.notificacaoEmail = notificacaoEmail;
	}

	public Integer getNotificacaoEmail() {
		return notificacaoEmail;
	}

	public void setNotificacaoEmail(Integer notificacaoEmail) {
		this.notificacaoEmail = notificacaoEmail;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public List<Aula> getAulas() {
		return aulas;
	}

}
