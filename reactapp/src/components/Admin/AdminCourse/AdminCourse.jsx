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
  const refreshData= ()=> {  //func for fc
    fetchData().then(courseList => {
        setCourseList(courseList); 
    });

     };
     const getList = (props, list) => {
        let result = [];
        let rowCount = 1;
        let isAdmin = props.isAdmin;
        console.log(isAdmin);
        if(!list) return ;
        list.forEach(element => {
            result.push(<div class="course-info">
                <div class="course-image"><img class="image" src={"/images/"+element.id+".jpg"} /></div>
                <div class="course-name">{element.name}</div> 
                <div class="course-location">{element.location}</div>
                <div class = "course-duration">{element.duration}</div>
                </div>);
        });
        return result;
    };    
    return (
        <div> 
            <div class = "SearchBar">Search: <input type = "text" name = "keyword" placeholder="Search courses"/> </div>
            { getList(props, courseList) }
        </div>
    );
}


export default AdminCourse;
