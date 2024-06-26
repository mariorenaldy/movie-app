import { Route, Routes } from "react-router-dom";

import Home from "../pages/Home";
import List from "../pages/List";
import Detail from "../pages/Detail";

const Router = () => {
  return (
    <Routes>
      <Route path="/:category/search/:keyword" element={<List />} />
      <Route path="/:category/:id" element={<Detail />} />
      <Route path="/:category" element={<List />} />
      <Route path="/" element={<Home />} index />
    </Routes>
  );
};

export default Router;
