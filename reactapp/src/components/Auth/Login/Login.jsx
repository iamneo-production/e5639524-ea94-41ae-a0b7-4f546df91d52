import React from 'react';
import { useFormik } from 'formik';
import * as Yup from "yup";
import { Link, useNavigate } from 'react-router-dom';
import '../Auth.css'
import UserService from '../../../service/UserService';

export default function Login() {
    let navigate = useNavigate();
    const formik = useFormik({
        initialValues: {
            email: '',
            password: ''
        },
        validationSchema: Yup.object({
            email: Yup.string()
                .email('Invalid email address')
                .required('Email Id is Required'),
            password: Yup.string()
                .required('Password is Required') 
                .min(8, 'Password is too short !')
                .max(12, 'Password should not max 12 character')
            }
        ),
        onSubmit: values => {
            UserService.login(values.email, values.password).then(res =>{
                if(res.data[0].userRole === 'admin') {
                    navigate("/admin");
                }else if(res.data[0].userRole === 'user'){
                    navigate("/viewAcademy");
                }else {
                    alert("Invalid Credentials");
                }
            });
        },
    });
  return (
    <div className="login">
        <div className="login-heading">
            <div className="login-grid">
                <div className="login-left">
                    <h1 className="welcome-login">Arts and Crafts Academy</h1>
                    <img className="login-img" src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/draw1.webp" alt="signup img" />
                </div>
                <div className="login-right">
                <h1 className="login-h">Login</h1>
                    <form onSubmit={formik.handleSubmit}>
                        <label htmlFor="email">Email Id</label>
                        <input
                        id="email"
                        name="email"
                        type="email"
                        onChange={formik.handleChange}
                        onBlur={formik.handleBlur}
                        value={formik.values.email} />
                        {    
                            formik.touched.email && formik.errors.email ? (
                                <div className="error">{formik.errors.email}</div>
                            ) : null
                        }
                        <label htmlFor="password">Password</label>
                        <input
                        id="password"
                        name="password"
                        type="password"
                        onChange={formik.handleChange}
                        onBlur={formik.handleBlur}
                        value={formik.values.password} />
                        {
                            formik.touched.password && formik.errors.password ? (
                                <div className="error">{formik.errors.password}</div>
                            ) : null
                        }
                        <h4>Are you new user? <Link to="/signup">Signup</Link> </h4> 
                        <button id="loginButton" type="submit">Login</button>
                    </form>
                </div>
            </div>
        </div>
    </div> 
  );
}