package com.opeterfreitas.restclient;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient // Registra a interface como um cliente REST
public interface CepService {

    @GET // Define que o método deve fazer uma requisição GET para o caminho "ws/{cep}/json/"
    @Produces(MediaType.APPLICATION_JSON)
    @Path("ws/{cep}/json/")
    Cep findByCep(@PathParam("cep") String cep); // Método para buscar um endereço. Recebe o CEP como parâmetro e retorna um objeto Cep
}
