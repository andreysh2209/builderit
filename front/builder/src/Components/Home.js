import React from 'react';
import {Col, Row} from "react-bootstrap";
import LeftMenu from "./LeftMenu";
import Slider from "./Slider";

function Home(props) {
    return (
        <Row>
            <Col sm={2}><LeftMenu/></Col>
            <Col sm={2} className="bg-info-subtle"></Col>
            <Col sm={6}><Slider/></Col>
            <Col sm={2}></Col>
        </Row>
    );
}

export default Home;