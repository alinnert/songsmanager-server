package dev.alinnert.songsmanager.server.artist.read;

import dev.alinnert.songsmanager.server.artist.api.dto.ArtistDetailedResponseDto;
import dev.alinnert.songsmanager.server.artist.api.dto.ArtistSimpleResponseDto;
import dev.alinnert.songsmanager.server.artist.domain.ArtistEntity;
import dev.alinnert.songsmanager.server.song.domain.SongEntity;
import dev.alinnert.songsmanager.server.song.dto.SongSimpleResponseDto;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class ArtistReadRepository
{
    public Optional<ArtistSimpleResponseDto> fetchSimpleArtist(UUID id) {
        return ArtistEntity
            .find("id", id)
            .project(ArtistSimpleResponseDto.class)
            .firstResultOptional();
    }

    public Optional<ArtistDetailedResponseDto> fetchDetailedArtist(UUID id) {
        return ArtistEntity
            .find("id", id)
            .project(ArtistSimpleResponseDto.class)
            .firstResultOptional()
            .map(ArtistDetailedResponseDto::fromArtistSimpleResponseDto);
    }

    public Optional<ArtistDetailedResponseDto> fetchDetailedArtistWithSongs(UUID id) {
        return fetchSimpleArtist(id).map(artist -> {
            var songs = SongEntity
                .find("artist.id", artist.id())
                .project(SongSimpleResponseDto.class)
                .list();

            return new ArtistDetailedResponseDto(
                artist.id(),
                artist.name(),
                songs
            );
        });
    }
}
