package dev.alinnert.songsmanager.server.artist.read;

import dev.alinnert.songsmanager.server.artist.domain.ArtistResponseDto;
import dev.alinnert.songsmanager.server.artist.domain.ArtistEntity;
import dev.alinnert.songsmanager.server.song.domain.SongDto;
import dev.alinnert.songsmanager.server.song.domain.SongEntity;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class ArtistReadRepository
{
    public Optional<ArtistResponseDto.SimpleResponse> fetchSimpleArtist(UUID id) {
        return ArtistEntity
            .find("id", id)
            .project(ArtistResponseDto.SimpleResponse.class)
            .firstResultOptional();
    }

    public Optional<ArtistResponseDto.DetailedResponse> fetchDetailedArtist(UUID id) {
        return fetchSimpleArtist(id).map(ArtistResponseDto.DetailedResponse::fromSimpleResponse);
    }

    public Optional<ArtistResponseDto.DetailedResponse> fetchDetailedArtistWithSongs(
        UUID id
    ) {
        return fetchSimpleArtist(id).map(artist -> {
            var songs = SongEntity
                .find("artist.id", artist.id())
                .project(SongDto.SimpleResponse.class)
                .list();

            return ArtistResponseDto.DetailedResponse.fromSimpleResponseAndSongs(
                artist,
                songs
            );
        });
    }
}
