import axios from 'axios';

const API_KEY = import.meta.env.VITE_TMDB_API_KEY;
const BASE_URL = 'https://api.themoviedb.org/3';

const tmdbService = {
  getPopularMovies: async () => {
    const response = await axios.get(`${BASE_URL}/movie/popular?api_key=${API_KEY}`);
    return response.data.results;
  },
  searchMovies: async (query) => {
    const response = await axios.get(`${BASE_URL}/search/movie?query=${query}&api_key=${API_KEY}`);
    return response.data.results;
  },
  saveMovie: async (movie) => {
    const response = await axios.post('/api/movies', movie);
    return response.data;
  },
};

export default tmdbService;
