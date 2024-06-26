import { useState } from "react";
import axiosInstance from "../api/axiosConfig";

function Signup() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [email, setEmail] = useState("");

  const handleSignup = async (e) => {
    e.preventDefault();
    try {
      const response = await axiosInstance.post("/api/auth/signup", { username, password, email });
      console.log(response);
      // Handle successful signup, e.g., redirect to login
    } catch (error) {
      console.error("Signup failed", error);
    }
  };

  return (
    <form onSubmit={handleSignup}>
      <div>
        <label>Username:</label>
        <input type="text" value={username} onChange={(e) => setUsername(e.target.value)} />
      </div>
      <div>
        <label>Password:</label>
        <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} />
      </div>
      <div>
        <label>Email:</label>
        <input type="email" value={email} onChange={(e) => setEmail(e.target.value)} />
      </div>
      <button type="submit">Sign Up</button>
    </form>
  );
}

export default Signup;
