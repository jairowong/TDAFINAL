package GestionEstudiantes.MSEstudiantes.model;

public class DocumentacionModel {
    
    private Long id;
    private String certificado;
    private String dni;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCertificado() {
        return certificado;
    }
    public void setCertificado(String certificado) {
        this.certificado = certificado;
    }
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    
}
