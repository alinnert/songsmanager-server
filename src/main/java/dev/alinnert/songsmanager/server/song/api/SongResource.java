package dev.alinnert.songsmanager.server.song.api;

import dev.alinnert.songsmanager.server.song.domain.SongDto;
import jakarta.ws.rs.*;

import java.util.List;
import java.util.UUID;

@Path("/songs")
public class SongResource
{
    @GET
    public List<SongDto.SimpleResponse> listSongs() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @GET
    @Path("/{id}")
    public SongDto.DetailedResponse getSongById(
        @PathParam("id") UUID id,
        @QueryParam("view") SongView songView
    ) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @POST
    public void addSong() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @PUT
    @Path("/{id}")
    public void updateSong(@PathParam("id") UUID id) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @DELETE
    @Path("/{id}")
    public void deleteSong(@PathParam("id") UUID id) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
