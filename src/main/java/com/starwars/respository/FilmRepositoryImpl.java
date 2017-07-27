package com.starwars.respository;

import com.starwars.model.Film;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Slf4j
@ConfigurationProperties(prefix = "taller.spring.ua")
public class FilmRepositoryImpl implements CustomFilmRepository {
    @Getter
    @Setter
    private List<String> aulas;

    @Override
    public void logFilm(Film film) {
        log.info(film.toString());
    }
}
