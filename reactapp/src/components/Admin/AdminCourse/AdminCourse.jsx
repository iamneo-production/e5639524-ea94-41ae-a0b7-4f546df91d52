import React, { useEffect, useState } from "react";
import UserService from "../../../service/UserService";
import { Card, Button, ButtonGroup } from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";
import { Link, useNavigate } from "react-router-dom";
import { toast } from "react-toastify";
import { Rating } from "react-simple-star-rating";

export default function AdminCourse() {
  let [course, setCourse] = useState([]);
  let [search, setSearch] = useState("");
  let navigate = useNavigate();
  const loadDataOnlyOnce = () => {
    UserService.viewCourse().then((res) => {
      setCourse(res.data);
      console.log(res.data);
    });
  };

  const editCourse = (id) => {
    navigate(`updateCourse/${id}`);
  };
  const deleteCourse = (id) => {
    UserService.deleteCourse(id).then((res) => {
      toast("Course Deleted Sucessfully");
      setCourse(course.filter((course) => course.courseId !== id));
    });
  };

  useEffect(() => {
    loadDataOnlyOnce();
  }, []);

  const changeSearchHandler = (event) => {
    setSearch(event.target.value);
  };
  const findCourse = () => {
    if (search === "") {
      UserService.viewCourse().then((res) => {
        setCourse(res.data);
        console.log(res.data);
      });
    } else {
      UserService.findCourseByName(search).then((res) => {
        setCourse(res.data);
      });
    }
  };

  return (
    <div>
      <div className="searchBar">
        <input
          className="search"
          type="text"
          placeholder="Type here to search Course"
          value={search}
          onChange={changeSearchHandler}
        />
        <input
          id="courseSearch"
          type="submit"
          value="Search"
          onClick={() => findCourse()}
        />
        <span id="addCourseBtn">
          <Link to="adminAddCourse">Add Course</Link>
        </span>
      </div>
      <div className="courseGrid">
        {course.map((course, i) => (
          <React.Fragment key={i}>
            <Card className="courseElement">
              <Card.Title className="courseCardTitle">
                {course.courseName}
              </Card.Title>
              <Card.Body className="courseCardGrid">
                <Card.Title>Academy Name : </Card.Title>
                <Card.Text>{course.academy.academyName}</Card.Text>
                <Card.Title>Course Duration :</Card.Title>
                <Card.Text>{course.courseDuration}</Card.Text>
                <Card.Title>Available Timing :</Card.Title>
                <Card.Text>
                  {course.startTime} to {course.endTime}
                </Card.Text>
                <Card.Title>No of Students Enrolled :</Card.Title>
                <Card.Text>{course.noOfStudents}</Card.Text>
                <Card.Title>Description :</Card.Title>
                <Card.Text>{course.courseDescription}</Card.Text>
                <div>
                  <Rating
                    initialValue={course.rating}
                    fillColorArray={['#f17a45', '#f19745', '#f1a545', '#f1b345', '#f1d045']}
                    allowHalfIcon
                    readonly={course.rating > 0 || course.rating === 0}
                    allowHover={false}
                  />
                </div>
                <ButtonGroup className="cardButton">
                  <Button
                    id="editCourse"
                    onClick={() => editCourse(course.courseId)}
                    variant="primary"
                  >
                    Edit
                  </Button>
                  <Button
                    id="deleteCourse"
                    onClick={() => deleteCourse(course.courseId)}
                    variant="primary"
                  >
                    Delete
                  </Button>
                </ButtonGroup>
              </Card.Body>
            </Card>
          </React.Fragment>
        ))}
      </div>
    </div>
  );
}
