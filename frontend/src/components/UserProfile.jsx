import { useEffect, useState } from "react";
import axiosInstance from "../api/axiosConfig";

function UserProfile() {
  const [user, setUser] = useState(null);
  const [watchlist, setWatchlist] = useState([]);

  useEffect(() => {
    const fetchUserData = async () => {
      // Fetch user data
      const userResponse = await axiosInstance.get("/api/users/me");
      setUser(userResponse);

      // Fetch watchlist
      const watchlistResponse = await axiosInstance.get("/api/watchlists");
      setWatchlist(watchlistResponse);
    };
    fetchUserData();
  }, []);

  if (!user) return <div>Loading...</div>;

  return (
    <div>
      <h2>{user.username}&rsquo;s Profile</h2>
      <h3>Watchlist</h3>
      <ul>
        {watchlist.map((movie) => (
          <li key={movie.id}>{movie.title}</li>
        ))}
      </ul>
    </div>
  );
}

export default UserProfile;
