package GestionEstudiantes.MSEstudiantes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import GestionEstudiantes.MSEstudiantes.model.DocumentacionModel;

@Repository
public interface IDocumentacionRepository extends JpaRepository<DocumentacionModel, Long> {
    // Métodos personalizados si los hay
}
