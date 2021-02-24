package com.mycompany.dvdstore.web.api;

import com.mycompany.dvdstore.controller.MovieControllerInterface;
import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.service.MovieServiceInterface;
import com.mycompany.dvdstore.web.form.MovieForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieResource implements MovieControllerInterface {
    @Autowired
    private MovieServiceInterface movieServiceInterface;

    public MovieServiceInterface getMovieServiceInterface() {
        return movieServiceInterface;
    }

    public void setMovieServiceInterface(MovieServiceInterface movieServiceInterface) {
        this.movieServiceInterface = movieServiceInterface;
    }

    @GetMapping
    public Iterable<Movie> list(){
        System.out.println("La méthode displayHome a été invoquée");
        return movieServiceInterface.getMovieList();
    }

    @GetMapping("/{id}")
    public Movie get(@PathVariable("id") Long id){
        System.out.println("La méthode displayMovie a été invoquée");
        return movieServiceInterface.getMovieById(id);
    }

    @PostMapping
    public Movie add(@RequestBody Movie movie){
        return movieServiceInterface.registerMovie(movie);
    }
}
