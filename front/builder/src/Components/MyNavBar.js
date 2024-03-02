import React, {useState} from 'react';
import {Button, Container, Form, Modal, Nav, Navbar} from "react-bootstrap";
import axios from "axios";
import {jwtDecode} from "jwt-decode";
import data from "bootstrap/js/src/dom/data";
import styled from "styled-components";
const Styles = styled.div`
  a, .navbar-brand, .navbar-nav {
    color: #abd1b8;

    &:hover {
      color: white;
    }
  }
`
function MyNavBar(props) {
    const [show, setShow] = useState(false);
    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);

    const [login, setLogin] = useState("");
    const [password, setPassword] = useState("");
    const [username, setUsername] = useState(localStorage.getItem("username"));
    const [role, setRole] = useState(localStorage.getItem("role"));
    const [auth, setAuth] = useState(localStorage.getItem("auth"));
    const [showRegistration, setShowRegistration] = useState(false);
    function handLogin() {
        const url = "http://localhost:8080/auth"
        axios.post(url, {
            username: login,
            password: password
        })
            .then(function (response) {
                localStorage.setItem("token", response.data.token)
                const decode = jwtDecode(response.data.token)
                localStorage.setItem("username", decode.sub)
                localStorage.setItem("role", decode.roles[0])
                localStorage.setItem("auth", "true")
                setUsername(decode.sub)
                setRole(decode.roles[0])
                setAuth("true")
                handleClose()
            })
            .catch(function (error) {
                alert("ERROR OUR")
            })
    }

    function handleLogOut() {
        localStorage.clear()
        setUsername("")
        setRole("")
        setAuth("false")

    }
    const handleShowRegistration = () => {  setShowRegistration(true)};

    function handleRegistration(e) {
        e.preventDefault();
        axios.post("http://localhost:8080/registration", {
            login: login,
            password: password
        }).then(function (response) {
            handleRegistrationClose();
        }).catch(function (error) {
            console.log(error);
            alert("Wrong credential")
        });
    }

    function handleRegistrationClose() {setShowRegistration(false)};

    return (
        <>
            <Styles>
            <Navbar expand="lg" bg="dark" variant="dark">
                <Container>
                    <Navbar.Brand href="/">IT-BUILDER</Navbar.Brand>
                    <Navbar.Toggle aria-controls="basic-navbar-nav"/>
                    <Navbar.Collapse id="basic-navbar-nav">
                        <Nav className="me-auto">
                            <Nav.Link href="/">Home</Nav.Link>
                            <Nav.Link href="/link">Link</Nav.Link>
                        </Nav>
                        {
                            auth === "false"
                                ? <>
                                    <Button variant="primary" className="me-2" onClick={handleShow}>Login</Button>
                                    <Button variant="primary" className="me-2" onClick={handleShowRegistration}>Registration</Button>
                                </>
                                : <>
                                {
                                    role==="ROLE_ADMIN"
                                    ?
                                        <Button variant="success" className="me-2" href="/admin">Panel Admin </Button>
                                        :
                                        <> </>
                                }
                                    <Button variant="primary" className="me-2" onClick={handleLogOut}>LogOut</Button>
                                    <Button variant="outline-info" className="me-2">{username}</Button>
                                </>
                        }

                    </Navbar.Collapse>
                </Container>
            </Navbar>
            <Modal show={show} onHide={handleClose}>
                <Modal.Header closeButton>
                    <Modal.Title>Enter in system</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <Form>
                        <Form.Group className="mb-3" controlId="formBasicEmail">
                            <Form.Label>Login</Form.Label>
                            <Form.Control type="text" placeholder="Enter login"
                                          onChange={(e) => setLogin(e.target.value)}/>
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBasicPassword">
                            <Form.Label>Password</Form.Label>
                            <Form.Control type="password" placeholder="Password"
                                          onChange={(e) => setPassword(e.target.value)}/>
                        </Form.Group>
                    </Form>
                </Modal.Body>
                <Modal.Footer>
                    <Button variant="secondary" onClick={handleClose}>
                        Close
                    </Button>
                    <Button variant="primary" onClick={handLogin}>
                        Login
                    </Button>
                </Modal.Footer>
            </Modal>
                <Modal show={showRegistration} onHide={handleRegistrationClose}>
                    <Modal.Header closeButton>
                        <Modal.Title>Registration</Modal.Title>
                    </Modal.Header>
                    <Modal.Body>
                        <Form>
                            <Form.Group controlId="fromBasicTextReg">
                                <Form.Label>Login</Form.Label>
                                <Form.Control type="text" placeholder="Enter login"
                                              onChange={(e) => setLogin(e.target.value)}/>
                                <Form.Text className='text-muted'>We'll never share your login</Form.Text>
                            </Form.Group>
                            <Form.Group controlId="fromBasicPasswordReg">
                                <Form.Label>Password</Form.Label>
                                <Form.Control type="password" placeholder="Enter password"
                                              onChange={(e) => setPassword(e.target.value)}/>
                            </Form.Group>
                            <Form.Group controlId="fromBasicCheckBox">
                                <Form.Check type="checkbox" label="Remember me"/>
                            </Form.Group>
                        </Form>
                    </Modal.Body>
                    <Modal.Footer>
                        <Button variant="primary" onClick={handleRegistration}>Registration</Button>
                    </Modal.Footer>
                </Modal>
            </Styles>
        </>
    );
}

export default MyNavBar;