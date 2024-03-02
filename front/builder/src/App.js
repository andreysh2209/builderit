import logo from './logo.svg';
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

function App() {
  return (
      <Router>
        <MyNavBar/>
        <Routes>
          <Route exact path="/" element={<Home/>}/>
          <Route exact path="/link" element={<Link/>}/>
          {/*<Route exact path="/about" element={<About/>}/>*/}
          <Route exact path="/admin" element={<PanelAdmin/>}/>
          <Route exact path="/addWorkGroup" element={<AddWorkGroup/>}/>
          <Route exact path="/addSubWorkGroup" element={<AddSubWorkGroup/>}/>
          {/*<Route exact path="/addComponent" element={<AddComponentForm/>}/>*/}
          {/*<Route exact path="/addProduct" element={<AddProduct/>}/>*/}
          {/*<Route exact path="/getListProduct" element={<ListProducts/>}/>*/}
          {/*<Route exact path="/departDetails/:id" element={<DepartDetails/>} />*/}
          {/*<Route exact path="/basket" element={<MyBasket/>} />*/}
          {/*<Route exact path="/getListComponents" element={<ListComponents/>} />*/}
          {/*<Route exact path="/sales" element={<Sales/>} />*/}
        </Routes>
        {/*<Footer/>*/}
      </Router>
  );
}

export default App;
