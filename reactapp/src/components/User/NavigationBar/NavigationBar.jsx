import React from 'react'
import { Link, Outlet } from "react-router-dom";
import { Navbar, Nav } from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";
import "./NavigationBar.css"
import AcademyIcon from "../../../icon/academyIcon.png";
import CourseIcon from "../../../icon/courseIcon.png";
import LogoutIcon from "../../../icon/logoutIcon.png";

export default function NavigationBar({logout}) {
  const onLogout = () => {
    logout();
    localStorage.clear();
  }
  return (
    <div>
        <Navbar collapseOnSelect expand="lg" className="nav" variant="dark">
        <Navbar.Brand >Arts and Crafts Academy</Navbar.Brand>
        <Navbar.Toggle aria-controls="responsive-navbar-nav" />
        <Navbar.Collapse id="responsive-navbar-nav">
          <Nav className="navbar-link">
            <img
              alt="academy"
              src={AcademyIcon}
              width="30"
              height="30"
              className="d-inline-block align-top"
            />{" "}
            <Link to="viewAcademy">Academy</Link>
            <img
              alt="academy"
              src={CourseIcon}
              width="30"
              height="30"
              className="d-inline-block align-top"
            />{" "}
            <Link to="enrolledCourse">Enrolled Course</Link>
          </Nav>
          <Nav className="nav-logout">
            <img
              alt="logout"
              src={LogoutIcon}
              width="30"
              height="30"
              className="d-inline-block align-top"
            />{" "}
            <Link id="logout" to="/login" onClick={()=>onLogout()} >Logout</Link>
          </Nav>
        </Navbar.Collapse>
      </Navbar>
      <Outlet />
    </div>
  );
}
