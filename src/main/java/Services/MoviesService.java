package Services;
import Model.MovieModel;

import java.util.ArrayList;
import java.util.Date;

public class MoviesService {
    public ArrayList<MovieModel> GetMovies(){
        ArrayList<MovieModel> movies = new ArrayList<MovieModel>();
        MovieModel movie = new MovieModel();
        movie.id = 1;
        movie.title = "A";
        movie.description = "AAA";
        movie.release = new Date(22,2,22);
        movies.add(movie);
        movie = new MovieModel();
        movie.id = 2;
        movie.title = "B";
        movie.description = "BBB";
        movie.release = new Date(22,2,22);
        movies.add(movie);
        movie = new MovieModel();
        movie.id = 3;
        movie.title = "C";
        movie.description = "CCC";
        movie.release = new Date(22,2,22);
        movies.add(movie);
        movie = new MovieModel();
        movie.id = 4;
        movie.title = "D";
        movie.description = "DDD";
        movie.release = new Date(22,2,22);
        movies.add(movie);
        return movies;
    }
}
