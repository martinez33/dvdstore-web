package com.mycompany.dvdstore.web.controller;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.service.MovieServiceInterface;
import com.mycompany.dvdstore.web.form.MovieForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private MovieServiceInterface movieServiceInterface;

    public MovieServiceInterface getMovieServiceInterface() {
        return movieServiceInterface;
    }

    public void setMovieServiceInterface(MovieServiceInterface movieServiceInterface) {
        this.movieServiceInterface = movieServiceInterface;
    }

    /*@GetMapping("/dvdstore-home")
    public @ModelAttribute("movies") List<Movie> displayHome(){
        List<Movie> movies = movieServiceInterface.getMovieList();
        System.out.println("La méthode displayHome a été invoquée");
        return movies;
    }*/

    @GetMapping("/dvdstore-home")
    public void displayHome(){
    }

    @GetMapping("/add-movie-form")
    public void displayMovieForm(@ModelAttribute MovieForm movieForm){

    }
}
