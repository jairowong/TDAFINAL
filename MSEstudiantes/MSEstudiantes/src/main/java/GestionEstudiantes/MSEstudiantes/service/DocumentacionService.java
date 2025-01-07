package GestionEstudiantes.MSEstudiantes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import GestionEstudiantes.MSEstudiantes.model.DocumentacionModel;
import GestionEstudiantes.MSEstudiantes.repository.IDocumentacionRepository;

@Service
public class DocumentacionService implements IDocumentacionService {


   @Autowired
   IDocumentacionRepository repository;

   @Override
   public List<DocumentacionModel> findAll() {
       return (List<DocumentacionModel>)repository.findAll();
   }

   @Override
   public DocumentacionModel findById(Integer id) {
       return (DocumentacionModel)repository.findById(id).get();
   }

   @Override
   public DocumentacionModel add(DocumentacionModel model) {
       return repository.save(model);
   }

   @Override
   public DocumentacionModel update(DocumentacionModel model) {
       return repository.save(model);
   }

   @Override
   public Boolean delete(Integer id) {
       repository.deleteById(id);
       return true;
   }
   
}   

