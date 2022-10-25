package com.openbootcamp.demosprintrest.controllers;

import com.openbootcamp.demosprintrest.models.Bootcamper;
import com.openbootcamp.demosprintrest.services.BootcamperService;
import javax.ws.rs.core.Response;
import org.springframework.stereotype.Component;


import javax.ws.rs.*;
import java.net.URI;
import java.util.List;

@Component
@Path("/")

//el controlador acepta la petición
public class BootcampersController {

    private BootcamperService bootcamperService;

    public BootcampersController() {
    }

    public BootcampersController(BootcamperService bootcamperService) {
        this.bootcamperService = bootcamperService;

        this.bootcamperService.add(new Bootcamper("uno"));
        this.bootcamperService.add(new Bootcamper("dos"));
        this.bootcamperService.add(new Bootcamper("tres"));
        this.bootcamperService.add(new Bootcamper("cuatro"));
        this.bootcamperService.add(new Bootcamper("cinco"));
    }

    @GET
    @Path("/bootcampers")
    @Produces("application/json")
    public List<Bootcamper> listarTodos() {
        return bootcamperService.getAll();
    }

    @GET
    @Path("/bootcampers/{nombre}")
    @Produces("application/json")
    public Bootcamper listarUno(@PathParam("nombre") String nombre) {
        return bootcamperService.get(nombre);
    }

    @POST
    @Path("/bootcampers")
    @Produces("application/json")
    @Consumes("application/json")
    public Response meterBootcamper(Bootcamper bootcamper) {
        bootcamperService.add(bootcamper);

        return Response.created(
                URI.create("/bootcampers/" + bootcamper.getNombre())
        ).build();

    }
}
