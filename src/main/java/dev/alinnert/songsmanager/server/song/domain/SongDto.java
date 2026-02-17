package dev.alinnert.songsmanager.server.song.domain;

import java.util.UUID;

public class SongDto
{
    public record SimpleResponse(UUID id, String title, int duration) {}

    public record DetailedResponse(
        UUID id, String title, int duration, String artistName
    ) {}
}
