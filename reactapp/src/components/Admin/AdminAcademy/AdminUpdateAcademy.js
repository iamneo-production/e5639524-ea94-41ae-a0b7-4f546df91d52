import React, { useState, useEffect } from 'react'
import { useFormik } from 'formik';
import * as Yup from 'yup';
import "../AdminUpdateAcademy.css";
import UserService from '/service/UserService';
import { useNavigate } from 'react-router-dom';

export default function AdminUpdateAcademy() {

    let navigation = useNavigate();
    const [initialValues, setInitialValues] = useState([]);

    const loadDataOnlyOnce = () => {
        UserService.FindStudentById(academyId).then((res) => {
          const updateAcademy = {
            academyName: res[0].data.academyName,
            contactNumber: res[0].data.contactNumber,
            imageUrl: res[0].data.imageUrl,
            emailId: res[0].data.emailId,
            academyLocation: res[0].academyLocation,
            academyDescription: res[0].academyDescription          
        };
        console.log(updateAcademy)
        setInitialValues(updateAcademy);
      });
    };
    useEffect(() => {
      loadDataOnlyOnce();
    }, []);    

    const formik = useFormik({

        initialValues: initialValues,
        enableReinitialize: true,

        validationSchema: Yup.object({
            academyName: Yup.string()
                .min(3, "Enter a Valid Name")
                .max(20, "Enter a Valid Name")
                .required("Required"),
            contactNumber: Yup.string()
                .min(10, "Enter a valid number")
                .max(10, "Enter a valid number")
                .required("Required"),
            imageUrl: Yup.string()
                .required("Please enter the Url"),
            emailId: Yup.string()
                .email("Enter a valid emailId")
                .required("Enter a valid emailId"),
            academyLocation: Yup.string()
                .min(3, "Enter a valid Location")
                .max(15, "Enter a valid Location")
                .required("Required"),
            academyDescription: Yup.string()
                .min(5, "Enter a valid Description")
                .max(200, "Enter a valid Description")
                .required("Required")
        }),

        onSubmit: (values) => {
            console.log(formik.values);
            UserService.UpdateStudent(acadmeyId, values).then((res) => {
                alert("Academy Updated Successfully")
                navigation(-1);
            });
        }
    })

    return (
        <div>
            <form onSubmit={formik.handleSubmit}>
                <div className='MainDiv'>

                    <div>
                        <label htmlFor='academyName'>Academy Name </label>
                        <input
                            id='editAcademyName'
                            type='text'
                            name='academyName'
                            placeholder='Enter Academy Name'
                            onChange={formik.handleChange}
                            onBlur={formik.handleBlur}
                            values={formik.values.academyName || ""}
                        />
                        {formik.touched.academyName && formik.errors.academyName ? <p>{formik.errors.academyName}</p> : null}
                    </div>

                    <div>
                        <label htmlFor='contactNumber'>Contact Number </label>
                        <input
                            id='editContactNumber'
                            type='text'
                            pattern='\d*'
                            name='contactNumber'
                            placeholder='Enter the Contact Number'
                            onChange={formik.handleChange}
                            onBlur={formik.handleBlur}
                            values={formik.values.contactNumber || ""}
                        />
                        {formik.touched.contactNumber && formik.errors.contactNumber ? <p>{formik.errors.contactNumber}</p> : null}
                    </div>

                    <div>
                        <label htmlFor='imageUrl'>Image Url </label>
                        <input
                            id='editImageUrl'
                            type='url'
                            name='imageUrl'
                            placeholder='Enter Image Url'
                            onChange={formik.handleChange}
                            onBlur={formik.handleBlur}
                            values={formik.values.imageUrl || ""}
                        />
                        {formik.touched.imageUrl && formik.errors.imageUrl ? <p>{formik.errors.imageUrl}</p> : null}
                    </div>

                    <div>
                        <label htmlFor='emailId'>Academy Email Id </label>
                        <input
                            id='editEmailId'
                            type='email'
                            name='emailId'
                            placeholder='Enter Academy Email'
                            onChange={formik.handleChange}
                            onBlur={formik.handleBlur}
                            values={formik.values.emailId || ""}
                        />
                        {formik.touched.emailId && formik.errors.emailId ? <p>{formik.errors.emailId}</p> : null}
                    </div>

                    <div>
                        <label htmlFor='academyLocation'>Academy Location </label>
                        <input
                            id='editAcademyLocation'
                            type='text'
                            name='academyLocation'
                            placeholder='Enter Academy Location'
                            onChange={formik.handleChange}
                            onBlur={formik.handleBlur}
                            values={formik.values.academyLocation || ""}
                        />
                        {formik.touched.academyLocation && formik.errors.academyLocation ? <p>{formik.errors.academyLocation}</p> : null}
                    </div>

                    <div>
                        <label htmlFor='academyDescription'>Academy Description </label>
                        <input
                            id='editAcademyDescription'
                            type='text'
                            name='academyDescription'
                            placeholder='Enter Academy Description'
                            onChange={formik.handleChange}
                            onBlur={formik.handleBlur}
                            values={formik.values.academyDescription || ""}
                        />
                        {formik.touched.academyDescription && formik.errors.academyDescription ? <p>{formik.errors.academyDescription}</p> : null}
                    </div>
                </div>

                <button id='updateAcademy' type='submit'>
                    Update Academy
                </button>

            </form>

        </div>
    )
}
