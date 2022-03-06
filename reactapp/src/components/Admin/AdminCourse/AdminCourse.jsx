import React, { useEffect, useState } from 'react'
import editLogo from '../../../icon/edit.jpg'
import deleteLogo from '../../../icon/delete.jpg'
import UserService from '../../../service/UserService';



import './AdminCourse.css';


const fetchData = async () => {
    const res = await fetch('http://localhost:8082/course/list');
   
   
    console.log(res);
    
    const json = await res.json();
    console.log(json);
    return json;
}


function AdminCourse(props) {
    const [courseList, setCourseList] = useState([])

  useEffect(() => {
    fetchData().then(courseList => {
        setCourseList(courseList)
    })
  }, []);

     const getList = (props, list) => {
        let result = [];
        let rowCount = 1;
        let isAdmin = props.isAdmin;
        console.log(isAdmin);
        if(!list) return ;
        list.forEach(element => {
            result.push(<div class="course-info">
                {/* <div class="course-image"><img class="image" src={"/images/"+element.id+".jpg"} /></div> */}
                <div class = "left-section"> 
                <div class="course-name">{element.name}</div> 
                {/* <div class="course-location">{element.location} </div> */}
                <div class = "course-duration">{element.duration}</div>
                <div class = "course-available-timings">{element.cst}</div>
                </div>
                <div class = "right-section"> 
                <div class = "number-of-students">Number of Students: {element.nos}</div>
                <div class = "course-description">{element.description}</div>
                <div class = "buttons">
                    <img class="edit button" src={"/icon/edit.jpg"} />
                    <img class="delete button" src={"/icon/delete.jpg"} />
                </div>
                </div>
                </div>);
        });
        return result;
    };    
    return (
        <div> 
            <div class = "SearchBar"> <input type = "text" name = "keyword" placeholder="Type here to search course"/>
             <button class = "Search-button"> Search </button></div>
            { getList(props, courseList) }
        </div>
    );
}
export default AdminCourse;