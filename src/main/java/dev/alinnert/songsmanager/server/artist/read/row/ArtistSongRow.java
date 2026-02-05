package dev.alinnert.songsmanager.server.artist.read.row;

import io.quarkus.runtime.annotations.RegisterForReflection;

import java.util.UUID;

@RegisterForReflection
public record ArtistSongRow(
    UUID artistId, String artistName, UUID songId, String songName
) {}
