package GestionEstudiantes.MSEstudiantes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import GestionEstudiantes.MSEstudiantes.model.EstudianteModel;
import GestionEstudiantes.MSEstudiantes.repository.IEstudianteRepository;

@Service
public class EstudianteService implements IEstudianteService {

    @Autowired
    private IEstudianteRepository repository;

    @Override
    public List<EstudianteModel> findAll() {
        return repository.findAll();
    }

    @Override
    public EstudianteModel findById(Long id) {
        Optional<EstudianteModel> estudianteOpt = repository.findById(id);
        return estudianteOpt.orElse(null);
    }

    @Override
    public EstudianteModel add(EstudianteModel model) {
        return repository.save(model);
    }

    @Override
    public EstudianteModel update(Long id, EstudianteModel model) {
        Optional<EstudianteModel> optionalEstudiante = repository.findById(id);
        if (optionalEstudiante.isPresent()) {
            EstudianteModel estudiante = optionalEstudiante.get();
            // Actualiza los campos necesarios
            estudiante.setDni(model.getDni());
            estudiante.setNombre(model.getNombre());
            estudiante.setApe_paterno(model.getApe_paterno());
            estudiante.setApe_materno(model.getApe_materno());
            estudiante.setEdad(model.getEdad());
            estudiante.setSexo(model.getSexo());
            // Si tienes otros campos, actualízalos aquí

            return repository.save(estudiante);
        } else {
            return null; // O maneja el caso de no encontrado según tu lógica
        }
    }

    @Override
    public Boolean delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
