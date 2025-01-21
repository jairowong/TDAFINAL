package GestionEstudiantes.MSEstudiantes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import GestionEstudiantes.MSEstudiantes.model.ApoderadoModel;
import GestionEstudiantes.MSEstudiantes.repository.IApoderadoRepository;

@Service
public class ApoderadoService implements IApoderadoService {

    @Autowired
    private IApoderadoRepository repository;

    @Override
    public List<ApoderadoModel> findAll() {
        return repository.findAll();
    }

    @Override
    public ApoderadoModel findById(Long id) {
        Optional<ApoderadoModel> apoderadoOpt = repository.findById(id);
        return apoderadoOpt.orElse(null);
    }

    @Override
    public ApoderadoModel add(ApoderadoModel model) {
        return repository.save(model);
    }

    @Override
    public ApoderadoModel update(Long id, ApoderadoModel model) {
        Optional<ApoderadoModel> optionalApoderado = repository.findById(id);
        if (optionalApoderado.isPresent()) {
            ApoderadoModel apoderado = optionalApoderado.get();
            // Actualiza los campos necesarios
            apoderado.setDni(model.getDni());
            apoderado.setNombre(model.getNombre());
            apoderado.setApellido(model.getApellido());
            apoderado.setEdad(model.getEdad());
            apoderado.setSexo(model.getSexo());
            apoderado.setGrado_instruccion(model.getGrado_instruccion());
            apoderado.setEstado_civil(model.getEstado_civil());
            apoderado.setTelefono(model.getTelefono());
            apoderado.setDireccion(model.getDireccion());
            // Actualiza otros campos según tu modelo

            return repository.save(apoderado);
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
