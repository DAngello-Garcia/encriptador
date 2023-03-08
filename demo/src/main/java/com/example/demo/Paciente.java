package com.example.demo;

import java.time.LocalDateTime;

public class Paciente {
    private String nombre, apellido, tipo_documento, numero_documento, diag_inicial, diag_final, medicamentos;
    private LocalDateTime fecha_diag_inicial, fecha_diag_final, fecha_medicamento, fecha_atencion;

    public Paciente() {
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

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getNumero_documento() {
        return numero_documento;
    }

    public void setNumero_documento(String numero_documento) {
        this.numero_documento = numero_documento;
    }

    public String getDiag_inicial() {
        return diag_inicial;
    }

    public void setDiag_inicial(String diag_inicial) {
        this.diag_inicial = diag_inicial;
    }

    public String getDiag_final() {
        return diag_final;
    }

    public void setDiag_final(String diag_final) {
        this.diag_final = diag_final;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }

    public LocalDateTime getFecha_diag_inicial() {
        return fecha_diag_inicial;
    }

    public void setFecha_diag_inicial(LocalDateTime fecha_diag_inicial) {
        this.fecha_diag_inicial = fecha_diag_inicial;
    }

    public LocalDateTime getFecha_diag_final() {
        return fecha_diag_final;
    }

    public void setFecha_diag_final(LocalDateTime fecha_diag_final) {
        this.fecha_diag_final = fecha_diag_final;
    }

    public LocalDateTime getFecha_medicamento() {
        return fecha_medicamento;
    }

    public void setFecha_medicamento(LocalDateTime fecha_medicamento) {
        this.fecha_medicamento = fecha_medicamento;
    }

    public LocalDateTime getFecha_atencion() {
        return fecha_atencion;
    }

    public void setFecha_atencion(LocalDateTime fecha_atencion) {
        this.fecha_atencion = fecha_atencion;
    }
}
