package br.com.udemy.mappers;

import br.com.udemy.domain.dto.MessageDTO;
import br.com.udemy.domain.exeption.AmoutException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class AmoutExceptionMapper  implements ExceptionMapper<AmoutException> {

    @Override
    public Response toResponse(AmoutException e) {
        MessageDTO message = new MessageDTO();
        message.setStatus(Response.Status.BAD_REQUEST.getStatusCode());
        message.setMessage("Erro: Não tem essa quantidade no Estoque!");
        return Response.status(Response.Status.BAD_REQUEST).entity(message).build();
    }
}
