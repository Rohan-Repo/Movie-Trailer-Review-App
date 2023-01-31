package in.easysystems.movies.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document( collection = "movies" )
// To Generate automatic getters Setters we annotate with @Data from lombok
@Data
// Lombok Generates a constructor with all private arguments with @AllArgsConstructor
@AllArgsConstructor
// Lombok Generates Default Constructor
@NoArgsConstructor
public class Movie {

    // Match the names according to your MongoDB Collection

    // Let's Compiler know that this is the Unique ID to identify any object
    @Id
    private ObjectId id;

    private String imdbId;

    private String title;

    private String releaseDate;

    private String trailerLink;

    private String poster;

    private List<String> genres;

    private List<String> backdrops;

    /* Manual Reference Relationship - DB will only store ID's of the review and reviews will have a different collection of it's own
        Learn about MongoDB Relationships - Without @DocumentReference One-To-Many Relationship will happen
     */
    @DocumentReference
    private List<Review> reviewIds;

}
