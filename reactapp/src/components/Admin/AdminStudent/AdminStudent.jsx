import React, { useState, useEffect } from "react";
import editLogo from "../../../icon/edit.jpg";
import deleteLogo from "../../../icon/delete.jpg";
import UserService from "../../../service/UserService";
import { Link, useNavigate } from "react-router-dom";

const AdminStudent = () => {
  let navigate = useNavigate();
  let [studentList, setStudentList] = useState([]);
  let [search, setSearch] = useState("");
  const loadDataOnlyOnce = () => {
    UserService.viewStudent().then((res) => {
      setStudentList(res.data);
      console.log(res.data);
    });
  };
  useEffect(() => {
    loadDataOnlyOnce();
  }, []);
  const changeSearchHandler = (event) => {
    setSearch(event.target.value);
  };
  const findStudent = () => {
    if (search === "") {
      UserService.viewStudent().then((res) => {
        setStudentList(res.data);
        console.log(studentList);
      });
    }else {
      UserService.FindStudentByName(search).then((res) => {
        setStudentList(res.data);
      });
    }
  };
  const editStudent = (id) => {
    navigate(`updateStudent/${id}`);
  };
  const deleteStudent = (id) => {
    UserService.deleteStudent(id).then((res) => {
      setStudentList(studentList.filter((student)=> student.studentId !== id))
    });
  };
  return (
    <div>
        <div>
          <div className="searchBar">
            <input
              className="search"
              type="text"
              placeholder="Type here to search Student"
              value={search}
              onChange={changeSearchHandler}
            />
            <input
              id="studentSearch"
              type="submit"
              value="Search"
              onClick={() => findStudent()}
            />
          <div id="addStudentBtn"><Link to="adminAddStudent">Add Student</Link></div>
          </div>
          <table>
            <thead>
              <tr>
                <th>Student ID</th>
                <th>Student Name</th>
                <th>Enrolled Course</th>
                <th>Mobile Number</th>
                <th>Action</th>
              </tr>
            </thead>
            <tbody className="studentList">
              {studentList.map((student) => (
                <tr key={student.studentId}>
                  <td> {student.studentId} </td>
                  <td> {student.firstName}</td>
                  <td> {student.enrolledCourse}</td>
                  <td> {student.phoneNumber}</td>
                  <td>
                    <img
                      id="adminEditStudent"
                      alt="editLogo"
                      onClick={() => editStudent(student.studentId)}
                      src={editLogo}
                    />
                    <img
                      id="adminDeleteStudent"
                      alt="deleteLogo"
                      onClick={() => deleteStudent(student.studentId)}
                      src={deleteLogo}
                    />
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
    </div>
  );
}
export default AdminStudent;