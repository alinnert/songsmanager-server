package dev.alinnert.songsmanager.server.artist.domain;

import dev.alinnert.songsmanager.server.song.domain.SongEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "artist")
public class ArtistEntity extends PanacheEntityBase implements Serializable
{
    @Id
    @GeneratedValue
    public UUID id;

    public String name;

    @OneToMany(mappedBy = "artist", cascade = CascadeType.REMOVE)
    public List<SongEntity> songs;
}
