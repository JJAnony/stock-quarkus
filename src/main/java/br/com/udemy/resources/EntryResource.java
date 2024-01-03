package br.com.udemy.resources;

import br.com.udemy.domain.dto.EntryDTO;
import br.com.udemy.service.EntryService;
import io.quarkus.security.identity.SecurityIdentity;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/entry")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EntryResource {

    @Inject
    SecurityIdentity securityIdentity;

    @Inject
    private EntryService service;

    @GET
    @RolesAllowed("user")
    public List<EntryDTO> list() {
        return this.service.list();
    }


    @POST
    @RolesAllowed("user")
    public void post(EntryDTO entry){
        this.service.save(entry);
    }

}
