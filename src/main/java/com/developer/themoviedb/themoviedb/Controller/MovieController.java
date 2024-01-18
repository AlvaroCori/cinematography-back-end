package com.developer.themoviedb.themoviedb.Controller;
import com.developer.themoviedb.themoviedb.Model.MovieModel;
import com.developer.themoviedb.themoviedb.Service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class MovieController {
    @Autowired
    MoviesService service;

    @RequestMapping("/movies")
    public ArrayList<MovieModel> GetMovies() {
        return service.GetMovies();
    }
    @RequestMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "there") String name) {
        return String.format("Hello %s!", name);
    }
}
