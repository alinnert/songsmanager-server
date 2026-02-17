package dev.alinnert.songsmanager.server.artist.write;

import dev.alinnert.songsmanager.server.artist.domain.ArtistDto;
import dev.alinnert.songsmanager.server.artist.domain.ArtistEntity;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class ArtistWriteService
{
    public ArtistDto.SimpleResponse add(ArtistDto.PostRequest artist) {
        var entity = new ArtistEntity();
        entity.name = artist.name();
        entity.persist();
        return new ArtistDto.SimpleResponse(entity.id, entity.name);
    }

    public void delete(UUID id) {
        ArtistEntity.deleteById(id);
    }
}
