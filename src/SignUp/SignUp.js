import "./SignUp.css";
import React, { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom"; // Import useNavigate
 
const SignUp = () => {
  const [username, setUsername] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [rollNo, setRollNo] = useState("");
  const [contactNo, setContactNo] = useState("");
  const [batch, setBatch] = useState("");
  const [skills, setSkills] = useState([]); // Array to hold skills
  const [newskill, setNewskill] = useState(""); // Holds the skill being typed
  const [cgpa, setCgpa] = useState("");
  const [stream, setStream] = useState("");
 
  const navigate = useNavigate(); // Initialize useNavigate hook
 
  // Handle adding a skill to the skills array
  const handleAddSkills = () => {
    if (newskill.trim() !== "") {
      const skillsArray = newskill.split(",").map(skill => skill.trim()); // Split by commas and trim spaces
      setSkills(prevSkills => [...prevSkills, ...skillsArray]); // Add new skills to the array
      setNewskill(""); // Clear the input after adding
    }
  };
 
  const newStudent = {
    username,
    email,
    password,
    rollNo,
    contactNo,
    batch,
    skills,
    cgpa,
    stream
  };
 
  const handleSubmit = async (event) => {
    event.preventDefault();
 
    // Prepare the data as a JSON object (instead of FormData)
    const data = {
      username: username,
      email: email,
      password: password,
      rollNo: rollNo,
      contactNo: contactNo,
      batch: batch,
      skills: skills.join(","), // Send skills array as a comma-separated string
      cgpa: cgpa,
      stream: stream,
    };
 
    try {
      // API call to server for sign-up
      const response = await axios.post(
        "http://localhost:8087/placement-system/api/students/signup",
        data, // Send the data as JSON
        {
          headers: {
            "Content-Type": "application/json", // Ensure we set the right Content-Type for JSON
          },
        }
      );
 
      // If the response status is 201, the account was created successfully
      if (response.status === 201) {
        alert("Account created successfully");
        navigate("/Login"); // Navigate immediately after successful sign-up
      }
 
      console.log(response.data);
 
      // Reset form fields
      setUsername("");
      setEmail("");
      setPassword("");
      setRollNo("");
      setBatch("");
      setContactNo("");
      setSkills([]); // Reset skills array
      setCgpa("");
      setStream("");
    } catch (error) {
      console.log(error);
      if (error.response) {
        console.log("Error response:", error.response.data);
        console.log("Error status:", error.response.status);
      }
    }
  };
 
 
 
 
  return (
    <div className="login">
      <div className="login-child" />
      <b className="nsec">
        <span className="nsec-txt">
          <span>ICON</span>
          <span className="e" />
        </span>
      </b>
      <b className="placement">
        <span className="nsec-txt">
          <span>placement</span>
          <span className="e">.</span>
        </span>
      </b>
 
      <b className="home">
        <a href="/">Home</a>
      </b>
      {/* <b className="contact">Contact</b> */}
      <div className="signup-item">
        <div className="cont11">
          <div className="text2">
            Ready to take the next step in your career?
          </div>
          <div className="text2">
            <span>Login to your account to</span>
            <span> start exploring </span>
            <div className="text2">job opportunities</div>
          </div>
        </div>
        <div className="signup-inner">
          <div className="signup1">SignUp</div>
          <div className="please-enter-your">
            Please enter your credentials!
          </div>
 
          <form className="signup-form" onSubmit={handleSubmit}>
            <label className="form-label1">
              Username:
              <input
                className="form-input1"
                type="text"
                value={username}
                placeholder="Name"
                onChange={event => setUsername(event.target.value)}
              />
            </label>
            <label className="form-label1">
              Email:
              <input
                className="form-input1"
                type="text"
                value={email}
                placeholder="EMAIL"
                onChange={event => setEmail(event.target.value)}
              />
            </label>
            <br />
            <label className="form-label1">
              Password:
              <input
                className="form-input1"
                type="password"
                value={password}
                placeholder="PASSWORD"
                onChange={event => setPassword(event.target.value)}
              />
            </label>
            <br />
            <label className="form-label1">
              RollNo:
              <input
                className="form-input1"
                type="text"
                value={rollNo}
                placeholder="University Roll Number"
                onChange={event => setRollNo(event.target.value)}
              />
            </label>
            <br />
            <label className="form-label1">
              Contact Number:
              <input
                className="form-input1"
                type="String"
                value={contactNo}
                placeholder="Contact Number"
                onChange={event => setContactNo(event.target.value)}
              />
            </label>
            <br />
            <label className="form-label1">
              Batch:
              <input
                className="form-input1"
                type="text"
                value={batch}
                placeholder="Batch"
                onChange={event => setBatch(event.target.value)}
              />
            </label>
 
            {/* Skills Input Field */}
            <label className="form-label1">
              Skills:
              <input
                className="form-input1"
                type="text"
                value={newskill} // Bind to newskill state
                placeholder="Enter skills (comma separated)"
                onChange={event => setNewskill(event.target.value)} // Update newskill state
              />
              <button type="button" onClick={handleAddSkills}>
                Add Skills
              </button>
            </label>
 
            {/* Display added skills */}
            <div className="skills-display">
              <p>Added Skills:</p>
              <ul>
                {skills.map((skill, index) =>
                  <li key={index}>
                    {skill}
                  </li>
                )}
              </ul>
            </div>
 
            <label className="form-label1">
              CGPA:
              <input
                className="form-input1"
                type="text"
                value={cgpa}
                placeholder="CGPA"
                onChange={event => setCgpa(event.target.value)}
              />
            </label>
            <label className="form-label1">
              Department:
              <input
                className="form-input1"
                type="text"
                value={stream}
                placeholder="Department"
                onChange={event => setStream(event.target.value)}
              />
            </label>
 
            <button className="form-button1" type="submit">
              SignUp
            </button>
          </form>
 
          <div className="not-registered-register-container">
            <span>{`Already have an account? `}</span>
            <b className="register">
              <a href="/Login">Login</a>
            </b>
          </div>
        </div>
      </div>
    </div>
  );
};
 
export default SignUp;
 
