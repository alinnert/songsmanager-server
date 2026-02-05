package dev.alinnert.songsmanager.server.artist.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import dev.alinnert.songsmanager.server.song.dto.SongSimpleResponseDto;
import io.quarkus.runtime.annotations.RegisterForReflection;

import java.util.List;
import java.util.UUID;

@RegisterForReflection
public record ArtistDetailedResponseDto(
    UUID id,
    String name,
    @JsonInclude(JsonInclude.Include.NON_NULL) List<SongSimpleResponseDto> songs
)
{
    public static ArtistDetailedResponseDto fromArtistSimpleResponseDto(
        ArtistSimpleResponseDto artist
    ) {
        return new ArtistDetailedResponseDto(artist.id(), artist.name(), null);
    }
}
