package GestionUsuario.MSUsuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import GestionUsuario.MSUsuario.model.AccessModel;

@Repository
public interface AuthRepository extends JpaRepository<AccessModel, Long> {
    AccessModel findByUsername(String username);
}
