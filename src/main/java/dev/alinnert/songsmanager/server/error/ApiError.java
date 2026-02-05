package dev.alinnert.songsmanager.server.error;

public record ApiError(
    int status, String code, String message, String path
) {}
