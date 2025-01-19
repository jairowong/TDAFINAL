package GestionMatricula.MSMatricula.repositorio;

import org.springframework.data.repository.CrudRepository;

import GestionMatricula.MSMatricula.model.ModelDetalleMatricula;

public interface DetalleMatriculaRepository extends CrudRepository<ModelDetalleMatricula,Integer>  {
    
}
