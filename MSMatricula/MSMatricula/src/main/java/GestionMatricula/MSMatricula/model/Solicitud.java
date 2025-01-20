package GestionMatricula.MSMatricula.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Solicitud")

public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    public int IdVacante;
    public int IdAlumno;
    public Date fecha_solicitud;
    public String estado;

    public Solicitud() {
    }

 

    public int getIdVacante() {
        return IdVacante;
    }

    public void setIdVacante(int idVacante) {
        IdVacante = idVacante;
    }

    public int getIdAlumno() {
        return IdAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        IdAlumno = idAlumno;
    }

    public Date getFecha_solicitud() {
        return fecha_solicitud;
    }

    public void setFecha_solicitud(Date fecha_solicitud) {
        this.fecha_solicitud = fecha_solicitud;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
