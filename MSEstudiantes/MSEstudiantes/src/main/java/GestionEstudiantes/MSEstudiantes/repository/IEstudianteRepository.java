package GestionEstudiantes.MSEstudiantes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import GestionEstudiantes.MSEstudiantes.model.EstudianteModel;

@Repository
public interface IEstudianteRepository
        extends CrudRepository<EstudianteModel, Integer> {

}
