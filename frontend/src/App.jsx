import Router from "./config/Router";
import { BrowserRouter } from "react-router-dom";
import Header from "./components/header/Header";
import Footer from "./components/footer/Footer";

import "./App.scss";
import "./assets/boxicons-2.1.4/css/boxicons.min.css";
import "swiper/css";

function App() {
  return (
    <BrowserRouter>
      <Header />
      <Router />
      <Footer />
    </BrowserRouter>
  );
}

export default App;
