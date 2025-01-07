package GestionUsuario.MSUsuario.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "access") // Nombre de la tabla en la base de datos
public class AccessModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generación automática del ID
    @Column(name = "id_user") // Mapeo con la columna de la tabla
    private Long id_user; // Cambiado a Long, ya que PostgreSQL maneja IDs numéricos por convención

    @Column(name = "username", nullable = false) // Columna no nula
    private String username;

    @Column(name = "password", nullable = false) // Columna no nula
    private String password;

    @Override
    public String toString() {
        return "AccessModel [id_user=" + id_user + ", username=" + username + ", password=" + password + "]";
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
