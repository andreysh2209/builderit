import './App.css';
import {Route, BrowserRouter as Router, Routes} from "react-router-dom";
import MyNavBar from "./Components/MyNavBar";
import 'bootstrap/dist/css/bootstrap.min.css';
import Home from "./Components/Home";
import Link from "./Components/Link";
import PanelAdmin from "./Components/PanelAdmin";
import AddWorkGroup from "./Components/AddWorkGroup";
import AddSubWorkGroup from "./Components/AddSubWorkGroup";

function App() {
    return (

        <Router>
            <MyNavBar/>
            <Routes>
                <Route exact path="/" element={<Home/>}/>
                <Route exact path="/link" element={<Link/>}/>
                <Route exact path="/admin" element={<PanelAdmin/>}/>
                <Route exact path="/addWorkGroup" element={<AddWorkGroup/>}/>
                <Route exact path="/addSubWorkGroup" element={<AddSubWorkGroup/>}/>
            </Routes>
        </Router>
    );

}

export default App;
