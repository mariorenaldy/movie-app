import { useState, useEffect, useCallback } from "react";
import { useNavigate, useParams } from "react-router-dom";

import "./movie-grid.scss";

import MovieCard from "../movie-card/MovieCard";
import Button, { OutlineButton } from "../button/Button";
import Input from "../input/Input";

import movieService, { category, movieType, seriesType } from "../../api/movieService";

function MovieGrid(props) {
  const [items, setItems] = useState([]);
  const [page, setPage] = useState(1);
  const [totalPage, setTotalPage] = useState(0);

  const { keyword } = useParams();

  useEffect(() => {
    async function getList() {
      let response = null;
      if (keyword === undefined) {
        const params = {};
        switch (props.category) {
          case category.movies:
            response = await movieService.getMoviesList(movieType.upcoming, { params });
            break;
          default:
            response = await movieService.getSeriesList(seriesType.popular, { params });
        }
      } else {
        const params = { query: keyword };
        response = await movieService.search(props.category, { params });
      }
      setItems(response.results);
      setTotalPage(response.total_pages);
    }
    getList();
  }, [props.category, keyword]);

  async function loadMore() {
    let response = null;
    if (keyword === undefined) {
      const params = { page: page + 1 };
      switch (props.category) {
        case category.movies:
          response = await movieService.getMoviesList(movieType.upcoming, { params });
          break;
        default:
          response = await movieService.getSeriesList(seriesType.popular, { params });
      }
    } else {
      const params = { page: page + 1, query: keyword };
      response = await movieService.search(props.category, { params });
    }
    setItems([...items, ...response.results]);
    setPage(page + 1);
  }

  return (
    <>
      <div className="section mb-3">
        <MovieSearch category={props.category} keyword={keyword} />
      </div>
      <div className="movie-grid">
        {items.map((item, i) => (
          <MovieCard category={props.category} item={item} key={i} />
        ))}
      </div>
      {page < totalPage ? (
        <div className="movie-grid__loadmore">
          <OutlineButton className="small" onClick={loadMore}>
            Load more
          </OutlineButton>
        </div>
      ) : null}
    </>
  );
}

function MovieSearch(props) {
  const navigate = useNavigate();

  const [keyword, setKeyword] = useState(props.keyword ? props.keyword : "");

  const goToSearch = useCallback(() => {
    if (keyword.trim().length > 0) {
      navigate(`/${category[props.category]}/search/${keyword}`);
    }
  }, [keyword, props.category, navigate]);

  useEffect(() => {
    function enterEvent(e) {
      e.preventDefault();
      if (e.keyCode === 13) {
        goToSearch();
      }
    }
    document.addEventListener("keyup", enterEvent);
    return () => {
      document.removeEventListener("keyup", enterEvent);
    };
  }, [keyword, goToSearch]);

  return (
    <div className="movie-search">
      <Input type="text" placeholder="Enter keyword" value={keyword} onChange={(e) => setKeyword(e.target.value)} />
      <Button className="small" onClick={goToSearch}>
        Search
      </Button>
    </div>
  );
}

export default MovieGrid;
