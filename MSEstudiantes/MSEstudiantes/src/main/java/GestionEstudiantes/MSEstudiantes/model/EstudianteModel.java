package GestionEstudiantes.MSEstudiantes.model;

public class EstudianteModel {
    
    private Long id;
    private String dni; 
    private String nombre;
    private String ape_apeterno;
    private String ape_materno;
    private int edad;
    private String sexo;
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
    public String getApe_apeterno() {
        return ape_apeterno;
    }
    public void setApe_apeterno(String ape_apeterno) {
        this.ape_apeterno = ape_apeterno;
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
