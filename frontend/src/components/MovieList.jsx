import { useEffect, useState } from "react";
import MovieCard from "./MovieCard";
import "../styles/MovieList.css";
import movieService, { movieType } from "../api/movieService";

function MovieList() {
  const [movies, setMovies] = useState([]);

  useEffect(() => {
    const fetchMovies = async () => {
      try {
        const response = await movieService.getMoviesList(movieType.popular, {});
        setMovies(response);
      } catch (error) {
        console.error("Error fetching movies:", error);
      }
    };
    fetchMovies();
  }, []);

  return (
    <div className="container mt-8">
      <h2 className="title">Popular Movies</h2>
      <div className="grid">
        {movies.map((movie) => (
          <MovieCard key={movie.id} movie={movie} />
        ))}
      </div>
    </div>
  );
}

export default MovieList;
