package br.com.udemy.resources;

import br.com.udemy.domain.model.Product;
import br.com.udemy.service.ProductService;
import io.quarkus.security.identity.SecurityIdentity;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/product")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {

    @Inject
    SecurityIdentity securityIdentity;

    @Inject
    private ProductService service;

    @GET
    @RolesAllowed("user")
    public List<Product> list() {
        return this.service.list();
    }

    @GET
    @Path("/{id}")
    @RolesAllowed("admin")
    public Product get(@PathParam("id") Long id){
        return this.service.getById(id);
    }

    @POST
    @RolesAllowed("user")
    public void post(Product product){
        this.service.save(product);
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed("admin")
    public void delete(@PathParam("id") Long id){
        this.service.delete(id);
    }
}
