package GestionMatricula.MSMatricula.service;

import java.util.List;

import GestionMatricula.MSMatricula.model.Solicitud;


public interface ISolicitudService {

    public List<Solicitud> mostrarSolicitud();
    public Solicitud mostrarSolicitudID(Integer id);
    public Solicitud crearSolicitud(Solicitud solicitud);
    public Solicitud modificarSolicitud(Solicitud soli);
    public boolean eliminarSolicitud(Integer id);

}
