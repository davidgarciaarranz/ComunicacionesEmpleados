package com.practica.hetero3.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practica.hetero3.dtos.EmpleadosDto;
import com.practica.hetero3.repositoryHttpClient.EmpleadosRepository;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/empleados")
public class EmpleadosController {
    // inyaccion de servicio por constructor
    private final EmpleadosRepository empleadosRepo;

    public EmpleadosController(EmpleadosRepository empleadosRepo) {
        this.empleadosRepo = empleadosRepo;
    }

    // get para pedir lista sync
    // endpoint: http://localhost:8081/empleados/listarSync
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/listarSync")
    public List<EmpleadosDto> ListarEmpleadosSync() {
        return empleadosRepo.listarEmpleadosSync();
    }

    // get para pedir lista async
    // endpoint: http://localhost:8081/empleados/listarAsync
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/listarAsync")
    public Flux<EmpleadosDto> ListarEmpleadosAsync() {
        return empleadosRepo.listarEmpleadosAsync();
    }

    // endpoint: http://localhost:8081/empleados/listarAsyncOk
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/listarAsyncOk")
    public String ListarEmpleadosAsyncOk() {
        return empleadosRepo.listarEmpleadosAsyncOk();
    }
}
