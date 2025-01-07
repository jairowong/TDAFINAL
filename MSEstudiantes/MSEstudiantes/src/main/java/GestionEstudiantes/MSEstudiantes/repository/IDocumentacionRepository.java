package GestionEstudiantes.MSEstudiantes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import GestionEstudiantes.MSEstudiantes.model.DocumentacionModel;

@Repository
public interface IDocumentacionRepository
        extends CrudRepository<DocumentacionModel, Integer> {

}
