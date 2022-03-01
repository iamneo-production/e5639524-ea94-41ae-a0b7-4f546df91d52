import React, { Component } from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Login from "../Auth/Login/Login";
import Signup from "../Auth/Signup/Signup";
import ViewAcademy from "../User/ViewAcademy/ViewAcademy";
import AdminNavigationBar from "../Admin/AdminAcademy/AdminNavigationBar";
import AdminAcademy from "../Admin/AdminAcademy/AdminAcademy";
import AdminStudent from "../Admin/AdminStudent/AdminStudent";
import AdminCourse from "../Admin/AdminCourse/AdminCourse";
import AdminAddStudent from "../Admin/AdminStudent/AdminAddStudent";
import ErrorPage from "../Error Page/ErrorPage";
import AdminUpdateStudent from "../Admin/AdminStudent/AdminUpdateStudent";
import HomePage from "../Home Page/HomePage";
export default class Auth extends Component {
  render() {
    return (
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<HomePage/>}/>
          <Route path="/signup" element={<Signup />}></Route>
          <Route path="/login" element={<Login />} ></Route>
          <Route path="/viewAcademy" element={<ViewAcademy />}></Route>
          <Route path="admin" element={<AdminNavigationBar />}>
            <Route path="" element={<AdminAcademy />}/>
            <Route path="adminStudent" element={<AdminStudent />}></Route>
            <Route path="adminStudent/adminAddStudent" element={<AdminAddStudent />}/>
            <Route path="adminStudent/updateStudent/:studentId" element={<AdminUpdateStudent />}/>
            <Route path="/AdminCourse" component={<AdminCourse />} />
          </Route>
          <Route path="/*" element={<ErrorPage />}></Route>
        </Routes>
      </BrowserRouter>
    );
  }
}
