package GestionEstudiantes.MSEstudiantes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import GestionEstudiantes.MSEstudiantes.model.EstudianteModel;
import GestionEstudiantes.MSEstudiantes.repository.IEstudianteRepository;


 @Service
 public class EstudianteService implements IEstudianteService {


    @Autowired
    IEstudianteRepository repository;

    @Override
    public List<EstudianteModel> findAll() {
        return (List<EstudianteModel>)repository.findAll();
    }

    @Override
    public EstudianteModel findById(Integer id) {
        return (EstudianteModel)repository.findById(id).get();
    }

    @Override
    public EstudianteModel add(EstudianteModel model) {
        return repository.save(model);
    }

    @Override
    public EstudianteModel update(EstudianteModel model) {
        return repository.save(model);
    }

    @Override
    public Boolean delete(Integer id) {
        repository.deleteById(id);
        return true;
    }
    
}   

    

