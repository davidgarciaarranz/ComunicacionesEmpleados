package com.practica.hetero3.repositoryHttpClient;

import java.util.List;

import com.practica.hetero3.dtos.EmpleadosDto;

import reactor.core.publisher.Flux;


public interface EmpleadosRepository {

    List<EmpleadosDto> listarEmpleadosSync();

    Flux<EmpleadosDto> listarEmpleadosAsync();

    String listarEmpleadosAsyncOk();
}
