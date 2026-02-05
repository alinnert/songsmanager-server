package dev.alinnert.songsmanager.server.song.read;

import dev.alinnert.songsmanager.server.song.domain.SongEntity;
import dev.alinnert.songsmanager.server.song.dto.SongSimpleResponseDto;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class SongReadService
{
    public List<SongSimpleResponseDto> listAll() {
        return SongEntity.findAll().project(SongSimpleResponseDto.class).list();
    }

    public Optional<SongSimpleResponseDto> getById(UUID id) {
        return Optional.ofNullable(SongEntity
            .find("id", id)
            .project(SongSimpleResponseDto.class)
            .firstResult());
    }
}
