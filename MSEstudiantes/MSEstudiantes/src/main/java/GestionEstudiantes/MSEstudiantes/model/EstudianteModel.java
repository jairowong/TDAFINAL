package GestionEstudiantes.MSEstudiantes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="estudiante")
public class EstudianteModel {
    
    private Long id;
    private String dni; 
    private String nombre;
    private String ape_paterno;
    private String ape_materno;
    private int edad;
    private String sexo;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApe_paterno() {
        return ape_paterno;
    }
    public void setApe_paterno(String ape_paterno) {
        this.ape_paterno = ape_paterno;
    }
    public String getApe_materno() {
        return ape_materno;
    }
    public void setApe_materno(String ape_materno) {
        this.ape_materno = ape_materno;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
   
    
}
