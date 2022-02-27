import axios from "axios";

const REST_API_URL = "http://localhost:8081";
class UserService {
  createUser(user) {
    return axios.post(REST_API_URL + "/signup", user);
  }
  login(email, password) {
    return axios.get(
      REST_API_URL + "/login?email=" + email + "&password=" + password
    );
  }

  //Student CURD Operation
  AddStudent(student) {
    return axios.post(REST_API_URL + "/admin/addStudent", student);
  }
  UpdateStudent(id, student) {
    return axios.put(REST_API_URL + "/admin/admin/editStudent/"+id, student);
  }
  FindStudentByName(search) {
    return axios.get(REST_API_URL + "/admin/findByStudent/name/" + search);
  }
  FindStudentById(id) {
    return axios.get(REST_API_URL + "/admin/findStudent/" + id);
  }
  viewStudent() {
    return axios.get(REST_API_URL + "/admin/viewStudent");
  }
  deleteStudent(id) {
    return axios.delete(REST_API_URL + "/admin/deleteStudent/" + id);
  }
  //Course

  addCourse(course){
    return axios.post(REST_API_URL + '/admin/addCourse', course);
  }
  
  viewCourse() {
    return axios.get(REST_API_URL + '/admin/viewCourse');
  }
  findCourseByAcademyName(search) {
    return axios.get( REST_API_URL + '/admin/getCourseByAcademy/' + search);
  }
  findCourseByName(search) {
    return axios.get( REST_API_URL + '/admin/findByCourse/' + search);
  }
  //Academy
  viewAcademy() {
    return axios.get(REST_API_URL + '/admin/viewAcademy');
  }
  //Admission
  addAdmission(admission) {
    return axios.post(REST_API_URL + '/admin/addAdmission', admission);
  }
  viewAdmission() {
    return axios.get(REST_API_URL + '/admin/viewAdmission');
  }
}
export default new UserService();
