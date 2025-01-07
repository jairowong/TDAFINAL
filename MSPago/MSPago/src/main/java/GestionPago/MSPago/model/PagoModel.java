package com.edu.pe.model;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "pago")
public class PagoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String apellido;
    private Date fecha;
    private double monto;
    private String tipoPago;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private MsUsuario usuario;

    public PagoModel(String nombre, String apellido, Date fecha, double monto, String tipoPago, UsuarioModel usuario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha = fecha;
        this.monto = monto;
        this.tipoPago = tipoPago;
        this.idusuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.idUsuario = usuario.getId();
    }
}   