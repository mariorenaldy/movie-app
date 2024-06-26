/* eslint-disable react/prop-types */
import { useEffect, useState, useRef } from "react";
import MovieCard from "./MovieCard";
import "../styles/MovieListScrollable.css";
import movieService, { movieType } from "../api/movieService";

function MovieListScrollable({ title }) {
  const [movies, setMovies] = useState([]);
  const scrollContainerRef = useRef(null);

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

  const scrollLeft = () => {
    if (scrollContainerRef.current) {
      scrollContainerRef.current.scrollBy({ left: -1000, behavior: "smooth" });
    }
  };

  const scrollRight = () => {
    if (scrollContainerRef.current) {
      scrollContainerRef.current.scrollBy({ left: 1000, behavior: "smooth" });
    }
  };

  return (
    <div className="movie-list-section">
      <h2 className="section-title">{title}</h2>
      <div className="movie-list-container">
        <button className="scroll-button left" onClick={scrollLeft}>
          &lt;
        </button>
        <div className="movie-list" ref={scrollContainerRef}>
          {movies.map((movie) => (
            <MovieCard key={movie.id} movie={movie} />
          ))}
        </div>
        <button className="scroll-button right" onClick={scrollRight}>
          &gt;
        </button>
      </div>
    </div>
  );
}

export default MovieListScrollable;
