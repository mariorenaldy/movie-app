import { useState, useEffect } from "react";
import tmdbService from "./services/tmdbService";

function App() {
  const [movies, setMovies] = useState([]);

  useEffect(() => {
    const fetchMovies = async () => {
      const popularMovies = await tmdbService.getPopularMovies();
      setMovies(popularMovies);
    };

    fetchMovies();
  }, []);

  const handleSaveMovie = async (movie) => {
    try {
      const savedMovie = await tmdbService.saveMovie(movie);
      console.log("Movie saved:", savedMovie);
    } catch (error) {
      console.error("Error saving movie:", error);
    }
  };

  return (
    <div>
      <h1>Popular Movies</h1>
      <ul>
        {movies.map((movie) => (
          <li key={movie.id}>
            {movie.title}
            <button onClick={() => handleSaveMovie(movie)}>Save</button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;
