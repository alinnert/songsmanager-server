package dev.alinnert.songsmanager.server.song.domain;

import dev.alinnert.songsmanager.server.artist.domain.ArtistEntity;
import dev.alinnert.songsmanager.server.playlist.domain.PlaylistEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "song")
public class SongEntity extends PanacheEntityBase implements Serializable
{
    @Id
    @GeneratedValue
    public UUID id;

    public String title;

    public Integer duration;

    @ManyToOne
    @JoinColumn(name = "artist_id", nullable = false)
    public ArtistEntity artist;

    @ManyToMany
    @JoinTable(
        name = "playlist_songs",
        joinColumns = @JoinColumn(name = "song_id"),
        inverseJoinColumns = @JoinColumn(name = "playlist_id")
    )
    public List<PlaylistEntity> playlists;

    public static int getDuration(int minutes, short seconds) {
        return minutes * 60 + seconds;
    }
}
