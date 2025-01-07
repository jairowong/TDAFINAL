package GestionEstudiantes.MSEstudiantes.service;

import java.util.List;

import GestionEstudiantes.MSEstudiantes.model.DocumentacionModel;

public interface IDocumentacionService {
    

    public List<DocumentacionModel> findAll();

    public DocumentacionModel findById(Integer id);

    public DocumentacionModel add(DocumentacionModel model);

    public DocumentacionModel update(DocumentacionModel model);

    public Boolean delete(Integer id);
}