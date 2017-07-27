package com.starwars.respository;

import com.starwars.model.Film;
import com.starwars.model.Planet;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FilmRepositoryTest {

    @Autowired
    private FilmRepository filmRepository;


    @Test
    public void should_find_max_people_in_film() throws  Exception{
        List<Film>films = filmRepository.findAllByMaxPeople();
        assertNotNull(films);
    }

    @Test
    public void should_print_all_films() throws  Exception{
        List<Film>films = filmRepository.findAll();
        films.stream().forEach(f -> filmRepository.logFilm(f));
    }

}
