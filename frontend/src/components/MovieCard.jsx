/* eslint-disable react/prop-types */
import { Link } from "react-router-dom";

function MovieCard({ movie }) {
  return (
    <div className="movie-card">
      <img className="movie-card-img" src={`https://image.tmdb.org/t/p/w342${movie.poster_path}`} alt={movie.title} />
      <div className="movie-card-content">
        <h3 className="movie-card-title">{movie.title}</h3>
        <Link to={`/movie/${movie.id}`} className="movie-card-link">
          Read more
        </Link>
      </div>
    </div>
  );
}

export default MovieCard;
