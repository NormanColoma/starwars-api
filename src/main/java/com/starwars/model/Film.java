package com.starwars.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@ToString(exclude = {"people", "planets"})
public class Film extends ResourceSupport{
    @Id
    @GeneratedValue
    private Long filmId;

    private String title;
    private Integer episodeId;
    @Column(length = 500)
    private String openingCrawl;
    private String director;
    private String producer;
    private Date releaseDate;

    @ManyToMany
    @JoinTable(joinColumns = {@JoinColumn(name = "film_id")},
        inverseJoinColumns = {@JoinColumn(name = "people_id")})
    private List<People> people;

    @ManyToMany
    @JoinTable(joinColumns = {@JoinColumn(name = "film_id")},
            inverseJoinColumns = {@JoinColumn(name = "planet_id")})
    private List<Planet> planets;
}
