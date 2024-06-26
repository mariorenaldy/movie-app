import { useEffect, useState } from "react";
import SeriesCard from "./SeriesCard";
import "../styles/SeriesList.css";
import movieService, { seriesType } from "../api/movieService";

function SeriesList() {
  const [series, setSeries] = useState([]);

  useEffect(() => {
    const fetchSeries = async () => {
      try {
        const response = await movieService.getSeriesList(seriesType.popular, {});
        setSeries(response);
      } catch (error) {
        console.error("Error fetching series:", error);
      }
    };
    fetchSeries();
  }, []);

  return (
    <div className="container mt-8">
      <h2 className="title">Popular TV Series</h2>
      <div className="grid">
        {series.map((s) => (
          <SeriesCard key={s.id} series={s} />
        ))}
      </div>
    </div>
  );
}

export default SeriesList;
