package GestionEstudiantes.MSEstudiantes.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="estudiante")
public class EstudianteModel {
    
<<<<<<< Updated upstream
    private Long id;

    @NotEmpty(message = "El DNI no puede estar vacío")
    @Size(min = 8, max = 8, message = "El DNI debe tener exactamente 8 caracteres")
    private String dni;

    @NotEmpty(message = "El nombre no puede estar vacío")
    @Size(max = 50, message = "El nombre no puede superar los 100 caracteres")
    private String nombre;

    @NotEmpty(message = "El apellido paterno y materno no puede estar vacío")
    @Size(max = 50, message = "El apellido paterno y materno no puede superar los 200 caracteres")
    private String ape_paterno;

    @NotEmpty(message = "El apellido paterno y materno no puede estar vacío")
    @Size(max = 50, message = "El apellido paterno y materno no puede superar los 200 caracteres")
    private String ape_materno;

    @NotNull(message = "La edad es obligatoria")
    private Integer edad;

    @NotEmpty(message = "El sexo no puede estar vacío")
    @Size(max = 1, message = "El sexo debe ser 'M' para masculino o 'F' para femenino")
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

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }



=======

        private Long id;
    
        @NotEmpty(message = "El DNI no puede estar vacío")
        @Size(min = 8, max = 8, message = "El DNI debe tener exactamente 8 caracteres")
        private String dni;
    
        @NotEmpty(message = "El nombre no puede estar vacío")
        @Size(max = 100, message = "El nombre no puede superar los 100 caracteres")
        private String nombre;
    
        @NotEmpty(message = "El apellido paterno y materno no puede estar vacío")
        @Size(max = 200, message = "El apellido paterno y materno no puede superar los 200 caracteres")
        private String ape_paterno;

        @NotEmpty(message = "El apellido paterno y materno no puede estar vacío")
        @Size(max = 200, message = "El apellido paterno y materno no puede superar los 200 caracteres")
        private String ape_materno;
    
        @NotNull(message = "La edad es obligatoria")
        private Integer edad;
    
        @NotEmpty(message = "El sexo no puede estar vacío")
        @Size(max = 1, message = "El sexo debe ser 'M' para masculino o 'F' para femenino")
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

        public Integer getEdad() {
            return edad;
        }

        public void setEdad(Integer edad) {
            this.edad = edad;
        }

        public String getSexo() {
            return sexo;
        }

        public void setSexo(String sexo) {
            this.sexo = sexo;
        }  
    
    
    
>>>>>>> Stashed changes
   
    
}
