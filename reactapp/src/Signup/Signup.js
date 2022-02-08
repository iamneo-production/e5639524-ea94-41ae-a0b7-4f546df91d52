import React from 'react';
import{Formik,Form,Field,ErrorMessage,FastField} from 'formik';
import * as Yup from 'yup'


function Signup() {
    const initialValues={
        email:'',
        username:'',
        mobileNumber:'',
        password:'',
        confirmPassword:'',
        userRole:'user'
        
  }
    const phoneRegExp = /^(\+\d{1,3}[- ]?)?\d{10}$/
    const validationSchema=Yup.object({
        email:Yup.string().email('Invalid email Format').required('Please enter your email'),
        username:Yup.string().required('Please enter your username'),
        mobileNumber: Yup.string().matches(phoneRegExp, 'Mobile number is not valid').required(' Please enter your mobile number'),
        password:Yup.string().required('Please enter your password'),
        confirmPassword:Yup.string().oneOf([Yup.ref('password'),''],'Passwords did not match').required('Enter your password again')
    })

    const onSubmit=(values,{resetForm})=>{
        console.log('form values',values);
        alert("You have Registered Successfully!");
        resetForm({values:''})
    }
   
  return <Formik 
  initialValues={initialValues}
  validationSchema={validationSchema}
  onSubmit={onSubmit}
  
>
    {}
    <div className="col-md-4 col-md-offset-4 ">
      <Form>
        <h3 className="text-center">Register</h3>
       <div className="form-group">
          <Field
            type="email"
            id="email"
            name="email"
            className="form-control"
            placeholder="Enter email"          
          />
         <ErrorMessage name="email" />
        </div>

        <div className="form-group">
          <Field
            type="text"
            id="username"
            name="username"
            className="form-control"
            placeholder="Enter username"          
          />
         <ErrorMessage name="username" />
        </div>
        <div className="form-group">
          <FastField
            type="text"
            id="mobileNumber"
            name="mobileNumber"
            className="form-control"
            placeholder="Enter MobileNumber"          
          />
         <ErrorMessage name="mobileNumber" />
        </div>


        <div className="form-group">
          <Field
            type="password"
            name="password"
            id="password"
            
            className="form-control"
            placeholder="Password"
          />
        <ErrorMessage name="password" />
        </div>

        <div className="form-group">
          <Field
            type="password"
            name="confirmPassword"
            id="confirmPassword"            
            className="form-control"
            placeholder="Confirm Password"
          />
        <ErrorMessage name="confirmPassword" />
        </div>

        <button
          type="submit"
          name="submit"
    
          id="submitButton"
          className="btn btn-success btn-block"

        >
          Submit
        </button>
        <p className="forgot-password text-center"
        id="submitButton">
          Already a user ? <a href="#" id="signinLink">Login</a>
        </p>
      </Form>
      </div>


  </Formik>
  
}

export default Signup;
