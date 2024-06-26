import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import movieService, { category } from "../api/movieService";

function SeriesDetail() {
  const { id } = useParams();
  const [series, setSeries] = useState(null);
  const [video, setVideo] = useState(null);

  useEffect(() => {
    const fetchSeries = async () => {
      try {
        const response = await movieService.detail(category.series, id, {});
        setSeries(response);
      } catch (error) {
        console.error("Error fetching series details:", error);
      }
    };

    const fetchVideo = async () => {
      try {
        const response = await movieService.getVideos(category.series, id);
        const videos = response;
        if (videos.length > 0) {
          setVideo(videos[0]);
        }
      } catch (error) {
        console.error("Error fetching TV series videos:", error);
      }
    };

    fetchSeries();
    fetchVideo();
  }, [id]);

  if (!series) return <div>Loading...</div>;

  return (
    <div className="detail-container">
      <div className="content-container">
        <div className="poster">
          <img src={`https://image.tmdb.org/t/p/w500${series.poster_path}`} alt={series.name} />
        </div>
        <div className="info">
          <h2 className="series-title">{series.name}</h2>
          <p className="overview">{series.overview}</p>
          <p>First Air Date: {series.first_air_date}</p>
          <p>Rating: {series.vote_average}</p>
        </div>
      </div>
      <div className="video">
        <h3 className="video-title">Video</h3>
        {video && video.site === "YouTube" && <iframe src={`https://www.youtube.com/embed/${video.key}`} title={video.name} frameBorder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowFullScreen></iframe>}
      </div>
    </div>
  );
}

export default SeriesDetail;
