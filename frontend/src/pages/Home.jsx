import MovieListScrollable from "../components/MovieListScrollable";
import SeriesListScrollable from "../components/SeriesListScrollable";
import HeroSlide from "../components/hero-slide/HeroSlide";

function HomePage() {
  return (
    <div>
      <HeroSlide />
      <MovieListScrollable title="Popular Movies" />
      <SeriesListScrollable title="Popular TV Series" />
    </div>
  );
}

export default HomePage;
