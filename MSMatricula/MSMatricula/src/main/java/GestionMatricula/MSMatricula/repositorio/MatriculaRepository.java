package GestionMatricula.MSMatricula.repositorio;

import org.springframework.data.repository.CrudRepository;

import GestionMatricula.MSMatricula.model.ModelMatricula;

public interface MatriculaRepository extends CrudRepository<ModelMatricula, Integer> {
    
}
