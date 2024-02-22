import React from 'react';
import {Button, Container, Nav, Navbar, NavDropdown} from "react-bootstrap";

function MyNavBar(props) {
    return (
        <Navbar expand="lg" bg="dark" variant="dark">
            <Container>
                <Navbar.Brand href="#home">IT-BUILDER</Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav"/>
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="me-auto">
                        <Nav.Link href="/">Home</Nav.Link>
                        <Nav.Link href="/link">Link</Nav.Link>
                    </Nav>
                    <Button variant="primary" className="me-2">Enter</Button>
                    <Button variant="primary" className="me-2">Registration</Button>
                </Navbar.Collapse>
            </Container>
        </Navbar>
    );
}

export default MyNavBar;