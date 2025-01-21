package GestionEstudiantes.MSEstudiantes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import GestionEstudiantes.MSEstudiantes.model.ApoderadoModel;

@Repository
public interface IApoderadoRepository extends JpaRepository<ApoderadoModel, Long> {
    // Métodos personalizados si los hay
}
