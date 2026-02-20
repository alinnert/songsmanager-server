package dev.alinnert.songsmanager.server.artist.read;

import dev.alinnert.songsmanager.server.artist.api.ArtistView;
import dev.alinnert.songsmanager.server.artist.domain.ArtistResponseDto;
import dev.alinnert.songsmanager.server.artist.domain.ArtistEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class ArtistReadService
{
    @Inject
    ArtistReadRepository artistReadRepository;

    public List<ArtistResponseDto.SimpleResponse> getAll() {
        return ArtistEntity
            .findAll()
            .project(ArtistResponseDto.SimpleResponse.class)
            .list();
    }

    public Optional<ArtistResponseDto.SimpleResponse> getById(UUID id) {
        return Optional.ofNullable(ArtistEntity
            .find("id", id)
            .project(ArtistResponseDto.SimpleResponse.class)
            .firstResult());
    }

    public Optional<ArtistResponseDto.DetailedResponse> getById(
        UUID id,
        ArtistView artistView
    ) {
        return switch (artistView) {
            case BASIC -> artistReadRepository.fetchDetailedArtist(id);
            case WITH_SONGS ->
                artistReadRepository.fetchDetailedArtistWithSongs(id);
        };
    }
}
