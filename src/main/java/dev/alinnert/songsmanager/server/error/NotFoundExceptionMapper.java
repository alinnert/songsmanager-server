package dev.alinnert.songsmanager.server.error;

import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.Optional;

@Provider
public class NotFoundExceptionMapper
    implements ExceptionMapper<NotFoundException>
{
    @Context
    UriInfo uriInfo;

    @Override
    public Response toResponse(NotFoundException e) {
        return Response.status(Response.Status.NOT_FOUND).entity(new ApiError(
            Response.Status.NOT_FOUND.getStatusCode(),
            "NOT_FOUND",
            Optional.ofNullable(e.getMessage()).orElse("Resource not found"),
            uriInfo.getPath()
        )).build();
    }
}
