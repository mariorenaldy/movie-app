import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import styles from "../styles/MovieDetail.module.css";
import movieService, { category } from "../api/movieService";

function MovieDetail() {
  const { id } = useParams();
  const [movie, setMovie] = useState(null);
  const [video, setVideo] = useState(null);

  useEffect(() => {
    const fetchMovie = async () => {
      try {
        const response = await movieService.detail(category.movies, id, {});
        setMovie(response);
      } catch (error) {
        console.error("Error fetching movie details:", error);
      }
    };

    const fetchVideo = async () => {
      try {
        const response = await movieService.getVideos(category.movies, id);
        const videos = response;
        if (videos.length > 0) {
          setVideo(videos[0]); // Set the first video
        }
      } catch (error) {
        console.error("Error fetching movie videos:", error);
      }
    };

    fetchMovie();
    fetchVideo();
  }, [id]);

  if (!movie) return <div>Loading...</div>;

  return (
    <div className={styles.detailContainer}>
      <div className={styles.contentContainer}>
        <div className="poster">
          <img src={`https://image.tmdb.org/t/p/w500${movie.poster_path}`} alt={movie.title} />
        </div>
        <div className="info">
          <h2 className="movie-title">{movie.title}</h2>
          <p className="overview">{movie.overview}</p>
          <p>Release Date: {movie.release_date}</p>
          <p>Rating: {movie.vote_average}</p>
        </div>
      </div>
      <div className="video">
        <h3 className="video-title">Video</h3>
        {video && video.site === "YouTube" && <iframe src={`https://www.youtube.com/embed/${video.key}`} title={video.name} frameBorder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowFullScreen></iframe>}
      </div>
    </div>
  );
}

export default MovieDetail;
