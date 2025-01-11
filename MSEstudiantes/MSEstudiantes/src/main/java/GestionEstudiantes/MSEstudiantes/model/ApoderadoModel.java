package GestionEstudiantes.MSEstudiantes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="apoderado")
public class ApoderadoModel {
    
    private Long id;
    @NotEmpty(message = "El nombre no puede estar vacío")
    @Size(max = 100, message = "El nombre no puede superar los 100 caracteres")
    private String nombre;

    @NotEmpty(message = "El apellido no puede estar vacío")
    @Size(max = 100, message = "El apellido no puede superar los 100 caracteres")
    private String apellido;

    @NotEmpty(message = "El DNI no puede estar vacío")
    @Size(min = 8, max = 8, message = "El DNI debe tener exactamente 8 caracteres")
    private String dni;

    @NotNull(message = "La edad es obligatoria")
    private Integer edad;

    @NotEmpty(message = "El sexo no puede estar vacío")
    @Pattern(regexp = "^[MF]$", message = "El sexo debe ser 'M' para masculino o 'F' para femenino")
    private String sexo;

    @NotEmpty(message = "El grado de instrucción no puede estar vacío")
    @Size(max = 50, message = "El grado de instrucción no puede superar los 50 caracteres")
    private String grado_instruccion;

    @NotEmpty(message = "El estado civil no puede estar vacío")
    @Pattern(regexp = "^(Soltero|Casado|Viudo|Divorciado)$", 
             message = "El estado civil debe ser uno de los siguientes: Soltero, Casado, Viudo, Divorciado")
    private String estado_civil;

    @NotEmpty(message = "El teléfono no puede estar vacío")
    @Pattern(regexp = "^\\d{9}$", message = "El teléfono debe contener exactamente 9 dígitos")
    private String telefono;

    @NotEmpty(message = "La dirección no puede estar Vacía")
    @Size(max = 200, message = "La dirección no puede superar los 200 caracteres")
    private String direccion;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
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
    public String getGrado_instruccion() {
        return grado_instruccion;
    }
    public void setGrado_instruccion(String grado_instruccion) {
        this.grado_instruccion = grado_instruccion;
    }
    public String getEstado_civil() {
        return estado_civil;
    }
    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    
}
