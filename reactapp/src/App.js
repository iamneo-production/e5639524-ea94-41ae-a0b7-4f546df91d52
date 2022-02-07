import './App.css';
import { Formik } from "formik";

function App() {
  var a = 10;
  return (
    <div className="hello">
      <input type="text" placeholder="Enter Name"/>
      <input type="button" value="Submit" />
      <h1>Hello World{a}</h1>
    </div>
  );
}

export default App;
