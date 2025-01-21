package GestionEstudiantes.MSEstudiantes.service;

import java.util.List;
import GestionEstudiantes.MSEstudiantes.model.ApoderadoModel;

public interface IApoderadoService {
    List<ApoderadoModel> findAll();
    ApoderadoModel findById(Long id);
    ApoderadoModel add(ApoderadoModel model);
    ApoderadoModel update(Long id, ApoderadoModel model);
    Boolean delete(Long id);
}