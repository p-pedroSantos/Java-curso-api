package imersaoJava.ifpe.pet.controlles;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import imersaoJava.ifpe.pet.models.Curso;
import imersaoJava.ifpe.pet.repositorys.CursoDAO;




@RestController
public class CursoController {
	
	private List<Curso> ListCurso = new ArrayList<Curso>();
	@Autowired
	private CursoDAO cursoDAO;
	
	@GetMapping("/")
	public String teste(){
		Curso curso = new Curso();
		curso.setNome("Curso de Imersão");
		curso.setNumeroAlunosMatriculados(40);
		curso.setNumeroMaximoAluno(50);
		curso.setDataInicioCurso(LocalDate.of(2021, 9, 29));
		curso.setDataEncerramentoCurso(LocalDate.of(2021, 12, 29));
		curso.setResumo("no curso vai ser ensinado .....");
		
		
		if (curso.getNumeroAlunosMatriculados()> curso.getNumeroMaximoAluno()) {
			System.out.println("o numero de alunos e maior que : "+ curso.getNumeroMaximoAluno());			
			return "**ERRO! o numero de alunos e maior que que o permitido";
		}
		if (curso.getDataEncerramentoCurso().isBefore(curso.getDataInicioCurso())) {
			return "ERRO! a data ta errada";
		}
			this.ListCurso.add(curso);
			this.cursoDAO.save(curso);
			return "foi salvo";		
	}	
	
		@GetMapping("/curso")
		public List<Curso> showcursos() {
			return cursoDAO.findAll();
		}
		@GetMapping("/curso/{id}")
		public Curso buscaPorID(@PathVariable Integer id){
			Optional<Curso> optional = cursoDAO.findById(id);
			if(optional.isEmpty())
				return null;
			return optional.get();
		}
		
		@PostMapping("/curso")
		public String salvar(@RequestBody Curso curso) {
			if (curso.getNumeroAlunosMatriculados()> curso.getNumeroMaximoAluno()) {
				System.out.println("o numero de alunos e maior que : "+ curso.getNumeroMaximoAluno());			
				return "**ERRO! o numero de alunos e maior que que o permitido";
			}
			if (curso.getDataEncerramentoCurso().isBefore(curso.getDataInicioCurso())) {
				return "ERRO! a data ta errada";
			}
			
			this.cursoDAO.save(curso);
			return "salvo";
		}
		
		@PutMapping("/curso/{id}")
		public String atualizar(@RequestBody Curso curso) {
			if(curso.getId()==null) {
				return "informe o id";
			}
			this.cursoDAO.save(curso);
			return "curso atualizado";
			
		}
		
		@DeleteMapping("/curso/{id}")
		public String delet(@PathVariable Integer id) {
			this.cursoDAO.deleteById(id);
			return "apagado";
		}

			
	
		
	
	
}
