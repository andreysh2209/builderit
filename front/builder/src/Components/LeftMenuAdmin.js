import React from 'react';
import {Nav} from "react-bootstrap";

function LeftMenuAdmin(props) {
    return (
        <>
            <Nav variant="pils" className="flex-column mt-2" defaultActiveKey="/admin">
                <Nav.Item>
                    <Nav.Link href="/addWorkGroup"><h2>AddWorkGroup</h2></Nav.Link>
                </Nav.Item>
                <Nav.Item>
                    <Nav.Link href="/addSubWorkGroup"><h2>AddSubGroup</h2></Nav.Link>
                </Nav.Item>
                <Nav.Item>
                    <Nav.Link href="/addWorkType"><h2>AddWorkType</h2></Nav.Link>
                </Nav.Item>
                <Nav.Item>
                    <Nav.Link href="/addCategoryMaterial"><h2>AddCategoryMaterial</h2></Nav.Link>
                </Nav.Item>
                <Nav.Item>
                    <Nav.Link href="/addMaterial"><h2>AddMaterial</h2></Nav.Link>
                </Nav.Item>
            </Nav>
        </>
    );
}

export default LeftMenuAdmin;