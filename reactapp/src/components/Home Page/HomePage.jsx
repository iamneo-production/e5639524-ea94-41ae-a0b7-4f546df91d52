import React from 'react'
import { useNavigate } from 'react-router'
import HomePageImg from '../../icon/HomePage.png'
import './Home.css'


export default function HomePage() {
    let navigate = useNavigate();
  return (
    <div class="Main">
        <div class="image">
            <h1 className="home-h1">Arts and Crafts Academy</h1>
            <img className="homeImg" src={HomePageImg} alt="Loading.."/>
            <button className="login" onClick={() => {navigate("login")}}>Login</button>
            <button className="signup" onClick={() => {navigate("signup")}}>SignUp</button>
        </div>
    </div>
  )
}
