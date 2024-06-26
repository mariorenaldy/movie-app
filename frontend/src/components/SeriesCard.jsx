/* eslint-disable react/prop-types */
import { Link } from "react-router-dom";

function SeriesCard({ series }) {
  return (
    <div className="series-card">
      <img className="series-card-img" src={`https://image.tmdb.org/t/p/w342${series.poster_path}`} alt={series.name} />
      <div className="series-card-content">
        <h3 className="series-card-title">{series.name}</h3>
        <Link to={`/series/${series.id}`} className="series-card-link">
          Read more
        </Link>
      </div>
    </div>
  );
}

export default SeriesCard;
