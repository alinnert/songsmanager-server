package dev.alinnert.songsmanager.server.artist.read;

import dev.alinnert.songsmanager.server.artist.api.ArtistView;
import dev.alinnert.songsmanager.server.artist.api.dto.ArtistDetailedResponseDto;
import dev.alinnert.songsmanager.server.artist.api.dto.ArtistSimpleResponseDto;
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

    public List<ArtistSimpleResponseDto> getAll() {
        return ArtistEntity
            .findAll()
            .project(ArtistSimpleResponseDto.class)
            .list();
    }

    public Optional<ArtistSimpleResponseDto> getById(UUID id) {
        return Optional.ofNullable(ArtistEntity
            .find("id", id)
            .project(ArtistSimpleResponseDto.class)
            .firstResult());
    }

    public Optional<ArtistDetailedResponseDto> getById(UUID id, ArtistView artistView) {
        if (artistView.equals(ArtistView.BASIC)) {
            return artistReadRepository.fetchDetailedArtist(id);
        }

        if (artistView.equals(ArtistView.WITH_SONGS)) {
            return artistReadRepository.fetchDetailedArtistWithSongs(id);
        }

        return Optional.empty();
    }
}
