package GestionPago.MSPago.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import GestionPago.MSPago.model.PagoModel;


@Repository
public interface IPagoRepository extends CrudRepository<PagoModel, Integer> {
}
