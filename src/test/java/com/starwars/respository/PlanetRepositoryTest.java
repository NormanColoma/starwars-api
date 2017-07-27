package com.starwars.respository;

import com.starwars.model.Planet;
import lombok.AllArgsConstructor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlanetRepositoryTest {

    @Autowired
    private PlanetRepository planetRepository;


    @Test
    public void should_find_by_name() throws  Exception{
        Planet alderaan = planetRepository.findByName("Alderaan");
        Assert.assertThat(alderaan.getName(), is("Alderaan"));
    }

    @Test
    public void should_find_all_paging () throws  Exception {
        PageRequest pageRequest = new PageRequest(0, 2);
        Page<Planet> planets = planetRepository.findAll(pageRequest);

    }


}
