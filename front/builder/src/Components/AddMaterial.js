import React, {useEffect, useState} from 'react';
import {Button, Col, Form, Modal, Row} from "react-bootstrap";
import LeftMenuAdmin from "./LeftMenuAdmin";
import axios from "axios";

function AddMaterial(props) {
    const [name, setName] = useState("");
    const [code, setCode] = useState("");
    const [price, setPrice] = useState(0);
    const [show, setShow] = useState(false);
    const [measurementTypes, setMeasurementTypes] = useState([]);
    const [measurementType, setMeasurementType] = useState("");

    useEffect(() => {
        const url = "http://localhost:8080/api/v1/materials/measurementTypes"
        axios.get(url, {
                headers: {
                    "Authorization": "Bearer " + localStorage.getItem("token")
                }
            }
        )
            .then(function (response) {
                setMeasurementTypes(response.data)
                setMeasurementType(response.data[0])
            })
            .catch(function (error) {
                alert("ERROR OUR")
            })
    }, [setMeasurementTypes]);

    function handleAddMaterial() {
        const url = "http://localhost:8080/api/v1/admin/addMaterial"
        if(validate()) {
            axios.post(url, {
                name: name,
                code: code,
                measurementType: measurementType,
                price:price
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
        }
        else {alert("Необходимо заполнить все поля")}
    }

    function validate() {
        if (name == null) return false;
        if (name.length < 1) return false;
        if (code == null) return false;
        if (code.length < 1) return false;
        return true;
    }

    const handleClose = () => setShow(false);
    const handleShow = () => {
        setShow(true)
    };

    return (
        <>
            <Row>
                <Col sm={2}><LeftMenuAdmin/></Col>
                <Col sm={10}>
                    <h1 style={{color: "royalblue"}}><b>Add Material</b></h1>
                    <br/>
                    <Form>
                        <Form.Group className="mb-3" controlId="formBasicName">
                            <Form.Label>Name Material</Form.Label>
                            <Form.Control type="text" placeholder="Enter Name Material"
                                          onChange={(e) => setName(e.target.value)}/>
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBasicCode">
                            <Form.Label>Code</Form.Label>
                            <Form.Control type="text" placeholder="Enter Code"
                                          onChange={(e) => setCode(e.target.value)}/>
                        </Form.Group>
                        <Form.Group controlId="fromBasicText7">
                            <Form.Label>Measurement Type</Form.Label>
                            <Form.Select
                                onChange={(e => setMeasurementType(e.target.value))}
                            >
                                {measurementTypes.map(item => {
                                    return (<option key={item} value={item}>{item}</option>);
                                })}
                            </Form.Select>
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBasicPrice">
                            <Form.Label>Price</Form.Label>
                            <Form.Control type="number" min="0" step="0.01" placeholder="Enter price"
                                          onChange={(e) => setPrice(e.target.value)}/>
                        </Form.Group>
                        <br/>
                        <Button variant="primary" onClick={handleAddMaterial}>
                            Add Material
                        </Button>
                    </Form>
                </Col>

            </Row>

            <Modal show={show} onHide={handleClose}>
                <Modal.Header closeButton>
                    <Modal.Title>Материал добавлен успешно</Modal.Title>
                </Modal.Header>
                <Modal.Footer>
                    <Button variant="secondary" onClick={handleClose}>
                        Close
                    </Button>
                </Modal.Footer>
            </Modal>
        </>
    );
}

export default AddMaterial;