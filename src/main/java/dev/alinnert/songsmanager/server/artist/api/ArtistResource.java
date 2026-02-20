package dev.alinnert.songsmanager.server.artist.api;

import dev.alinnert.songsmanager.server.artist.domain.ArtistRequestDto;
import dev.alinnert.songsmanager.server.artist.domain.ArtistResponseDto;
import dev.alinnert.songsmanager.server.artist.read.ArtistReadService;
import dev.alinnert.songsmanager.server.artist.write.ArtistWriteService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Path("/artists")
public class ArtistResource
{
    @Inject
    ArtistWriteService artistWriteService;

    @Inject
    ArtistReadService artistReadService;

    @GET
    public List<ArtistResponseDto.SimpleResponse> listArtists() {
        return artistReadService.getAll();
    }

    @GET
    @Path("/{id}")
    public ArtistResponseDto.DetailedResponse getArtistById(
        @PathParam("id") UUID id,
        @QueryParam("view") ArtistView artistView
    ) {
        if (artistView == null) { artistView = ArtistView.BASIC; }
        return artistReadService
            .getById(id, artistView)
            .orElseThrow(() -> new NotFoundException(
                "Artist with id %s not found".formatted(id)));
    }

    @POST
    public ArtistResponseDto.SimpleResponse addArtist(
        // TODO: Validate request body
        @RequestBody ArtistRequestDto.PostRequest artist
    ) {
        return Optional
            .ofNullable(artist)
            .map(a -> artistWriteService.add(a))
            .orElseThrow(() -> new BadRequestException(
                "No request body provided"));
    }

    @DELETE
    @Path("/{id}")
    public void deleteArtist(@PathParam("id") UUID id) {
        artistWriteService.delete(id);
    }

    @PUT
    @Path("/{id}")
    public void updateArtist(@PathParam("id") UUID id) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @PATCH
    @Path("/{id}")
    public void patchArtist(@PathParam("id") UUID id) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
