package br.com.udemy.resources;


import br.com.udemy.domain.dto.EntryDTO;
import br.com.udemy.domain.dto.LowDTO;
import br.com.udemy.service.EntryService;
import br.com.udemy.service.LowService;
import io.quarkus.security.identity.SecurityIdentity;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/low")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LowResource {


    @Inject
    SecurityIdentity securityIdentity;

    @Inject
    private LowService service;

    @GET
    @RolesAllowed("user")
    public List<LowDTO> list() {
        return this.service.list();
    }


    @POST
    @RolesAllowed("user")
    public void post(LowDTO low){
        this.service.save(low);
    }
}
