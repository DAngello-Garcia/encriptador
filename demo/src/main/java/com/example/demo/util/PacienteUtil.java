package com.example.demo.util;

import com.example.demo.model.Paciente;

import java.time.LocalDate;
import java.util.function.Predicate;

public class PacienteUtil {
    public static Predicate<Paciente> buscarPorNombre(String nombre){
        return (paciente) -> paciente.getNombre().contains(nombre);
    }
    public static Predicate<Paciente> buscarPorApellido(String apellido){
        return (paciente) -> paciente.getApellido().contains(apellido);
    }
    public static Predicate<Paciente> buscarPorDocumento(String cedula){
        return (paciente) -> paciente.getNumero_documento().equals(cedula);
    }
    public static Predicate<Paciente> buscarPorFecha(LocalDate fecha){
        return paciente -> paciente.getFecha_atencion().toString().equals(fecha);
    }
    public static Predicate<Paciente> buscarPorFechaExacta(LocalDate fecha){
        Predicate<Paciente> predicado = paciente -> true;
        predicado = predicado.and(buscarPorFecha(fecha));
        return predicado;
    }
    public static Predicate<Paciente> buscarPorTodo(String nombre, String apellido, String cedula, LocalDate fecha){
        Predicate<Paciente> predicado = paciente -> true;
        if(nombre != null && !nombre.isEmpty()){
            predicado = predicado.and(buscarPorNombre(nombre));
        }
        if(apellido != null && !apellido.isEmpty()){
            predicado = predicado.and(buscarPorApellido(apellido));
        }
        if(cedula != null && !cedula.isEmpty()){
            predicado = predicado.and(buscarPorDocumento(cedula));
        }
        if(fecha != null){
            predicado = predicado.and(buscarPorFecha(fecha));
        }
        return predicado;
    }
}
