package GestionMatricula.MSMatricula.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="detallematricula")
public class ModelDetalleMatricula {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int iddetalle_matricula;
    private int idalumno;
    private int idmatricula;
    private String grado;
    private String seccion;
    private String curso;
    private String periodo;

    public ModelDetalleMatricula() {
    }

    public int getIddetalle_matricula() {
        return iddetalle_matricula;
    }

    public void setIddetalle_matricula(int iddetalle_matricula) {
        this.iddetalle_matricula = iddetalle_matricula;
    }

    public int getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(int idalumno) {
        this.idalumno = idalumno;
    }

    public int getIdmatricula() {
        return idmatricula;
    }

    public void setIdmatricula(int idmatricula) {
        this.idmatricula = idmatricula;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    
    


}
