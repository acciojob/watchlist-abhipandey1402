package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {

    HashMap<String, Movie> movieDb = new HashMap<>();

    HashMap<String, Director> directorDb = new HashMap<>();

    HashMap<String, List<String>> movieDirectorDb = new HashMap<>();

    public String addMovie(Movie movie){

        movieDb.put(movie.getName(), movie);

        return "success";
    }

    public String addDirector(Director director){

        directorDb.put(director.getName(), director);

        return "success";
    }

    public String addMovieDirectorPair(String movie, String director){

        if(movieDirectorDb.containsKey(director)){
            movieDirectorDb.get(director).add(movie);
        } else{
            movieDirectorDb.put(director, new ArrayList<>());
            movieDirectorDb.get(director).add(movie);
        }
        return "success";
    }

    public Movie getMovieByName(String name){
        if(movieDb.containsKey(name)){
            return movieDb.get(name);
        }
        return null;
    }

    public Director getDirectorByName(String name){
        if(directorDb.containsKey(name)){
            return directorDb.get(name);
        }
        return null;
    }

    public List<String> getMoviesByDirectorName(String director){
        return movieDirectorDb.getOrDefault(director, null);
    }

    public List<String> findAllMovies(){
        List<String> list = new ArrayList<>();

        for(String s : movieDb.keySet()){
            list.add(s);
        }
        return list;
    }

    public String deleteDirectorByName(String director){
        if(directorDb.containsKey(director)){
            if(movieDirectorDb.containsKey(director)){
                List<String> l = movieDirectorDb.get(director);
                for(String s : l){
                    movieDb.remove(s);
                }
                movieDirectorDb.remove(director);
            }
            directorDb.remove(director);
        }
        return "success";
    }

    public String deleteAllDirectors(){
        for(String director : directorDb.keySet()){
            if(movieDirectorDb.containsKey(director)){
                List<String> list = movieDirectorDb.get(director);

                for(String m : list){
                    movieDb.remove(m);
                }
                movieDirectorDb.remove(director);
            }
            directorDb.remove(director);
        }
        return "success";
    }
}
