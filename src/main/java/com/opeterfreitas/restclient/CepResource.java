package com.opeterfreitas.restclient;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/cep")
public class CepResource {

    @Inject
    @RestClient
    CepService cepService;

    @Inject
    CepRepository cepRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{cep}")
    @Transactional
    public Response methodname(@PathParam("cep") String cep) {
        Cep response = cepService.findByCep(cep);
        cepRepository.persist(response);
        return Response.ok(response).build();
    }
}