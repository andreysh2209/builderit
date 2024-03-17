import './App.css';
import MyNavBar from "./Components/MyNavBar";
import 'bootstrap/dist/css/bootstrap.min.css';
import 'mdb-react-ui-kit/dist/css/mdb.min.css';
import "@fortawesome/fontawesome-free/css/all.min.css";
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom'
import Home from "./Components/Home";
import Link from "./Components/Link";
import PanelAdmin from "./Components/PanelAdmin";
import AddWorkGroup from "./Components/AddWorkGroup";
import AddSubWorkGroup from "./Components/AddSubWorkGroup";
import AddWorkType from "./Components/AddWorkType";
import AddMaterial from "./Components/AddMaterial";
import AddCategoryMaterial from "./Components/AddCategoryMaterial";
import AddSubCategoryMaterial from "./Components/AddSubCategoryMaterial";

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
          <Route exact path="/addWorkType" element={<AddWorkType/>}/>
          <Route exact path="/addMaterial" element={<AddMaterial/>}/>
          <Route exact path="/addCategoryMaterial" element={<AddCategoryMaterial/>}/>
          <Route exact path="/addSubCategoryMaterial" element={<AddSubCategoryMaterial/>}/>
        </Routes>
      </Router>
  );
}

export default App;
