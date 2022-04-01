import axios from "axios";
import { toast } from "react-toastify";
import { useNavigate } from 'react-router';
import axios1 from "axios";

const REST_API_URL = "http://localhost:8081";

axios.interceptors.request.use(function (config ) {
  const token = localStorage.getItem('token');
  if (token) {
    config.headers.Authorization = `Bearer ${token}`;
  }
  return config;
}, function (error) {
  return Promise.reject(error);
});

axios.interceptors.response.use(response => response, error => {
  if (error.response.status === 403 ){
    toast.warn("Session Expired !!")
    localStorage.clear();
    window.location.href = '/login';
  }
});

class UserService {

  // Login and SignUp
  createUser(user) {
    return axios1.post(REST_API_URL + "/signup", user);
  }
  authenticateUser(userDetails) {
    return axios1.post(REST_API_URL + "/authenticate", userDetails);
  }
  login(userName, password) {
    return axios.get(
      REST_API_URL + "/login/"+ userName +"/"+ password
    );
  }
  checkUserMailId(email) {
    return axios1.get(REST_API_URL + "/checkUserMailId/" + email);
  }
  checkUserName(userName) {
    return axios1.get(REST_API_URL + "/checkUsername/" + userName);
  }

  //Student CURD Operation
  AddStudent(student) {
    return axios.post(REST_API_URL + "/admin/addStudent", student);
  }
  UpdateStudent(id, student) {
    return axios.put(REST_API_URL + "/admin/editStudent/" + id, student);
  }
  FindStudentByName(search) {
    return axios.get(REST_API_URL + "/admin/findByStudent/name/" + search);
  }
  FindStudentById(id) {
    return axios.get(REST_API_URL + "/admin/findStudent/" + id);
  }
  FindByStudentById(id) {
    return axios.get(REST_API_URL + "/admin/findByStudent/" + id);
  }
  viewStudent() {
    return axios.get(REST_API_URL + "/admin/viewStudent");
  }
  deleteStudent(id) {
    return axios.delete(REST_API_URL + "/admin/deleteStudent/" + id);
  }
  checkStudentMailId(email) {
    return axios.get(REST_API_URL + "/admin/checkStudentMailId/" + email);
  }
  findStudentIdByEmail(email) {
    return axios.get(REST_API_URL + "/admin/getStudentId/" + email);
  }
  //Course
  addCourse(course) {
    return axios.post(REST_API_URL + "/admin/addCourse", course);
  }
  viewCourse() {
    return axios.get(REST_API_URL + "/admin/viewCourse");
  }
  updateCourse(id, course) {
    return axios.put(REST_API_URL + "/admin/editCourse/" + id, course);
  }
  deleteCourse(id) {
    return axios.delete(REST_API_URL + "/admin/deleteCourse/" + id);
  }
  findCourseByAcademyName(search) {
    return axios.get(REST_API_URL + "/admin/getCourseByAcademyName/" + search);
  }
  findCourseByName(search) {
    return axios.get(REST_API_URL + "/admin/findByCourse/" + search);
  }
  findCourseById(id) {
    return axios.get(REST_API_URL + "/admin/findCourse/" + id);
  }

  //Academy
  addAcademy(academy) {
    return axios.post(REST_API_URL + "/admin/addAcademy", academy);
  }
  viewAcademy() {
    return axios.get(REST_API_URL + "/admin/viewAcademy");
  }
  updateAcademy(id, academy) {
    return axios.put(REST_API_URL + "/admin/editAcademy/" + id, academy);
  }
  viewAcademyById(id) {
    return axios.get(REST_API_URL + "/admin/findAcademy/" + id);
  }
  viewAcademyByName(name) {
    return axios.get(REST_API_URL + "/admin/findByAcademy/" + name);
  }
  deleteAcademy(id) {
    return axios.delete(REST_API_URL + "/admin/deleteAcademy/" + id);
  }
  checkAcademyName(name) {
    return axios.get(REST_API_URL + "/admin/checkAcademyName/" + name);
  }

  //Admission
  addAdmission(emailId, admissionDetails) {
    return axios.put(REST_API_URL + "/admin/addAdmission/"+ emailId, admissionDetails);
  }
  viewAdmission() {
    return axios.get(REST_API_URL + "/admin/viewAdmissionTable");
  }
  viewAdmissionById(id) {
    return axios.get(REST_API_URL + "/admin/viewAdmission/" + id);
  }
  checkAdmission(emailId, course) {
    return axios.get(REST_API_URL + "/admin/checkAdmission/" + emailId + "/" + course);
  }
  deleteAdmission(id) {
    return axios.delete(REST_API_URL + "/admin/deleteAdmission/" + id);
  }
  //Review
  addReview(review) {
    return axios.post(REST_API_URL + "/admin/addReview", review);
  }
  editReview(id, review) {
    return axios.put(REST_API_URL + "/admin/editReview/"+id, review);
  }
  findReview(id) {
    return axios.get(REST_API_URL + "/admin/viewReview/"+id);
  }
  checkReview(id) {
    return axios.get(REST_API_URL + "/admin/checkReview/"+id);
  }
}
export default new UserService();
