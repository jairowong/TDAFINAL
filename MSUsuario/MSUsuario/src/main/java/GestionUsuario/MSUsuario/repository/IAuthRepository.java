package GestionUsuario.MSUsuario.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
 
import POLYGLOT.MS.TEST.Security.model.AccessModel;
 
@Repository
public interface IAuthRepository extends MongoRepository<AccessModel, String> {
   
}
