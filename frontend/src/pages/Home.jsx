import { Link } from "react-router-dom";
import HeroSlide from "../components/hero-slide/HeroSlide";
import { OutlineButton } from "../components/button/Button";
import MovieList from "../components/movie-list/MovieList";
import { category, movieType, seriesType } from "../api/movieService";

function HomePage() {
  return (
    <div>
      <HeroSlide />
      <div className="container">
        <div className="section mb-3">
          <div className="section__header mb-2">
            <h2>Trending Movies</h2>
            <Link to="/movies">
              <OutlineButton className="small">View more</OutlineButton>
            </Link>
          </div>
          <MovieList category={category.movies} type={movieType.popular} />
        </div>

        <div className="section mb-3">
          <div className="section__header mb-2">
            <h2>Top Rated Movies</h2>
            <Link to="/movies">
              <OutlineButton className="small">View more</OutlineButton>
            </Link>
          </div>
          <MovieList category={category.movies} type={movieType.top_rated} />
        </div>

        <div className="section mb-3">
          <div className="section__header mb-2">
            <h2>Trending Series</h2>
            <Link to="/series">
              <OutlineButton className="small">View more</OutlineButton>
            </Link>
          </div>
          <MovieList category={category.series} type={seriesType.popular} />
        </div>

        <div className="section mb-3">
          <div className="section__header mb-2">
            <h2>Top Rated Series</h2>
            <Link to="/series">
              <OutlineButton className="small">View more</OutlineButton>
            </Link>
          </div>
          <MovieList category={category.series} type={seriesType.top_rated} />
        </div>
      </div>
    </div>
  );
}

export default HomePage;
