package com.practica.hetero3.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadosDto {

    private String codigo;

    private String nombre;

    private String apellidos;

    private String telefono;

    private String dni;

    private String puesto;

    @Override
    public String toString() {
        return "EmpleadosDto{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", puesto='" + puesto + '\'' +
                '}';
    }
}
