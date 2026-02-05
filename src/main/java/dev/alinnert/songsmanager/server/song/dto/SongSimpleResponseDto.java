package dev.alinnert.songsmanager.server.song.dto;

import java.util.UUID;

public record SongSimpleResponseDto(UUID id, String title, int duration) {}
