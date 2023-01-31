import './Hero.css';
import Carousel from 'react-material-ui-carousel';
import {Paper} from '@mui/material';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faCirclePlay } from '@fortawesome/free-solid-svg-icons';
import { Link, useNavigate } from 'react-router-dom';
import Button from 'react-bootstrap/Button';

const Hero = ( {movies} ) => {

    const navigate = useNavigate();

    function reviews(imdbId) {
        navigate(`/Reviews/${imdbId}`)
    }

  return (
    <div className='movie-carousel-container'>
        <Carousel>
            {
                movies.map( (movie) => {
                    return(
                        // Paper element encapsulates each element in a Carousel
                        <Paper>
                            <div className='movie-card-container'>
                                <div className='movie-card' style={{"--img": `url(${movie.backdrops[0]})`}}>
{/* We want A gradient that fades from dark to light from the bottom of each Carousel item, we use inline Styling for it */}
{/* So to dynamically reference the background URL we use inline style */}
                                    <div className='movie-detail'>
                                        <div className='movie-poster'>
                                            <img src={movie.poster} alt="" />
                                        </div>
                                        <div className='movie-title'>
                                            <h4> {movie.title} </h4>
                                        </div>
                                        <div className='movie-buttons-container'>
                                            {/* Just pass the Video Id not the whole Link */}
                                            <Link to={ `/Trailer/${movie.trailerLink.split('=')[1]}` } >
                                                <div className="play-button-icon-container">
                                                    <FontAwesomeIcon className="play-button-container" icon = {faCirclePlay} />
                                                </div>
                                            </Link>
                                            <div className="movie-review-button-container">
                                                <Button variant='info' onClick={ () => reviews(movie.imdbId) } > Reviews </Button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </Paper>
                    )
                })
            }
        </Carousel>
    </div>
  )
}

export default Hero