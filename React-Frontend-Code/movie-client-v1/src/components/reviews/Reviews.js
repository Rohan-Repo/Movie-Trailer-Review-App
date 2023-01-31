import { useEffect, useRef } from "react";
import api from '../../api/axiosConfig';
import { useParams } from 'react-router-dom';
import { Container, Row, Col  } from "react-bootstrap";
import ReviewForm from "../reviewform/ReviewForm";

const Reviews = ( { getMovieData, movie, reviews, setReviews} ) => {

const reviewText = useRef();
let params = useParams();
const imdbId = params.imdbId;

useEffect(() => {
    getMovieData(imdbId);
},[movie]);

const addReview = async(e) => {

    e.preventDefault();

    const review = reviewText.current;

    try{
        const response = await api.post("/api/v1/reviews", {reviewBody: review.value, imdbId: imdbId} );

        const updateReviews = [...reviews, {body: review.value} ];

        // console.log( 'Revs : ' + JSON.stringify(reviews) + " -- V : " + review.value )

        review.value = "";

        setReviews(updateReviews);

    }catch(err) {
        console.log( err );
    }
}

return (
<div>
    <Container>
        <Row>
            <Col> <h3> Reviews </h3> </Col>
        </Row>
        <Row className="mt-2">
            <Col>
                <img src={movie?.poster} alt="" />
            </Col>
            <Col>
                {
                    <>
                        <Row>
                            <Col>
                                <ReviewForm handleSubmit={addReview} reviewText={reviewText} labelText="Write a Review!"/>
                            </Col>
                        </Row>
                        <Row>
                            <Col>
                                <hr />
                            </Col>
                        </Row>
                    </>
                }
                {
                    reviews.map( (r) => {
                        return(
                            <>
                            

                                <Row>
                                    <Col> {r.reviewBody} </Col>
                                </Row>
                                <Row>
                                    <Col>
                                        <hr />
                                    </Col>
                                </Row>
                            </>
                        )
                    })
                }
                
            </Col>
        </Row>
    </Container>
</div>
)
}

export default Reviews