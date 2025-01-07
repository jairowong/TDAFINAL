package GestionEstudiantes.MSEstudiantes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import GestionEstudiantes.MSEstudiantes.model.ApoderadoModel;

@Repository
public interface IApoderadoRepository
        extends CrudRepository<ApoderadoModel, Integer> {

}
