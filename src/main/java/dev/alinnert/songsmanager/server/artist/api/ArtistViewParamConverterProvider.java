package dev.alinnert.songsmanager.server.artist.api;

import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.ext.ParamConverter;
import jakarta.ws.rs.ext.ParamConverterProvider;
import jakarta.ws.rs.ext.Provider;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

@Provider
public class ArtistViewParamConverterProvider implements ParamConverterProvider
{
    private static final ParamConverter<ArtistView> CONVERTER = new ParamConverter<>()
    {
        @Override
        public ArtistView fromString(String value) {
            try {
                return ArtistView.fromString(value);
            } catch (IllegalArgumentException e) {
                throw new BadRequestException(e.getMessage());
            }
        }

        @Override
        public String toString(ArtistView artistView) {
            return artistView == null ? null : artistView.getValue();
        }
    };

    @Override
    @SuppressWarnings("unchecked")
    public <T> ParamConverter<T> getConverter(
        Class<T> rawType,
        Type genericType,
        Annotation[] annotations
    ) {
        if (rawType == ArtistView.class) {
            return (ParamConverter<T>) CONVERTER;
        }
        return null;
    }
}
