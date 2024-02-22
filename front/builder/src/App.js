import './App.css';
import {Route, BrowserRouter as Router, Routes} from "react-router-dom";
import MyNavBar from "./Components/MyNavBar";
import 'bootstrap/dist/css/bootstrap.min.css';
import Home from "./Components/Home";
import Link from "./Components/Link";

function App() {
    return (

        <Router>
            <MyNavBar/>
            <Routes>
                <Route exact path="/" element={<Home/>}/>
                <Route exact path="/link" element={<Link/>}/>
                <Route/>
            </Routes>
        </Router>
    );

}

export default App;
