package dev.alinnert.songsmanager.server.playlist.api;

import jakarta.ws.rs.*;

import java.util.UUID;

@Path("/playlists")
public class PlaylistResource
{
    @GET
    public void listPlaylists() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @GET
    @Path("/{id}")
    public void getPlaylistById() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @POST
    public void createPlaylist() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @PUT
    @Path("/{id}")
    public void updatePlaylist(@PathParam("id") UUID id) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @DELETE
    @Path("/{id}")
    public void deletePlaylist(@PathParam("id") UUID id) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
