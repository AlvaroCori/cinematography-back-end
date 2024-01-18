package Controllers;
import Model.MovieModel;
import Services.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class MoviesController {
    //@Autowired
    //MoviesService service;

    @RequestMapping("/movies")
    public ArrayList<MovieModel> GetMovies() {
        return new ArrayList<MovieModel>();//service.GetMovies();
    }
    @RequestMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "there") String name) {
        return String.format("Hello %s!", name);
    }
}
