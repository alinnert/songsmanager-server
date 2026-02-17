package dev.alinnert.songsmanager.server.song.read;

import dev.alinnert.songsmanager.server.song.domain.SongDto;
import dev.alinnert.songsmanager.server.song.domain.SongEntity;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class SongReadService
{
    public List<SongDto.SimpleResponse> listAll() {
        return SongEntity
            .findAll()
            .project(SongDto.SimpleResponse.class)
            .list();
    }

    public Optional<SongDto.SimpleResponse> getById(UUID id) {
        return Optional.ofNullable(SongEntity
            .find("id", id)
            .project(SongDto.SimpleResponse.class)
            .firstResult());
    }
}
