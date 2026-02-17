package dev.alinnert.songsmanager.server.artist.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import dev.alinnert.songsmanager.server.song.domain.SongDto;
import io.quarkus.runtime.annotations.RegisterForReflection;

import java.util.List;
import java.util.UUID;

public abstract class ArtistDto
{
    @RegisterForReflection
    public record PostRequest(String name) {}

    @RegisterForReflection
    public record SimpleResponse(UUID id, String name) {}

    @RegisterForReflection
    public record DetailedResponse(
        UUID id,
        String name,
        @JsonInclude(JsonInclude.Include.NON_NULL) List<SongDto.SimpleResponse> songs
    )
    {
        public static DetailedResponse fromSimpleResponse(
            SimpleResponse artist
        ) {
            return new DetailedResponse(artist.id(), artist.name(), null);
        }

        public static DetailedResponse fromSimpleResponseAndSongs(
            SimpleResponse artist,
            List<SongDto.SimpleResponse> songs
        ) {
            return new DetailedResponse(artist.id(), artist.name(), songs);
        }
    }
}
