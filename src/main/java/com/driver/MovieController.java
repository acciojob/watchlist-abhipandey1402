package com.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    // 1. Add a Movie
    @PostMapping("/movies/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody() Movie movie){

        String response = movieService.addMovie(movie);

        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    // 2. Add a Director
    @PostMapping("/movies/add-director")
    public ResponseEntity<String> addDirector(@RequestBody() Director director){

        String response = movieService.addDirector(director);

        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    // 3. Pair an Existing Movie and Director
    @PostMapping("/movies/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movieName") String movieName, @RequestParam("directorName") String directorName){

        String response = movieService.addMovieDirectorPair(movieName, directorName);

        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    // 4. Get Movie by movieName as Path Variable
    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String movieName){

        Movie movieObj = movieService.getMovieByName(movieName);

        if(movieObj == null){
            return new ResponseEntity<>(movieObj, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(movieObj, HttpStatus.FOUND);
    }

    // 5. Get Director by Director Name
    @GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name") String directorName){

        Director directorObj = movieService.getDirectorByName(directorName);

        if(directorObj == null){
            return new ResponseEntity<>(directorObj, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(directorObj, HttpStatus.FOUND);
    }

    // 6. Get List of movies name for a given director name

    @GetMapping("/movies/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("name") String directorName){

        List<String> movieList = movieService.getMoviesByDirectorName(directorName);

        if(movieList == null){
            return new ResponseEntity<>(movieList, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(movieList, HttpStatus.OK);
    }

    // 7. Get List of all movies added
    @GetMapping("/movies/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){

        List<String> movieList = movieService.findAllMovies();

        if(movieList == null){
            return new ResponseEntity<>(movieList, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(movieList, HttpStatus.OK);
    }

    // Delete a director and its movies from the records

    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String name){

        String response = movieService.deleteDirectorByName(name);

        if(response == null){
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    // Delete all directors and all movies by them from the records
    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        String response = movieService.deleteAllDirectors();

        if(response == null){
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
}