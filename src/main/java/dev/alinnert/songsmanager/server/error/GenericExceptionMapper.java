package dev.alinnert.songsmanager.server.error;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.Optional;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable>
{
    @Context
    UriInfo uriInfo;

    @Override
    public Response toResponse(Throwable throwable) {
        int statusCode = Optional.of(throwable).map(e -> {
            if (e instanceof WebApplicationException wae) {
                return wae.getResponse().getStatus();
            }
            return 500;
        }).orElse(500);

        var status = Optional
            .ofNullable(Response.Status.fromStatusCode(statusCode))
            .orElse(Response.Status.INTERNAL_SERVER_ERROR);

        var message = Optional
            .ofNullable(throwable.getMessage())
            .orElse(status.getReasonPhrase());

        var code = status.name();
        var path = uriInfo.getPath();

        return Response
            .status(statusCode)
            .entity(new ApiError(statusCode, code, message, path))
            .build();
    }
}
