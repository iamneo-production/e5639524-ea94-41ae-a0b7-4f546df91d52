import React from "react";
import { useFormik } from "formik";
import * as Yup from "yup";
import "../App.css";
import { useNavigate } from "react-router";
import UserService from "../../../service/UserService";
import { toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

export default function AddAcademy() {
  let navigation = useNavigate();

  const formik = useFormik({
    initialValues: {
      academyName: "",
      academyImageUrl: "",
      academyLocation: "",
      academyMobileNo: "",
      academyEmail: "",
      academyDescription: "",
    },
    validationSchema: Yup.object({
      academyEmail: Yup.string()
        .email("Invalid email Format *")
        .required("Please enter your Academy Email *"),
      academyName: Yup.string()
        .min(3, "At least 3 Characters required")
        .max(20, "Maximum Characters allowed is 20")
        .required("Please enter your Academy Name *"),
      academyMobileNo: Yup.string()
        .matches(/^(\+\d{1,3}[- ]?)?\d{10}$/, "Contact number is not valid *")
        .required(" Please enter your Academy Contact number *"),
      academyImageUrl: Yup.string()
        .matches(
          /^http[^\?]*.(jpg|jpeg|gif|png|tiff|bmp)(\?(.*))?$/,
          "Please Enter correct Url"
        )
        .required("Please enter your ImageUrl *"),
      academyLocation: Yup.string()
        .required("Enter your Academy Location *")
        .min(3, "At least 3 characters required")
        .max(20, "Maximum Characters allowed is 20"),
      academyDescription: Yup.string()
        .required("Enter the Academy Description")
        .min(5, "Too short Description")
        .max(200, "Maximum Characters allowed is 200"),
    }),
    onSubmit: (values) => {
      UserService.addAcademy(values).then((res) => {
        toast.success("New Academy Added Successfully");
        formik.resetForm();
        navigation(-1);
        console.log(res.data);
      });
    },
  });
  return (
    <div>
      <h2 className="headingAddCourse">Add Academy</h2>
      <form onSubmit={formik.handleSubmit}>
        <div className="MainDiv">
          <div>
            <label htmlFor="academyName">Academy Name </label>
            <input
              id="editAcademyName"
              type="text"
              name="academyName"
              placeholder="Enter Academy Name"
              onChange={formik.handleChange}
              onBlur={formik.handleBlur}
              values={formik.values.academyName || ""}
            />
            {formik.touched.academyName && formik.errors.academyName ? (
              <p id="error">{formik.errors.academyName}</p>
            ) : null}
          </div>

          <div>
            <label htmlFor="contactNumber">Contact Number </label>
            <input
              id="contactNumber"
              type="text"
              pattern="\d*"
              name="academyMobileNo"
              placeholder="Enter the Contact Number"
              onChange={formik.handleChange}
              onBlur={formik.handleBlur}
              values={formik.values.contactNumber || ""}
            />
            {formik.touched.academyMobileNo && formik.errors.academyMobileNo ? (
              <p id="error">{formik.errors.academyMobileNo}</p>
            ) : null}
          </div>

          <div>
            <label htmlFor="imageUrl">Image Url </label>
            <input
              id="imageUrl"
              type="url"
              name="academyImageUrl"
              placeholder="Enter Image Url"
              onChange={formik.handleChange}
              onBlur={formik.handleBlur}
              values={formik.values.academyImageUrl || ""}
            />
            {formik.touched.academyImageUrl && formik.errors.academyImageUrl ? (
              <p id="error">{formik.errors.academyImageUrl}</p>
            ) : null}
          </div>

          <div>
            <label htmlFor="emailId">Academy Email Id </label>
            <input
              id="emailId"
              type="email"
              name="academyEmail"
              placeholder="Enter Academy Email"
              onChange={formik.handleChange}
              onBlur={formik.handleBlur}
              values={formik.values.academyEmail || ""}
            />
            {formik.touched.academyEmail && formik.errors.academyEmail ? (
              <p id="error">{formik.errors.academyEmail}</p>
            ) : null}
          </div>

          <div>
            <label htmlFor="academyLocation">Academy Location </label>
            <input
              id="academyLocation"
              type="text"
              name="academyLocation"
              placeholder="Enter Academy Location"
              onChange={formik.handleChange}
              onBlur={formik.handleBlur}
              values={formik.values.academyLocation || ""}
            />
            {formik.touched.academyLocation && formik.errors.academyLocation ? (
              <p id="error">{formik.errors.academyLocation}</p>
            ) : null}
          </div>

          <div>
            <label htmlFor="academyDescription">Academy Description </label>
            <input
              id="academyDescription"
              type="text"
              name="academyDescription"
              placeholder="Enter Academy Description"
              onChange={formik.handleChange}
              onBlur={formik.handleBlur}
              values={formik.values.academyDescription || ""}
            />
            {formik.touched.academyDescription &&
            formik.errors.academyDescription ? (
              <p id="error">{formik.errors.academyDescription}</p>
            ) : null}
          </div>
          <div></div>
          <button id="addAcademy" type="submit">
            Add Academy
          </button>
        </div>
      </form>
    </div>
  );
}
