package dev.alinnert.songsmanager.server.artist.api.dto;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public record ArtistPostRequestDto(String name) {}