import './App.css';
import api from './api/axiosConfig'
import { useState, useEffect } from 'react';
import Layout from './components/Layout';
import { Routes, Route } from 'react-router-dom';
import Home from './components/home/Home';
import Header from './components/header/Header';
import Trailer from './components/trailer/Trailer';
import Reviews from './components/reviews/Reviews';

function App() {

  // Store Array of Movie Data
  // The app component will be restarted when the state of movies variable is changed
  const[ movies, setMovies ] = useState([]);
  const [movie, setMovie] = useState([]);
  const [reviews, setReviews] = useState([]);

  const getMovies = async() => {

    // We could run into errors during remote API calls so better to have your code in try catch block 
      
    try {
// This extra path "/api/v1/movies" will be added to the baseURL which we defined in axiosConfig.js 
// async await for asynchronous thread management - To ensure UI is not blocked when long-running operations like remote API calls take time to be processed 
// Promise is made to return to the code written previously when a long-running task like I/O bound task to ensure a better UX

      const response = await api.get("/api/v1/movies");

      // console.log( 'Status: ', response.status );
      // console.log( 'Data: ' + JSON.stringify(response.data) );

      // if( response.status == 200 )
      setMovies( response.data );

      // console.log( movies )

    } 
    catch (error) {
      console.log(error);
    }
    
  }

  const getMovieData = async(imdbId) => {
    try{
      const response = await api.get( `/api/v1/movies/${imdbId}` );

      const singleMovie = response.data;

      // console.log( 'Movie Data : ' + JSON.stringify(singleMovie) );
      
      setMovie( singleMovie );

      setReviews( singleMovie.reviewIds )

    }catch( err ){
      console.log( err );
    }
  }

  // Whenever our MainPage is reloaded, grab all Movies Data so we use useEffect Hook
  useEffect( () => {
    getMovies();
  },[movies])

  return (
    <div className="App">
      <Header />
      <Routes>
        <Route path ="/" element= { <Layout /> } >
          <Route path="/" element={ <Home movies={movies}/> }> </Route>
          <Route path="/Trailer/:ytTrailerLink" element={ <Trailer /> } />
          <Route path="/Reviews/:imdbId" element={ <Reviews getMovieData={getMovieData} movie={movie} reviews={reviews} setReviews={setReviews} /> } />
        </Route>
      </Routes>

    </div>
  );
}

export default App;
