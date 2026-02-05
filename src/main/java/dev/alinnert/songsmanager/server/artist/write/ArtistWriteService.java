package dev.alinnert.songsmanager.server.artist.write;

import dev.alinnert.songsmanager.server.artist.api.dto.ArtistPostRequestDto;
import dev.alinnert.songsmanager.server.artist.api.dto.ArtistSimpleResponseDto;
import dev.alinnert.songsmanager.server.artist.domain.ArtistEntity;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class ArtistWriteService
{
    public ArtistSimpleResponseDto add(ArtistPostRequestDto artist) {
        var entity = new ArtistEntity();
        entity.name = artist.name();
        entity.persist();
        return new ArtistSimpleResponseDto(entity.id, entity.name);
    }

    public void delete(UUID id) {
        ArtistEntity.deleteById(id);
    }
}
