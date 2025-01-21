package GestionEstudiantes.MSEstudiantes.service;

import java.util.List;
import GestionEstudiantes.MSEstudiantes.model.DocumentacionModel;

public interface IDocumentacionService {
    List<DocumentacionModel> findAll();
    DocumentacionModel findById(Long id);
    DocumentacionModel add(DocumentacionModel model);
    DocumentacionModel update(Long id, DocumentacionModel model);
    Boolean delete(Long id);
}
