import React, {useState} from 'react';
import {Button, Col, Form, Modal, Row} from "react-bootstrap";
import LeftMenuAdmin from "./LeftMenuAdmin";
import axios from "axios";

function AddCategoryMaterial(props) {
    const [name, setName] = useState("");
    const [description, setDescription] = useState("");
    const [show, setShow] = useState(false);
    const handleClose = () => setShow(false);
    const handleShow = () => {
        setShow(true)
    };

    function handleAddCategoryMaterial() {
        const url = "http://localhost:8080/api/v1/admin/addCategoryMaterial"
        if (validate()) {
            axios.post(url, {
                name: name,
                description: description

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
    function validate() {
        if (name == null) return false;
        if (name.length < 1) return false;
        if (description == null) return false;
        if (description.length < 1) return false;
        return true;
    }
    return (
        <>
            <Row>
                <Col sm={2}><LeftMenuAdmin/></Col>
                <Col sm={10}>
                    <h1 style={{color: "royalblue"}}><b>Add Category Material</b></h1>
                    <br/>
                    <Form>
                        <Form.Group className="mb-3" controlId="formBasicName">
                            <Form.Label>Name Category Material</Form.Label>
                            <Form.Control type="text" placeholder="Enter Name Category Material"
                                          onChange={(e) => setName(e.target.value)}/>
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formBasicCode">
                            <Form.Label>Description Category</Form.Label>
                            <Form.Control type="text" placeholder="Enter Description Category"
                                          onChange={(e) => setDescription(e.target.value)}/>
                        </Form.Group>

                        <br/>
                        <Button variant="primary" onClick={handleAddCategoryMaterial}>
                            Add Category Material
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

export default AddCategoryMaterial;