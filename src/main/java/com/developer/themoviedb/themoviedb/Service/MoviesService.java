package com.developer.themoviedb.themoviedb.Service;
import com.developer.themoviedb.themoviedb.Model.MovieModel;
import com.developer.themoviedb.themoviedb.Repository.MovieRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import java.util.Date;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class MoviesService {

    public ArrayList<MovieModel> GetMovies(){
        ArrayList<MovieModel> movies = new ArrayList<MovieModel>();
        MovieRepository movieRepository = new MovieRepository();
        ObjectMapper mapper = new ObjectMapper();
        var request = movieRepository.makeGetRequest("https://api.themoviedb.org/3/discover/movie/");
        try {
            JsonNode node = mapper.readTree(request);

            for (var movieJson:node.get("results")) {
                System.out.println(movieJson);
                MovieModel movie = new MovieModel();
                JsonNode movieJsonNode = movieJson;
                movie.id = movieJsonNode.get("id").asInt();
                movie.title = movieJsonNode.get("original_title").textValue();
                movie.description = movieJsonNode.get("overview").textValue();
                movie.averageVote = movieJsonNode.get("vote_average").asDouble();
                movie.votesCount = movieJsonNode.get("vote_count").asInt();
                movies.add(movie);
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }




        return movies;
    }
}
