package GestionPago.MSPago.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.edu.pe.model.PagoModel;

public interface IPagoRepository extends CrudRepository<PagoModel, Integer> {
}
