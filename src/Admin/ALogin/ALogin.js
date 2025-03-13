
import "./ALogin.css";
import React, { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import { useAdminContext } from "../../Context/AdminContext";

const Login = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [errorMessage, setErrorMessage] = useState(""); // For storing error messages
  const { logIn } = useAdminContext();
  const nav = useNavigate();

  const handleSubmit = async (event) => {
    event.preventDefault();
    setErrorMessage(""); // Clear previous error messages

    try {
      const response = await axios.post(`http://localhost:8083/placement-system/login`, { username, password });

      if (response.status === 200) {
        // If login is successful, set success message and navigate
        console.log("Login successful");
        alert("Logged in successfully!");
        logIn(username); // Assuming logIn function updates the context
        nav("/ACommon/AHome"); // Navigate to Home
      }
    } catch (error) {
      // Handle errors, show validation or authentication error messages
      if (error.response) {
        console.log("Error response:", error.response);

        // Handle different status codes
        if (error.response.status === 404) {
          setErrorMessage(error.response.data); // Show the "Username not found" message
        } else if (error.response.status === 401) {
          setErrorMessage(error.response.data); // Show the "Invalid password" message
        } else {
          setErrorMessage("An unexpected error occurred. Please try again later.");
        }
      } else if (error.request) {
        // Network error (when no response is received)
        setErrorMessage("Network error. Please check your internet connection.");
      } else {
        // Unknown error during setup
        setErrorMessage("An unknown error occurred. Please try again.");
      }
    }
  };

  return (
    <div className="login">
      <div className="login-child" />
      <b className="nsec">
        <span className="nsec-txt">
          <span>ICON</span>
          <span className="e"></span>
        </span>
      </b>
      <b className="placement">
        <span className="nsec-txt">
          <span>placement</span>
          <span className="e">.</span>
        </span>
      </b>
      <b className="home"><a href="/">Home</a></b>

      <div className="login-item">
        <div className="cont1">
          <div className="text1">Welcome Back!</div>
          <div className="text2">Admin</div>
          <div className="text2"><span>Login to your account</span>
            <span> start exploring </span>
            <div className="text2">job opportunities</div>
          </div>
        </div>

        <div className="login-inner">
          <div className="login1">Login</div>
          <div className="please-enter-your">Please enter your credentials!</div>

          {/* Display error message if present */}
          {errorMessage && <div className="error-message">{errorMessage}</div>}

          <form className="login-form" onSubmit={handleSubmit}>
            <label className="form-label">
              Username:
              <input
                className="form-input"
                type="text"
                value={username}
                placeholder="USERNAME"
                onChange={(event) => setUsername(event.target.value)}
              />
            </label>
            <br />
            <label className="form-label">
              Password:
              <input
                className="form-input"
                type="password"
                value={password}
                placeholder="PASSWORD"
                onChange={(event) => setPassword(event.target.value)}
              />
            </label>
            <br />
            <button className="form-button" type="submit">Login</button>
          </form>

        </div>
      </div>
    </div>
  );
};

export default Login;





































