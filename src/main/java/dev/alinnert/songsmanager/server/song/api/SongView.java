package dev.alinnert.songsmanager.server.song.api;

public enum SongView
{
    BASIC("basic"),
    WITH_ARTIST("with-artist");

    private final String value;

    SongView(String value) { this.value = value; }

    public String getValue() { return value; }

    public static SongView fromString(String value) {
        for (SongView view : values()) {
            if (view.value.equals(value)) { return view; }
        }
        throw new IllegalArgumentException("Unknown view: " + value);
    }
}
