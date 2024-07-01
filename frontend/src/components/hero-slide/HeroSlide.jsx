import { useState, useEffect, useRef } from "react";
import { Swiper, SwiperSlide } from "swiper/react";
import { Autoplay } from "swiper/modules";
import { useNavigate } from "react-router-dom";

import Button, { OutlineButton } from "../button/Button";
import Modal, { ModalContent } from "../modal/Modal";
import movieService, { category, movieType } from "../../api/movieService";
import apiConfig from "../../api/apiConfig";

import "./hero-slide.scss";

function HeroSlide() {
  const [movieItems, setMovieItems] = useState([]);

  useEffect(() => {
    const getMovies = async () => {
      const params = { page: 1 };
      try {
        const response = await movieService.getMoviesList(movieType.popular, params);
        setMovieItems(response.results.slice(0, 6));
      } catch (error) {
        console.error("Error fetching popular movies:", error);
      }
    };
    getMovies();
  }, []);

  return (
    <div className="hero-slide">
      <Swiper modules={[Autoplay]} grabCursor={true} spaceBetween={0} slidesPerView={1} autoplay={{ delay: 10000 }}>
        {movieItems.map((item, i) => (
          <SwiperSlide key={i}>{({ isActive }) => <HeroSlideItem item={item} className={`${isActive ? "active" : ""}`} />}</SwiperSlide>
        ))}
      </Swiper>
      {movieItems.map((item, i) => (
        <TrailerModal key={i} item={item} />
      ))}
    </div>
  );
}

function HeroSlideItem(props) {
  const navigate = useNavigate();

  const item = props.item;

  const background = apiConfig.originalImage(item.backdrop_path ? item.backdrop_path : item.poster_path);

  async function setModalActive() {
    const modal = document.querySelector(`#modal_${item.id}`);

    try {
      const videos = await movieService.getVideos(category.movies, item.id);

      if (videos.results.length > 0) {
        const videoSrc = "https://www.youtube.com/embed/" + videos.results[0].key;
        modal.querySelector(".modal__content > iframe").setAttribute("src", videoSrc);
      } else {
        modal.querySelector(".modal__content").innerHTML = "No trailer";
      }

      modal.classList.toggle("active");
    } catch (error) {
      console.error("Error fetching movie videos:", error);
    }
  }

  return (
    <div className={`hero-slide__item ${props.className}`} style={{ backgroundImage: `url(${background})` }}>
      <div className="hero-slide__item__content container">
        <div className="hero-slide__item__content__info">
          <h2 className="title">{item.title}</h2>
          <div className="overview">{item.overview}</div>
          <div className="btns">
            <Button onClick={() => navigate(`/movie/${item.id}`)}>Watch now</Button>
            <OutlineButton onClick={setModalActive}>Watch trailer</OutlineButton>
          </div>
        </div>
        <div className="hero-slide__item__content__poster">
          <img src={apiConfig.w500Image(item.poster_path)} alt="" />
        </div>
      </div>
    </div>
  );
}

function TrailerModal(props) {
  const item = props.item;

  const iframeRef = useRef(null);

  function onClose() {
    iframeRef.current.setAttribute("src", "");
  }

  return (
    <Modal active={false} id={`modal_${item.id}`}>
      <ModalContent onClose={onClose}>
        <iframe ref={iframeRef} width="100%" height="500px" title="trailer"></iframe>
      </ModalContent>
    </Modal>
  );
}

export default HeroSlide;
