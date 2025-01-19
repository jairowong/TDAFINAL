package GestionMatricula.MSMatricula.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "matricula")
public class ModelMatricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String idalumno;
    private Date mat_fecha;
    private String mat_estado;
    private String mat_grado;
    private String mat_seccion;
    private int tipo_matricula;
    
    public ModelMatricula() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(String idalumno) {
        this.idalumno = idalumno;
    }

    public Date getMat_fecha() {
        return mat_fecha;
    }

    public void setMat_fecha(Date mat_fecha) {
        this.mat_fecha = mat_fecha;
    }

    public String getMat_estado() {
        return mat_estado;
    }

    public void setMat_estado(String mat_estado) {
        this.mat_estado = mat_estado;
    }

    public String getMat_grado() {
        return mat_grado;
    }

    public void setMat_grado(String mat_grado) {
        this.mat_grado = mat_grado;
    }

    public String getMat_seccion() {
        return mat_seccion;
    }

    public void setMat_seccion(String mat_seccion) {
        this.mat_seccion = mat_seccion;
    }

    public int getTipo_matricula() {
        return tipo_matricula;
    }

    public void setTipo_matricula(int tipo_matricula) {
        this.tipo_matricula = tipo_matricula;
    }



    

}
