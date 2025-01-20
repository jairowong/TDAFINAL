package GestionPago.MSPago.repository;



import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import GestionPago.MSPago.model.PagoModel;


@Repository
public interface IPagoRepository extends MongoRepository<PagoModel, Integer> {
}
