package GestionEstudiantes.MSEstudiantes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import GestionEstudiantes.MSEstudiantes.model.DocumentacionModel;
import GestionEstudiantes.MSEstudiantes.repository.IDocumentacionRepository;

@Service
public class DocumentacionService implements IDocumentacionService {

    @Autowired
    private IDocumentacionRepository repository;

    @Override
    public List<DocumentacionModel> findAll() {
        return repository.findAll();
    }

    @Override
    public DocumentacionModel findById(Long id) {
        Optional<DocumentacionModel> documentacionOpt = repository.findById(id);
        return documentacionOpt.orElse(null);
    }

    @Override
    public DocumentacionModel add(DocumentacionModel model) {
        return repository.save(model);
    }

    @Override
    public DocumentacionModel update(Long id, DocumentacionModel model) {
        Optional<DocumentacionModel> optionalDocumentacion = repository.findById(id);
        if (optionalDocumentacion.isPresent()) {
            DocumentacionModel existingDocumentacion = optionalDocumentacion.get();
            // Actualiza los campos necesarios
            existingDocumentacion.setCertificado(model.getCertificado());
            existingDocumentacion.setDni(model.getDni());
            // Si tu modelo tuviera más campos, actualízalos aquí

            return repository.save(existingDocumentacion);
        } else {
            return null; // O lanza una excepción personalizada si prefieres
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
