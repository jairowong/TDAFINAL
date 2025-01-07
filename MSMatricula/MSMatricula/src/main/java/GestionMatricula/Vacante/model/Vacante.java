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
          public int Idgrado;
          public int Idseccion;
          public int vacantes_disponibles;
          public Date año_alectivo;

          
        public Vacante() {
        }


        public Vacante(int idgrado, int idseccion, int vacantes_disponibles, Date año_alectivo) {
            Idgrado = idgrado;
            Idseccion = idseccion;
            this.vacantes_disponibles = vacantes_disponibles;
            this.año_alectivo = año_alectivo;
        }


        public int getIdgrado() {
            return Idgrado;
        }


        public void setIdgrado(int idgrado) {
            Idgrado = idgrado;
        }


        public int getIdseccion() {
            return Idseccion;
        }


        public void setIdseccion(int idseccion) {
            Idseccion = idseccion;
        }


        public int getVacantes_disponibles() {
            return vacantes_disponibles;
        }


        public void setVacantes_disponibles(int vacantes_disponibles) {
            this.vacantes_disponibles = vacantes_disponibles;
        }


        public Date getAño_alectivo() {
            return año_alectivo;
        }


        public void setAño_alectivo(Date año_alectivo) {
            this.año_alectivo = año_alectivo;
        }





}
