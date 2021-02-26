package com.mycompany.dvdstore.web.controller;

import com.mycompany.dvdstore.controller.MovieControllerInterface;
import com.mycompany.dvdstore.entity.Actor;
import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.service.MovieServiceInterface;
import com.mycompany.dvdstore.web.form.MovieForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/movie")
public class MovieController  implements MovieControllerInterface {
    @Autowired
    private MovieServiceInterface movieServiceInterface;

    public MovieServiceInterface getMovieServiceInterface() {
        return movieServiceInterface;
    }

    public void setMovieServiceInterface(MovieServiceInterface movieServiceInterface) {
        this.movieServiceInterface = movieServiceInterface;
    }

    /*@GetMapping("/{id}")
    public String displayMovieCard(@PathVariable("id") Long id, Model model){
        System.out.println("La méthode displayMovie a été invoquée");
        model.addAttribute("movie", movieServiceInterface.getMovieById(id));
        return "movie-details";
    }*/

    @PostMapping("/add")
    public String addMovie(@Validated @ModelAttribute MovieForm movieForm, BindingResult result){
        if(result.hasErrors()){
            return "add-movie-form";
        }
        Movie movie = new Movie();
        movie.setTitle(movieForm.getTitle());
        movie.setGenre(movieForm.getGenre());
        movie.setDescription(movieForm.getDescription());
        Actor actor = new Actor(movieForm.getFirstName(), movieForm.getLastName());
        movie.setMainActor(actor);
        movieServiceInterface.registerMovie(movie);
        return "movie-added";
    }

}
