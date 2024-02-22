import React from 'react';
import {Nav} from "react-bootstrap";

function LeftMenu(props) {
    return (
        <>
            <Nav
                defaultActiveKey="/home" className="flex-column"
            >
                <Nav.Item>
                    <Nav.Link href="/home">Active</Nav.Link>
                </Nav.Item>
                <Nav.Item>
                    <Nav.Link href="/link">Link</Nav.Link>
                </Nav.Item>
                <Nav.Item>
                    <Nav.Link eventKey="disabled" disabled>
                        Disabled
                    </Nav.Link>
                </Nav.Item>
            </Nav>
        </>
    );
}

export default LeftMenu;