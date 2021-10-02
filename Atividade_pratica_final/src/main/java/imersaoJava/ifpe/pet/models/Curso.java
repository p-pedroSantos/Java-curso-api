package imersaoJava.ifpe.pet.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Curso {
	
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	private int numeroMaximoAluno;
	private int numeroAlunosMatriculados;
	private LocalDate dataInicioCurso;
	private LocalDate dataEncerramentoCurso;
	private String resumo;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getNumeroMaximoAluno() {
		return numeroMaximoAluno;
	}
	public void setNumeroMaximoAluno(int numeroMaximoAluno) {
		this.numeroMaximoAluno = numeroMaximoAluno;
	}
	public int getNumeroAlunosMatriculados() {
		return numeroAlunosMatriculados;
	}
	public void setNumeroAlunosMatriculados(int numeroAlunosMatriculados) {
		this.numeroAlunosMatriculados = numeroAlunosMatriculados;
	}
	public LocalDate getDataInicioCurso() {
		return dataInicioCurso;
	}
	public void setDataInicioCurso(LocalDate dataInicioCurso) {
		this.dataInicioCurso = dataInicioCurso;
	}
	public LocalDate getDataEncerramentoCurso() {
		return dataEncerramentoCurso;
	}
	public void setDataEncerramentoCurso(LocalDate dataEncerramentoCurso) {
		this.dataEncerramentoCurso = dataEncerramentoCurso;
	}
	public String getResumo() {
		return resumo;
	}
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	
	
}
