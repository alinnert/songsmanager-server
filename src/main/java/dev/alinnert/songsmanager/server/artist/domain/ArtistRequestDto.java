package dev.alinnert.songsmanager.server.artist.domain;

import io.quarkus.runtime.annotations.RegisterForReflection;

public abstract class ArtistRequestDto
{
    @RegisterForReflection
    public record PostRequest(String name) {}
}
