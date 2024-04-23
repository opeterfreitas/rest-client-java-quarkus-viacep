package com.opeterfreitas.restclient;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/cep") // Define o caminho base para as requisições a este recurso
public class CepResource {

    @Inject // Injeta o cliente REST para buscar CEPs
    @RestClient
    CepService cepService;

    @GET // Define que este método deve responder a requisições GET
    @Produces(MediaType.APPLICATION_JSON) // Define que este método produz uma resposta no formato JSON
    @Path("{cep}")
    public Response methodname(@PathParam("cep") String cep) { // Recebe o CEP como parâmetro e retorna um objeto Response com o Cep
        Cep response = cepService.findByCep(cep); // Chama o método findByCep do CepService para buscar o endereco completo
        return Response.ok(response).build(); // Retorna a resposta do cliente REST
    }
}