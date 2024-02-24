import React from 'react';
import {Col, Row} from "react-bootstrap";
import LeftMenuAdmin from "./LeftMenuAdmin";

function PanelAdmin(props) {
    return (
        <Row>
            <Col sm={2}><LeftMenuAdmin/></Col>
            <Col sm={10}></Col>

        </Row>
    );
}

export default PanelAdmin;