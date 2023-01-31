package in.easysystems.movies.controllers;

import in.easysystems.movies.model.Movie;
import in.easysystems.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

// This class is just concerned with Getting a Request from the User and Returning the response

@RestController
// Instead of mapping to localhost:8080 we want it to map to custom URI "/api/v1/movies"
@RequestMapping( "/api/v1/movies" )
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        // return new ResponseEntity<String>( "All Movies", HttpStatus.OK );
        // Grab Movies from movieService instead of String Response
        return new ResponseEntity<List<Movie>> ( movieService.allMovies(), HttpStatus.OK );
    }

    // We could get Null response if the ID we passed is not found to avoid that we say Optional<Movie>
    /*
    Previously we were taking the Id but now we want to find by ImdbId because we dont want to expose ID to public

    @GetMapping("/{Id}")
    public  ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable ObjectId Id) {
        return new ResponseEntity<Optional<Movie>>( movieService.singleMovie(imdbId), HttpStatus.OK );
    }
    Make Sure you have ImdbID as PathVariable otherwise it doesnt work
     */
    @GetMapping("/{imdbId}")
    public  ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId) {
        return new ResponseEntity<Optional<Movie>>( movieService.singleMovie(imdbId), HttpStatus.OK );
    }
}
