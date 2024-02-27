import React from 'react';
import {Nav} from "react-bootstrap";

function LeftMenuAdmin(props) {
    return (
        <>
            <Nav
                defaultActiveKey="/admin" className="flex-column"
            >
                <Nav.Item>
                    <Nav.Link href="/addWorkGroup">AddWorkGroup</Nav.Link>
                </Nav.Item>
                <Nav.Item>
                    <Nav.Link href="/addSubWorkGroup">AddSubGroup</Nav.Link>
                </Nav.Item>
                <Nav.Item>
                    <Nav.Link >AddTypeGroup</Nav.Link>
                </Nav.Item>
            </Nav>
        </>
    );
}

export default LeftMenuAdmin;