package dev.alinnert.songsmanager.server.song.dto;

import java.util.UUID;

public record SongDetailedResponseDto(
    UUID id, String title, int duration, String artistName
) {}
