package GestionMatricula.Vacante.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="Vacante")

public class Vacante {

          @Id
          @GeneratedValue(strategy = GenerationType.IDENTITY)
          public String Idgrado;
          public String Idseccion;
          public String vacantes_disponibles;
          public Date año_alectivo;

          
        public Vacante() {
        }


        public Vacante(String idgrado, String idseccion, String vacantes_disponibles, Date año_alectivo) {
            Idgrado = idgrado;
            Idseccion = idseccion;
            this.vacantes_disponibles = vacantes_disponibles;
            this.año_alectivo = año_alectivo;
        }


        public String getIdgrado() {
            return Idgrado;
        }


        public void setIdgrado(String idgrado) {
            Idgrado = idgrado;
        }


        public String getIdseccion() {
            return Idseccion;
        }


        public void setIdseccion(String idseccion) {
            Idseccion = idseccion;
        }


        public String getVacantes_disponibles() {
            return vacantes_disponibles;
        }


        public void setVacantes_disponibles(String vacantes_disponibles) {
            this.vacantes_disponibles = vacantes_disponibles;
        }


        public Date getAño_alectivo() {
            return año_alectivo;
        }


        public void setAño_alectivo(Date año_alectivo) {
            this.año_alectivo = año_alectivo;
        }

        

    



}
