package com.starwars.respository;

import com.starwars.model.People;
import com.starwars.model.Planet;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PeopleRepositoryTest {

    @Autowired
    private PeopleRepository peopleRepository;


    @Test
    public void should_find_top_20_height_people() throws  Exception{
        List<People> actualHeightPeople = peopleRepository.findFirst20ByOrderByMassDesc();
        assertNotNull(actualHeightPeople);
    }

}
