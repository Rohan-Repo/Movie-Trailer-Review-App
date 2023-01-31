// Use the useParams hook to play the Youtube Trailer by passing a valid Youtube Video Link 
import { useParams } from "react-router-dom";
import ReactPlayer from 'react-player';
import './Trailer.css';

const Trailer = () => {

    let params = useParams();
    const trailerVideoId = params.ytTrailerLink;



  return (
    <div className="react-player-container">
        {
            (trailerVideoId != null ) ? 
            <ReactPlayer controls="true" playing={true} url={`https://www.youtube.com/watch?v=${trailerVideoId}`} width= '100%' height= '100%' />
            :null
        }
    </div>
  )
}

export default Trailer
