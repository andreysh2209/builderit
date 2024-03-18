import React from 'react';
import {Nav} from "react-bootstrap";

function LeftMenuUser(props) {
    return (
        <Nav variant="pils" className="flex-column mt-2" defaultActiveKey="/admin">
            <Nav.Item>
                <Nav.Link href="/addApartment"><h2>Add Apartment</h2></Nav.Link>
            </Nav.Item>
       
        </Nav>
    );
}

export default LeftMenuUser;