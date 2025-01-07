package GestionMatricula.MSMatricula.repositorio;

import org.springframework.data.repository.CrudRepository;

import GestionMatricula.MSMatricula.model.Matricula;

public interface MatriculaRepository extends CrudRepository<Matricula, Integer> {
    
}
