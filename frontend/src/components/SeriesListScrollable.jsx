/* eslint-disable react/prop-types */
import { useEffect, useState, useRef } from "react";
import SeriesCard from "./SeriesCard";
import "../styles/SeriesListScrollable.css";
import movieService, { seriesType } from "../api/movieService";

function SeriesListScrollable({ title }) {
  const [series, setSeries] = useState([]);
  const scrollContainerRef = useRef(null);

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
    <div className="series-list-section">
      <h2 className="section-title">{title}</h2>
      <div className="series-list-container">
        <button className="scroll-button left" onClick={scrollLeft}>
          &lt;
        </button>
        <div className="series-list" ref={scrollContainerRef}>
          {series.map((s) => (
            <SeriesCard key={s.id} series={s} />
          ))}
        </div>
        <button className="scroll-button right" onClick={scrollRight}>
          &gt;
        </button>
      </div>
    </div>
  );
}

export default SeriesListScrollable;
