import React from 'react';
import {Col, Row} from "react-bootstrap";
import LeftMenuUser from "./LeftMenuUser";

function PanelUser(props) {
    return (
        <Row>
            <Col sm={2}><LeftMenuUser/></Col>
            <Col sm={10}></Col>

        </Row>
    );
}

export default PanelUser;