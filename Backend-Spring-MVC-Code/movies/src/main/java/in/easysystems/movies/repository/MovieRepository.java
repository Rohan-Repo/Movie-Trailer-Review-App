package in.easysystems.movies.repository;

import in.easysystems.movies.model.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// Data Access Layer, access Data from DB and getting the data back

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {

    Optional<Movie> findMovieByImdbId(String imdbId);
    
    /*  we can create any dynamic functions with any property present in our model and MongoRepository creates for you
        Just make Sure that the names in the Model match the Functions and Values you send & receive
        Just make Sure your Data is Unique otherwise if there's multiple data for Same ID it could create problems
    */
}
