package GestionEstudiantes.MSEstudiantes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import GestionEstudiantes.MSEstudiantes.model.EstudianteModel;

public interface IEstudianteRepository extends JpaRepository<EstudianteModel, Long> {
    // Métodos personalizados si los hay
}