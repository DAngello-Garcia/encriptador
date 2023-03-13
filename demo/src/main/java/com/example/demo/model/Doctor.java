package com.example.demo.model;

import com.example.demo.exception.PersonaNoExisteException;
import com.example.demo.exception.ValorRequeridoException;
import com.example.demo.util.PacienteUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class Doctor {
    private String nombre;
    private List<Paciente> listaPacientes;
    public Doctor(){}

    public Doctor(String nombre) {
        this.nombre = nombre;
        this.listaPacientes = new ArrayList<>();
    }

    public List<Paciente> getListaPacientes() {
        return listaPacientes;
    }

    public void removerPaciente(String identificacion) throws PersonaNoExisteException, ValorRequeridoException {
        if(Objects.requireNonNull(identificacion, "La Identificacion del paciente no puede ser NULL").isEmpty()){
            throw new ValorRequeridoException("Identificacion del paciente");
        }
        Optional<Paciente>paciente = buscarPacientePorDocumento(identificacion);
        if(paciente.isEmpty()){
            throw new PersonaNoExisteException("Paciente");
        }
        this.listaPacientes.remove(paciente.get());
    }

    public List<Paciente> buscar(String nombre, String apellido, String cedula, LocalDate fecha){
        return this.listaPacientes.stream().filter(PacienteUtil.buscarPorTodo(nombre,apellido,cedula,fecha))
                .collect(Collectors.toUnmodifiableList());
    }
    public List<Paciente> buscarFecha(LocalDate fecha){
        return listaPacientes.stream()
                .filter(PacienteUtil.buscarPorFechaExacta(fecha))
                .collect(Collectors.toUnmodifiableList());
    }
    public Optional<Paciente> buscarPacientePorNombre(String nombre){
        return this.listaPacientes.stream().filter(PacienteUtil.buscarPorNombre(nombre)).findFirst();
    }
    public Optional<Paciente> buscarPacientePorApellido(String apellido){
        return this.listaPacientes.stream().filter(PacienteUtil.buscarPorApellido(apellido)).findFirst();
    }
    public Optional<Paciente> buscarPacientePorDocumento(String doc){
        return this.listaPacientes.stream().filter(PacienteUtil.buscarPorDocumento(doc)).findFirst();
    }
}
