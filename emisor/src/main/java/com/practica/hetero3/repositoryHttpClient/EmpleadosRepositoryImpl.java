package com.practica.hetero3.repositoryHttpClient;

import java.time.Duration;
import java.util.List;

import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.practica.hetero3.dtos.EmpleadosDto;

import reactor.core.publisher.Flux;
import reactor.netty.http.client.HttpClient;

@Component
public class EmpleadosRepositoryImpl implements EmpleadosRepository {

    @Override
    public List<EmpleadosDto> listarEmpleadosSync() {
        final HttpClient client = HttpClient.create().responseTimeout(Duration.ofSeconds(30)); // time client http espera
        
        final WebClient webClient = WebClient.builder().clientConnector(new ReactorClientHttpConnector(client)).build();

        return webClient.get().uri("http://localhost:8082/empleados/listar") //url q apunta
                .retrieve()
                .bodyToFlux(EmpleadosDto.class)
                .collectList()
                .block(Duration.ofSeconds(30)); // time blockeo del hilo
    }

    @Override
    public Flux<EmpleadosDto> listarEmpleadosAsync() {

        final WebClient webClient = WebClient.builder().build();

        return webClient.get()
                .uri("http://localhost:8082/empleados/listar")
                .retrieve().bodyToFlux(EmpleadosDto.class) // programa la respuesta cuando llegue
                .timeout(Duration.ofSeconds(30)); // t espera
    }

    @Override
    public String listarEmpleadosAsyncOk() {

        final WebClient webClient = WebClient.builder().build();

        webClient.get()
                .uri("http://localhost:8082/empleados/listar")
                .retrieve().bodyToFlux(EmpleadosDto.class) // programa la respuesta cuando llegue
                .timeout(Duration.ofSeconds(30));
        return "Ok";
    }

}
