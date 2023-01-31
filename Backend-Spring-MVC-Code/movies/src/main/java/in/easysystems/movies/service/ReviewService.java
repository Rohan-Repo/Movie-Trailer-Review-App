package in.easysystems.movies.service;

import in.easysystems.movies.model.Movie;
import in.easysystems.movies.model.Review;
import in.easysystems.movies.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    /*
        MongoRepository is one way to talk to the DB, the other way is MongoTemplate
        There could be extra operations which should not be done or are too complex for Repository.
        So, MongoTemplate will be used to form a Dynamic Query and do the Job inside the Database
     */
    @Autowired
    private MongoTemplate mongoTemplate;

    // Find Movie by ImdbId and then associate that review with that movie
    public Review createReview( String reviewBody, String imdbId ){
        /*
            Instead of instantiating Review, insert returns the value you send so just assign that value
            Review review = new Review(reviewBody);

         */
        Review review = reviewRepository.insert( new Review(reviewBody) );

        // Update Reviews Based on imdbId provided - Movies Document has reviewIds as a parameter so update that
        mongoTemplate.update( Movie.class )
        // Send imdbID in the WHERE clause - (id = imdbId )
                .matching(Criteria.where("imdbId").is(imdbId) )
        // Update reviewIds Array and the review we created will be pushed inside the Array
                .apply( new Update().push("reviewIds" ).value(review) )
        // Update only Single Value so first
                .first();

        return review;
    }

    // Get All Reviews for the movie specified
}
