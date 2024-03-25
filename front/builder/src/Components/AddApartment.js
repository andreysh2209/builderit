import React, {useEffect, useState} from 'react';
import {Button, Col, Form, Modal, Row, Table} from "react-bootstrap";
import LeftMenuUser from "./LeftMenuUser";
import axios from "axios";

function AddApartment(props) {
    const [name, setName] = useState("");
    const [rooms, setRooms] = useState([]);
    const [show, setShow] = useState(false);
    const [showDoor, setShowDoor] = useState(false);
    const [showWindows, setShowWindows] = useState(false);
    const [roomTypes, setRoomTypes] = useState([])
    const [roomType, setRoomType] = useState()
    const [width, setWidth] = useState(0)
    const [widthDoor, setWidthDoor] = useState(0)
    const [widthWindow, setWidthWindow] = useState(0)
    const [length, setLength] = useState(0)
    const [height, setHeight] = useState(0)
    const [heightDoor, setHeightDoor] = useState(0)
    const [heightWindow, setHeightWindow] = useState(0)
    const [addedRoms, setAddedRooms] = useState([])
    const [addedDoors, setAddedDoors] = useState([])
    const [addedWindows, setAddedWindows] = useState([])
    const handleClose = () => setShow(false);
    const handleShow = () => {
        setShow(true)
    };
    const handleCloseDoor = () => setShowDoor(false);
    const handleShowDoor = () => {
        setShowDoor(true)
    };

    function handleShowWindows() {
        setShowWindows(true);
    }

    const handleCloseWindows = () => setShowWindows(false);

    useEffect(() => {
        const url = "http://localhost:8080/api/v1/apartments/getRoomTypes"
        axios.get(url, {
                headers: {
                    "Authorization": "Bearer " + localStorage.getItem("token")
                }
            }
        )
            .then(function (response) {
                setRoomTypes(response.data)
                setRoomType(response.data[0])
                console.log(response.data)
            })
            .catch(function (error) {
                console.log(error)
            })
    }, [setRoomTypes]);


    function handleAddRoom() {
        const room = {
            roomType: roomType,
            width: width,
            length: length,
            height: height,
            doors: addedDoors,
            windows: addedWindows
        };
        addedRoms.push(room)
        setAddedDoors([])
        setAddedWindows([])
        setShow(false)

    }

    function handleAddDoor() {
        const door = {
            width: widthDoor,
            height: heightDoor
        };
        addedDoors.push(door)
        setShowDoor(false)
    }

    function handleAddApartment() {
        console.log(addedRoms)
        const url = "http://localhost:8080/api/v1/apartments/addAppartment"

        function validate() {
            return true;
        }

        if (validate()) {
            axios.post(url, {
                name: name,
                rooms: addedRoms
            }, {
                headers: {
                    "Authorization": "Bearer " + localStorage.getItem("token")
                }
            })
                .then(function (response) {
                    handleShow()
                })
                .catch(function (error) {
                    alert("ERROR OUR")
                })
        } else {
            alert("Необходимо заполнить все поля")
        }
    }


    function handleAddWindow() {
        const window = {
            width: widthWindow,
            height: heightWindow
        };
        addedWindows.push(window)
        console.log(addedWindows)
        setShowWindows(false)
    }

    return (
        <>
            <Row>
                <Col sm={2}><LeftMenuUser/></Col>
                <Col sm={10}>
                    <h1 style={{color: "royalblue"}}><b>Add Apartment</b></h1>
                    <br/>
                    <Form>
                        <Form.Group className="mb-3" controlId="formBasicName">
                            <Form.Label>Name Apartment</Form.Label>
                            <Form.Control type="text" placeholder="Enter Name Apartment"
                                          onChange={(e) => setName(e.target.value)}/>
                        </Form.Group>

                        <br/>
                        <Table striped bordered hover>
                            <thead>
                            <tr>
                                <th>Тип комнаты</th>
                                <th>Ширина</th>
                                <th>Длинна</th>
                                <th>Высота</th>
                                <th>Двери</th>
                                <th>Окна</th>

                            </tr>
                            </thead>
                            <tbody> {addedRoms.map((d) => (
                                <tr>
                                    <td>{d.roomType}</td>
                                    <td>{d.width}</td>
                                    <td>{d.length}</td>
                                    <td>{d.height}</td>
                                    <td></td>
                                    <td></td>

                                </tr>
                            ))}
                            </tbody>
                        </Table>

                        <Button variant="primary" onClick={handleShow}>+ room</Button>
                    </Form>
                    <br/>
                    <Button onClick={handleAddApartment}>Add Apartment</Button>
                </Col>
            </Row>
            <Modal show={show} onHide={handleClose} size={"lg"}>
                <Modal.Header closeButton>
                    <Modal.Title>Add Room</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <Form>
                        <Form.Group controlId="fromBasicText7">
                            <Form.Label>Room Type</Form.Label>
                            <Form.Select
                                onChange={(e => setRoomType(e.target.value))}
                            >
                                {roomTypes.map(item => {
                                    return (<option key={item} value={item}>{item}</option>);
                                })}
                            </Form.Select>
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBasicPrice">
                            <Form.Label>Width</Form.Label>
                            <Form.Control type="number" min="0" step="0.01" placeholder="Enter Width"
                                          onChange={(e) => setWidth(e.target.value)}/>
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBasicPrice">
                            <Form.Label>Length</Form.Label>
                            <Form.Control type="number" min="0" step="0.01" placeholder="Enter Length"
                                          onChange={(e) => setLength(e.target.value)}/>
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBasicPrice">
                            <Form.Label>Height</Form.Label>
                            <Form.Control type="number" min="0" step="0.01" placeholder="Enter Height"
                                          onChange={(e) => setHeight(e.target.value)}/>
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBasicPrice">
                            <Form.Label>Doors</Form.Label>
                            <Table striped bordered hover>
                                <thead>
                                <tr>
                                    <th>Width</th>
                                    <th>Height</th>
                                    <th><Button onClick={handleShowDoor}>+</Button></th>


                                </tr>
                                </thead>
                                <tbody> {addedDoors.map((d) => (
                                    <tr>
                                        <td>{d.width}</td>
                                        <td>{d.height}</td>
                                        <td></td>

                                    </tr>
                                ))}
                                </tbody>
                            </Table>
                        </Form.Group>
                        <br/>
                        <Form.Group className="mb-3" controlId="formBasicPrice">
                            <Form.Label>Windows</Form.Label>
                            <Table striped bordered hover>
                                <thead>
                                <tr>
                                    <th>Width</th>
                                    <th>Height</th>
                                    <th><Button onClick={handleShowWindows}>+</Button></th>


                                </tr>
                                </thead>
                                <tbody> {addedWindows.map((d) => (
                                    <tr>
                                        <td>{d.width}</td>
                                        <td>{d.height}</td>
                                        <td></td>

                                    </tr>
                                ))}
                                </tbody>
                            </Table>
                        </Form.Group>
                        <br/>

                        <Button variant="primary" onClick={handleAddRoom}>
                            Add Room
                        </Button>
                    </Form>
                </Modal.Body>
            </Modal>
            <Modal show={showDoor} onHide={handleCloseDoor} size={"lg"}>
                <Modal.Header closeButton>
                    <Modal.Title>Add Door</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <Form>

                        <Form.Group className="mb-3" controlId="formBasicWidthDoors">
                            <Form.Label>Width</Form.Label>
                            <Form.Control type="number" min="0" step="0.01" placeholder="Enter Width"
                                          onChange={(e) => setWidthDoor(e.target.value)}/>
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBasicHeightDoors">
                            <Form.Label>Height</Form.Label>
                            <Form.Control type="number" min="0" step="0.01" placeholder="Enter Height"
                                          onChange={(e) => setHeightDoor(e.target.value)}/>
                        </Form.Group>

                        <br/>

                        <Button variant="primary" onClick={handleAddDoor}>
                            Add Door
                        </Button>
                    </Form>
                </Modal.Body>
            </Modal>
            <Modal show={showWindows} onHide={handleCloseWindows} size={"lg"}>
                <Modal.Header closeButton>
                    <Modal.Title>Add Windows</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <Form>

                        <Form.Group className="mb-3" controlId="formBasicWidthWindows">
                            <Form.Label>Width</Form.Label>
                            <Form.Control type="number" min="0" step="0.01" placeholder="Enter Width"
                                          onChange={(e) => setWidthWindow(e.target.value)}/>
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBasicHeightWindows">
                            <Form.Label>Height</Form.Label>
                            <Form.Control type="number" min="0" step="0.01" placeholder="Enter Height"
                                          onChange={(e) => setHeightWindow(e.target.value)}/>
                        </Form.Group>

                        <br/>

                        <Button variant="primary" onClick={handleAddWindow}>
                            Add Window
                        </Button>
                    </Form>
                </Modal.Body>
            </Modal>
        </>
    );
}

export default AddApartment;