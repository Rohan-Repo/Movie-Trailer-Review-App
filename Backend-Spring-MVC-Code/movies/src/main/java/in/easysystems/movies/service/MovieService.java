package in.easysystems.movies.service;

import in.easysystems.movies.model.Movie;
import in.easysystems.movies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Business Logic Added here! - DB Access Methods

@Service
public class MovieService {

    // @Autowired instantiates this Interface on it's own
    @Autowired
    private MovieRepository movieRepository;

    // Grab all Movies using MongoRepository's findAll() Methods
    public List<Movie> allMovies() {
        return movieRepository.findAll();
    }

    /*
    We dont want to expose the Document ID to the public so we search by imdb ID
        public Optional<Movie> singleMovie(ObjectId id) {
            return movieRepository.findById(id);
        }
     */

    public Optional<Movie> singleMovie(String imdbId) {
        return movieRepository.findMovieByImdbId( imdbId );
    }
}
