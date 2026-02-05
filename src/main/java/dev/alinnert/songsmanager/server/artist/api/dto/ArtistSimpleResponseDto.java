package dev.alinnert.songsmanager.server.artist.api.dto;

import io.quarkus.runtime.annotations.RegisterForReflection;

import java.util.UUID;

@RegisterForReflection
public record ArtistSimpleResponseDto(UUID id, String name) {}
