package GestionMatricula.Solicitu_Matricula.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import GestionMatricula.Solicitu_Matricula.model.Solicitud;
import GestionMatricula.Solicitu_Matricula.repository.SolicitudRepository;


@Service

public class SolicitudServiceIpm implements ISolicitudService{

    @Autowired
    SolicitudRepository  solicitudrepository;

    @Override
    public List<Solicitud> mostrarSolicitud() {
        return (List<Solicitud>) solicitudrepository.findAll();

    }

    @Override
    public Solicitud crearSolicitud(Solicitud solicitud) {
        return solicitudrepository.save(solicitud);
    }

    @Override
    public Solicitud modificarSolicitud(Solicitud soli) {
        return solicitudrepository.save(soli);
    }

    @Override
    public boolean eliminarSolicitud(Integer id) {
        solicitudrepository.existsById(id);
        if (solicitudrepository.existsById(id)) {
            solicitudrepository.deleteById(id);
            return true;
        } else {
            return false;
        }

    }

    

}
