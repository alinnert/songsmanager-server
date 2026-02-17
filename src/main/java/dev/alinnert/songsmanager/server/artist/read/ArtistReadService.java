package dev.alinnert.songsmanager.server.artist.read;

import dev.alinnert.songsmanager.server.artist.api.ArtistView;
import dev.alinnert.songsmanager.server.artist.domain.ArtistDto;
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

    public List<ArtistDto.SimpleResponse> getAll() {
        return ArtistEntity
            .findAll()
            .project(ArtistDto.SimpleResponse.class)
            .list();
    }

    public Optional<ArtistDto.SimpleResponse> getById(UUID id) {
        return Optional.ofNullable(ArtistEntity
            .find("id", id)
            .project(ArtistDto.SimpleResponse.class)
            .firstResult());
    }

    public Optional<ArtistDto.DetailedResponse> getById(
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
