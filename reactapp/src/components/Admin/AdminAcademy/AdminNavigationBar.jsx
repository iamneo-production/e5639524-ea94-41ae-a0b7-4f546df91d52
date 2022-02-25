import React from "react";
import AcademyIcon from "../../../icon/academyIcon.png"
import CourseIcon from "../../../icon/courseIcon.png"
import StudentIcon from "../../../icon/studentIcon.png"
import LogoutIcon from "../../../icon/logoutIcon.png"
import {Link, Outlet} from 'react-router-dom'
import ".././App.css";

export default function AdminAcademy() {
  return (
    <div className="adminPanel">
      <nav className="navbar">
        <ul>
          <li>
            <p className="title">Arts and Crafts Academy Admission</p>
          </li>
          <li>
            <img id="academyImg" src={AcademyIcon} alt="" />
            <Link to="">Academy</Link>
          </li>
          <li>
            <img id="courseImg" src={CourseIcon} alt="" />
            <Link to="adminCourse">Course</Link>
          </li>
          <li>
            <img id="studentImg" src={StudentIcon} alt="" />
            <Link to="adminStudent">Student</Link>
          </li>
          <li>
            <img id="logoutImg" src={LogoutIcon} alt="" />
            <Link to="/login">Logout</Link>
          </li>
        </ul>
      </nav>
     <Outlet/>
    </div>
  );
}
