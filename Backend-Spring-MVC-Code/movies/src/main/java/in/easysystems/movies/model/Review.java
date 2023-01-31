package in.easysystems.movies.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document( collection = "reviews" )
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @Id
    private ObjectId id;
    private String reviewBody;

    // AllArgsConstructor will create ID by default but we want a Constructor with just the reviewBody
    public Review( String reviewBody ) {
        this.reviewBody = reviewBody;
    }
}

