package dev.alinnert.songsmanager.server.artist.api;

import java.util.Arrays;

public enum ArtistView
{
    BASIC("basic"),
    WITH_SONGS("with-songs");

    private final String value;

    ArtistView(String value) { this.value = value; }

    public String getValue() { return value; }

    public static ArtistView fromString(String value) {
        for (ArtistView view : values()) {
            if (view.value.equals(value)) { return view; }
        }
        var valuesList = Arrays
            .stream(values())
            .map(ArtistView::getValue)
            .toList();
        var supportedValues = String.join(", ", valuesList);
        throw new IllegalArgumentException(
            "Unknown view '%s' (supported views: %s)".formatted(
                value,
                supportedValues
            ));
    }
}
