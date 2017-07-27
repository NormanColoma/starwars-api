package com.starwars.rest;

import com.starwars.model.Film;
import com.starwars.respository.FilmRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RepositoryRestController
public class FilmController {
    private static HashMap<Integer, Link> imdbLinks;
    private FilmRepository repository;

    public FilmController(FilmRepository repository){
        this.repository = repository;
        this.loadImdbLinks();
    }

    @RequestMapping(method = RequestMethod.GET, value="films/search/findAllByReleaseDateGreaterThanEqual")
    public @ResponseBody
    ResponseEntity<?> withIMDBLink(@RequestParam("releaseDate") @DateTimeFormat(pattern = "yyyy-mm-dd'T'HH:mm:ss") Date releaseDate){
        List<Film> films = this.repository.findAllByReleaseDateGreaterThanEqual(releaseDate);

        Resources<Film> resources = new Resources<Film>(films);
        resources.forEach(resource -> {
            Link imdbLink = imdbLinks.get((int)(long)resource.getFilmId());
            resource.add(imdbLink.withRel("imdb"));
        });

        return new ResponseEntity<List<Film>>(films, HttpStatus.OK);
    }

    private static void loadImdbLinks() {
        imdbLinks = new HashMap<Integer, Link>();

        imdbLinks.put(1, new Link("http://www.imdb.com/title/tt0120915/"));
        imdbLinks.put(2, new Link("http://www.imdb.com/title/tt0121765/?ref_=nv_sr_2"));
        imdbLinks.put(3, new Link("http://www.imdb.com/title/tt0121766/?ref_=nv_sr_1"));
        imdbLinks.put(4, new Link("http://www.imdb.com/title/tt0076759/?ref_=nv_sr_1"));
        imdbLinks.put(5, new Link("http://www.imdb.com/title/tt0080684/?ref_=nv_sr_1"));
        imdbLinks.put(6, new Link("http://www.imdb.com/title/tt0086190/?ref_=nv_sr_1"));
        imdbLinks.put(7, new Link("http://www.imdb.com/title/tt2488496/?ref_=nv_sr_1"));
    }
}
