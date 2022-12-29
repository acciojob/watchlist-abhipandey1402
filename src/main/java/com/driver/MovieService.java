package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public String addMovie(Movie movie){

        String res = movieRepository.addMovie(movie);

        return res;
    }

    public String addDirector(Director director){

        String res = movieRepository.addDirector(director);

        return res;
    }

    public String addMovieDirectorPair(String movie, String director){

        String res = movieRepository.addMovieDirectorPair(movie, director);

        return res;
    }

    public Movie getMovieByName(String name){

        Movie res = movieRepository.getMovieByName(name);

        return res;
    }

    public Director getDirectorByName(String name){

        Director res = movieRepository.getDirectorByName(name);

        return res;
    }

    public List<String> getMoviesByDirectorName(String name){

        List<String> res = movieRepository.getMoviesByDirectorName(name);

        return res;
    }

    public List<String> findAllMovies(){

        List<String> res = movieRepository.findAllMovies();

        return res;
    }

    public String deleteDirectorByName(String name){

        String res = movieRepository.deleteDirectorByName(name);

        return res;
    }

    public String deleteAllDirectors(){

        String res = movieRepository.deleteAllDirectors();

        return res;
    }
}
