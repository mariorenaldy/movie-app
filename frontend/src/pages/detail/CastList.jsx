import { useState, useEffect } from "react";

import { useParams } from "react-router-dom";

import movieService from "../../api/movieService";
import apiConfig from "../../api/apiConfig";

function CastList(props) {
  const { category } = useParams();

  const [casts, setCasts] = useState([]);

  useEffect(() => {
    const getCredits = async () => {
      const res = await movieService.credits(category, props.id);
      setCasts(res.results.slice(0, 5));
    };
    getCredits();
  }, [category, props.id]);
  return (
    <div className="casts">
      {casts.map((item, i) => (
        <div key={i} className="casts__item">
          <div className="casts__item__img" style={{ backgroundImage: `url(${apiConfig.w500Image(item.profile_path)})` }}></div>
          <p className="casts__item__name">{item.name}</p>
        </div>
      ))}
    </div>
  );
}

export default CastList;
