package dev.alinnert.songsmanager.server.artist.write;

import dev.alinnert.songsmanager.server.artist.domain.ArtistEntity;
import dev.alinnert.songsmanager.server.artist.domain.ArtistRequestDto;
import dev.alinnert.songsmanager.server.artist.domain.ArtistResponseDto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.UUID;

@ApplicationScoped
public class ArtistWriteService
{
    @Transactional
    public ArtistResponseDto.SimpleResponse add(ArtistRequestDto.PostRequest artist) {
        var entity = new ArtistEntity();
        entity.name = artist.name();
        entity.persist();
        return new ArtistResponseDto.SimpleResponse(entity.id, entity.name);
    }

    @Transactional
    public void delete(UUID id) {
        ArtistEntity.deleteById(id);
    }
}
